package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class ChopTree extends AnticipativeTask
{
	private static final long serialVersionUID = -2656198936560507724L;

	@Override
	public boolean execute()
	{
		General.println("Executing ChopTree...");
		return new ClickObject("Chop down", "Tree", 15, true, true).execute() 
				&& Timing.waitCondition(FCConditions.animationChanged(-1), 5000);
	}

	@Override
	public boolean shouldExecute()
	{
		if(Player.getAnimation() != -1)
			return false;
		
		return Inventory.getCount("Logs") == 0 && (FCTutorial.getProgress() == 40/* || FCTutorial.getProgress() == 50*/);
	}

	@Override
	public String getStatus()
	{
		return "Chop tree";
	}

	@Override
	public Task getNext()
	{
		return !LightFire.isFireOnTile(Player.getPosition()) ? TutorialTask.LIGHT_FIRE.TASK : null;
	}

	@Override
	public void waitForTaskComplete()
	{
		General.println("Waiting to chop tree!!");
		FCTiming.waitCondition(() -> Inventory.getCount("Logs") > 0 && FCTutorial.getProgress() > 40, 7500);
	}

}
