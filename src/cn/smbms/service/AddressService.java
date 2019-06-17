package cn.smbms.service;

import java.util.List;

import cn.smbms.pojo.Address;

public interface AddressService {
	/**
	 * 查询地址列表
	 * @return
	 */
	List<Address> getAddressList();
	/**
	 * 获取地址总数
	 * @return
	 */
	int getAddressCount();
}
