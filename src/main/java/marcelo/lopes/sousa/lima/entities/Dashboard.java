package marcelo.lopes.sousa.lima.entities;

import java.util.List;

public class Dashboard {
	Long id;
	String description;
	List<Rule> rules;

	public Dashboard() {

	}

	public Dashboard(Long id, String description, List<Rule> rules) {
		this.id = id;
		this.description = description;
		this.rules = rules;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
