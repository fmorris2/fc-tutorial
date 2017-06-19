package scripts.fc.missions.fctutorial.tasks.bank_stage;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class BankerDialogue extends Task
{
	private static final long serialVersionUID = 1179595891873863609L;
	private static final Positionable DIALOGUE_TILE = new RSTile(3121, 3123, 0);
	
	@Override
	public boolean execute()
	{
		RSNPC[] bankers = NPCs.find("Banker");
		
		if(bankers.length > 0)
		{
			if(Player.getPosition().distanceTo(DIALOGUE_TILE) > 2)
				new DPathNavigator().traverse(DIALOGUE_TILE);
			else
				new NpcDialogue("Talk-to", "Banker", 25, 0).execute();
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 510 && Player.getPosition().getY() <= 3500;
	}

	@Override
	public String getStatus()
	{
		return "Banker dialogue";
	}

}
