package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class MasterChefDoor extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -1221964821671959304L;

	@Override
	public boolean execute()
	{
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 130;
	}

	@Override
	public String getStatus()
	{
		return "Open door";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Door", new RSArea(new RSTile(3077, 3086, 0), new RSTile(3080, 3083, 0)));
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MASTER_CHEF_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 7500);
	}

}
