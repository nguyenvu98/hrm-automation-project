package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "http://localhost:90/orangehrm5/web/index.php/auth/login"; 
	
	public static final String PROJECT_PATH = System.getProperty("user.dir"); 
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator +"uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator +"downloadFiles" ;
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator +"browserLogs"; 
	public static final String DRAG_DROP_HTML = PROJECT_PATH + File.separator +"dragDropHTML"; 
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator +"autoIT";
}
