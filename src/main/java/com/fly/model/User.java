package com.fly.model;

public class User {
    private Integer Id;

    private String username;

    private boolean sex;

    private String city;

    private String sign;
    
    private int experience;
    
    private int scores;
    
    private int classify;
    
    private int wealth;
    
    private boolean auth;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	public int getClassify() {
		return classify;
	}

	public void setClassify(int classify) {
		this.classify = classify;
	}

	public int getWealth() {
		return wealth;
	}

	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public User(Integer id, String username, boolean sex, String city, String sign, int experience, int scores,
			int classify, int wealth, boolean auth) {
		super();
		Id = id;
		this.username = username;
		this.sex = sex;
		this.city = city;
		this.sign = sign;
		this.experience = experience;
		this.scores = scores;
		this.classify = classify;
		this.wealth = wealth;
		this.auth = auth;
	}

	public User() {
		super();
	}

}