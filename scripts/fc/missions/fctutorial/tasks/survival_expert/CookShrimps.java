package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class CookShrimps extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 6159860992107728108L;

	@Override
	public boolean execute()
	{
		if(FCTutorial.getProgress() == 90)
		{
			return getInteractable().execute()
					&& Timing.waitCondition(FCConditions.animationChanged(-1), 6500)
					&& Timing.waitCondition(FCConditions.animationChanged(897), 6500);
		}
		
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		final int SHRIMPS = Inventory.getCount("Raw shrimps");
		return (SETTING == 90 && SHRIMPS >= 2) || (SETTING == 110 && SHRIMPS >= 1);
	}

	@Override
	public String getStatus()
	{
		return "Cook shrimps";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ItemOnObject("Use", "Fire", "Raw shrimps", 15);
	}

	@Override
	public Task getNext()
	{
		return FCTutorial.getProgress() < 110 ? this : TutorialTask.SURVIVAL_EXPERT_GATE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
