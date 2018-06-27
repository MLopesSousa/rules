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
		rules.add(new Rule("rule01", "#808080", "{}", true));
		rules.add(new Rule("rule02", "#CD5C5C", "{}", true));

		Dashboard ds = new Dashboard();
		ds.setId(1L);
		ds.setDescription("Rommel");
		ds.setRules(rules);

		List<Rule> rules2 = new ArrayList<Rule>();
		rules2.add(new Rule("rule03", "#808080",
				"{\"es_host\":\"172.30.68.214\",\"es_port\":9200,\"index\":\"log-%Y.%m.%d\",\"use_strftime_index\":true,\"name\":\"rule06\",\"type\":\"any\",\"query_key\":[\"instance\",\"target\"],\"filter\":[{\"term\":{\"@type\":\"jboss\"}},{\"match\":{\"@message\":\"java.lang.OutOfMemoryError\"}}],\"alert\":[\"command\"],\"pipe_match_json\":true,\"command\":[\"/opt/elastalert/scripts/cepro/run.py\"],\"realert\":{\"minutes\":10}}",
				true));

		Dashboard ds2 = new Dashboard();
		ds2.setId(2L);
		ds2.setDescription("Adalberto");
		ds2.setRules(rules2);

		this.dashboards.add(ds);
		this.dashboards.add(ds2);
	}

	public Dashboard getDashboard(String description) {
		for (Dashboard ds : this.dashboards) {
			if (ds.getDescription().equals(description)) {
				return ds;
			}
		}
		
		Dashboard ds = new Dashboard(new Long(this.dashboards.size() + 1), description, new ArrayList<Rule>());
		this.addDashboard(ds);
		return ds;
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

	public Dashboard updateDashboard(Dashboard dashboard) {
		return null;
	}
}
