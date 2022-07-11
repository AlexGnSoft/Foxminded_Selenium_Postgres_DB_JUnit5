package testsuite;

import org.junit.platform.suite.api.*;
import tests.Contacts.ContactsTest;

@SuiteDisplayName("New Contact Test Suite")
@SelectClasses(
        {ContactsTest.class}
)
@IncludeTags({"create_new_contact","create_new_contact_db_test", "create_new_contact_validation_test"})
@Suite
public class Contacts_NewContact {
}
