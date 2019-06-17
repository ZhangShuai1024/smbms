package cn.smbms.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserService {
	/**
	 * ��ȡ�û��б�
	 * @return �û��б�
	 */
	List<User> getUserList();
	/**
	 * �����û������ѯ�û�
	 * @param userCode
	 * @return
	 */
	User getUserByUserCode(@Param("userCode")String userCode);
	/**
	 * ����id��ѯ�û�
	 * @param userId
	 * @return
	 */
	User getUserById(@Param("id") Integer userId);
	/**
	 * ��֤�û������Ƿ����
	 * @param userCode
	 * @return
	 */
	int isExistUserCode(String userCode);
	/**
	 * ��ȡ�û�����
	 * @return ����
	 */
	int getUserCount();
	/**
	 * �ж��û��Ƿ����
	 * @param user
	 * @return
	 */
	int isExistUser(User user);
	/**
	 * �����û����Ʋ�ѯ�û��б�ģ����ѯ��
	 * @param userName
	 * @return
	 */
	List<User> getUserListByUserName(String userName);
	/**
	 * ��ѯ�û��б�
	 * @param user �������
	 * @return
	 */
	List<User> getUserListByUser(User user);
	/**
	 * ��ѯ�û��б�
	 * @param userMap ������Map��
	 * @return
	 */
	List<User> getUserListByMap(Map<String , String > userMap);
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	int add(User user);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int modify(User user);
	/**
	 * �޸ĵ�ǰ�û�����
	 * @param id
	 * @param pwd
	 * @return
	 */
	int updatePwd(@Param("id")Integer id,@Param("userPassword")String pwd);
	/**
	 * ����userIdɾ���û���Ϣ
	 * @param delId
	 * @return
	 */
	int deleteUserById(@Param("id")Integer delId);
	/**
	 * ���ݽ�ɫid��ȡ��ɫ�б�
	 * @param roleId
	 * @return
	 */
	List<User> getUserListByRoleId(@Param("userRole")Integer roleId);
	/**
	 * ��ȡָ���û��������Ϣ�͵�ַ�б�
	 * @param userId
	 * @return
	 */
	User getAddressListByUserId(@Param("id")Integer userId);
	/**
	 * ��ҳ��ȡ�û��б�
	 * @param pageIndex 
	 * @param pageSize
	 * @return
	 */
	List<User> getUserListByPage(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
}
