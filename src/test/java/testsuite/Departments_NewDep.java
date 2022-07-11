package testsuite;

import org.junit.platform.suite.api.*;
import tests.CreateNew.TestExecution_19;
import tests.Departments.TestExecution_14_1;
import tests.Tickets.TestExecution_10;

@SuiteDisplayName("New Department Test Suite")
@SelectClasses(
        {TestExecution_10.class,
                TestExecution_14_1.class, TestExecution_19.class}
)
@IncludeTags({"create_new_department", "department", "create_new_department"})
@Suite
public class Departments_NewDep {

}
