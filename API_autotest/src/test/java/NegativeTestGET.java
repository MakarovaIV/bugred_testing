import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class NegativeTestGET {

    @Test
    @DisplayName("Get user by invalid email")
    public void invalidEmail() throws IOException {
        String email = "smile200@mailru";
        String type = "error";

        Assert.assertTrue("Checking existence user by invalid email", TestMethods.testGETInvalidUsr(email, type));
    }

    @Test
    @DisplayName("Get user by non-existing email")
    public void nonExistEmail() throws IOException {
        String email = "smile201@mail.ru";
        String type = "error";

        Assert.assertTrue("Checking existence user by non-existing email", TestMethods.testGETInvalidUsr(email, type));
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
