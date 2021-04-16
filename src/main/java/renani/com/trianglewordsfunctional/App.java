package renani.com.trianglewordsfunctional;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Hello world!
 */
public class App {
    private static final Pattern COMMA_DELIMITER = Pattern.compile(",");

    record Word(String value, int triangleNumber) {
    }

    record WordGroup(int triangleNumber, String commaSeparated) {
    }


    public static void main(String[] args) {
        if(args.length<1){
            printHelp();
            System.exit(0);
        }
        String inFile=args[0];

        String jsonString=null;
        try {
            jsonString = searchAndGroupTriangleWords(inFile);
        }catch (Throwable t){
            t.printStackTrace();
            System.exit(-1);//shit of shit.. what went wrong?
        }
        System.out.println(jsonString);
        System.exit(0);

    }

    private static void printHelp() {
        System.out.println("* Example usage: Java -jar TriangeWordsFunctional.jar <path to file>*");
    }

    public static String searchAndGroupTriangleWords(String fileName) {

        long start = System.currentTimeMillis();
        String returnValue=null;
        try {
            List<String> wordsFromFile = getWordsFromFile(fileName);
            Map<Integer, List<Word>> groupedWords = wordsFromFile.parallelStream()
                    .map(w -> new Word(w, TriangleWordUtil.getTriangleNumber(w)))
                    .filter(r -> r.triangleNumber() >0)
                    .collect(Collectors.groupingBy(wrd -> wrd.triangleNumber()));

            Map<Integer, String> collect = groupedWords.entrySet().parallelStream().map(entrySet ->
            {
                String wordList = entrySet.getValue().stream().sorted((o1, o2) -> o2.value()
                        .compareTo(o1.value()))
                        .map(wrd -> wrd.value())
                        .collect(Collectors.joining(","));
                return new WordGroup(entrySet.getKey(), wordList);
            }).collect(Collectors.toMap(WordGroup::triangleNumber, WordGroup::commaSeparated));


            ObjectMapper mapper = new ObjectMapper();
            returnValue =  mapper.writeValueAsString(collect);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);//we can expect this error

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return returnValue;
    }


    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().replace("\"", "").toLowerCase(Locale.ROOT));
            }
        }
        return values;
    }

    private static List<String> getWordsFromFile(String fileName) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<List<String>>();

        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records.stream().flatMap(Collection::stream).toList();


    }

}
