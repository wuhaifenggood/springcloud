package com.example.src.Po;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 *序号
	 **/
	@Id
	private long id;
	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	/**
	 *服务商id
	 **/
	private long pid;

	/**
	 *登陆名
	 **/
	private String loginName;

	/**
	 *用户名
	 **/
	private String userName;

	/**
	 *头像
	 **/
	private String avatar;

	/**
	 *加盐
	 **/
	private String salt;

	/**
	 *密码
	 **/
	private String password;

	/**
	 *注册时间
	 **/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date registerTime;

	/**
	 *用户状态
	 **/
	private int isEnable;

	/**
	 *删除状态
	 **/
	private int removed;

	/**
	 *手机号
	 **/
	private long phone;
	
	/**
	 * 入驻类型
	 * 
	 **/
	private String settledType;
	
	public String getSettledType() {
		return settledType;
	}

	public void setSettledType(String settledType) {
		this.settledType = settledType;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return this.id;
	}

	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	public String getLoginName(){
		return this.loginName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return this.salt;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setRegisterTime(java.util.Date registerTime){
		this.registerTime = registerTime;
	}

	public java.util.Date getRegisterTime(){
		return this.registerTime;
	}

	public void setIsEnable(int isEnable){
		this.isEnable = isEnable;
	}

	public int getIsEnable(){
		return this.isEnable;
	}

	public void setRemoved(int removed){
		this.removed = removed;
	}

	public int getRemoved(){
		return this.removed;
	}

	public void setPhone(long phone){
		this.phone = phone;
	}

	public long getPhone(){
		return this.phone;
	}

	
}
