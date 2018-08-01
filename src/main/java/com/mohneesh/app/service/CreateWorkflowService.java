package com.mohneesh.app.service;

import org.springframework.http.ResponseEntity;
import com.mohneesh.app.pojo.VideoMetadata;

public interface CreateWorkflowService {
	ResponseEntity<?> createNewWorkFlow(VideoMetadata metadata);
}
