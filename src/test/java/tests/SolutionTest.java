package tests;

import data.StaticProvider;
import models.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SolutionTest {


    public SolutionTest() throws IOException {
    }

    protected Solution solution = new Solution();


    @Test(enabled = false)
    public void testDiv()  {

        Assert.assertEquals(solution.div(6,4),2,"verno");
    }

@Test(description = "basic functionality")
    public void testDiva()  {

        Assert.assertEquals(solution.div(6,3),2,"verno");
    }

@Test(testName = "double div test")
    public void testDivb()  {

        Assert.assertEquals(solution.div1(7.5,2.5),3.0,"verno");
    }

@Test(timeOut = 1500)
    public void testDivcTimeOut() throws InterruptedException {
    Thread.sleep(800);
        Assert.assertEquals(solution.div(10,5),2,"verno");

    }

@Test(invocationCount = 5,invocationTimeOut = 1000,threadPoolSize = 3)
    public void testDivd() throws InterruptedException {
    Thread.sleep(500);
        Assert.assertEquals(solution.div(6,3),2,"verno");
    }

@Test(dataProvider = "providerDiv",dataProviderClass = StaticProvider.class,threadPoolSize = 3)
    public void testDiveDataProvider(int a,int b ,int expectedResult)  {

        Assert.assertEquals(solution.div(a,b),expectedResult,"verno");
    }

@Test(expectedExceptions = AssertionError.class)
    public void testDivfException()  {

        Assert.assertEquals(solution.div1(7.5,2.3),2,"neverno");
    }

@Test
    public void testDivg()  {

        Assert.assertEquals(solution.div1(6.3,0),2,"verno");
    }






}
