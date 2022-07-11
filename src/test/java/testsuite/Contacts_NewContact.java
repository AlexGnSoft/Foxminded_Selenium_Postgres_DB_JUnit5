package testsuite;

import org.junit.platform.suite.api.*;
import tests.CreateNew.TestExecution_19;
import tests.Tickets.TestExecution_10;

@SuiteDisplayName("New Contact Test Suite")
@SelectClasses(
        {TestExecution_10.class, TestExecution_19.class}
)
@IncludeTags("create_new_contact")
@Suite
public class Contacts_NewContact {
}
