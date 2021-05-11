import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class NegativeTestPOST {

    // Create user for testing registered user with existing name.
    @BeforeClass
    @DisplayName("Create user with valid email, name, pass")
    public static void validUsr() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile17@mail.ru\",\n" +
            "    \"name\": \"Улыбashka17\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String email = "smile17@mail.ru";
        String name = "Улыбashka17";

        TestMethods.testPOSTValidUsr(postParam, email, name);
    }

    @Test
    @DisplayName("Create user with empty email, pass, name")
    public void emptyValue() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"\",\n" +
            "    \"name\": \"\",\n" +
            "    \"password\": \"\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with empty data", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid email and pass, space in name (' ')")
    public void symbolSpaceInName() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile10@mail.ru\",\n" +
            "    \"name\": \"     \",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with symbol space in name", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid email and name, but empty pass")
    public void emptyPassword() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile11@mail.ru\",\n" +
            "    \"name\": \"\",\n" +
            "    \"password\": \"\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with empty password", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid name and pass, but email with two at (@@)")
    public void emailWithTwoAt() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile12@@mail.ru\",\n" +
            "    \"name\": \"Улыбashka12\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with two at symbol in email", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid name and pass, but email without two at (@)")
    public void emailWithoutAt() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile13mail.ru\",\n" +
            "    \"name\": \"Улыбashka13\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user without at symbol in email", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid name and pass, but email with cyrillic symbols")
    public void cyrillicEmail() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"йцук@mail.ru\",\n" +
            "    \"name\": \"Улыбashka14\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with cyrillic email", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid name and pass, space in email ")
    public void symbolSpaceInEmail() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile 15@mail.ru\",\n" +
            "    \"name\": \"Улыбashka15\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with space symbol in email", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Create user with valid name and pass, email without domain")
    public void emailWithoutDomain() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile16@\",\n" +
            "    \"name\": \"Улыбashka16\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user without domain in email", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

//It's believed that email and name are unique.
    @Test
    @DisplayName("Create user with existing name")
    public void usrWithExistName() throws IOException {
        String postParam = "{\n" +
            "    \"email\": \"smile18@mail.ru\",\n" +
            "    \"name\": \"Улыбashka17\",\n" +
            "    \"password\": \"123\"\n" +
            "}";
        String type = "error";

        Assert.assertTrue("Checking new user with existing name", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    @Test
    @DisplayName("Send empty JSON")
    public void emptyJSON() throws IOException {
        String postParam = "{}";
        String type = "error";

        Assert.assertTrue("Checking new user with empty JSON", TestMethods.testPOSTInvalidUsr(postParam, type));
    }

    //This is a plug in case different people try to run tests. Delete user for future tests
    @AfterClass
    @DisplayName("Delete users after tests")
    public static void deleteUsersAfterTests() throws IOException {
        String email10 = "smile10@mail.ru";
        TestMethods.testDELValidUser(email10);

        String email17 = "smile17@mail.ru";
        TestMethods.testDELValidUser(email17);
    }

}
