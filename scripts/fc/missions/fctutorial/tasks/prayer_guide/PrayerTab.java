package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class PrayerTab extends Task
{
	private static final long serialVersionUID = -693824880268120521L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.PRAYERS);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 560;
	}

	@Override
	public String getStatus()
	{
		return "Open prayer tab";
	}

}
