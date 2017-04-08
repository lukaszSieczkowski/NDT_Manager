package pl.ndt.manager.services;

import java.io.File;

public interface FileDirectory {
	/**
	 * Target folder in server directory
	 */
	public final String UPLOAD_FOLDER = System.getProperty("catalina.home") + File.separator + "NDT_MANAGER_FILES"
			+ File.separator;
}
