package scripts.fc.missions.fctutorial.tasks.magic_instructor;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class WalkToMagicInstructor extends Task
{
	private static final long serialVersionUID = -7796891496980718371L;
	public static final Positionable TARGET = new RSTile(3139, 3087);
	public static final int THRESHOLD = 6;

	@Override
	public boolean execute()
	{
		return Travel.webWalkTo(TARGET);
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 620 && Player.getPosition().distanceTo(TARGET) > THRESHOLD;
	}

	@Override
	public String getStatus()
	{
		return "Walk to Magic Instructor";
	}

}
