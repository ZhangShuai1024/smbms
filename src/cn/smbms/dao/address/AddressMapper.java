package cn.smbms.dao.address;

import java.util.List;

import cn.smbms.pojo.Address;

public interface AddressMapper {
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
