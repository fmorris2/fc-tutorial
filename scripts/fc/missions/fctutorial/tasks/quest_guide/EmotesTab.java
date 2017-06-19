package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class EmotesTab extends Task
{
	private static final long serialVersionUID = -3831426448491961010L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.EMOTES);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 183;
	}

	@Override
	public String getStatus()
	{
		return "Emotes tab";
	}

}
