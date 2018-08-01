package com.mohneesh.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.netflix.conductor.client.task.WorkflowTaskCoordinator;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;

@Component
public class ConductorConfig {

	/**
	 * @return WorkflowTaskCoordinator.Builder
	 */
	@Bean
	public WorkflowTaskCoordinator.Builder buildBean() {

		return new WorkflowTaskCoordinator.Builder();
	}

	/**
	 * 
	 * @return WorkflowTask instance
	 */

	@Bean
	@Scope("protoType")
	public WorkflowTask getWorkflowTaskInstance() {

		return new WorkflowTask();
	}

	/**
	 * 
	 * @return WorkflowDef instance
	 */

	@Bean
	@Scope("prototype")
	public WorkflowDef getWorkFlowBean() {
		return new WorkflowDef();
	}

}
