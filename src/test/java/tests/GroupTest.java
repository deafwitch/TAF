package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GroupTest extends SolutionTest{
    public GroupTest() throws IOException {
    }

    @Test(groups="smoke")
    public void anotherstepb(){


        Assert.assertEquals(solution.div(6,3),2,"verno");

    }
    @Test(groups = "regression")
    public void anotherstepa(){
        Assert.assertEquals(solution.div(10,5),3,"verno");
    }
    @Test(groups = {"functional","smoke"})
    public void anotherstepd(){
        Assert.assertEquals(solution.div(14,7),2,"verno");
    }
    @Test(groups = "functional")
    public void anotherstepc(){
        Assert.assertEquals(solution.div(12,4),3,"verno");
    }
}
