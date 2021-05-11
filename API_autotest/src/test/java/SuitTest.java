import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import positiveTests.validDataDEL;
import positiveTests.validDataPOST;
import positiveTests.validDataPUT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        validDataDEL.class,
        validDataPOST.class,
        validDataPUT.class,
        NegativeTestPOST.class,
        ProhibitedValuePOST.class,
        NegativeTestGET.class,
        NegativeTestPUT.class,
        NegativeTestDEL.class
})
public class SuitTest {
}
