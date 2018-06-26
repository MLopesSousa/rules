package marcelo.lopes.sousa.lima.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.mock.DashboardManager;

@Path("dashboards")
public class DashboardRest {
	@Inject
	DashboardManager dm;
	
	@GET
	@Path("{description}")
	public Dashboard getDashboard(@PathParam("description") String description) {
		return dm.getDashboard(description);
	}
}
