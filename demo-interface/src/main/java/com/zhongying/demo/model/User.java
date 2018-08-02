package com.zhongying.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = -759580475983247539L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userCode;

    private String mobile;

    private String password;

    private Integer status;

    private Integer openAccountStatus;

    private String platform;

    private Integer client;

    private String version;

    private Integer channal;

    private String registerCode;

    private Long registerIp;

    private Date lastLoginTime;

    private Long lastLoginIp;

    private Date createTime;

    private Date updateTime;

    private Integer type;

    private Integer gesturePassword;
    
    private String openid;
    
    private String nickname;
    
    private String city;
    
    private String headimgurl;
    

    public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getGesturePassword() {
        return gesturePassword;
    }

    public void setGesturePassword(Integer gesturePassword) {
        this.gesturePassword = gesturePassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getChannal() {
        return channal;
    }

    public void setChannal(Integer channal) {
        this.channal = channal;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode == null ? null : registerCode.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(Long lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(Long registerIp) {
        this.registerIp = registerIp;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(Integer openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }
}