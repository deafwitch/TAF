package tests.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

public class BaseDBTest {
    Logger logger = LoggerFactory.getLogger(BaseDBTest.class);

    public DataBaseService dataBaseService;

    public BaseDBTest() {
    }

    @BeforeTest
    public void setupConnection() {
        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
