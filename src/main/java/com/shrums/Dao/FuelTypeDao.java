package Dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrums.FuelType;



/**
 * <bean id="tmealDao" name="www.meal.com,www.yahoo.com"		class="com.dao.MealDao">
		  <property name="jdbcTemplate"  ref="tjdbcTemplate"/>
	</bean>
	
 * @author banepali
 *
 */

@Repository("fuelTypeDao")
public class FuelTypeDao {
	
	@Autowired
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
		
		/* 
		 * The last attribute of the methods like .update, .query, . queryForObject are to return the 
		 * type of the object requested. by the "sql"
		 * For Example: the above   "new Object[] {fuelType.getGas(),fuelType.getGallons(),
				new Timestamp(new Date().getTime())}" ->> returns the object array of the FuelType
		 *  
		 *  */
		System.out.println(fuelType);
		
	}
	
	
	public List<FuelType> findAll() {
		 List<FuelType> fuelTypes = jdbcTemplate.query("select fid, gas, gallons, createDate from fuel_type_tbl",
				 new BeanPropertyRowMapper(FuelType.class));
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
				 new Object[] {fid},new BeanPropertyRowMapper(FuelType.class));
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