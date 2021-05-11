import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.TestMethods;

import java.io.IOException;

public class NegativeTestDEL {

    @Test
    @DisplayName("Delete user with non-existing email")
    public void nonExistEmail() throws IOException {
        String email = "smile400@mail.ru";
        Assert.assertFalse("Checking delete non-existing user", TestMethods.testDELValidUser(email));
    }
}
