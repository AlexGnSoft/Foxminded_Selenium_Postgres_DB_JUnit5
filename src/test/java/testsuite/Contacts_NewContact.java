package testsuite;

import org.junit.platform.suite.api.*;
import tests.Contacts.ContactsTest_Parametrized_Locator;

@SuiteDisplayName("New Contact Test Suite")
@SelectClasses(
        {ContactsTest_Parametrized_Locator.class}
)
@IncludeTags({"create_new_contact","create_new_contact_db_test", "create_new_contact_validation_test"})
@Suite
public class Contacts_NewContact {
}
