package scripts.fc.missions.fctutorial.tasks.bank_stage;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
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
	
	private ABC2Reaction reaction = new ABC2Reaction(false, 2400);
	
	@Override
	public boolean execute()
	{
		RSObject[] objs = Objects.getAt(EXIT_DOOR_TILE);
		
		if(Player.getPosition().distanceTo(EXIT_DOOR_TILE) > 3)
			Walking.blindWalkTo(objs[0]);
		if(objs.length > 0 && new ClickObject("Open", objs[0]).execute())
		{
			reaction.start();
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 525 || 
				(FCTutorial.getProgress() == 520 
					&& InterfaceUtils.findContainingText("When you're ready, move on through the door indicated") != null);
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
		if(Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 525), 3500))
			reaction.react();
	}

}
