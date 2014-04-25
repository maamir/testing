package org.arquillian.appsys;

import java.io.PrintStream;

import javax.inject.Inject;

/**
 * File: Greeter.java
 * 
 * @author aamirm
 *
 */
public class Greeter {

	private PhraseBuilder phraseBuilder;
	
	@Inject
	public Greeter(PhraseBuilder phraseBuilder) {
		this.phraseBuilder = phraseBuilder;
	}
	
	/**
	 * Take inputstream and value to print on this stream.
	 * 
	 * @param to
	 * @param name
	 */
	public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

	/**
	 * 
	 * @param name
	 * @return
	 */
    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }
}
