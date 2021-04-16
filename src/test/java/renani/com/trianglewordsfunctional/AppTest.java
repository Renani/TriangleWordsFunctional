package renani.com.trianglewordsfunctional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testSearchAndGroupTriangleWords(){
        String tmp = "C:\\Users\\siavashr\\mainWorkspace\\TriangleWords\\DEFA Challenge 1\\words.txt";
        String s = App.searchAndGroupTriangleWords(tmp);

        System.out.println(s);

    }
}