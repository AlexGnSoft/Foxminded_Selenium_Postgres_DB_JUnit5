package testsuite;

import org.junit.platform.suite.api.*;
import tests.CreateNew.TestExecution_19;
import tests.Tickets.TestExecution_10;

@SuiteDisplayName("Tickets Test Suite")
@SelectPackages({
        "tests.Tickets", "CreateNew"})
@SelectClasses(
        {TestExecution_10.class, TestExecution_19.class}
)
@IncludeTags("create_new_ticket")
@Suite
public class Tickets_NewTicket {
}
