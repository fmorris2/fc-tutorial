package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class WalkToBrotherBrace extends Task
{
	private static final long serialVersionUID = 6582028899684299578L;
	public static final Positionable TARGET_TILE = new RSTile(3124, 3107, 0);
	public static final int DISTANCE_THRESHOLD = 5;

	@Override
	public boolean execute()
	{		
		if(Travel.webWalkTo(TARGET_TILE))
			Timing.waitCondition(FCConditions.withinDistanceOfTile(TARGET_TILE, DISTANCE_THRESHOLD), 4500);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 550 && Player.getPosition().distanceTo(TARGET_TILE) > DISTANCE_THRESHOLD;
	}

	@Override
	public String getStatus()
	{
		return "Walk to Brother Brace";
	}

}
