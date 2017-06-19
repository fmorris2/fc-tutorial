package scripts.fc.missions.fctutorial.tasks.magic_instructor;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;

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
		DPathNavigator dPath = new DPathNavigator();
		dPath.overrideDoorCache(true, new RSObject[0]);
		dPath.traverse(TARGET);
		
		return false;
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
