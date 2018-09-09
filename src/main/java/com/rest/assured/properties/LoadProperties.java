package com.rest.assured.properties;

import com.rest.assured.common.*;

public class LoadProperties {
	
	BasicProperties bp = new BasicProperties();
	
	public String getProp (String key){
		
		return bp.load(Global.fileEnv).getProperty(key);
	
	}
	
	public String getData(String key){
		
		return bp.load(Global.fileData).getProperty(key);
	}

}
