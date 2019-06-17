package cn.smbms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderService {
	/**
	 * ��ѯ��Ӧ���б�
	 * @return
	 */
	List<Provider> getProviderList();
	/**
	 * ��ѯ��Ӧ�̼�¼��
	 * @return
	 */
	int getProviderCount();
	/**
	 * ����id��ѯ��Ӧ��
	 * @param id
	 * @return
	 */
	Provider getProviderById(@Param("id")Integer id);
	/**
	 * ���ݹ�Ӧ�����Ʋ�ѯ�б�
	 * @param proName
	 * @return
	 */
	List<Provider> getProviderListByProName(@Param("proName")String proName,@Param("proCode")String proCode);
	/**
	 * �޸Ĺ�Ӧ����Ϣ
	 * @param provider
	 * @return
	 */
	int modifyProvider(Provider provider);
	/**
	 * ���ӹ�Ӧ����Ϣ
	 * @param provider
	 * @return
	 */
	int addProvider(Provider provider);
	/**
	 * ͨ��idɾ����Ӧ����Ϣ
	 * @param id
	 * @return
	 */
	int deleteProviderById(@Param("id")Integer id);
}
