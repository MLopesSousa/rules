package marcelo.lopes.sousa.lima.entities;

public class Rule {
	String descripition;
	String color;
	String body;
	boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void enable() {
		this.enabled = true;
	}
	
	public void disable() {
		this.enabled = false;
	}

	public Rule(String description, String color, String body, boolean enabled) {
		this.descripition = description;
		this.color = color;
		this.body = body;
		this.enabled = enabled;
	}
	
	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
