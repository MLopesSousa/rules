package marcelo.lopes.sousa.lima.entities;

public class Rule {
	String descripition;
	String color;
	String body;

	public Rule(String description, String color, String body) {
		this.descripition = description;
		this.color = color;
		this.body = body;
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
