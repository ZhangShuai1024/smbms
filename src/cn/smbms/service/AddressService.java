package cn.smbms.service;

import java.util.List;

import cn.smbms.pojo.Address;

public interface AddressService {
	/**
	 * ��ѯ��ַ�б�
	 * @return
	 */
	List<Address> getAddressList();
	/**
	 * ��ȡ��ַ����
	 * @return
	 */
	int getAddressCount();
}
