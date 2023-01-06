package com.gcu.utility;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArmorTest.class, CartTest.class, HealthTest.class, ProductTest.class, StoreInventoryTest.class,
		WeaponTest.class })
public class AllTests {

}
