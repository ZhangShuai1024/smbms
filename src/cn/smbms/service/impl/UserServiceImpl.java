package cn.smbms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	@Override
	public User getUserByUserCode(String userCode) {
		return userMapper.getUserByUserCode(userCode);
	}

	@Override
	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}

	@Override
	public int isExistUserCode(String userCode) {
		return userMapper.isExistUserCode(userCode);
	}

	@Override
	public int getUserCount() {
		return userMapper.getUserCount();
	}

	@Override
	public int isExistUser(User user) {
		return userMapper.isExistUser(user);
	}

	@Override
	public List<User> getUserListByUserName(String userName) {
		return userMapper.getUserListByUserName(userName);
	}

	@Override
	public List<User> getUserListByUser(User user) {
		return userMapper.getUserListByUser(user);
	}

	@Override
	public List<User> getUserListByMap(Map<String, String> userMap) {
		return userMapper.getUserListByMap(userMap);
	}

	@Override
	public int add(User user) {
		return userMapper.add(user);
	}

	@Override
	public int modify(User user) {
		return userMapper.modify(user);
	}

	@Override
	public int updatePwd(Integer id, String pwd) {
		return userMapper.updatePwd(id, pwd);
	}

	@Override
	public int deleteUserById(Integer delId) {
		return userMapper.deleteUserById(delId);
	}

	@Override
	public List<User> getUserListByRoleId(Integer roleId) {
		return userMapper.getUserListByRoleId(roleId);
	}

	@Override
	public User getAddressListByUserId(Integer userId) {
		return userMapper.getAddressListByUserId(userId);
	}

	@Override
	public List<User> getUserListByPage(Integer pageIndex, Integer pageSize) {
		return userMapper.getUserListByPage(pageIndex, pageSize);
	}}
