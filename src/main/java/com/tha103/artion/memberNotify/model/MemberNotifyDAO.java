package com.tha103.artion.memberNotify.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberNotifyDAO implements MemberNotifyDAO_interface {

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/artion");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO membernotify (mem_id,memberNot_readStatus,memberNot_existStatus,memberNot_content) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT memberNot_serialNumber,mem_id,memberNot_readStatus,memberNot_existStatus,memberNot_content,memberNot_receiveTime FROM membernotify order by memberNot_serialNumber";
	private static final String GET_ONE_STMT = 
		"SELECT memberNot_serialNumber,mem_id,memberNot_readStatus,memberNot_existStatus,memberNot_content,memberNot_receiveTime FROM membernotify where memberNot_serialNumber = ?";
	private static final String DELETE = 
		"DELETE FROM membernotify where memberNot_serialNumber = ?";
	private static final String UPDATE = 
		"UPDATE membernotify set mem_id=?, memberNot_readStatus=?, memberNot_existStatus=?, memberNot_content=? where memberNot_serialNumber = ?";
	private static final String FILTER="SELECT * FROM membernotify WHERE mem_id=?";

	@Override
	public void insert(MemberNotifyVO memberNotifyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memberNotifyVO.getMemId());
			pstmt.setBoolean(2, memberNotifyVO.getMemberNotReadStatus());
			pstmt.setBoolean(3, memberNotifyVO.getMemberNotExistStatus());
			pstmt.setString(4, memberNotifyVO.getMemberNotContent());
			
			
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(MemberNotifyVO memberNotifyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memberNotifyVO.getMemId());
			pstmt.setBoolean(2, memberNotifyVO.getMemberNotReadStatus());
			pstmt.setBoolean(3, memberNotifyVO.getMemberNotExistStatus());
			pstmt.setString(4, memberNotifyVO.getMemberNotContent());
			pstmt.setInt(5, memberNotifyVO.getMemberNotSerialNumber());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer memberNotSerialNumber) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberNotSerialNumber);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public MemberNotifyVO findByPrimaryKey(Integer memberNotSerialNumber) {

		MemberNotifyVO memberNotifyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberNotSerialNumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				memberNotifyVO = new MemberNotifyVO();
				memberNotifyVO.setMemberNotSerialNumber(rs.getInt("memberNot_serialNumber"));
				memberNotifyVO.setMemId(rs.getInt("mem_id"));
				memberNotifyVO.setMemberNotReadStatus(rs.getBoolean("memberNot_readStatus"));
				memberNotifyVO.setMemberNotExistStatus(rs.getBoolean("memberNot_existStatus"));
				memberNotifyVO.setMemberNotContent(rs.getString("memberNot_content"));
				memberNotifyVO.setMemberNotReceiveTime(rs.getTimestamp("memberNot_receiveTime"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberNotifyVO;
	}

	@Override
	public List<MemberNotifyVO> getAll() {
		List<MemberNotifyVO> list = new ArrayList<MemberNotifyVO>();
		MemberNotifyVO memberNotifyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				memberNotifyVO = new MemberNotifyVO();
				memberNotifyVO.setMemberNotSerialNumber(rs.getInt("memberNot_serialNumber"));
				memberNotifyVO.setMemId(rs.getInt("mem_id"));
				memberNotifyVO.setMemberNotReadStatus(rs.getBoolean("memberNot_readStatus"));
				memberNotifyVO.setMemberNotExistStatus(rs.getBoolean("memberNot_existStatus"));
				memberNotifyVO.setMemberNotContent(rs.getString("memberNot_content"));
				memberNotifyVO.setMemberNotReceiveTime(rs.getTimestamp("memberNot_receiveTime"));
				
				list.add(memberNotifyVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	public List<MemberNotifyVO> getMemID(Integer memId) {
		List<MemberNotifyVO> list = new ArrayList<MemberNotifyVO>();
		MemberNotifyVO memberNotifyVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(FILTER);

			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberNotifyVO = new MemberNotifyVO();
				memberNotifyVO.setMemberNotSerialNumber(rs.getInt("memberNot_serialNumber"));
				memberNotifyVO.setMemId(rs.getInt("mem_id"));
				memberNotifyVO.setMemberNotReadStatus(rs.getBoolean("memberNot_readStatus"));
				memberNotifyVO.setMemberNotExistStatus(rs.getBoolean("memberNot_existStatus"));
				memberNotifyVO.setMemberNotContent(rs.getString("memberNot_content"));
				memberNotifyVO.setMemberNotReceiveTime(rs.getTimestamp("memberNot_receiveTime"));
				
				list.add(memberNotifyVO); // Store the row in the list
			}
			
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}