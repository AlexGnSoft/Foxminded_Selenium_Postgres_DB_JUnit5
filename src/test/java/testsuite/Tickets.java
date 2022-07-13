package testsuite;

import org.junit.platform.suite.api.*;
import tests.Tickets.TicketsTest;

@SuiteDisplayName("Tickets Test Suite")
@SelectClasses(
        {TicketsTest.class}
)
@IncludeTags({"ticket", "create_new_ticket", "create_new_ticket_db_test", "edit_ticket"})
@Suite
public class Tickets {

}
