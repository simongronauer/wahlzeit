package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({			
			org.wahlzeit.handlers.HandlersTest.class,
			org.wahlzeit.model.ModelTest.class,
			org.wahlzeit.services.ServicesTest.class,
			org.wahlzeit.utils.UtilsTest.class
})

public class AllTest {

}
