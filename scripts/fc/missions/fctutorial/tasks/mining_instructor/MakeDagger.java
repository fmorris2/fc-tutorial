package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api.Clicking;
import org.tribot.api.Timing;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class MakeDagger extends AnticipativeTask
{
	private static final long serialVersionUID = 3960209709548589124L;
	private static final int INTER_CHILD = 2;
	
	private RSInterface master;
	private ABC2Reaction reaction = new ABC2Reaction(true, 2000);

	@Override
	public boolean execute()
	{
		RSInterface daggerChild = master == null ? null : master.getChild(INTER_CHILD);
		if(daggerChild != null && Clicking.click(daggerChild) && Timing.waitCondition(FCConditions.animationChanged(-1), 5000))
		{
			reaction.start();
			return true;
		}
		
		return !shouldExecute();
	}

	@Override
	public boolean shouldExecute()
	{
		master = Interfaces.get(ClickAnvil.INTERFACE_MASTER);
		return FCTutorial.getProgress() == 350 && master != null;
	}

	@Override
	public String getStatus()
	{
		return "Make dagger";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MINING_INSTRUCTOR_EXIT.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		if(FCTiming.waitCondition(() -> Inventory.getCount("Bronze dagger") > 0, 6000))
			reaction.react();
	}

}
