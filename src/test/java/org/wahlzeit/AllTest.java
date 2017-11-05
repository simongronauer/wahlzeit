package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({			
			org.wahlzeit.handlers.TellFriendTest.class,
			org.wahlzeit.model.AccessRightsTest.class,
			org.wahlzeit.model.CoordinateLocationTest.class,
			org.wahlzeit.model.FlagReasonTest.class,
			org.wahlzeit.model.GenderTest.class,
			org.wahlzeit.model.GuestTest.class,
			org.wahlzeit.model.PhotoFilterTest.class,
			org.wahlzeit.model.TagsTest.class,
			org.wahlzeit.model.UserStatusTest.class,
			org.wahlzeit.model.ValueTest.class,
			org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
			org.wahlzeit.services.EmailAddressTest.class,
			org.wahlzeit.services.LogBuilderTest.class,
			org.wahlzeit.services.mailing.EmailServiceTest.class,
			org.wahlzeit.services.mailing.EmailServiceTestSuite.class,
			org.wahlzeit.utils.StringUtilTest.class,
			org.wahlzeit.utils.VersionTest.class
})

public class AllTest {

}
