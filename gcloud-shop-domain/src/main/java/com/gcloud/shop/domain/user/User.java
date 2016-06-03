package com.gcloud.shop.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: User
 * @Package com.gcloud.domain.SubUser
 * @Description: 用户模型
 * @date 2016/6/1 13:53
 */
public class User implements Serializable {

	/**
	 * 系统的用户编号
	 */
	private Long id;
	
	/**
	 * 淘宝的卖家编号
	 */
	private Long taobaoId;
	
	/**
	 * 卖家昵称
	 */
	private String nick;
	
	/**
	 * 上一次登录时间
	 */
	private Date lastLoginDate;
	
	/**
	 * 店铺关联编号，默认为-1，如果大于0，表示有关联店铺
	 */
	private Long associationId;
	
	/**
	 * 如果绑定了店铺，那么这个用户是否为主店铺
	 */
	private Integer masterUser;
	
	/**
	 * 淘宝的店铺编号
	 */
	private Long sid;
	
	/**
	 * 淘宝的会话
	 */
	private String sessionId;
	
	/**
	 * 有关卖家的系统配置数据
	 */
	private String conf;
	
	/**
	 * 用户的服务到期时间
	 */
	private Date deadline;
	
	/**
	 * 用户购买软件的等级，1表示初级版，2表示中级版，3表示高级版
	 */
	private Integer level;
	
	/**
	 * 创建时间
	 */
	private Date created;
	
	/**
	 * 更新时间
	 */
	private Date modified;
	
	/**
	 * 数据的可用状态，0表示不可用，1表示可用
	 */
	private Integer enableStatus;
	
	/**
	 * 用户从淘宝跳转到应用的请求参数
	 */
	private String urlParams;

	/**
	 * 用户的配置信息，从conf属性中解析出来，这个不做存储由userService进行控制
	 */
	private UserConf userConf;
	
	/**
	 * 如果这个用户下面绑定了其他的店铺的用户，那么这里需要加载其他店铺的用户信息，这个控制应该在会话层处理，这个属性不会进行持久化
	 */
	private Map<Long, User> bindUsers;
	
	/**
	 * 当前登录的子账户信息，如果是子账户登录到系统中，会话中将会使用subUser中的信息
	 */
	private SubUser subUser;
	
	/**
	 * 跳转的来源地，默认为空
	 */
	private String source;
	
	/**
	 * 绑定店铺的信息，一般在多店铺中查询用户信息时才会返回
	 */
	private List<Shop> bindShops;

	/**
	 * 绑定店铺的信息, 获取店铺信息（支持单店铺）
	 */
	private List<Shop> shopList;
	
	/**
	 * 只有在主从的多店铺模式下，才会使用此数据
	 */
	private User masterUserData;
	
	/**
	 * 只有在主从的多店铺模式下，如果使用slave用户登录，那么用户会话还依然是主店铺的会话，但是会将当前登录的店铺用户信息放入到slaveUserData中
	 */
	private User slaveUserData;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaobaoId() {
		return taobaoId;
	}

	public void setTaobaoId(Long taobaoId) {
		this.taobaoId = taobaoId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getAssociationId() {
		return associationId;
	}

	public void setAssociationId(Long associationId) {
		this.associationId = associationId;
	}

	public Integer getMasterUser() {
		return masterUser;
	}

	public void setMasterUser(Integer masterUser) {
		this.masterUser = masterUser;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public String getUrlParams() {
		return urlParams;
	}

	public void setUrlParams(String urlParams) {
		this.urlParams = urlParams;
	}

	public UserConf getUserConf() {
		return userConf;
	}

	public void setUserConf(UserConf userConf) {
		this.userConf = userConf;
	}

	public Map<Long, User> getBindUsers() {
		return bindUsers;
	}

	public void setBindUsers(Map<Long, User> bindUsers) {
		this.bindUsers = bindUsers;
	}

	public SubUser getSubUser() {
		return subUser;
	}

	public void setSubUser(SubUser subUser) {
		this.subUser = subUser;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Shop> getBindShops() {
		return bindShops;
	}

	public void setBindShops(List<Shop> bindShops) {
		this.bindShops = bindShops;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

	public User getMasterUserData() {
		return masterUserData;
	}

	public void setMasterUserData(User masterUserData) {
		this.masterUserData = masterUserData;
	}

	public User getSlaveUserData() {
		return slaveUserData;
	}

	public void setSlaveUserData(User slaveUserData) {
		this.slaveUserData = slaveUserData;
	}
}
