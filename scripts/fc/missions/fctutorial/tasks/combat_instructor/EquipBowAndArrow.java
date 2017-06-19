package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api2007.Equipment;

import scripts.fc.api.items.ItemUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class EquipBowAndArrow extends Task
{
	private static final long serialVersionUID = 8349637399147565836L;

	@Override
	public boolean execute()
	{
		if(!ItemUtils.equipItem("Shortbow") || !ItemUtils.equipItem("Bronze arrow"))
			return false;
		
		return true;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 480 
				&& (!Equipment.isEquipped("Shortbow") || !Equipment.isEquipped("Bronze arrow"));
	}

	@Override
	public String getStatus()
	{
		return "Equip bow and arrow";
	}

}
