package com.mohneesh.app.service;

import org.springframework.http.ResponseEntity;

public interface AppIngestionService {
	 ResponseEntity<?> appInjectionMethod(String task);
}
