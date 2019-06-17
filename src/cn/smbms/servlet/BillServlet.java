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

import cn.smbms.pojo.Bill;
import cn.smbms.service.BillService;
import cn.smbms.util.ApplicationContextUtil;

@SuppressWarnings("serial")
public class BillServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		ApplicationContext ac = ApplicationContextUtil.createApplicationContext();
		BillService billService = (BillService)ac.getBean("billServiceImpl");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if("showBill".equals(method)){//��ʾ�������
			List<Bill> billList = billService.getBillList(null, null, null);
			out.print(JSON.toJSONString(billList));
		} else if("view".equals(method)){//��ʾָ���������
			Integer billid = Integer.parseInt(request.getParameter("bid"));
			Bill bill = billService.getBillById(billid);
			out.print(JSON.toJSONString(bill));
		} else if("delbill".endsWith(method)){//ɾ�����
			Integer billid = Integer.parseInt(request.getParameter("billid"));
			String result;
			Bill bill = billService.getBillById(billid);
			if(bill == null){
				result = "notexist";
			} else {
				BillService billService2 = (BillService)ac.getBean("billServiceImpl");
				int count = billService2.deleteBillById(billid);
				if(count==0){
					result = "false";
				} else{
					result = "true";
				}
			}
			out.print("{\"delResult\" : \""+ result +"\"}");
		} else if("search".equals(method)){//��������
			String ProductName = request.getParameter("queryProductName");
			Integer ProviderId = Integer.parseInt(request.getParameter("queryProviderId"));
			Integer IsPayment = Integer.parseInt(request.getParameter("queryIsPayment"));
			List<Bill> billList = billService.getBillList(ProductName, IsPayment, ProviderId);
			out.print(JSON.toJSONString(billList));
		} else if("add".equals(method)){//��Ӷ���
			Bill bill = new Bill();
			bill.setBillCode(request.getParameter("billCode"));
			bill.setProductName(request.getParameter("productName"));
			bill.setProductDesc(request.getParameter("productDesc"));
			bill.setProductUnit(request.getParameter("productUnit"));
			bill.setProductCount(Double.parseDouble(request.getParameter("productCount")));
			bill.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
			bill.setIsPayment(Integer.parseInt(request.getParameter("isPayment")));
			bill.setProviderId(Integer.parseInt(request.getParameter("providerId")));
			bill.setCreatedBy(1);
			bill.setCreationDate(new Date());
			out.print(billService.addBill(bill));
		} else if("modifysave".equals(method)){//�޸Ķ���
			Bill bill = new Bill();
			bill.setId(Integer.parseInt(request.getParameter("id")));
			bill.setBillCode(request.getParameter("billCode"));
			bill.setProductName(request.getParameter("productName"));
			bill.setProductDesc(request.getParameter("productDesc"));
			bill.setProductUnit(request.getParameter("productUnit"));
			bill.setProductCount(Double.parseDouble(request.getParameter("productCount")));
			bill.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
			bill.setIsPayment(Integer.parseInt(request.getParameter("isPayment")));
			bill.setProviderId(Integer.parseInt(request.getParameter("providerId")));
			bill.setCreatedBy(1);
			bill.setCreationDate(new Date());
			out.print(billService.modify(bill));
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
