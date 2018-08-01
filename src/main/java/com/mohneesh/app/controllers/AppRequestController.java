package com.mohneesh.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mohneesh.app.pojo.VideoMetadata;
import com.mohneesh.app.service.AppIngestionService;
import com.mohneesh.app.service.CreateWorkflowService;
import com.mohneesh.app.service.StartWorkFlowService;
/*import com.mohneesh.app.serviceImpl.AppIngestionServiceImpl;
import com.mohneesh.app.serviceImpl.CreateWorkFlowServiceImpl;
import com.mohneesh.app.serviceImpl.StartWorkFlowServiceImpl;
*/
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * Main Controller
 * @author mohneesh.p
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="conductorClient")
public class AppRequestController {

	@Autowired
	AppIngestionService appInjectionInstance;

	@Autowired
	CreateWorkflowService newWorkFlow;

	@Autowired
	StartWorkFlowService startWorkFlowService;

	@GetMapping(value = "/callInjection")
	@ApiOperation(value = "Ingestion Service")
	public ResponseEntity<?> callInjectionService(@RequestParam(name = "operation") String str) {

		return appInjectionInstance.appInjectionMethod(str);

	}

	@RequestMapping(value = "/createWorkFlow", method = RequestMethod.POST)
	@ApiOperation(value = "Create new Workflow Service")
	public ResponseEntity<?> createNewWorkFlow(@RequestBody VideoMetadata metadata) {
		return newWorkFlow.createNewWorkFlow(metadata);
	}

	@PostMapping("/startWorkFlow")
	@ApiOperation(value = "Start Workflow Service")
	public ResponseEntity<?> startWorkFlow(@RequestBody VideoMetadata meta) {
		return startWorkFlowService.startWorkflowMeth(meta);
	}

}
