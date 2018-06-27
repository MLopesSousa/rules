package marcelo.lopes.sousa.lima.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import marcelo.lopes.sousa.lima.entities.Dashboard;
import marcelo.lopes.sousa.lima.mock.DashboardManager;

@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/dashboards")
public class DashboardRest {
	@Inject
	DashboardManager dm;
	
	@GET
	public List<Dashboard> listDashboards() {
		return dm.listDashboard();
	}
	
	@GET
	@Path("{description}")
	public Dashboard getDashboard(@PathParam("description") String description) {
		return dm.getDashboard(description);
	}
	
	@PUT
	@Path("{description}")
	public Dashboard updateDashboard(@PathParam("description") String description, @FormParam("body") Dashboard dashboard) {
		return null;
	}
	
	
}
