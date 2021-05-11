import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class NegativeTestGET {

    @Test
    @DisplayName("Get user by non-existing email")
    public void nonExistEmail() throws IOException {
        String email = "smile201@mail.ru";
        String type = "error";

        Assert.assertTrue("Checking existence user by non-existing email", TestMethods.testGETInvalidUsr(email, type));
    }
}
