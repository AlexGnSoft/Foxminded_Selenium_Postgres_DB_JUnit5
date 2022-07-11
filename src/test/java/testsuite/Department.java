package testsuite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.Departments.DepartmentsTest;

@SuiteDisplayName("Departments Test Suite")
@SelectClasses(
        {DepartmentsTest.class}
)
@IncludeTags("department")
@Suite
public class Department {
}
