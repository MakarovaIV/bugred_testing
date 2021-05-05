import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class NegativeTestDEL {

    @Test
    @DisplayName("Delete user with non-existing email")
    public void nonExistEmail() throws IOException {
        String email = "smile400@mail.ru";
        Assert.assertFalse("Checking delete non-existing user", TestMethods.testDELValidUser(email));
    }

    @Test
    @DisplayName("Delete user with invalid email")
    public void invalidEmail() throws IOException {
        String email = "smile401@mailru";
        Assert.assertFalse("Checking delete user with invalid email", TestMethods.testDELValidUser(email));
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
