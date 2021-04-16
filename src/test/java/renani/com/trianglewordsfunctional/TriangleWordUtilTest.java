package renani.com.trianglewordsfunctional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleWordUtilTest {
    @Test
    public void TestCalculateWordValue(){
        int a = TriangleWordUtil.calculateWordValue("a");
        System.out.println("Value of A is " + a);


    }
}