package com.ritik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ritik.bean.Patient;

@Component("pDao")
public class PatientInfoDaoImpl implements PatientInfoDao {

	private final String QUERY_FOR_PATIENTS_FROM_GIVEN_STATES="SELECT PID , PNAME ,PAGE, STATE FROM PATIENTS_DETAILS WHERE STATE IN(?,?,?) ORDER BY 4";
	
	@Autowired
	private DataSource ds;

	List<Patient> ls;
	

	@Override
	public List<Patient> getAllPatientInfo(String state1 , String state2 , String state3) throws Exception {
	
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_FOR_PATIENTS_FROM_GIVEN_STATES);	
			){
				ps.setString(1, state1);
				ps.setString(2, state2);
				ps.setString(3, state3);
				
				try(ResultSet rs = ps.executeQuery()){
					ls = new ArrayList<Patient>();
					Patient p ;
					while(rs.next()) {
						p= new Patient();
						p.setPId(rs.getInt(1));
						p.setPName(rs.getString(2));
						p.setAge(rs.getInt(3));
						p.setPState(rs.getString(4));
						
						ls.add(p);
					}
					return ls;
			}catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
			
			
	}

}
