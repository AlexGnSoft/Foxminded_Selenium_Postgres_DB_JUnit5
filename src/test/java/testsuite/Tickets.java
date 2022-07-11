package testsuite;

import org.junit.platform.suite.api.*;
import tests.Tickets.TicketsTest;

@SuiteDisplayName("Tickets Test Suite")
@SelectClasses(
        {TicketsTest.class}
)
@IncludeTags("ticket")
@Suite
public class Tickets {

}
