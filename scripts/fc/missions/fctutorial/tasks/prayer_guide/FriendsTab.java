package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class FriendsTab extends Task
{
	private static final long serialVersionUID = -5480141876598859534L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.FRIENDS);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 580;
	}

	@Override
	public String getStatus()
	{
		return "Open friends tab";
	}

}
