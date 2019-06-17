package cn.smbms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderService {
	/**
	 * 查询供应商列表
	 * @return
	 */
	List<Provider> getProviderList();
	/**
	 * 查询供应商记录数
	 * @return
	 */
	int getProviderCount();
	/**
	 * 根据id查询供应商
	 * @param id
	 * @return
	 */
	Provider getProviderById(@Param("id")Integer id);
	/**
	 * 根据供应商名称查询列表
	 * @param proName
	 * @return
	 */
	List<Provider> getProviderListByProName(@Param("proName")String proName,@Param("proCode")String proCode);
	/**
	 * 修改供应商信息
	 * @param provider
	 * @return
	 */
	int modifyProvider(Provider provider);
	/**
	 * 增加供应商信息
	 * @param provider
	 * @return
	 */
	int addProvider(Provider provider);
	/**
	 * 通过id删除供应商信息
	 * @param id
	 * @return
	 */
	int deleteProviderById(@Param("id")Integer id);
}
