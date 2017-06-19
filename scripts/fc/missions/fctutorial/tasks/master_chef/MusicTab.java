package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MusicTab extends Task
{
	private static final long serialVersionUID = 2332928535472639585L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.MUSIC);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 170;
	}

	@Override
	public String getStatus()
	{
		return "Music tab";
	}

}
