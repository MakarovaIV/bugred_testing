import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class ProhibitedValuePOST {

    @Test
    @DisplayName("Create user with valid email, pass and SQL-injection in name")
    public void sqlInjection() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile100@mail.ru\",\n" +
            "    \"name\": \"DROP TABLE users\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile100@mail.ru";
        String name = "DROP TABLE users";

        Assert.assertTrue("Checking new user with SQL-injection", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Create user with valid email, pass and XSS-injection in name")
    public void xssInjection() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile101@mail.ru\",\n" +
            "    \"name\": \"</script><script>alert()</script>\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile101@mail.ru";
        String name = "alert()";

        Assert.assertTrue("Checking new user with XSS-injection", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Create user with valid email, pass and HTML tag in name")
    public void htmlTag() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile102@mail.ru\",\n" +
            "    \"name\": \"<h1>alert</h1>\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile102@mail.ru";
        String name = "alert";

        Assert.assertTrue("Checking new user with HTML tag", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Create user with valid email, pass and NULL in name")
    public void nullInName() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile103@mail.ru\",\n" +
            "    \"name\": \"NULL\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile103@mail.ru";
        String name = "NULL";

        Assert.assertTrue("Checking new user with value NULL", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Create user with valid email, pass and UNDEFINED in name")
    public void undefinedInName() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile104@mail.ru\",\n" +
            "    \"name\": \"UNDEFINED\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile104@mail.ru";
        String name = "UNDEFINED";

        Assert.assertTrue("Checking new user with value UNDEFINED", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Create user with valid email, pass and non-ASCII symbol in name")
    public void nonASCIIinName() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile105@mail.ru\",\n" +
            "    \"name\": \"♣\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile105@mail.ru";
        String name = "♣";

        Assert.assertTrue("Checking new user with non-ASCII symbol", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    //Delete users for future tests
    @AfterClass
    @DisplayName("Delete users after tests")
    public static void deleteUsersAfterTests() throws IOException {
        String email100 = "smile100@mail.ru";
        TestMethods.testDELValidUser(email100);

        String email101 = "smile101@mail.ru";
        TestMethods.testDELValidUser(email101);

        String email102 = "smile102@mail.ru";
        TestMethods.testDELValidUser(email102);

        String email103 = "smile103@mail.ru";
        TestMethods.testDELValidUser(email103);

        String email104 = "smile104@mail.ru";
        TestMethods.testDELValidUser(email104);

        String email105 = "smile105@mail.ru";
        TestMethods.testDELValidUser(email105);
    }
}
