package marcelo.lopes.sousa.lima.routines;

import java.io.File;
import java.io.IOException;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import marcelo.lopes.sousa.lima.definitions.Definitions;
import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.entities.Rule;
import marcelo.lopes.sousa.lima.mock.DashboardManager;

@Singleton
public class RulesWatcher {
	@Inject
	private DashboardManager dm;
	
	@Inject
	private Definitions df;
	
	@Schedule(second = "*/2", minute = "*", hour = "*")
	private void createRules() {
		for(Dashboard dashboard: dm.listDashboard()) {
			for(Rule rule: dashboard.getRules()) {
				String dir = df.getRulesDir() + "\\" + dashboard.getDescription();
				rule.setPath(dir + "\\" + rule.getDescripition() + ".yaml");
				File file = new File(rule.getPath());
				
				if(!new File(dir).exists()) {
					new File(dir).mkdirs();
				}
				
				if(rule.isEnabled()) {	
					if(!file.exists()) { 
						JsonNode jsonNodeTree;
						try {
							jsonNodeTree = new ObjectMapper().readTree(rule.getBody());
							((ObjectNode) jsonNodeTree).put("name", dashboard.getDescription() + ":" + rule.getDescripition());
							new YAMLMapper().writeValue(file, jsonNodeTree);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					if(!file.exists()) {
						file.delete();
					}
				}
			}
		}
	}
}
