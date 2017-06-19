package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Game;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.items.ItemOnItem;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class LightFire extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 8317087202347142705L;
	
	@Override
	public boolean execute()
	{
		if(Game.isUptext("Use Tinderbox"))
		{
			if(isFireOnTile(Player.getPosition()))
				Mouse.click(1);
			else
			{
				return getInteractable().execute() && Timing.waitCondition(FCConditions.animationChanged(-1), 3000)
						&& Timing.waitCondition(FCConditions.animationChanged(733), 7500);
			}
		}
		
		makeFire();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 50 && Inventory.getCount("Logs") > 0;
	}

	@Override
	public String getStatus()
	{
		return "Light fire";
	}
	
	private boolean makeFire()
	{
		if(isFireOnTile(Player.getPosition()))
		{
			moveToOpenTile();
			return false;
		}
		
		if(getInteractable().execute() && Timing.waitCondition(FCConditions.animationChanged(-1), 3000)
				&& Timing.waitCondition(FCConditions.animationChanged(733), 7500)
				&& FCTiming.waitCondition(() -> FCTutorial.getProgress() > 50, 10000))
			return true;
		
		return false;
	}
	
	public static boolean isFireOnTile(Positionable p)
	{
		return Objects.getAt(p, Filters.Objects.nameEquals("Fire")).length > 0;
	}
	
	private void moveToOpenTile()
	{
		RSArea potential = new RSArea(Player.getPosition().translate(-3, 3),
				Player.getPosition().translate(3, -3));
		
		for(RSTile t : potential.getAllTiles())
		{
			if(PathFinding.canReach(t, false) && !isFireOnTile(t))
			{
				Walking.walkTo(t);
				break;
			}
		}
	}

	@Override
	public EntityInteraction getInteractable()
	{
		General.println("Getting LightFire Interactable!");
		return new ItemOnItem("Use", "Tinderbox", "Logs");
	}

}
