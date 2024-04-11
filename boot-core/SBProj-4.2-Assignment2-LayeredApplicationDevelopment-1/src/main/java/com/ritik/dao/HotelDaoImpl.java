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

import com.ritik.bean.Hotel;

@Component("dao")
public class HotelDaoImpl implements HotelDao {

	private final String QUERY= "SELECT HID , HNAME , HCITY , HROOMS FROM HOTEL_INFO WHERE HCITY IN(?,?,?) ORDER BY 1";
	
	@Autowired
	private DataSource ds;
	
	private List<Hotel> ls;
	
	@Override
	public List<Hotel> getAllHotels(String city1, String city2, String city3) throws Exception {
		
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY);
			){
			ps.setString(1,city1);
			ps.setString(2,city2);
			ps.setString(3,city3);
			
			try(ResultSet rs = ps.executeQuery()){
				ls = new ArrayList<Hotel>();
				Hotel h ;
				while (rs.next()) {
					h=new Hotel();
					h.setHId(rs.getInt(1));
					h.setHName(rs.getString(2));
					h.setHCity(rs.getString(3));
					h.setHRooms(rs.getInt(4));
					ls.add(h);
				}
				return ls;
			}catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		
		}
		
		
		
	}

}
