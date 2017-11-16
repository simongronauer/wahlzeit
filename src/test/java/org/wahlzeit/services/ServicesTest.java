package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
			org.wahlzeit.services.mailing.MailingTest.class,
			org.wahlzeit.services.EmailAddressTest.class,
			org.wahlzeit.services.LogBuilderTest.class
})

public class ServicesTest {

}
