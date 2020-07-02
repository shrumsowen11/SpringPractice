package com.shrums.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrums.entity.FuelType;



/**
 * <bean id="tmealDao" name="www.meal.com,www.yahoo.com"		class="com.dao.MealDao">
		  <property name="jdbcTemplate"  ref="tjdbcTemplate"/>
	</bean>
	
 * @author banepali
 *
 */

@Repository("fuelTypeDao")
/*
 * Using "@Repository("fuelTypeDao")", we are making the bean/object
 * Now, we will not have to make the beans in the .xml file instead of which
 * 
 * "<context:component-scan base-package="com.shrums.Dao"/>" which will be 
 * looking for the "@ANNOTATIONS" presence in the .java files
 */


public class FuelTypeDao {
	
	@Autowired  
	
	
	/*  ************We were doing like this ****************
	 * <bean id = "fuelTypeObject" name = "www.fueltype.com,www.ft.com" class =
	 * "com.shrums.Dao.FuelTypeDao"> <property name="jdbcTemplate" ref =
	 * "jdbcTemplateForConnection"/>
	 * </bean>
	 * 
	 * 	<bean id = "fuelService"  class = "com.shrums.Dao.FuelService">
 	 *	<property name = "fuelTypeDao" ref = "fuelTypeObject"/>
     *	</bean>
	 * 
	 * 
	 * Now, to inject or to do the Inversion of Control(IOC) the jdbcTemplate into the FuelTypeDao class, we use the "@Autowired"
	 */
	
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	

	public void save(FuelType fuelType) {
		String sql = "insert into fuel_type_tbl (gas, gallons, createDate) values (?,?,?)";
		jdbcTemplate.update(sql,new Object[] {fuelType.getGas(),fuelType.getGallons(),
				new Timestamp(new Date().getTime())});
		
		/* .query 			-->	returns a List of any size
		 * .queryForObject 	--> returns one object
		 * .update 			-->	updates the data	
		 *
		 * the above   "new Object[] {fuelType.getGas(),fuelType.getGallons(),
		 *		new Timestamp(new Date().getTime())}" ->> passed into the sql.
		 *  
		 */
		System.out.println(fuelType);
		
	}
	
	
	public List<FuelType> findAll() {
		 List<FuelType> fuelTypes = jdbcTemplate.query("select fid, gas, gallons, createDate from fuel_type_tbl",
				 new BeanPropertyRowMapper<>(FuelType.class));
			/*
			 *  Here, the last attribute returns the FuelType Object which is 
			 *  requested by the "sql" here and starts making
			 *  list of that object and then, if there // are more than one FuelType
			 *  Object, then it start ******* mapping ******* them into a List
			 *  and therefore, returns the list at the end
			 *  
			 */		 
			
		 return  fuelTypes;
	}
	
	public FuelType findById(int fid) {
		FuelType fuelType=(FuelType)jdbcTemplate.queryForObject("select fid, gas, gallos, createDate"
				+ " from fuel_type_tbl where fid=?",
				 new Object[] {fid},new BeanPropertyRowMapper<>(FuelType.class));
		/* here, the last attribute of the jdbcTemplate is asking for only one item(one  FuelTypeEntity)
		 * through the "sql", so therefore, the "new BeanPropertyRowMapper(FuelType.class)" is using
		 * the FuelType.class to get the FuelType class object
		 *  */
	
		 return  fuelType;
	}

	public int findCount() {
	 	String sql="select count(*) from fuel_type_tbl";
	 	int count =jdbcTemplate.queryForObject(sql, Integer.class);
		 return  count;
	}
	
	public void deleteById(int fid) {
		jdbcTemplate.update("delete from fuel_type_tbl where fid = "+fid);
	}

}