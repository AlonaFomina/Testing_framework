package testng_learning;
import org.junit.Assert;
import org.testng.annotations.Test;

public class _04_Optional_Assertion_Error_Message {
    @Test
    public void method1(){

        //TestNG way
        //Assert.assertTrue();
       org.testng.Assert.assertEquals("","","");


       //JUnit way
        Assert.assertTrue("",true);
        Assert.assertEquals("","","");
    }
}
