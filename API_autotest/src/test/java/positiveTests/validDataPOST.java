package positiveTests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class validDataPOST {

    @Test
    @DisplayName("Create user with valid data")
    public void testValidDataPOST() throws IOException {
        String postParam = "{\n" +
                "    \"email\": \"smile1@mail.ru\",\n" +
                "    \"name\": \"Улыбashka1\",\n" +
                "    \"password\": \"123\"\n" +
                "}";
        String email = "smile1@mail.ru";
        String name = "Улыбashka1";

        Assert.assertTrue("Checking new user with valid data", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @AfterClass
    @DisplayName("Delete user with valid email")
    public static void deleteUserAfterTest() throws IOException {
        String email = "smile1@mail.ru";
        TestMethods.testDELValidUser(email);
    }
}
