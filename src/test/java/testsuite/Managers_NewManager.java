package testsuite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.Managers.TestExecution_12;
import tests.CreateNew.TestExecution_21;

@SuiteDisplayName("New Manager Test Suite")
@SelectClasses(
        {TestExecution_12.class, TestExecution_21.class}
)
@IncludeTags("create_new_manager")
@Suite
public class Managers_NewManager {
}
