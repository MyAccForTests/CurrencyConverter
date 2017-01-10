package model.services;

import ScheduledTasks.ScheduledTask;

/**
 * Created by Ilua on 10.01.2017.
 */
public interface ScheduledTasksExecutorService {
    void addTask(ScheduledTask task, int period);
    void removeTask(ScheduledTask task);
}
