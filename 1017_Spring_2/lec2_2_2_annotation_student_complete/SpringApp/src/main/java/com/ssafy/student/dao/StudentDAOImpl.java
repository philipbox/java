package com.ssafy.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ssafy.student.domain.StudentDTO;
import com.ssafy.student.util.ConnectionProxy;


@Component(value="sdao")
public class StudentDAOImpl implements StudentDAO{
	private ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end close method
	
	
	
	
	@Override
	public void insertStudent(StudentDTO s) {
		list.add(s);
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into student values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getNum());
			ps.setString(2, s.getName());
			ps.setString(3, s.getAge());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("학생추가 실패");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("학생추가 실패");
//			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	@Override
	public void updateStudent(StudentDTO s) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update student set name=?, age=? where num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getAge());
			ps.setString(3, s.getNum());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("학생정보 수정 실패");
//			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void deleteStudent(String num) {

		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from student where num=?";
			// delete from student where num='12';
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.executeUpdate();
//			res = true;
		} catch (ClassNotFoundException e) {
			System.out.println("학생삭제 실패");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("학생삭제 실패");
//			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public StudentDTO selectStudentOne(String name) {
		StudentDTO student = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from student where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				student = new StudentDTO(rs.getString("num"), rs.getString("name"), rs.getString("age"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("학생검색 실패");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("학생검색 실패");
//			e.printStackTrace();
		} finally {
			close();
		}
		return student;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() {
		
		ArrayList<StudentDTO> slist = new ArrayList<StudentDTO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				slist.add(new StudentDTO(rs.getString("num"), rs.getString("name"), rs.getString("age")));
			}
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			close();
		}
	return slist;
	}//end selectStudentList method
	
}
