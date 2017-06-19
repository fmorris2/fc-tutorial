package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api2007.Options;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class TurnRunOn extends Task
{
	private static final long serialVersionUID = 5082991673248036880L;

	@Override
	public boolean execute()
	{
		Options.setRunOn(true);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 200;
	}

	@Override
	public String getStatus()
	{
		return "Turn run on";
	}

}
