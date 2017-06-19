package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api2007.Player;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class MiningInstructorExit extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -6631125048389989843L;

	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
			return true;
		
		return !shouldExecute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 360;
	}

	@Override
	public String getStatus()
	{
		return "Click gate";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Gate", 25);
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.COMBAT_INSTRUCTOR_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute() || !Player.isMoving(), 6000);
	}

}
