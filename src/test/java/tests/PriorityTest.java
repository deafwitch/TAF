package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PriorityTest  extends SolutionTest{


    public PriorityTest() throws IOException {
    }

    @Test(priority=2)
    public void stepa(){


            Assert.assertEquals(solution.div(6,3),2,"verno");

    }
        @Test(priority=1)
    public void stepb(){
            Assert.assertEquals(solution.div(10,5),2,"verno");
    }
        @Test(priority=4)
    public void stepc(){
            Assert.assertEquals(solution.div(14,7),2,"verno");
    }
        @Test(priority=3)
    public void stepd(){
            Assert.assertEquals(solution.div(12,4),3,"verno");
    }


}
