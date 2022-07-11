package testsuite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@SelectPackages({
        "tests.PackageB"
        ,"tests.PackageA"})

@Suite
public class TestSuite {

}
