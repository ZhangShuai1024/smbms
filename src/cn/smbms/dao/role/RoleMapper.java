package cn.smbms.dao.role;

import java.util.List;

import cn.smbms.pojo.Role;


public interface RoleMapper {
	/**
	 * ��ѯ��ɫ�б�
	 * @return
	 */
	List<Role> getRoleList();
	/**
	 * ��ȡ��ɫ����
	 * @return
	 */
	int getRoleCount();
}
