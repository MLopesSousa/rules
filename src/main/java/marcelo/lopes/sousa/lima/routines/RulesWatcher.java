package marcelo.lopes.sousa.lima.routines;

import java.io.File;
import java.io.IOException;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.entities.Rule;
import marcelo.lopes.sousa.lima.mock.DashboardManager;

@Singleton
public class RulesWatcher {
	@Inject
	private DashboardManager dm;
	private final String RULES_DIR = "D:\\RULES";
	
	@Schedule(second = "*/2", minute = "*", hour = "*")
	private void createRules() {
		for(Dashboard dashboard: dm.listDashboard()) {
			for(Rule rule: dashboard.getRules()) {
				String dir = this.RULES_DIR + "\\" + dashboard.getDescription();
				
				if(!new File(dir).exists()) {
					new File(dir).mkdirs();
				}
				
				File file = new File(dir + "\\" + rule.getDescripition() + ".yaml");
				if(!file.exists()) { 
					JsonNode jsonNodeTree;
					try {
						jsonNodeTree = new ObjectMapper().readTree(rule.getBody());
						new YAMLMapper().writeValue(new File("D:\\rule.yaml"), jsonNodeTree);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
}
