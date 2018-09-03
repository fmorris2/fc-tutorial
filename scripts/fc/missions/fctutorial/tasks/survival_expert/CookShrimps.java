package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;

import scripts.fc.api.abc.ABC2Reaction;
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
	
	private boolean firstShrimp;
	private final ABC2Reaction reaction = new ABC2Reaction(true, 2500);

	@Override
	public boolean execute()
	{
		if(FCTutorial.getProgress() == 90)
		{
			firstShrimp = true;
			final boolean success = getInteractable().execute();
			reaction.start();
			
			if(success && Timing.waitCondition(FCConditions.animationChanged(-1), 6500)
					&& Timing.waitCondition(FCConditions.inventoryContains("Burnt shrimp"), 6500))
			{
				reaction.react();
				return true;
			}
			
			return false;
		}
		
		firstShrimp = false;
		if(getInteractable().execute() && Timing.waitCondition(FCConditions.animationChanged(-1), 6500))
		{
			reaction.start();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		final int SHRIMPS = Inventory.getCount("Raw shrimps");
		if(Player.getAnimation() != -1)
			return false;
		
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
		General.println("Progress in CookShrimps getNext(): " + FCTutorial.getProgress());
		return firstShrimp ? this : TutorialTask.SURVIVAL_EXPERT_GATE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		if(FCTiming.waitCondition(() -> Player.getAnimation() == -1, 6000))
			reaction.react();
	}

}
