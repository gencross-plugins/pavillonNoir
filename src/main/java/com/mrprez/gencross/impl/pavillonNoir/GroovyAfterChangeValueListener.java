package com.mrprez.gencross.impl.pavillonNoir;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.HashMap;
import java.util.Map;

import com.mrprez.gencross.Property;
import com.mrprez.gencross.listener.AfterChangeValueListener;
import com.mrprez.gencross.value.Value;

public class GroovyAfterChangeValueListener extends AfterChangeValueListener {
	
	private String script;

	@Override
	public void callAfterChangeValue(Property property, Value oldValue) throws Exception {
		Binding binding = new Binding();
		binding.setProperty("property", property);
		binding.setProperty("oldValue", oldValue);
		binding.setProperty("personnage", property.getPersonnage());
		GroovyShell groovyShell = new GroovyShell(binding);
		groovyShell.evaluate(script);
	}

	@Override
	public Map<String, String> getArgs() {
		Map<String, String> args = new HashMap<String, String>(1);
		args.put("script", script);
		return null;
	}

	@Override
	public void setArgs(Map<String, String> args) throws Exception {
		script = args.get("script");
	}

}