package testsuite;

import org.junit.platform.suite.api.*;
import tests.Tickets.TicketsTest;

@SuiteDisplayName("New Ticket Test Suite")
@SelectClasses(
        {TicketsTest.class}
)
@IncludeTags(
        {"create_new_ticket", "create_new_ticket_db_test"})
@Suite
public class Tickets_NewTicket {
}
