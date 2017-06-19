package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api.Timing;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class ClickOptions extends Task
{
	private static final long serialVersionUID = -1314376717068239123L;
	
	@Override
	public boolean execute()
	{
		if(GameTab.open(TABS.OPTIONS))
			Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 190), 5000);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 190;
	}

	@Override
	public String getStatus()
	{
		return "Click options & wait for run to turn off";
	}
	

}
