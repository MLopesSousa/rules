package marcelo.lopes.sousa.lima.mock;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.entities.Rule;

@ApplicationScoped
public class DashboardManagerImplementation implements DashboardManager {
	List<Dashboard> dashboards = new ArrayList<Dashboard>();
	
	private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
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
		
		this.dashboards.add(ds);
		this.dashboards.add(ds2);
	}
	
	public Dashboard getDashboard(String description) {
		for(Dashboard ds: this.dashboards) {
			if(ds.getDescription().equals(description)) {
				return ds;
			}
		}
		
		return new Dashboard(new Long(this.dashboards.size() + 1), description, new ArrayList<Rule>());
	}
	
	public List<Dashboard> listDashboard() {
		return this.dashboards;
	}

	public void addDashboard(Dashboard dashboard) {
		this.dashboards.add(dashboard);
	}

	public void removeDashboard(Dashboard dashboard) {
		this.dashboards.remove(dashboard);
	}

}
