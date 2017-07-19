package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.AttackNpc;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class RangeRat extends Task
{
	private static final long serialVersionUID = -6634211527227299511L;
	private static final List<Positionable> OPEN_TILES = Arrays.asList(new RSTile(3106, 9510, 0), new RSTile(3107, 9511, 0),
			new RSTile(3107, 9512, 0), new RSTile(3109, 9513, 0));
	private static final int ESTIMATED_WAIT = 10000;
	
	private ABC2Reaction reaction = new ABC2Reaction(false, ESTIMATED_WAIT);

	@Override
	public boolean execute()
	{
		if(Player.getRSPlayer().getInteractingCharacter() != null)
		{
			reaction.start();
			return waitForKill();
		}
		
		if(!OPEN_TILES.contains(Player.getPosition()))
		{
			Positionable targetPos = OPEN_TILES.get(General.random(0, OPEN_TILES.size() - 1));
			if(!targetPos.getPosition().isClickable())
				Camera.turnToTile(targetPos);
			
			if(Walking.walkScreenPath(Walking.generateStraightScreenPath(targetPos)))
				FCTiming.waitCondition(() -> Player.getPosition().equals(targetPos), 3500);
		}
		else
		{
			AttackNpc attack = new AttackNpc("Attack", "Giant rat", 15);
			attack.setCheckPath(false);
			
			if(attack.execute() && Timing.waitCondition(FCConditions.IN_COMBAT_CONDITION, 3000))
				return waitForKill();
		}
		
		return !shouldExecute();
	}
	
	private boolean waitForKill()
	{
		reaction.start();
		
		boolean success = Timing.waitCondition(FCConditions.KILL_CONDITION, 30000);
		if(success)
			reaction.react();
		
		return success;
	}
	
	@Override
	public boolean shouldExecute()
	{
		return (FCTutorial.getProgress() == 480 && Equipment.isEquipped("Bronze arrow") && Equipment.isEquipped("Shortbow"))
					|| (FCTutorial.getProgress() == 490);
	}

	@Override
	public String getStatus()
	{
		return "Range rat";
	}

}
