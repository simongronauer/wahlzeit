package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({			
			org.wahlzeit.model.persistence.AbstractAdapterTest.class,
			org.wahlzeit.model.persistence.DatastoreAdapterTest.class
})

public class PersistenceTest {

}
