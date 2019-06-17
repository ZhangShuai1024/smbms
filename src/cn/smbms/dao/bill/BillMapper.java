package cn.smbms.dao.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;

public interface BillMapper {
	/**
	 * ��ѯ�����б�
	 * @param productName ��Ʒ����
	 * @param isPayment �Ƿ�֧����1��δ֧�� 2����֧����
	 * @param providerId ��Ӧ��ID
	 * @return
	 */
	List<Bill> getBillList(@Param("productName")String productName,
						   @Param("isPayment")Integer isPayment,
						   @Param("providerId")Integer providerId);
	/**
	 * ��ȡ��������
	 * @return
	 */
	int getBillCount();
	/**
	 * ����id��ѯ����
	 * @param id
	 * @return
	 */
	Bill getBillById(@Param("id")Integer id);
	/**
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	int deleteBillById(@Param("id")Integer id);
	/**
	 * ��Ӷ���
	 * @param bill
	 * @return
	 */
	int addBill(Bill bill);
	/**
	 * �޸Ķ���
	 * @param bill
	 * @return
	 */
	int modify(Bill bill);
}
