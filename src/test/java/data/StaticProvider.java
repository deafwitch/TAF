package data;

import org.junit.experimental.theories.DataPoint;
import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name="providerDiv")
    public static Object[][] dataDiv() {
        return new Object[][]{

                {4, 1, 4},
                {7, 7, 1}


        };
    }
}
