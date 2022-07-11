package testsuite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.Contacts.TestExecution_22;

@SuiteDisplayName("Tickets Test Suite")
@SelectClasses(
        TestExecution_22.class
)
@Suite
public class Contacts {
}
