package scripts.fc.missions.fctutorial;

import java.util.LinkedList;

import org.tribot.api2007.Game;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.mission.MissionManager;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class FCTutorial extends MissionManager implements Mission
{
	public FCTutorial(FCMissionScript script)
	{
		super(script);
	}
	
	public FCTutorial(FCMissionScript script, String key)
	{
		super(script);
	}

	public static final int PROGRESS_SETTING = 281;
	
	@Override
	public boolean hasReachedEndingCondition()
	{
		return getProgress() == 1000;
	}

	@Override
	public String getMissionName()
	{
		return "Tutorial Island";
	}

	@Override
	public String getCurrentTaskName()
	{
		return currentTask == null ? "null" : currentTask.getStatus();
	}

	@Override
	public String getEndingMessage()
	{
		return "FC Tutorial has been completed";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[0];
	}

	@Override
	public void execute()
	{
		executeTasks();
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(TutorialTask.ALL_TASKS);
	}
	
	public static int getProgress()
	{
		return Game.getSetting(PROGRESS_SETTING);
	}
	
	public String toString()
	{
		return getMissionName();
	}

	@Override
	public void resetStatistics()
	{}

}
