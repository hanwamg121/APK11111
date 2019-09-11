package JavaP;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBean {

	private String driverStr="com.mysql.jdbc.Driver";
	private String connStr="jdbc:mysql://localhost:3306/apk?useSSL=true&useUnicode=true&characterEncoding=utf8";
	private String username="root";
	private String userpassword="root";
	private String sql2="select*from user";
	private String sql3="select*from APK";
	private Connection conn=null;
	private Statement stmt=null;
	private ResultSet sqlRst=null;
	
	public LoginBean()
	{
	}
	public int correct(String inputName,String inputPassword)/*throws SQLException*///����1��ʾ��½�ɹ���0��ʾʧ��
	{
		try
		{
			Class.forName(driverStr);
			conn=DriverManager.getConnection(connStr,username,userpassword);
			stmt=conn.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("123456789");
		}
		try
		{
		sqlRst=stmt.executeQuery(sql2);
		while(sqlRst.next())
		{
			String sqlName=new String(sqlRst.getString("name"));
			String sqlPassword=new String(sqlRst.getString("pw"));
			if((sqlName.equals(inputName))&&(sqlPassword.equals(inputPassword)))
			{
				return 1;
			}
		}
		return 0;
		}
		catch(Exception ex)
		{
			System.out.println("987456321");
			return 0;
		}
	}
	
}
