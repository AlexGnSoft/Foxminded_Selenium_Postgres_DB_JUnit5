package testsuite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.Managers.ManagersTest;

@SuiteDisplayName("New Manager Test Suite")
@SelectClasses(
        {ManagersTest.class}
)
@IncludeTags({"create_new_manager", "create_new_manager_db_test"})
@Suite
public class Managers {
}
