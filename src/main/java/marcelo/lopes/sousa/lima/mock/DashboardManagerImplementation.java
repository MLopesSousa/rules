package marcelo.lopes.sousa.lima.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.entities.Rule;

@Startup
@Singleton
public class DashboardManagerImplementation implements DashboardManager {
	List<Dashboard> dashboards = new ArrayList<Dashboard>();
	
	@PostConstruct
	private void onStartup() {
		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new Rule("rule01","#808080","{}"));
		rules.add(new Rule("rule02","#CD5C5C","{}"));
		
		Dashboard ds = new Dashboard();
		ds.setId(1L);
		ds.setDescription("Rommel");
		ds.setRules(rules);
		
		List<Rule> rules2 = new ArrayList<Rule>();
		rules.add(new Rule("rule03","#808080","{}"));
		rules.add(new Rule("rule04","#CD5C5C","{}"));
		
		Dashboard ds2 = new Dashboard();
		ds2.setId(2L);
		ds2.setDescription("Adalberto");
		ds2.setRules(rules2);
	}
	
	public Dashboard getDashboard(String description) {
		for(Dashboard ds: this.dashboards) {
			if(ds.getDescription().equals(description)) {
				return ds;
			}
		}
		
		return null;
	}
	
	public List<Dashboard> listDashboard() {
		return this.dashboards;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboards.add(dashboard);
	}

	public void removeDashboard(Dashboard dashboard) {
		this.dashboards.remove(dashboard);
	}

}
