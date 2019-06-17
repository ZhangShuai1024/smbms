package cn.smbms.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
	/**
	 * 获取用户列表
	 * @return 用户列表
	 */
	List<User> getUserList();
	/**
	 * 根据用户编码查询用户
	 * @param userCode
	 * @return
	 */
	User getUserByUserCode(@Param("userCode")String userCode);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	User getUserById(@Param("id") Integer userId);
	/**
	 * 验证用户编码是否存在
	 * @param userCode
	 * @return
	 */
	int isExistUserCode(String userCode);
	/**
	 * 获取用户列表
	 * @param user
	 * @return
	 */
	List<User> getUserList(User user);
	/**
	 * 获取用户数量
	 * @return 数量
	 */
	int getUserCount();
	/**
	 * 判断用户是否存在
	 * @param user
	 * @return
	 */
	int isExistUser(User user);
	/**
	 * 根据用户名称查询用户列表（模糊查询）
	 * @param userName
	 * @return
	 */
	List<User> getUserListByUserName(String userName);
	/**
	 * 查询用户列表
	 * @param user 对象参数
	 * @return
	 */
	List<User> getUserListByUser(User user);
	/**
	 * 查询用户列表
	 * @param userMap 参数（Map）
	 * @return
	 */
	List<User> getUserListByMap(Map<String , String > userMap);
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int add(User user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int modify(User user);
	/**
	 * 修改当前用户密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	int updatePwd(@Param("id")Integer id,@Param("userPassword")String pwd);
	/**
	 * 根据userId删除用户信息
	 * @param delId
	 * @return
	 */
	int deleteUserById(@Param("id")Integer delId);
	/**
	 * 根据角色id获取角色列表
	 * @param roleId
	 * @return
	 */
	List<User> getUserListByRoleId(@Param("userRole")Integer roleId);
	/**
	 * 根据用户角色列表，获取该角色列表下用户列表信息-foreach_array
	 * @param roldIds
	 * @return
	 */
	List<User> getUserByRoleId_foreach_array(Integer[] roldIds);
	/**
	 * 根据用户角色列表，获取该角色列表下用户列表信息-foreach_list
	 * @param roldIds
	 * @return
	 */
	List<User> getUserByRoleId_foreach_list(List<Integer> roldList);
	/**
	 * 获取指定用户的相关信息和地址列表
	 * @param userId
	 * @return
	 */
	User getAddressListByUserId(@Param("id")Integer userId);
	/**
	 * 分页获取用户列表
	 * @param pageIndex 
	 * @param pageSize
	 * @return
	 */
	List<User> getUserListByPage(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	/**
	 * 根据用户角色列表和性别（多参数），获取该角色列表下指定性别的用户列表信息-foreach_map
	 * @param conditionMap
	 * @return
	 */
	List<User> getUserByCoditionMap_foreach_map(Map<String, Object> conditionMap);
	/**
	 * 据用户角色列表，获取该角色列表下用户列表信息-foreach_map(单参数封装成map)
	 * @param roleMap
	 * @return
	 */
	List<User> getUserByRoleId_foreach_map(Map<String, Object> roleMap);
	/**
	 * 查询用户列表（choose）
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
	 * 查询用户类别（分页显示）
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
