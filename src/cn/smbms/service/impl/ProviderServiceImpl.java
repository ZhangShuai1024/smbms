package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;
@Transactional
@Service
public class ProviderServiceImpl implements ProviderService {
	@Resource
	private ProviderMapper providerMapper;

	@Override
	public List<Provider> getProviderList() {
		return providerMapper.getProviderList();
	}

	@Override
	public int getProviderCount() {
		return providerMapper.getProviderCount();
	}

	@Override
	public Provider getProviderById(Integer id) {
		return providerMapper.getProviderById(id);
	}

	@Override
	public List<Provider> getProviderListByProName(String proName,
			String proCode) {
		return providerMapper.getProviderListByProName(proName, proCode);
	}

	@Override
	public int modifyProvider(Provider provider) {
		return providerMapper.modifyProvider(provider);
	}

	@Override
	public int addProvider(Provider provider) {
		return providerMapper.addProvider(provider);
	}

	@Override
	public int deleteProviderById(Integer id) {
		return providerMapper.deleteProviderById(id);
	}
	

}
