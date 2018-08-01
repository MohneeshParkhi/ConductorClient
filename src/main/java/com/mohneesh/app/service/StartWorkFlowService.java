package com.mohneesh.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mohneesh.app.pojo.VideoMetadata;

@Service
public interface StartWorkFlowService {
   ResponseEntity<?> startWorkflowMeth(VideoMetadata metadata);
}
