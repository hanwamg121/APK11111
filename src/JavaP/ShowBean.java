package JavaP;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowBean extends HttpServlet{
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql连接驱动,无需改
	
	public static String connStr="jdbc:mysql://localhost:3306/apk?useSSL=true&useUnicode=true&characterEncoding=utf8";
	public static String username = "root";//数据库用户名
	public static String userpassword = "root";//数据库密码
	private static Connection conn;
	
	static {
		try {
			Class.forName(jdbcDriver);// 加载mysql驱动类
			conn = DriverManager.getConnection(connStr, username, userpassword);
			// 驱动利用驱动地址，数据库用户名，密码创建连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//以上基本是固定格式的
	
	public List<Map> ListInit(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
		String sql = "select * from apk"; // SQL查询语句
		try {
			Statement stmt = conn.createStatement();  
			ResultSet rs = stmt.executeQuery(sql);  
            while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String developer = rs.getString("developer");
				Date time = rs.getDate("time");
				//获取用循环接收数据库的表格信息
				
				Map map = new HashMap(); 
				map.put("id", id);			
				map.put("name", name);		
				map.put("type", type);
				map.put("developer", developer);
				map.put("time",time);
				//用键值对存入到map集合中
				list.add(map);//在将map集合对象存入list集合
				/*for (Map map_1 :list) {
					System.out.println(map_1);
				}//在打印台遍历出数据查看是否有错误*/

			}//遍历结果集
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("key_list",list);//将list集合数据放入到request中共享
		return list;
	}
	public void del(HttpServletRequest request, HttpServletResponse response,String id)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int intid =Integer.parseInt(id);
		String sql = "delete from apk where id= ?";
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, intid);
            int count = pst.executeUpdate();
            pst.close();
			if(count>0)System.out.println("删除"+intid);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void change(HttpServletRequest request, HttpServletResponse response,String name,String type,String developer,int id)
			throws ServletException, IOException{
		String sql = "UPDATE apk SET name = ? , type = ? , developer = ? WHERE id = ?";
		PrintWriter out = response.getWriter();
		System.out.println(name);
		System.out.println(type);
		System.out.println(developer);
		System.out.println(id);
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, type);
			pst.setString(3, developer);
			pst.setInt(4, id);
            int count = pst.executeUpdate();
            pst.close();
			if(count>0)System.out.println("修改"+id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void add(HttpServletRequest request, HttpServletResponse response,String name,String type,String developer,Date date)
			throws ServletException, IOException{
		String sql="insert into apk(id,name,type,developer,time) values(?,?,?,?,?)";
		System.out.println(sql);
		int idnum=0;
		String maxIDSql="select max(id) as id from apk"; 
		try{
			PreparedStatement pst1 = conn.prepareStatement(maxIDSql);
			ResultSet rs = pst1.executeQuery(maxIDSql);
			if(rs.next()){ 
				idnum = rs.getInt("id")+1;
				System.out.println(idnum);
			}else{ 
			idnum = 0;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idnum);
			pst.setString(2, name);
			pst.setString(3, type);
			pst.setString(4, developer);
			pst.setDate(5, date);
            int count = pst.executeUpdate();
            pst.close();
			if(count>0)System.out.println("添加"+idnum);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
