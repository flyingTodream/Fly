package com.fly.model;

import java.io.Serializable;


public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;
    @Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", nickName=" + nickName + ", avatar=" + avatar + ", phone=" + phone + ", email=" + email + ", sex="
				+ sex + ", locked=" + locked + ", addTime=" + addTime + ", updateTime=" + updateTime + ", version="
				+ version + "]";
	}

	private String id;

    private String username;

    private String password;

    private String realname;

    private String nickName;

    private String avatar;

    private String phone;

    private String email;

    private Byte sex;

    private Byte locked;

    private String addTime;

    private String updateTime;

    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}