package com.accelerator.automation.drivers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.accelerator.automation.common.World;


public class SeleniumGridDriver {
	private World world;
	ResourceBundle configLib;
	private WebDriver driver;
	private String GRID_HOSTNAME,GRID_PORT,GRID_URL;
	public SeleniumGridDriver(World world) {
		this.world=world;
	}
	//To get Web Driver instance
	public WebDriver getDriver() { 
		DesiredCapabilities caps =  null;
		String PLATFORM = null;
		try 
		{
			//Reading config file
			File file = new File("config");
			URL[] urls = {file.toURI().toURL()};
			ClassLoader loader = new URLClassLoader(urls);

			System.out.println("The default locale is : "+Locale.getDefault());

			configLib = ResourceBundle.getBundle("config",Locale.getDefault(),loader);



			//Selenium Grid Hub name
			GRID_HOSTNAME = configLib.getString("GRID_HOSTNAME");
			System.out.println("The grid host name is :" + GRID_HOSTNAME);
			//Selenium hub Port
			GRID_PORT = configLib.getString("GRID_PORT");
			System.out.println("The grid port is :" + GRID_PORT);
			//selenium grid url
			GRID_URL = configLib.getString("GRID_URL").replaceFirst("HOSTIP", GRID_HOSTNAME).replaceFirst("PORT", GRID_PORT);
			//GRID_URL = configLib.getString("GRID_URL");

			System.out.println("The grid url is : "+GRID_URL);


			
			if(world.getBrowser().equalsIgnoreCase("firefox"))
			{
				//firefox capabilities
				caps = DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				/*if(world.getPlatform().equalsIgnoreCase("windows")) {
					
					if(world.getPlatformVersion().equalsIgnoreCase("10")) {
						caps.setPlatform(Platform.WIN10);
					}
				}*/
				
				this.driver=new RemoteWebDriver(new URL(GRID_URL), caps);		
			}
			else if(world.getBrowser().equalsIgnoreCase("chrome"))
			{
				System.out.println("The chrome in chrome Browser is 12345 : "+ world.getBrowser());
				//chrome capabilities
				caps = DesiredCapabilities.chrome();
				caps.setBrowserName("chrome");
				/*if(world.getPlatform().equalsIgnoreCase("windows")) {
					
					if(world.getPlatformVersion().equalsIgnoreCase("10")) {
						caps.setPlatform(Platform.WIN10);
					}
				}*/
				
				this.driver=new RemoteWebDriver(new URL(GRID_URL), caps);
			}
			else if(world.getBrowser().equalsIgnoreCase("safari"))
			{
				//safari capabilities
				caps = DesiredCapabilities.safari();
				caps.setBrowserName("safari");
				if(world.getPlatform().equalsIgnoreCase("windows")) {
					
					if(world.getPlatformVersion().equalsIgnoreCase("10")) {
						caps.setPlatform(Platform.WIN10);
					}
				}
				
				this.driver=new RemoteWebDriver(new URL(GRID_URL), caps);
			}
			else if(world.getBrowser().equalsIgnoreCase("iexplore"))
			{
				//ie capabilities
				caps = DesiredCapabilities.internetExplorer();
				caps.setBrowserName("iexplore");
				if(world.getPlatform().equalsIgnoreCase("windows")) {
					
					if(world.getPlatformVersion().equalsIgnoreCase("10")) {
						caps.setPlatform(Platform.WIN10);
					}
				}
				
				this.driver=new RemoteWebDriver(new URL(GRID_URL), caps);
			}
			else if(world.getBrowser().equalsIgnoreCase("edge"))
			{
				//edge capabilities to be included
				/*
				 * io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
				 * this.driver=new EdgeDriver();
				 */
			}
		
		} 
		catch (RuntimeException | MalformedURLException e) {
			this.driver = null;
			e.printStackTrace();
		}
		return driver;
	}

	
	

}
