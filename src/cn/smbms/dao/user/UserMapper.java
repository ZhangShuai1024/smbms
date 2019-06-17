package cn.smbms.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
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
	 * ��ȡ�û��б�
	 * @param user
	 * @return
	 */
	List<User> getUserList(User user);
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
	 * �����û���ɫ�б���ȡ�ý�ɫ�б����û��б���Ϣ-foreach_array
	 * @param roldIds
	 * @return
	 */
	List<User> getUserByRoleId_foreach_array(Integer[] roldIds);
	/**
	 * �����û���ɫ�б���ȡ�ý�ɫ�б����û��б���Ϣ-foreach_list
	 * @param roldIds
	 * @return
	 */
	List<User> getUserByRoleId_foreach_list(List<Integer> roldList);
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
	/**
	 * �����û���ɫ�б���Ա𣨶����������ȡ�ý�ɫ�б���ָ���Ա���û��б���Ϣ-foreach_map
	 * @param conditionMap
	 * @return
	 */
	List<User> getUserByCoditionMap_foreach_map(Map<String, Object> conditionMap);
	/**
	 * ���û���ɫ�б���ȡ�ý�ɫ�б����û��б���Ϣ-foreach_map(��������װ��map)
	 * @param roleMap
	 * @return
	 */
	List<User> getUserByRoleId_foreach_map(Map<String, Object> roleMap);
	/**
	 * ��ѯ�û��б�choose��
	 * @param userName
	 * @param userRole
	 * @param userCode
	 * @param creatuibDate
	 * @return
	 */
	List<User> getUserList_choose(@Param("userName")String userName,
								  @Param("userRole")Integer userRole,
							  	  @Param("userCode")String userCode,
								  @Param("creationDate")Date creationDate);
	/**
	 * ��ѯ�û���𣨷�ҳ��ʾ��
	 * @param userName
	 * @param roleId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	List<User> getUserList(@Param("userName")String userName,
						   @Param("userRole")Integer roleId,
					  	   @Param("from")Integer currentPage,
						   @Param("pageSize")Integer pageSize);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
