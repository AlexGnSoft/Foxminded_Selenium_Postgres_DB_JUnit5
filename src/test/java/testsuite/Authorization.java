package testsuite;

import org.junit.platform.suite.api.*;

@SuiteDisplayName("Authorization Test Suite")
@SelectPackages({
          "tests.Authorization"})
@IncludeTags("production")
@Suite
public class Authorization {

}
