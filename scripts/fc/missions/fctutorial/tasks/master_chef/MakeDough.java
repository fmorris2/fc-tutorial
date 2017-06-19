package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.items.ItemUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MakeDough extends Task
{
	private static final long serialVersionUID = -2426522816509099562L;

	@Override
	public boolean execute()
	{
		final int START_AMT = Inventory.getAll().length;
		if(ItemUtils.useItemOnItem("Pot of flour", "Bucket of water"))
			Timing.waitCondition(FCConditions.inventoryChanged(START_AMT), 5000);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 150;
	}

	@Override
	public String getStatus()
	{
		return "Make dough";
	}

}
