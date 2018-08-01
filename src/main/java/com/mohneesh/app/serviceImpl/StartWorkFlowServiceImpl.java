package com.mohneesh.app.serviceImpl;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mohneesh.app.pojo.VideoMetadata;
import com.mohneesh.app.service.StartWorkFlowService;

/**
 * @author mohneesh.p
 * 
 */
@Service
public class StartWorkFlowServiceImpl implements StartWorkFlowService {

	/**
	 * This method starts the workflow execution and schedule first task to Queue
	 * for processing.
	 * 
	 * @param metadata
	 * @return workflowId
	 */
	@Override
	public ResponseEntity<?> startWorkflowMeth(VideoMetadata metadata) {

		String baseUrl = "http://localhost:8080/api/workflow/";
		RestTemplate restClient = new RestTemplate();

		String URI = baseUrl + metadata.getVideoName() + "?version=" + metadata.getVersion();

		System.out.println(URI);

		HttpEntity<VideoMetadata> http = new HttpEntity<VideoMetadata>(metadata);

		ResponseEntity<String> workflowId = restClient.postForEntity(URI, http, String.class);

		return workflowId;
	}

}
