package marcelo.lopes.sousa.lima.definitions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class Definitions {
	private String RULES_DIR; 
	
	private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		this.RULES_DIR = "D:\\RULES";
	}
	
	public String getRulesDir() {
		return this.RULES_DIR;
	}
}
