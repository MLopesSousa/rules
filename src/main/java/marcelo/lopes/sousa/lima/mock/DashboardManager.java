package marcelo.lopes.sousa.lima.mock;

import java.util.List;

import marcelo.lopes.sousa.lima.entities.Dashboard;

public interface DashboardManager {
	public Dashboard getDashboard(String description);

	public List<Dashboard> listDashboard();

	public void addDashboard(Dashboard dashboard);

	public Dashboard updateDashboard(Dashboard dashboard);

	public void deleteDashboard(String description);
}
