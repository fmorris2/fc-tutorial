package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class SmeltOre extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -8822531871057467898L;

	@Override
	public boolean execute()
	{
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 320;
	}

	@Override
	public String getStatus()
	{
		return "Smelt ore";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ItemOnObject("Use", 10082, "Tin ore", 20);
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MINING_INSTRUCTOR_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
