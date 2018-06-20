package org.simpletomcat;

import java.io.File;

public class Constants {
  public static final String WEB_ROOT =
    System.getProperty("user.dir") + File.separator  + "webapp";
	public static String SHUTDOWN = "/shutdown";
}
