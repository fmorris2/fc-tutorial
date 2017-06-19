package scripts.fc.missions.fctutorial.tasks.magic_instructor;

import org.tribot.api.Clicking;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Game;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.ClickNpc;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class CastWindStrike extends AnticipativeTask
{
	private static final long serialVersionUID = -6873472290393042208L;
	
	private static final RSArea CAST_AREA = new RSArea(new RSTile(3140, 3090, 0), 1);
	private static final int MAGIC_INTER_MASTER = 218;
	private static final int SPELL_CHILD = 2;

	@Override
	public boolean execute()
	{
		if(!CAST_AREA.contains(Player.getPosition()))
		{
			RSTile t = CAST_AREA.getRandomTile();
			
			if(!t.isOnScreen())
				Camera.turnToTile(t);
			
			if(Game.isUptext("Wind"))
				Mouse.click(1);
			
			if(Walking.walkScreenPath(Walking.generateStraightScreenPath(t)))
					Timing.waitCondition(FCConditions.inAreaCondition(CAST_AREA), 3500);
		}
		else if(CAST_AREA.contains(Player.getPosition()))
		{
			if(Game.isUptext("Wind"))
			{
				if(new ClickNpc("Cast Wind Strike ->", "Chicken", 15).execute())
					return true;
			}
			else
			{
				if(GameTab.open(TABS.MAGIC))
				{
					RSInterface inter = Interfaces.get(MAGIC_INTER_MASTER, SPELL_CHILD);
					
					if(inter != null)
						Clicking.click(inter);
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 650;
	}

	@Override
	public String getStatus()
	{
		return "Cast wind strike";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.MAGIC_INSTRUCTOR_DIALOGUE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 650), 2500);
	}

}
