package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class OpenQuestGuideDoor extends AnticipativeTask
{
	private static final long serialVersionUID = 7902124529325875281L;
	
	private static final Positionable DOOR_TILE = new RSTile(3086, 3127, 0);
	private static final int FAILURE_THRESH = 5;
	
	private int failures;

	@Override
	public boolean execute()
	{
		if(failures > FAILURE_THRESH && Player.getPosition().distanceTo(DOOR_TILE) > 8)
			Walking.blindWalkTo(DOOR_TILE);
		else if(new ClickObject("Open", "Door", new RSArea(new RSTile(3084, 3128, 0), new RSTile(3088, 3123, 0))).execute())
			return true;
		else
		{
			failures++;
			Camera.setCameraAngle(General.random(0, 100));
			Camera.setCameraRotation(General.random(0, 360));
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 210;
	}

	@Override
	public String getStatus()
	{
		return "Open door";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.QUEST_GUIDE_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
