package com.mohneesh.app.serviceImpl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mohneesh.app.config.ConductorConfig;
import com.mohneesh.app.config.ConductorConstantFile;
import com.mohneesh.app.pojo.VideoMetadata;

import com.mohneesh.app.service.AppIngestionService;
import com.mohneesh.app.service.CreateWorkflowService;
import com.mohneesh.app.service.StartWorkFlowService;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;

/**
 * 
 * @author mohneesh.p
 *
 */
@Service
public class CreateWorkFlowServiceImpl implements CreateWorkflowService {

	@Autowired
	WorkflowDef workFlowdef;

	@Autowired
	ConductorConstantFile constFile;

	@Autowired
	ConductorConfig conductorConfig;

	@Autowired
	AppIngestionService appIngestionpollService;

	@Autowired
	StartWorkFlowService workFlowService;

	@Override
	public ResponseEntity<?> createNewWorkFlow(VideoMetadata metadata) {

		String url = "http://localhost:8080/api/metadata/workflow";
		LinkedList<WorkflowTask> tasks = new LinkedList<WorkflowTask>();

		RestTemplate restC = new RestTemplate();

		WorkflowTask ingestion = conductorConfig.getWorkflowTaskInstance();
		System.out.println(ingestion.hashCode());
		ingestion.setName(ConductorConstantFile.task1Name);
		ingestion.setTaskReferenceName(ConductorConstantFile.task1RefrenceName);
		ingestion.setType(ConductorConstantFile.task1Type);

		WorkflowTask process = conductorConfig.getWorkflowTaskInstance();
		System.out.println(process.hashCode());
		process.setName(ConductorConstantFile.task2Name);
		process.setTaskReferenceName(ConductorConstantFile.task2RefrenceName);
		process.setType(ConductorConstantFile.task2Type);

		WorkflowTask transcoding = conductorConfig.getWorkflowTaskInstance();
		System.out.println(transcoding.hashCode());
		transcoding.setName(ConductorConstantFile.task3Name);
		transcoding.setTaskReferenceName(ConductorConstantFile.task3RefrenceName);
		transcoding.setType(ConductorConstantFile.task3Type);

		tasks.add(ingestion);
		tasks.add(process);
		tasks.add(transcoding);

		workFlowdef.setCreatedBy(metadata.getCreatedBy());
		workFlowdef.setDescription(metadata.getVideoDescription());
		workFlowdef.setName(metadata.getVideoName());
		workFlowdef.setSchemaVersion(metadata.getSchemaVersion());
		workFlowdef.setOwnerApp(metadata.getOwnerApp());
		workFlowdef.setVersion(metadata.getVersion());
		workFlowdef.setTasks(tasks);

		ResponseEntity<String> id = restC.postForEntity(url, workFlowdef, String.class);

		workFlowService.startWorkflowMeth(metadata);

		appIngestionpollService.appInjectionMethod("Ingestion");
		return id;
	}

}
