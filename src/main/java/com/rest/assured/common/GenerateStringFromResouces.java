package com.rest.assured.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateStringFromResouces {
	
	/**
	 * This method use when only to convert xml file to String and add to body of POST request
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public String generateStringFromSources(String path) throws IOException {
		
		return new String (Files.readAllBytes(Paths.get(path)));
	}

}
