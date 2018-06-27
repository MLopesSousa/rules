package marcelo.lopes.sousa.lima.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.entities.Rule;

@ApplicationScoped
public class DashboardManagerImplementation implements DashboardManager {
	Map<String, Dashboard> dashboards = new HashMap<String, Dashboard>();

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

		this.dashboards.put(ds.getDescription(), ds);
		this.dashboards.put(ds2.getDescription(), ds2);
	}

	public Dashboard getDashboard(String description) {
		if (this.dashboards.containsKey(description)) {
			return this.dashboards.get(description);
		} else {
			Dashboard ds = new Dashboard(new Long(this.dashboards.size() + 1), description, new ArrayList<Rule>());
			this.addDashboard(ds);
			return ds;
		}

	}

	public List<Dashboard> listDashboard() {
		return new ArrayList<Dashboard>(this.dashboards.values());
	}

	public void addDashboard(Dashboard dashboard) {
		this.dashboards.put(dashboard.getDescription(), dashboard);
	}

	public Dashboard updateDashboard(Dashboard dashboard) {
		this.dashboards.remove(dashboard.getDescription());
		this.dashboards.put(dashboard.getDescription(), dashboard);
		return dashboard;
	}

	public void deleteDashboard(String description) {
		this.dashboards.remove(description);
	}
}
