package cn.smbms.dao.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;

public interface BillMapper {
	/**
	 * 查询订单列表
	 * @param productName 商品名称
	 * @param isPayment 是否支付（1：未支付 2：已支付）
	 * @param providerId 供应商ID
	 * @return
	 */
	List<Bill> getBillList(@Param("productName")String productName,
						   @Param("isPayment")Integer isPayment,
						   @Param("providerId")Integer providerId);
	/**
	 * 获取订单总数
	 * @return
	 */
	int getBillCount();
	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
	Bill getBillById(@Param("id")Integer id);
	/**
	 * 根据id删除订单
	 * @param id
	 * @return
	 */
	int deleteBillById(@Param("id")Integer id);
	/**
	 * 添加订单
	 * @param bill
	 * @return
	 */
	int addBill(Bill bill);
	/**
	 * 修改订单
	 * @param bill
	 * @return
	 */
	int modify(Bill bill);
}
