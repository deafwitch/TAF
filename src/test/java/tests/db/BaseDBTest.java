package tests.db;

import dbEntities.CustomersTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

public class BaseDBTest {
    public DataBaseService dataBaseService;

    CustomersTable customersTable;

    Logger logger = LoggerFactory.getLogger(BaseDBTest.class);

    public BaseDBTest() {
    }

    @BeforeTest
    public void setupConnection() {
        dataBaseService = new DataBaseService();

        customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

        customersTable.addCustomer("Evan", "Perks", "ivanov@test.com", 28);
        customersTable.addCustomer("Evan1", "Evan2", "petrov@test.com", 38);
        customersTable.addCustomer("Evan23", "Evaneewefwef", "marina@test.com", 23);
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
