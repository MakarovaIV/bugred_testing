import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;


@DisplayName("Test user with valid email, name, pass")
public class PositiveTestNumInDomain {

//Check valid email with hyphen and numbers in domain
    @BeforeClass
    @DisplayName("Create user with hyphen and numbers in domain")
    public static void validNumInDomainPOST() throws IOException {
        String postParam = "{\n" +
                "    \"email\": \"smile2@mail-2.ru\",\n" +
                "    \"name\": \"Улыбashka2\",\n" +
                "    \"password\": \"123\"\n" +
                "}";
        String email = "smile2@mail-2.ru";
        String name = "Улыбashka2";

        Assert.assertTrue("Checking new user with numbers and hyphen in domain", TestMethods.testPOSTValidUsr(postParam, email, name));
    }

    @Test
    @DisplayName("Change name to new valid value in valid user email")
    public void validDataPUT() throws IOException {
        String putParam = "{\n" +
                "    \"field\": \"name\",\n" +
                "    \"email\": \"smile2@mail-2.ru\",\n" +
                "    \"value\": \"Улыбa\"\n" +
                "}";
        String email = "smile2@mail-2.ru";
        String name = "Улыбa";

        Assert.assertTrue("Checking new user name", TestMethods.testPUTValidValue(putParam, email, name));
    }

    @AfterClass
    @DisplayName("Delete user with hyphen and numbers in email")
    public static void validNumInDomainDEL() throws IOException {
        String email = "smile2@mail-2.ru";
        Assert.assertTrue("Checking deleted user with numbers and hyphen in domain", TestMethods.testDELValidUser(email));
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
