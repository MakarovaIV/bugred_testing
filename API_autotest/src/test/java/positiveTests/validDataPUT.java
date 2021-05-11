package positiveTests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class validDataPUT {
    @BeforeClass
    @DisplayName("Create user with valid data")
    public static void createUserForTest() throws IOException {
        String postParam = "{\n" +
                "    \"email\": \"smile3@mail.ru\",\n" +
                "    \"name\": \"Улыбashka3\",\n" +
                "    \"password\": \"123\"\n" +
                "}";
        String email = "smile3@mail.ru";
        String name = "Улыбashka3";

        TestMethods.testPOSTValidUsr(postParam, email, name);
    }

    @Test
    @DisplayName("Change name to new valid value in valid user email")
    public void testValidDataPUT() throws IOException {
        String putParam = "{\n" +
                "    \"field\": \"name\",\n" +
                "    \"email\": \"smile3@mail.ru\",\n" +
                "    \"value\": \"Улыбashka\"\n" +
                "}";
        String email = "smile3@mail.ru";
        String name = "Улыбashka";

        Assert.assertTrue("Checking new user name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @AfterClass
    @DisplayName("Delete user with valid email")
    public static void deleteUserAfterTest() throws IOException {
        String email = "smile3@mail.ru";
        TestMethods.testDELValidUser(email);
    }
}
