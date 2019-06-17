package cn.smbms.pojo;

import java.util.Date;

/**
 * ����
 * @author lenovo
 *
 */
public class Bill {
	private Integer id;//����ID
	private String billCode;//�˵�����
	private String productName;//��Ʒ����
	private String productDesc;//��Ʒ����
	private String productUnit;//��Ʒ��λ
	private Double productCount;//��Ʒ����
	private Double totalPrice;//��Ʒ�ܶ�
	private Integer isPayment;//�Ƿ�֧����1��δ֧�� 2����֧����
	private Integer createdBy;//�����ߣ�userId��
	private Date creationDate;//����ʱ��
	private Integer modifyBy;//�����ߣ�userId��
	private Date modifyDate;//����ʱ��
	private Integer providerId;//��Ӧ��ID
	private String providerName;//��Ӧ������
	private Provider provider;//��Ӧ����Ϣ
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Double getProductCount() {
		return productCount;
	}
	public void setProductCount(Double productCount) {
		this.productCount = productCount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
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
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
}
