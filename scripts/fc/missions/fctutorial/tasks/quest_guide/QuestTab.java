package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class QuestTab extends Task
{
	private static final long serialVersionUID = -3577202548768354448L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.QUESTS);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 230;
	}

	@Override
	public String getStatus()
	{
		return "Open quest tab";
	}

}
