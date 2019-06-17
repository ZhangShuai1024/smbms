package cn.smbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;
import cn.smbms.util.ApplicationContextUtil;

@SuppressWarnings("serial")
public class ProviderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		ApplicationContext ac = ApplicationContextUtil.createApplicationContext();
		ProviderService providerService = (ProviderService)ac.getBean("providerServiceImpl");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if("showProvider".equals(method)){//��ʾ��Ӧ��
			String proName = request.getParameter("queryProName");
			String proCode = request.getParameter("queryProCode");
			List<Provider> providers = providerService.getProviderListByProName(proName, proCode);
			out.print(JSON.toJSONString(providers));
		} else if("showProviderName".equals(method)){//��ʾ��Ӧ�����
			out.print(JSON.toJSONString(providerService.getProviderList()));
		} else if("view".equals(method)){//�鿴��Ϣ
			Integer pid = Integer.parseInt(request.getParameter("pid"));
			out.print(JSON.toJSONString(providerService.getProviderById(pid)));
		} else if("modify".equals(method)){//�޸���Ϣ
			Provider provider = new Provider();
			provider.setId(Integer.parseInt(request.getParameter("pid")));
			provider.setProCode(request.getParameter("proCode"));
			provider.setProName(request.getParameter("proName"));
			provider.setProDesc(request.getParameter("proDesc"));
			provider.setProContact(request.getParameter("proContact"));
			provider.setProPhone(request.getParameter("proPhone"));
			provider.setProAddress(request.getParameter("proAddress"));
			provider.setProFax(request.getParameter("proFax"));
			provider.setModifyBy(1);
			provider.setModifyDate(new Date());
			out.print(providerService.modifyProvider(provider));
		} else if("delprovider".equals(method)){//ɾ��Ӧ��
			Integer pid = Integer.parseInt(request.getParameter("proid"));
			String result;
			Provider provider = providerService.getProviderById(pid);
			if(provider == null){
				result = "notexist";
			} else if(provider.getBillList().size() != 0 && provider.getBillList().get(0).getBillCode() != null){
				result =""+ provider.getBillList().size() +"";
			} else {
				ProviderService providerService2 = (ProviderService)ac.getBean("providerServiceImpl");
				int count = providerService2.deleteProviderById(pid);
				if(count==0){
					result = "false";
				} else{
					result = "true";
				}
			}
			out.print("{\"delResult\" : \""+ result +"\"}");
		} else if("add".equals(method)){//��ӹ�Ӧ��
			Provider provider = new Provider();
			provider.setProCode(request.getParameter("proCode"));
			provider.setProName(request.getParameter("proName"));
			provider.setProDesc(request.getParameter("proDesc"));
			provider.setProContact(request.getParameter("proContact"));
			provider.setProPhone(request.getParameter("proPhone"));
			provider.setProAddress(request.getParameter("proAddress"));
			provider.setProFax(request.getParameter("proFax"));
			provider.setCreatedBy(1);
			provider.setCreationDate(new Date());
			out.print(providerService.addProvider(provider));
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
