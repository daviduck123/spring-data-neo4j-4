package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.initialData.initDataMaster;


public class V1_1__InitMaster implements SpringJdbcMigration  {
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		/*
		//Example using h2 database
		jdbcTemplate.execute("CREATE TABLE Unit ("
				+ "code VARCHAR(30),"
				+ "name VARCHAR(30),"
				+ "value DOUBLE"
				+ ");");
		
		jdbcTemplate.execute("INSERT INTO Unit ('ft','Feet',1);");
		
		How I can save my init data to neo4j database in here?
		for(String[] unitString : initDataMaster.unitList){
			//I got list unitList here
		}
		*/
	}
}