package com.mytwilio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mytwilio.entity.Schedules;
import com.mytwilio.util.DBHelper;

public class SchedulesDAO {

	// This method is used to get all schedules from database
	public ArrayList<Schedules> getSchedules(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Schedules> list = new ArrayList<Schedules>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from schedules;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Schedules s = new Schedules();
				s.setId(rs.getByte("uid"));
				s.setRoute(rs.getString("route"));
				s.setStop(rs.getString("stop"));
				s.setTime(rs.getString("time"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}

	// This method is used to get schedules associate with a designated route
	public ArrayList<Schedules> getSchedulesByRoute(String route){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Schedules> list = new ArrayList<Schedules>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from schedules where route=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, route);
			rs = stmt.executeQuery();
			while(rs.next()){
				Schedules s = new Schedules();
				s.setId(rs.getByte("uid"));
				s.setRoute(rs.getString("route"));
				s.setStop(rs.getString("stop"));
				s.setTime(rs.getString("time"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	// This method is used to get schedules associate with a designated stop
	public ArrayList<Schedules> getSchedulesByStop(String stop){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Schedules> list = new ArrayList<Schedules>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from schedules where stop=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stop);
			rs = stmt.executeQuery();
			while(rs.next()){
				Schedules s = new Schedules();
				s.setId(rs.getByte("uid"));
				s.setRoute(rs.getString("route"));
				s.setStop(rs.getString("stop"));
				s.setTime(rs.getString("time"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	// This method is used to get all routes from database
	public String getRoutes(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		try {
			conn = DBHelper.getConnection();
			String sql = "select route from schedules group by route;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				sb.append(rs.getString("route")+" ");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	// This method is used to get all stops from database
	public String getStops(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		try {
			conn = DBHelper.getConnection();
			String sql = "select stop from schedules group by stop;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				sb.append(rs.getString("stop")+" ");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
