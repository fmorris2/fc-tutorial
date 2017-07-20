package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api.Timing;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class ClickAnvil extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 8149746082672492751L;
	
	public static final int INTERFACE_MASTER = 312;
	
	private static final RSArea ANVIL_AREA = new RSArea(new RSTile(3082, 9501, 0), new RSTile(3085, 9495, 0));
	
	private ABC2Reaction reaction = new ABC2Reaction(false, 3000);

	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
		{
			reaction.start();
			if(Timing.waitCondition(FCConditions.interfaceUp(INTERFACE_MASTER), 5000))
			{
				reaction.react();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 340 || (FCTutorial.getProgress() == 350 && Interfaces.get(INTERFACE_MASTER) == null);
	}

	@Override
	public String getStatus()
	{
		return "Click anvil";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Smith", "Anvil", ANVIL_AREA);
	}

}
