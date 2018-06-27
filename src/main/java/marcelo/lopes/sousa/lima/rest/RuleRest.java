package marcelo.lopes.sousa.lima.rest;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import marcelo.lopes.sousa.lima.entities.Rule;
import marcelo.lopes.sousa.lima.mock.DashboardManager;

@Produces({ "application/json" })
@Consumes({ "application/json" })
@Path("/dashboards/{dashboard}/rules/")
public class RuleRest {
	@Inject
	DashboardManager dm;
	
	@GET
	public List<Rule> getRules(@PathParam("dashboard") String dashboard) {
		return dm.getDashboard(dashboard).getRules();
	}
	
	@POST
	public void createRule(@PathParam("dashboard") String dashboard, Rule rule) {
	
	}
}
