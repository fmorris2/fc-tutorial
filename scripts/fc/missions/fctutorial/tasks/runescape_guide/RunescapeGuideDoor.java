package scripts.fc.missions.fctutorial.tasks.runescape_guide;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class RunescapeGuideDoor extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 3157225351510368011L;

	private ABC2Reaction reaction = new ABC2Reaction(true, 2500);
	
	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
		{
			reaction.start();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 10;
	}

	@Override
	public String getStatus()
	{
		return "Click door";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Door", new RSArea(new RSTile(3097, 3107, 0), 5));
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.SURVIVAL_EXPERT_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		if(FCTiming.waitCondition(() -> !shouldExecute(), 6000))
			reaction.react();
	}

}
