package com.accelerator.automation.drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import com.beachbody.pojo.OATSStatus;
import com.accelerator.automation.common.World;

public class OATSDriver {

    private World world;
    public OATSDriver(World world){
        this.world=world;
    }

    /**
     * Method to run OATS Script from command Line
     * @param scriptName
     * @param properties
     * @return OATSStatus
     * @throws Exception
     */
    public OATSStatus runScript(String scriptName, String properties) throws Exception {
        OATSStatus oatsStatus = new OATSStatus();
        ProcessBuilder oatsProcess = new ProcessBuilder("C:/OracleATS/openScript/runScript.bat", scriptName + "/" + scriptName + ".jwg");
        oatsProcess.directory(new File("OATS/Scripts"));
        StringBuilder builder = new StringBuilder();
        try {
            oatsProcess.redirectErrorStream(true);
            Process p = oatsProcess.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            p.waitFor();
            oatsStatus.setExitStatus(p.exitValue()==0?true:false);
            oatsStatus.setBufferMessage(builder.toString());
        } catch (Exception e) {
            throw new Exception("Not able to run OATS Script due to " + e.getMessage());
        }
        return oatsStatus;
    }

}
