package positiveTests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class validDataDEL {
    @BeforeClass
    @DisplayName("Create user with valid data")
    public static void createUserForTest() throws IOException {
        String postParam = "{\n" +
                "    \"email\": \"smile1@mail.ru\",\n" +
                "    \"name\": \"Улыбashka1\",\n" +
                "    \"password\": \"123\"\n" +
                "}";
        String email = "smile1@mail.ru";
        String name = "Улыбashka1";

        TestMethods.testPOSTValidUsr(postParam, email, name);
    }

    @Test
    @DisplayName("Delete user with valid email")
    public void testValidDataDEL() throws IOException {
        String email = "smile1@mail.ru";
        Assert.assertTrue("Checking deleted user", TestMethods.testDELValidUser(email));
    }
}
