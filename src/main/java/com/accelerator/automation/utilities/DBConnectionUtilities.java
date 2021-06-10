package com.accelerator.automation.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionUtilities{
	
	private Connection connection;
	public DBConnectionUtilities() throws Exception {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@cimora-scan.qa.dc2.beachbody.com:1521/QA3OIM","qa3oim_oim", "qa3_oim");
			//connection = DriverManager.getConnection("jdbc:oracle:thin:"+ConfigFileReader.getConnectionString("idm_qa"), ConfigFileReader.dbProperties.getProperty("IDM_QA3_USER_ID"),ConfigFileReader.dbProperties.getProperty("IDM_QA3_PWD"));
			Statement statement = connection.createStatement();
			//String query = "select usr_key from qa3oim_oim.usr where USR_EMAIL ='hkML1557924347@yopmail.com'";
			//String query = "select USR_LOGIN GUID,USR_PROVISIONED_DATE IDMSYNCTIME,USR_UDF_BB_CUST_TYPE CUSTOMERTYPE,USR_UDF_BB_GNCCUST_ID GNCCUSTOMERID,USR_UDF_BB_GNCCOACH_ID GNCCOACHID from ${IDMSCHEMA}oim_oim.usr where UPPER(USR_EMAIL) ='hkML1557924347@yopmail.com'";
			String query = "select ost.ost_status PROVISIONSTATUS, obj.obj_name APPLICATION, obj.obj_key\n" +
					"from qa3oim_oim.oiu\n" +
					"inner join qa3oim_oim.ost on oiu.ost_key = ost.ost_key\n" +
					"inner join qa3oim_oim.obi on oiu.obi_key = obi.obi_key\n" +
					"inner join qa3oim_oim.obj on obi.obj_key = obj.obj_key\n" +
					"where oiu.usr_key=(select usr_key from qa3oim_oim.usr where USR_EMAIL ='hkML1557924347@yopmail.com')";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
			if(resultSet.next())
				resultSet.getInt(1);
		}finally {
			connection.close();
		}
	}
}
