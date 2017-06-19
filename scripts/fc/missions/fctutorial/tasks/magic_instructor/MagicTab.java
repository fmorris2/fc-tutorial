package scripts.fc.missions.fctutorial.tasks.magic_instructor;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MagicTab extends Task
{
	private static final long serialVersionUID = 7955504266331210964L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.MAGIC);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 630;
	}

	@Override
	public String getStatus()
	{
		return "Open magic tab";
	}

}
