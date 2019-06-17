package cn.smbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import cn.smbms.util.ApplicationContextUtil;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		ApplicationContext ac = ApplicationContextUtil.createApplicationContext();
		UserService userService = (UserService)ac.getBean("userServiceImpl");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if("login".equals(method)){//��¼
			User user = new User();
			user.setUserCode(request.getParameter("userCode"));
			user.setUserPassword(request.getParameter("userPassword"));
			int resutl = userService.isExistUser(user);
			if(resutl == 1){
				UserService userService1 = (UserService)ac.getBean("userServiceImpl");
				user = userService1.getUserByUserCode(user.getUserCode());
				response.addCookie(new Cookie("userId", URLEncoder.encode(user.getId().toString(), "UTF-8")));
				response.addCookie(new Cookie("userCode", URLEncoder.encode(user.getUserCode(), "UTF-8")));
				response.addCookie(new Cookie("userName", URLEncoder.encode(user.getUserName(), "UTF-8")));
				request.getSession().setAttribute("user", user);
			}
			out.print(resutl);
		} else if("query".equals(method)){//���û�����ҳ��
			response.sendRedirect("../userList.html");
		} else if("showUser".equals(method)){//��ʾ�û����
			List<User> userList = userService.getUserList();
			out.print(JSON.toJSONString(userList));
		} else if("search".equals(method)){//�����û�
			String queryname = request.getParameter("queryname");
			String queryUserRole = request.getParameter("queryUserRole");
			Integer userRole = Integer.parseInt(queryUserRole);
			Map<String , String > map = new HashMap<String, String>();
			map.put("uName", queryname);
			map.put("uRole", queryUserRole);
			User user = new User();
			user.setUserName(queryUserRole);
			List<User> userList = (queryname != ""&&userRole==0)?userService.getUserListByUserName(queryname):
					(queryname == ""&&userRole!=0)?userService.getUserListByRoleId(userRole):
					(queryname != ""&&userRole!=0)?	userService.getUserListByMap(map):userService.getUserList();
			out.print(JSON.toJSONString(userList));
		} else if("deluser".equals(method)){//ɾ���û�
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			out.print(JSON.toJSONString(userService.deleteUserById(uid)));
		} else if("modify".equals(method)){//��ȡָ���û���Ϣ�͵�ַ
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			out.print(JSON.toJSONString(userService.getAddressListByUserId(uid)));
		} else if("modifyexe".equals(method)){//�޸��û�
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			String userName = request.getParameter("userName");
			String phone = request.getParameter("phone");
			String time = request.getParameter("birthday");  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date birthday = null;
	        try {
	        	birthday = sdf.parse(time);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			String address = request.getParameter("address");
			Integer gender = Integer.parseInt(request.getParameter("gender"));
			Integer rid = Integer.parseInt(request.getParameter("userRole"));
			User user = new User();
			user.setId(uid);
			user.setModifyBy(uid);
			user.setModifyDate(new Date());
			user.setUserName(userName);
			user.setAddress(address);
			user.setGender(gender);
			user.setUserRole(rid);
			user.setBirthday(birthday);
			user.setPhone(phone);
			out.print(JSON.toJSONString(userService.modify(user)));
		} else if("view".equals(method)){//��ȡָ���û���Ϣ
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			out.print(JSON.toJSONString(userService.getUserById(uid)));
		} else if("ucexist".equals(method)){//��֤�û������Ƿ����
			String userCode = request.getParameter("userCode");
			out.print(JSON.toJSONString(userService.isExistUserCode(userCode)));
		} else if("add".equals(method)){//����û�
			String userCode = request.getParameter("userCode");
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			Integer gender = Integer.parseInt(request.getParameter("gender"));
			String phone = request.getParameter("phone");
			String time = request.getParameter("birthday");  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date birthday = null;
	        try {
	        	birthday = sdf.parse(time);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			String address = request.getParameter("address");
			Integer rid = Integer.parseInt(request.getParameter("userRole"));
			User user = new User();
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			user.setUserName(userName);
			user.setUserCode(userCode);
			user.setUserPassword(userPassword);
			user.setAddress(address);
			user.setGender(gender);
			user.setUserRole(rid);
			user.setBirthday(birthday);
			user.setPhone(phone);
			out.print(JSON.toJSONString(userService.add(user)));
		} else if("checkpwd".equals(method)){//��֤����
			String passWord = request.getParameter("oldpassword");
			User user = (User)request.getSession().getAttribute("user");
			String result;
			if(passWord==""){
				result = "error";
			} else if(user == null){
				result = "sessionerror";
			} else if(passWord.equals(user.getUserPassword())){
				result = "true";
			} else {
				result = "false";
			}
			out.print("{\"result\" : \""+ result +"\"}");
		} else if("pwdmodify".equals(method)){//�޸�����
			String newpassword = request.getParameter("newpassword");
			User user = (User)request.getSession().getAttribute("user");
			out.print(userService.updatePwd(user.getId(), newpassword));
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
