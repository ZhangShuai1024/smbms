package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.service.BillService;
@Transactional
@Service
public class BillServiceImpl implements BillService {
	@Resource
	private BillMapper billMapper;
	@Override
	public List<Bill> getBillList(String productName, Integer isPayment,
			Integer providerId) {
		return billMapper.getBillList(productName, isPayment, providerId);
	}
	@Override
	public int getBillCount() {
		return billMapper.getBillCount();
	}
	@Override
	public int modify(Bill bill) {
		return billMapper.modify(bill);
	}
	@Override
	public Bill getBillById(Integer id) {
		return billMapper.getBillById(id);
	}
	@Override
	public int deleteBillById(Integer id) {
		return billMapper.deleteBillById(id);
	}
	@Override
	public int addBill(Bill bill) {
		return billMapper.addBill(bill);
	}
	

}
