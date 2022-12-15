package com.hcl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.beans.User;


public class UserDaoImp implements IUserDao {

Connection conn = DBFactory.getDBConnection();
	
	PreparedStatement pstmt;

	
	@Override
	public int addUser(User user) {
		String insertQuery = "insert into user(userid,username,password) values(?,?,?)";

		int count = 0;

		try {

		pstmt = conn.prepareStatement(insertQuery);

		pstmt.setInt(1, user.getUserId() );
		pstmt.setString(2,user.getUserName() );
		pstmt.setString(3,user.getPassword() );

		count = pstmt.executeUpdate();

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		return count;
		
	}

	@Override
	public int updateUser(User user) {
		String updateQuery = "update user set userName = ? , password = ? where userId =?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());	
			pstmt.setInt(3, user.getUserId());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public int deleteUserById(int userId) {
		
		String deleteQuery = "delete from user where userId = ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, userId);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public User selectUserById(int userId) {
		String selectOne = "select * from user where userId = ?";
		User user=new User();
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId1 = rs.getInt("userId");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				
				user.setUserId(userId1);
				user.setUserName(userName);
				user.setPassword(password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> userList = null;

		try {

		String selectAllQuery = "select * from user";

		pstmt = conn.prepareStatement(selectAllQuery);

		ResultSet rs = pstmt.executeQuery();

		userList = new ArrayList<User>();

		while(rs.next()) {

		int userId = rs.getInt("userid");
		String userName = rs.getString("username");
		String password = rs.getString("password");

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		userList.add(user);

		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		return userList;
		}
	}


