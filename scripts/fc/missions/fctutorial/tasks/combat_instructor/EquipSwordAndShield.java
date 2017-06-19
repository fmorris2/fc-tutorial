package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import scripts.fc.api.items.ItemUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class EquipSwordAndShield extends Task
{
	private static final long serialVersionUID = 5727634730163728385L;

	@Override
	public boolean execute()
	{
		ItemUtils.equipItem("Bronze sword");
		ItemUtils.equipItem("Wooden shield");
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 420;
	}

	@Override
	public String getStatus()
	{
		return "Equip sword and shield";
	}

}
