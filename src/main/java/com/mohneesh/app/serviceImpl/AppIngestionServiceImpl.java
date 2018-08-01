package com.mohneesh.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mohneesh.app.service.AppIngestionService;
import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.task.WorkflowTaskCoordinator;

@Service
public class AppIngestionServiceImpl implements AppIngestionService {

	@Autowired
	WorkflowTaskCoordinator.Builder builder;

	/**
	 * this method need to updated to call the Worker Thread...
	 * 
	 * @param task
	 * @return ResponseEntity<?>
	 */
	@Override
	public ResponseEntity<?> appInjectionMethod(String task) {

		TaskClient taskClient = new TaskClient();
		taskClient.setRootURI("http://localhost:8080/api/");

		int threadCount = 5; // initializing no of threads for worker system
		AppInjestionWorkerServiceImpl appInjectionWorker1 = new AppInjestionWorkerServiceImpl();
		if ("Ingestion".equalsIgnoreCase(task))
			appInjectionWorker1.setTaskDefName("Ingestion");
		else if ("Process".equalsIgnoreCase(task))
			appInjectionWorker1.setTaskDefName("Process");
		else if ("Transcoding".equalsIgnoreCase(task))
			appInjectionWorker1.setTaskDefName("Transcoding");

		AppInjestionWorkerServiceImpl appInjectionWorker2 = new AppInjestionWorkerServiceImpl();
		appInjectionWorker2.setTaskDefName("Transcoding");

		// Worker workerOne = appInjectionWorker;
		WorkflowTaskCoordinator coordinator = builder.withWorkers(appInjectionWorker1).withThreadCount(threadCount)
				.withTaskClient(taskClient).build();

		coordinator.init();

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
