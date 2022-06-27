import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();
        while (driverEnumeration.hasMoreElements()) {
            Driver driver = driverEnumeration.nextElement();
            print(driver);
        }
    }
    public static void print(Driver driver) {
        System.out.println("Driver's Name: " + driver.getClass().getName());
        System.out.println("Version: " + driver.getMajorVersion());
    }
}
