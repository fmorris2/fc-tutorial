package scripts.fc.missions.fctutorial.tasks.bank_stage;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Keyboard;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.utils.InterfaceUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class PollBooth extends Task
{
	private static final long serialVersionUID = 1240933668596100934L;
	private static final Condition SPACEBAR_HOLD_CONDITION = spacebarHoldCondition();
	
	private ABC2Reaction reaction = new ABC2Reaction(true, 2400);
	
	@Override
	public boolean execute()
	{
		if(Banking.close() && new ClickObject("Use", "Poll booth", 15).execute())
		{	
			reaction.start();
			if(Timing.waitCondition(FCConditions.IN_DIALOGUE_CONDITION, 3500))
			{
				reaction.react();
				while(InterfaceUtils.findContainingText("When you're ready, move on through the door indicated") == null && !TutorialTask.BANKING_EXIT.TASK.shouldExecute())
				{
					Keyboard.holdKey(' ', Keyboard.getKeyCode(' '), SPACEBAR_HOLD_CONDITION);
					General.sleep(10);
				}
			}
		}
		
		return false;
	}
	
	private static Condition spacebarHoldCondition() {
		return new Condition() {
			@Override
			public boolean active() {
				return TutorialTask.BANKING_EXIT.TASK.shouldExecute() || FCConditions.SPACEBAR_HOLD.active();
			}
			
		};
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 520; 
	}

	@Override
	public String getStatus()
	{
		return "Poll booth";
	}

}
