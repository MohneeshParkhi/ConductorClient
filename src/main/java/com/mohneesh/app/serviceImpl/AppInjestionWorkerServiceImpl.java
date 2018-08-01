package com.mohneesh.app.serviceImpl;

import org.springframework.stereotype.Service;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.netflix.conductor.common.metadata.tasks.TaskResult.Status;

/**
 * This class is implementation of Worker interface
 * 
 * @author mohneesh.p
 *
 */
@Service
public class AppInjestionWorkerServiceImpl implements Worker {

	private String taskDefName;

	public void setTaskDefName(String taskDefName) {
		this.taskDefName = taskDefName;

	}

	@Override
	public String getTaskDefName() {
		// return task name i.e. task type
		return taskDefName;
	}

	/**
	 * This method is called after polling to change status of task at server side.
	 * 
	 * @return result
	 * @param task
	 * 
	 */
	@Override
	public TaskResult execute(Task task) {

		System.out.println("Task Name" + task);
		System.out.println("Task Instance" + task);
		TaskResult result = new TaskResult(task);
		result.setStatus(Status.COMPLETED);
		return result;
	}

}
