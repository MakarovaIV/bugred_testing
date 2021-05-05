import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PositiveTest.class, PositiveTestNumInDomain.class,
        NegativeTestPOST.class, ProhibitedValuePOST.class,
        NegativeTestGET.class, NegativeTestPUT.class, NegativeTestDEL.class} )
public class SuitTest {
}
