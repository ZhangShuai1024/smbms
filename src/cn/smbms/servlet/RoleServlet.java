package cn.smbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;

import cn.smbms.service.RoleService;
import cn.smbms.util.ApplicationContextUtil;

@SuppressWarnings("serial")
public class RoleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		ApplicationContext ac = ApplicationContextUtil.createApplicationContext();
		RoleService roleService = (RoleService)ac.getBean("roleServiceImpl");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if("getrolelist".equals(method)){//��ȡ��ɫ�б�
			out.print(JSON.toJSONString(roleService.getRoleList()));
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
