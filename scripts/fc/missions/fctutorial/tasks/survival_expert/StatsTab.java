package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class StatsTab extends Task
{
	private static final long serialVersionUID = 1498331206241027277L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.STATS);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 60;
	}

	@Override
	public String getStatus()
	{
		return "Stats tab";
	}
	
}
