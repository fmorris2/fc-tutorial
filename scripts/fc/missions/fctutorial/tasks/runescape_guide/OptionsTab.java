package scripts.fc.missions.fctutorial.tasks.runescape_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.api.utils.Utils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class OptionsTab extends Task
{
	private static final long serialVersionUID = 5958434404215345678L;

	@Override
	public boolean execute()
	{
		if(GameTab.open(TABS.OPTIONS))
		{
			Utils.removeRoofs();
			Utils.turnSoundDown();
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 3;
	}

	@Override
	public String getStatus()
	{
		return "Click options tab";
	}

}
