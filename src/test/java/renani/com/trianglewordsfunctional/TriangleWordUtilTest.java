package renani.com.trianglewordsfunctional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TriangleWordUtilTest {


    @Test
    public void TestGetTriangleNumber() {
        String word = "Triangle";
        int triangleNumber = TriangleWordUtil.getTriangleNumber(word);
        System.out.println("TriangleNumber " + triangleNumber);
    }

    @Test
    void TestIsNotTriangleWord() {
        String word = "TKY";//Is there a triangle word where its sum is one more than closest previous triangle word?
        assertFalse(TriangleWordUtil.getTriangleNumber(word) > 0, "T=S+1");

        Integer[] nonTriangleNumbers = {2, 4, 5, 7, 8, 9, 11, 12, 13, 14, 16};
        List<Integer> nonTriangleList = new ArrayList<Integer>();
        Collections.addAll(nonTriangleList, nonTriangleNumbers);

        List<String> triangleWords = nonTriangleList.stream().map(e -> createWordFromSum(e)).collect(Collectors.toList());

        triangleWords.stream().forEach(e -> assertIfWordIsNotTriangle(e));

    }

    /**
     * Testing with triangle numbers.
     */
    @Test
    void TestIsTriangleWord() {
        String word = ("SKY");
        assertTrue(TriangleWordUtil.getTriangleNumber(word) > 0);
        List<Integer> triangleNumbers = Arrays.asList(new Integer[]{1, 3, 6, 10, 15, 21, 28, 36, 45, 55});
        List<String> triangleWords = triangleNumbers.stream().map(e -> createWordFromSum(e)).collect(Collectors.toList());
        triangleWords.stream().forEach(e -> assertIfWordIsTriangle(e));
    }

    @Test
    void testCalculateWordValue() {
        int wordValue = TriangleWordUtil.calculateWordValue("aaa");
        assertEquals(3, wordValue);

        wordValue = TriangleWordUtil.calculateWordValue("zzz");
        assertEquals(26 * 3, wordValue);

        wordValue = TriangleWordUtil.calculateWordValue("bbb");
        assertEquals(1 + 2 + 3, wordValue);

        wordValue = TriangleWordUtil.calculateWordValue("sky");
        assertEquals(55, wordValue);
    }


    /**
     * Creating random "words" from String.
     *
     * @param sumValue
     * @return
     */
    private String createWordFromSum(double sumValue) {
        int totLetters = TriangleWordUtil.ASCII_END - TriangleWordUtil.ASCII_OFFSET;
        StringBuffer buffer = new StringBuffer();

        while (sumValue + TriangleWordUtil.ASCII_OFFSET > TriangleWordUtil.ASCII_END) {
            int randomChar = ((int) (Math.random() * (totLetters - 1))) + 1;
            randomChar = (int) Math.min(randomChar, sumValue);

            buffer.append((char) (randomChar + TriangleWordUtil.ASCII_OFFSET));
            sumValue -= randomChar;
        }

        if (sumValue > 0) {
            buffer.append((char) (sumValue + TriangleWordUtil.ASCII_OFFSET));
        }

        return buffer.toString();
    }

    private void assertIfWordIsTriangle(String variable) {
        assertTrue(TriangleWordUtil.getTriangleNumber(variable) > 0, "This word is NOT Triangle " + variable + ". ");
    }

    private void assertIfWordIsNotTriangle(String variable) {
        assertFalse(TriangleWordUtil.getTriangleNumber(variable) > 0, "This word IS triangle " + variable + ". ");
    }


}