package com.accelerator.automation.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private Properties orProperties;
	public static Properties dbProperties;
	private final String propertyFilePath = System.getProperty("user.dir") + "/config/config.properties";
	private final String objectrepositoryFilePath = System.getProperty("user.dir")
			+ "/configs/objectrepository.properties";

	// *************************************************
	private static ConfigFileReader configFileReader, objectRepositoryFileReader;

	public static ConfigFileReader getConfigFileReader() {
		String config = "CONFIG";
		if (configFileReader != null) {
			return configFileReader;
		} else {
			configFileReader = new ConfigFileReader(config);
			return configFileReader;
		}

	}

	public static ConfigFileReader getObjectRepositoryFileReader() {
		String repo = "OR";
		if (objectRepositoryFileReader != null) {
			return objectRepositoryFileReader;
		} else {
			objectRepositoryFileReader = new ConfigFileReader(repo);
			return objectRepositoryFileReader;
		}

	}
	// *************************************************

	protected ConfigFileReader(String configType) {
		System.out.println("Into Config file reader");

		BufferedReader reader = null;
		try {
			if (configType.equalsIgnoreCase("CONFIG")) {
				System.out.println("Into Config ");
				properties = new Properties();
				reader = new BufferedReader(new FileReader(propertyFilePath));
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					System.out.println("Here is the exception in config");
					e.printStackTrace();
				}

			} else if (configType.equalsIgnoreCase("OR")) {
				System.out.println("Into OR Config ");
				orProperties = new Properties();
				reader = new BufferedReader(new FileReader(objectrepositoryFilePath));
				try {
					orProperties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// properties = new Properties();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getOIMUrl() {
		String url = properties.getProperty("OIM_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getBYDUrl() {
		String url = properties.getProperty("BYD_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getCOOUrl() {
		String url = properties.getProperty("COO_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getECOMUrl() {
		String url = properties.getProperty("ECOM_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getCOOUserName() {
		String userName = properties.getProperty("Coach_Username");
		if (userName != null && !userName.isEmpty())
			return userName;
		else
			throw new RuntimeException("COO_Username not specified in the config.properties file.");
	}

	public String getCOOPassword() {
		String password = properties.getProperty("Coach_Password");
		if (password != null && !password.isEmpty())
			return password;
		else
			throw new RuntimeException("COO_Password not specified in the config.properties file.");
	}

	public String getTBBUrl() {
		String url = properties.getProperty("TBB_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getBYDSearchUrl() {
		String url = properties.getProperty("BYD_SEARCH_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getElement(String elemntName) {
		String tempElement = orProperties.getProperty(elemntName);
		if (tempElement != null)
			return tempElement;
		else
			throw new RuntimeException(tempElement + " not specified in the ObjectRepository.properties file.");
	}

	public String getDriverPath() {
		String driverPath = System.getProperty("user.dir") + properties.getProperty("driverpath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlywait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {

		String url = null;
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(System.getenv("APP_URL"));
			url = System.getenv("APP_URL");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		} catch (Exception e) {
			url = null;
		}
		if (url == null) {
			url = properties.getProperty("url");
		}

		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getApiGatewayUrl() {
		String url = properties.getProperty("apigateway");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getBeachBodyOIMApplicationUrl() {
		System.out.println("#########################################" + properties.getProperty("OIM_QA3_URL"));
		String url = properties.getProperty("OIM_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}

	public String getKeyStatus() {
		String url = properties.getProperty("Jsonkeys");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public int getWebDriverWait() {
		String webdriverwait = properties.getProperty("webdriverwait");
		if (webdriverwait != null)
			return Integer.parseInt(webdriverwait);
		else
			throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}

	public long getPause() {
		String pause = properties.getProperty("pause");
		if (pause != null)
			return Long.parseLong(pause);
		else
			throw new RuntimeException("pause not specified in the Configuration.properties file.");
	}

	public long getPageLoadPause() {
		String pageloadpause = properties.getProperty("pageloadpause");
		if (pageloadpause != null)
			return Long.parseLong(pageloadpause);
		else
			throw new RuntimeException("pageloadpause not specified in the Configuration.properties file.");
	}

	public String getTemplatePath() {
		String templatePath = System.getProperty("user.dir") + properties.getProperty("templateloc");
		if (templatePath != null)
			return templatePath;
		else
			throw new RuntimeException("templatePath not specified in the Configuration.properties file.");
	}

	public String getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getObjectRepoPath() {
		String objectConfigPath = properties.getProperty("ObjectRepoPath");
		if (objectConfigPath != null)
			return objectConfigPath;
		else
			throw new RuntimeException(
					"Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getDocumentType() {
		String template = System.getProperty("user.dir") + properties.getProperty("template");
		if (template != null)
			return template;
		else
			throw new RuntimeException("template is not specified in the Configuration.properties file.");
	}

	public String getOIMUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOIMPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getConnectionString(String dbEnv) {
		configFileReader = new ConfigFileReader("db");
		String connectionString = "";
		switch (dbEnv.toLowerCase()) {
		case "idm_qa":
			connectionString = String.format("@%s:%s/%s", dbProperties.getProperty("IDM_HOST_NAME"),
					dbProperties.getProperty("IDM_PORT"), dbProperties.getProperty("IDM_QA3_SERVICE_NAME"));
			break;
		case "idm_uat":
			connectionString = String.format("@%s:%s/%s",
					dbProperties.getProperty("IDM_HOST_NAME").replace("qa", "uat"),
					dbProperties.getProperty("IDM_PORT"), dbProperties.getProperty("IDM_UAT_SERVICE_NAME"));
			break;
		case "ebs_qa":
			connectionString = String.format("@%s:%s/%s", dbProperties.getProperty("EBS_HOST_NAME"),
					dbProperties.getProperty("EBS_PORT"), dbProperties.getProperty("EBS_QA3_SERVICE_NAME"));
			break;
		case "ebs_uat":
			connectionString = String.format("@%s:%s/%s", dbProperties.getProperty("EBS_HOST_NAME"),
					dbProperties.getProperty("EBS_PORT"), dbProperties.getProperty("EBS_UAT_SERVICE_NAME"));
			break;
		default:
			connectionString = String.format("@%s:%s/%s", dbProperties.getProperty("IDM_HOST_NAME"),
					dbProperties.getProperty("IDM_PORT"), dbProperties.getProperty("IDM_QA3_SERVICE_NAME"));
			break;
		}
		return connectionString;
	}

	public String getShareACartUrl() {
		String url = properties.getProperty("SHAREACART_QA3_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException(url + " url not specified in the Configuration.properties file.");
	}
	
	/*
	 * Mongo DB Host Name
	 * */
	public String getMongoDBHostName() {
	   String mongoHostName = properties.getProperty("MONGO_DB_HOSTNAME");
	   if(mongoHostName != null && !mongoHostName.isEmpty()) return mongoHostName;
	   else throw new RuntimeException("MONGO_DB_HOSTNAME not specified in the Configuration.properties file.");
	}

	/*
	 * Mongo DB port
	 * */
	public int getMongoDBPort() {
	   int mongoPort = Integer.parseInt(properties.getProperty("MODGO_DB_PORT"));
	   if(mongoPort != 0) return mongoPort;
	   else throw new RuntimeException("MODGO_DB_PORT not specified in the Configuration.properties file.");
	}

	/*
	 * Mongo DB User Name
	 * */
	public String getMongoDBUserName() {
	   String mongoUserName = properties.getProperty("MONGO_DB_USER_NAME");
	   if(mongoUserName != null && !mongoUserName.isEmpty()) return mongoUserName;
	   else throw new RuntimeException("MONGO_DB_USER_NAME not specified in the Configuration.properties file.");
	}

	/*
	 * Mongo DB Password
	 * */
	public String getMongoDBPassword() {
	   String mongoPassword = properties.getProperty("MONOG_DB_PASSWORD");
	   if(mongoPassword != null && !mongoPassword.isEmpty()) return mongoPassword;
	   else throw new RuntimeException("MONOG_DB_PASSWORD not specified in the Configuration.properties file.");
	}

	/*
	 * Mongo DB Collection
	 * */
	public String getMongoDBName() {
	   String mongoCollection = properties.getProperty("MONGO_DB_NAME");
	   if(mongoCollection != null && !mongoCollection.isEmpty()) return mongoCollection;
	   else throw new RuntimeException("MONGO_DB_NAME not specified in the Configuration.properties file.");
	}

	/*
	 * Debug Mode
	 * */
	public boolean isDebugModeOn() {
	   if(properties.getProperty("DEBUG_MODE")!=null && !properties.getProperty("DEBUG_MODE").isEmpty()) {
	      return Boolean.parseBoolean(properties.getProperty("DEBUG_MODE"));
	   }else {
	      return true;
	   }
	}

	/*
	 * Mongo DB Collection
	 * */
	public String getMongoDBCollectionName() {
	   String mongoCollection = properties.getProperty("MONGO_DB_COLLECTION");
	   if(mongoCollection != null && !mongoCollection.isEmpty()) return mongoCollection;
	   else throw new RuntimeException("MONGO_DB_COLLECTION not specified in the Configuration.properties file.");
	}

	/*
	 * Mongo DB Debug Mode Collection
	 * */
	public String getMongoDBDebugModeCollectionName() {
	   String mongoDebugCollection = properties.getProperty("DEBUG_MODE_MONGO_DB_COLLECTION");
	   if(mongoDebugCollection != null && !mongoDebugCollection.isEmpty()) return mongoDebugCollection;
	   else throw new RuntimeException("DEBUG_MODE_MONGO_DB_COLLECTION not specified in the Configuration.properties file.");
	}


}
