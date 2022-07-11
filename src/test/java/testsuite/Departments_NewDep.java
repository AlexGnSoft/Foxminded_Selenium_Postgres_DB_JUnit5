package testsuite;

import org.junit.platform.suite.api.*;
import tests.Departments.DepartmentsTest;

@SuiteDisplayName("New Department Test Suite")
@SelectClasses(
        {DepartmentsTest.class}
)
@IncludeTags({"create_new_department", "create_new_department_db_test"})
@Suite
public class Departments_NewDep {

}
