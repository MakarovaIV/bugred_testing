import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class NegativeTestPUT {

    //Create user for testing PUT
    @BeforeClass
    @DisplayName("Create user with valid email, name, pass")
    public static void createUserForTest() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"name\": \"Улыбashka300\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "Улыбashka300";

        TestMethods.testPOSTValidUsr(postParam, email, name);
    }

    @Test
    @DisplayName("Change name to non-ASCII symbol in valid user email")
    public void nonASCII() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"♣\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "♣";

        Assert.assertTrue("Checking new user with non-ASCII symbol in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name in non-existing user email")
    public void nonExistUsr() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile14@mail.ru\",\n" +
            "    \"value\": \"Улыбashka14\",\n" +
            "}";

        Assert.assertFalse("Checking new user with non-existing email", TestMethods.testPUTInvalidValue(putParam));
    }

    @Test
    @DisplayName("Change name to space (' ') in valid user email")
    public void symbolSpaceInName() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \" \"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "";

        Assert.assertTrue("Checking new user with space symbol in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name in valid user email without value")
    public void withoutFieldValue() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile14@mail.ru\"\n" +
            "}";

        Assert.assertFalse("Checking new user without field 'value'", TestMethods.testPUTInvalidValue(putParam));
    }

    @Test
    @DisplayName("Change name to SQL-injection in valid user email")
    public void sqlInjection() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"DROP TABLE users\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "DROP TABLE users";

        Assert.assertTrue("Checking new user with SQL-injection in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name to XSS-injection in valid user email")
    public void xssInjection() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"</script><script>alert()</script>\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "<script>alert()";

        Assert.assertTrue("Checking new user with XSS-injection in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name to HTML tag in valid user email")
    public void htmlTag() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"<h1>alert</h1>\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "alert";

        Assert.assertTrue("Checking new user HTML tag in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name to NULL in valid user email")
    public void valueNULL() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"NULL\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "NULL";

        Assert.assertTrue("Checking new user with value NULL in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @Test
    @DisplayName("Change name to UNDEFINED in valid user email")
    public void valueUNDEFINED() throws IOException {
        String putParam = "{\n" +
            "    \"field\": \"name\",\n" +
            "    \"email\": \"smile300@mail.ru\",\n" +
            "    \"value\": \"UNDEFINED\"\n" +
            "}";
        String email = "smile300@mail.ru";
        String name = "UNDEFINED";

        Assert.assertTrue("Checking new user with value UNDEFINED in name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    //Delete user for future tests
    @AfterClass
    @DisplayName("Delete user with valid email")
    public static void deleteUserAfterTest() throws IOException {
        String email = "smile300@mail.ru";
        TestMethods.testDELValidUser(email);
    }
}
