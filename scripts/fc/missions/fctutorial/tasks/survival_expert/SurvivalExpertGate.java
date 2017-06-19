package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api2007.Player;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class SurvivalExpertGate extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -4737101560208497031L;

	@Override
	public boolean execute()
	{
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 120;
	}

	@Override
	public String getStatus()
	{
		return "Click gate";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Gate", 20);
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MASTER_CHEF_DOOR.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute() || !Player.isMoving(), 6000);
	}

}
