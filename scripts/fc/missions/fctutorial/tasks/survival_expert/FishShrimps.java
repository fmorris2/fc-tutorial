package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.ClickNpc;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class FishShrimps extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -6769017398897731224L;
	private static final int FISH_ANIM = 621;

	@Override
	public boolean execute()
	{
		boolean success = getInteractable().execute();
		
		if(FCTutorial.getProgress() == 80)
			return Timing.waitCondition(FCConditions.inventoryChanged(Inventory.getAll().length), General.random(6000, 7500));
		
		return success;
	}

	@Override
	public boolean shouldExecute()
	{
		if(Player.getAnimation() != -1)
			return false;
		
		return FCTutorial.getProgress() == 80 || (FCTutorial.getProgress() == 90 && Inventory.getCount("Raw shrimps") <= 1);
	}

	@Override
	public String getStatus()
	{
		return "Fish shrimps";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickNpc("Net", "Fishing spot", 15);
	}

	@Override
	public Task getNext()
	{
		return Player.getAnimation() == FISH_ANIM && Inventory.getCount("Raw shrimps") >= 1 ? TutorialTask.COOK_SHRIMPS.TASK : null;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}
	
}
