package cn.smbms.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserService {
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
}
