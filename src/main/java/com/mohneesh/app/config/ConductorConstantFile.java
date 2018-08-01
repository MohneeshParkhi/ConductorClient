package com.mohneesh.app.config;

import org.springframework.stereotype.Component;

/**
 * This class provide constant values for creation of tasks
 * 
 * @author mohneesh.p
 * 
 */

@Component
public class ConductorConstantFile {

	// task One credentials....
	public static final String task1Name = "Ingestion";
	public static final String task1RefrenceName = "Ingestion";
	public static final String task1Type = "SIMPLE";

	// task 2 Credentials...
	public static final String task2Name = "Process";
	public static final String task2RefrenceName = "Process";
	public static final String task2Type = "Simple";

	// task 3 credentials...
	public static final String task3Name = "Transcoding";
	public static final String task3RefrenceName = "Transcoding";
	public static final String task3Type = "Simple";

}
