import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class PositiveTest {

    @BeforeClass
    public static void validDataPOST() throws IOException {
        String postParam = "{\n" +
                "    \"email\": \"smile1@mail.ru\",\n" +
                "    \"name\": \"Улыбashka1\",\n" +
                "    \"password\": \"123\"\n" +
                "}";
        String email = "smile1@mail.ru";
        String name = "Улыбashka1";

        Assert.assertTrue("Checking new user with valid data", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Change name to new valid value in valid user email")
    public void validDataPUT() throws IOException {
        String putParam = "{\n" +
                "    \"field\": \"name\",\n" +
                "    \"email\": \"smile1@mail.ru\",\n" +
                "    \"value\": \"Улыбashka\"\n" +
                "}";
        String email = "smile1@mail.ru";
        String name = "Улыбashka";

        Assert.assertTrue("Checking new user name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @AfterClass
    @DisplayName("Delete user with valid email")
    public static void validDataDEL() throws IOException {
        String email = "smile1@mail.ru";
        Assert.assertTrue("Checking deleted user", TestMethods.testDELValidUser(email));
    }

    @AfterClass
    public static void tearDown() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpClient.close(httpClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
