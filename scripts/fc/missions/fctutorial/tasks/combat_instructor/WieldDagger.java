package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api2007.Interfaces;

import scripts.fc.api.items.ItemUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class WieldDagger extends Task
{
	private static final long serialVersionUID = -1684947311939380326L;

	@Override
	public boolean execute()
	{
		ItemUtils.equipItem("Bronze dagger");
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 405 && Interfaces.get(ViewEquipment.EQUIP_SCREEN_MASTER) != null;
	}

	@Override
	public String getStatus()
	{
		return "Wield dagger";
	}

}
