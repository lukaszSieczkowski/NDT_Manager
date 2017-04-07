package pl.ndt.manager.services;

import java.io.File;

public interface FileDirectory {
	
	public final String UPLOAD_FOLDER = System.getProperty("catalina.home") + File.separator + "NDT_MANAGER_FILES"
			+ File.separator;
}
