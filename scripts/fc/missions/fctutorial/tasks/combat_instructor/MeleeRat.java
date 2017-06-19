package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api.Timing;
import org.tribot.api2007.Player;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.AttackNpc;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MeleeRat extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = -4826359909960013294L;
	
	int setting;

	@Override
	public boolean execute()
	{
		if(Player.getRSPlayer().isInCombat() || Player.getRSPlayer().getInteractingCharacter() != null)
			return true;
			
		if(getInteractable().execute() && Timing.waitCondition(FCConditions.IN_COMBAT_CONDITION, 3500)
				&& Timing.waitCondition(FCConditions.KILL_CONDITION, 40000))
			return true;
		
		return !shouldExecute();
	}

	@Override
	public boolean shouldExecute()
	{
		setting = FCTutorial.getProgress();
		return setting == 450 || setting == 460;
	}

	@Override
	public String getStatus()
	{
		return "Melee rat";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new AttackNpc("Attack", "Giant rat", 15);
	}

}
