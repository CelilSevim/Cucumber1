package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void test_01(){
        int[]arr= {1,2,3,4,5,6,7,8,9};
        MyMethods myMethods=new MyMethods();
        int actual=myMethods.sum(arr);
        int actual2=new MyMethods().sum(arr);
        int expected=45;

        // unit test
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actual2,expected);



    }

}
