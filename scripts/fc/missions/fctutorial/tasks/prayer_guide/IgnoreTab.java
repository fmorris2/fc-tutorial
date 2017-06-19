package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class IgnoreTab extends Task
{
	private static final long serialVersionUID = 3095237295992744775L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.IGNORE);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 590;
	}

	@Override
	public String getStatus()
	{
		return "Open ignore tab";
	}

}
