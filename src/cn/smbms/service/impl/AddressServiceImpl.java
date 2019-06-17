package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.address.AddressMapper;
import cn.smbms.pojo.Address;
import cn.smbms.service.AddressService;
@Transactional
@Service
public class AddressServiceImpl implements AddressService {
	@Resource
	private AddressMapper addressMapper;
	@Override
	public List<Address> getAddressList() {
		return addressMapper.getAddressList();
	}

	@Override
	public int getAddressCount() {
		return addressMapper.getAddressCount();
	}
	
}
