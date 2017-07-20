package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class EnterRatCage extends AnticipativeTask
{
	private static final long serialVersionUID = 5780492008028034953L;

	private ABC2Reaction reaction = new ABC2Reaction(false, 3000);
	
	@Override
	public boolean execute()
	{
		if(new ClickObject("Open", "Gate", new RSArea(new RSTile(3108, 9521, 0), new RSTile(3112, 9516, 0))).execute())
		{
			reaction.start();
			return true;
		}
		
		return !shouldExecute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 440;
	}

	@Override
	public String getStatus()
	{
		return "Enter rat cage";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MELEE_RAT.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		if(FCTiming.waitCondition(() -> !shouldExecute(), 6000))
			reaction.react();
	}

}
