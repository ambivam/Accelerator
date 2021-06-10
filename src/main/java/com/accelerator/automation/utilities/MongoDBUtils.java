package com.accelerator.automation.utilities;

import com.accelerator.automation.common.Constants;
import com.accelerator.automation.common.World;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import java.io.File;

public class MongoDBUtils {
    static Logger logger = LogManager.getLogger(MongoDBUtils.class);

    /*
    * Store Results in Mongo DB Collection
    * */
    public static boolean storeResultsIntoMongoDB() throws Exception {
        try {
            World world = Constants.world;
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("driverType", world.getDriverType().toString());
            jsonObject.addProperty("locale", world.getLocale());
            if (world.getDriverType() == Constants.DRIVERTYPE.SAUCE && world.isMobile()) {
                jsonObject.addProperty("isMobile", true);
                jsonObject.addProperty("tunnel", world.getTunnelRequired());
                jsonObject.addProperty("mobilePlatform", world.getMobilePlatform());
                jsonObject.addProperty("mobileDeviceName", world.getMobileDeviceName());
                jsonObject.addProperty("mobileDeviceOrientation", world.getMobileDeviceOrientation());
                jsonObject.addProperty("mobilePlatformVersion", world.getMobilePlatformVersion());
                jsonObject.addProperty("mobilePlatformName", world.getMobilePlatformName());
                jsonObject.addProperty("mobileBrowser", world.getMobileBrowser());
            } else if (world.getDriverType() == Constants.DRIVERTYPE.LOCAL && world.isMobile()) {
                jsonObject.addProperty("isMobile", true);
                jsonObject.addProperty("Browser", world.getBrowser());
                jsonObject.addProperty("browserVersion", world.getBrowserVersion());
                jsonObject.addProperty("browserVersion", world.getBrowserPlatform());
            } else {
                jsonObject.addProperty("Browser", world.getBrowser());
                jsonObject.addProperty("browserVersion", world.getBrowserVersion());
                jsonObject.addProperty("browserPlatform", world.getBrowserPlatform());
            }

            String jsonString = FileUtils.readFileToString(new File("target/json-cucumber-reports/cukejson.json"), "UTF-8");
            JsonArray resultArray = new Gson().fromJson(jsonString, JsonArray.class);
            JsonObject resultObject = new JsonObject();
            resultObject.add("result", resultArray);
            resultObject.add("metadata", jsonObject);

            Document doc = Document.parse(resultObject.toString());
            //Create the MONGO DB object to write the file into mongo
            String host = ConfigFileReader.getConfigFileReader().getMongoDBHostName();
            String databaseName = ConfigFileReader.getConfigFileReader().getMongoDBName();
            String cname = "";
            if (ConfigFileReader.getConfigFileReader().isDebugModeOn()) {
                cname = ConfigFileReader.getConfigFileReader().getMongoDBDebugModeCollectionName();
            } else {
                cname = ConfigFileReader.getConfigFileReader().getMongoDBCollectionName();
            }
            MongoClient client = new MongoClient(host, 27017);
            MongoDatabase database = client.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(cname);
            collection.insertOne(doc);
            logger.info("Sucessfully inserted into mongodb");
            System.out.println("Sucessfully inserted into mongodb");
            client.close();
            return true;
        } catch (Exception e) {
            logger.info("Not Sucessfully inserted into mongodb");
            System.out.println("Not Sucessfully inserted into mongodb");
            throw new Exception("Not able to store results into Mongo due to " + e.getMessage());
        }
    }
}
