package org.wahlzeit.services.mailing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({			
			org.wahlzeit.services.mailing.EmailServiceTest.class,
			org.wahlzeit.services.mailing.EmailServiceTestSuite.class
})

public class MailingTest {

}
