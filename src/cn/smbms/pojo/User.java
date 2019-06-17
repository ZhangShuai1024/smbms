package cn.smbms.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * �û�
 * @author lenovo
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	private Integer id;//id
	private String userCode;//�û�����
	private String userName;//�û�����
	private String userPassword;//�û�����
	private Integer gender;//�Ա�
	private Date birthday;//��������
	private String phone;//�绰
	private String address;//��ַ
	private Integer userRole;//�û���ɫ
	private Integer createdBy;//������
	private Date creationDate;//����ʱ��
	private Integer modifyBy;//������
	private Date modifyDate;//����ʱ��
	@SuppressWarnings("unused")
	private Integer age;//����
	private String userRoleName;//�û���ɫ��

	private Role role;//�û���ɫ
	private List<Address> addressList;//�û���ַ�б�
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getAge() {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
			 
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
			if (dayOfMonthNow < dayOfMonthBirth) 
				age--;
			}else{
				age--;
			}
		}
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
}
