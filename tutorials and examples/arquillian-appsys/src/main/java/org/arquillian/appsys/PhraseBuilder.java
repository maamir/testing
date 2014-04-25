package org.arquillian.appsys;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * File: PhraseBuilder.java
 * 
 * @author aamirm
 * 
 */
public class PhraseBuilder {

	private Map<String, String> templates;

	@PostConstruct
	public void initialise() {
		templates = new HashMap<String, String>();
		templates.put("hello", "Hello, {0} buddy boy!!");
	}

	/**
	 * 
	 * @param id
	 * @param args
	 * @return
	 */
	public String buildPhrase(String id, Object... args) {
		return MessageFormat.format(templates.get(id), args);
	}
}
