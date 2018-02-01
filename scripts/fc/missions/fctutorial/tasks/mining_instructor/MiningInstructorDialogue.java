package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class MiningInstructorDialogue extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 6132602685767319522L;

	private static final Positionable TARGET_TILE = new RSTile(3081, 9507, 0);
	private static final int DISTANCE_THRESHOLD = 12;
	boolean walkingToInstructor;
	
	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TARGET_TILE) > DISTANCE_THRESHOLD)
		{
			walkingToInstructor = true;
			new DPathNavigator().traverse(TARGET_TILE);
		}
		else
		{
			walkingToInstructor = false;
			return getInteractable().execute();
		}
		
		return true;
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		return SETTING == 260 || SETTING == 290
				|| SETTING == 291|| SETTING == 330;
	}

	@Override
	public String getStatus()
	{
		return "Mining Instructor dialogue";
	}

	@Override
	public Task getNext()
	{
		if(walkingToInstructor)
			return null;
		
		final int SETTING = FCTutorial.getProgress();
		if(SETTING == 260 || SETTING == 290)
			return TutorialTask.HANDLE_TIN.TASK;
		else if(SETTING == 330)
			return TutorialTask.CLICK_ANVIL.TASK;
		
		return null;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new NpcDialogue("Talk-to", "Mining Instructor", 15, false, 2, 2);
	}

}
