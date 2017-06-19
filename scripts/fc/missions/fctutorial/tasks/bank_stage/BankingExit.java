package scripts.fc.missions.fctutorial.tasks.bank_stage;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.utils.InterfaceUtils;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class BankingExit extends AnticipativeTask
{
	private static final long serialVersionUID = 2085896203169675974L;
	private static final Positionable EXIT_DOOR_TILE = new RSTile(3125, 3124, 0);
	
	@Override
	public boolean execute()
	{
		RSObject[] objs = Objects.getAt(EXIT_DOOR_TILE);
		
		if(InterfaceUtils.findContainingText("Content Poll #") != null)
			Walking.blindWalkTo(objs[0]);
		else if(objs.length > 0 && new ClickObject("Open", objs[0]).execute())
			return true;
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 525;
	}

	@Override
	public String getStatus()
	{
		return "Click door";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.FINANCIAL_ADVISOR_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 525), 3500);
	}

}