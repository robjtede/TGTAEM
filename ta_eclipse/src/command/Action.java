package command;

import java.util.ArrayList;

public class Action {
	String name;
	Word verb;
	Word noun;
	ArrayList<String> altNames = new ArrayList<>();
	String method;

	public Action(String name, Word verb, Word noun, String method) {
		this.name = name;
		this.verb = verb;
		this.noun = noun;
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public Word getVerb() {
		return verb;
	}

	public Word getNoun() {
		return noun;
	}

	public String verb() {
		return verb.getPrime();
	}

	public String noun() {
		return noun.getPrime();
	}

	public String getMethod() {
		return this.method;
	}

	public ArrayList<String> getAltNames() {
		return this.altNames;
	}

	public void addAltName(String alt) {
		this.altNames.add(alt);
		return;
	}

	@Override
	public String toString() {
		String a = this.name + " | " + this.verb.getName() + " | " + this.noun.getName() + " | " + this.method + "\n";
		a += "Alt: ";
		for (String alt : this.altNames) {
			a += alt + "\n";
		}
		return a;
	}

}
