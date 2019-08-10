package com.bed_lock.bean;

import org.springframework.web.multipart.MultipartFile;

public class User {

    private String tel;
    private String sex;
    private String name;
    private String address;
    private String email;
    private String idcard;
    private String age;
    private String image;
    private String usertype;
    private String community;
    

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	private MultipartFile file;

    

    public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	

	public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [tel=" + tel + ", sex=" + sex + ", name=" + name + ", email=" + email + ", idcard=" + idcard
				+ ", age=" + age + ", usertype=" + usertype + ", community=" + community + "]";
	}
	
	

     
}


