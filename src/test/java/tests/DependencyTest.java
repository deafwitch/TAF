package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DependencyTest extends SolutionTest{
    public DependencyTest() throws IOException {
    }

    @Test
    public void anotherstepb(){


        Assert.assertEquals(solution.div(6,3),2,"verno");

    }
    @Test(dependsOnMethods ="anotherstepb" )
    public void anotherstepa(){
        Assert.assertEquals(solution.div(10,5),3,"verno");
    }
    @Test(dependsOnMethods ="anotherstepa" ,alwaysRun = true)
    public void anotherstepd(){
        Assert.assertEquals(solution.div(14,7),2,"verno");
    }
    @Test(dependsOnMethods ="anotherstepd" )
    public void anotherstepc(){
        Assert.assertEquals(solution.div(12,4),3,"verno");
    }
}
