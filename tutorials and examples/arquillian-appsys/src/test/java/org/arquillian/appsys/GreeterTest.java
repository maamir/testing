package org.arquillian.appsys;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * File: GreeterTest.java
 * 
 * Test class for {@link Greeter}
 * 
 * @author aamirm
 *
 */
@RunWith(Arquillian.class)
public class GreeterTest {
	
	@Inject
	Greeter greeter;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClasses(Greeter.class, PhraseBuilder.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	@Test
	public void testGreet() {
		Assert.assertEquals("Hello, Aamir Arquillian buddy boy!!", greeter.createGreeting("Aamir Arquillian")); 
		greeter.greet(System.out, "Aamir Arquillian");
	}
}
