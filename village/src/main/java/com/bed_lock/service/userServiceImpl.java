package com.bed_lock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bed_lock.bean.Community;
import com.bed_lock.bean.Mark;
import com.bed_lock.bean.User;
import com.bed_lock.mapper.userDao;
@Service
public class userServiceImpl implements userService{
	@Autowired
	private userDao userdao;

	public userDao getUserdao() {
		return userdao;
	}

	public void setUserdao(userDao userdao) {
		this.userdao = userdao;
	}


	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userdao.insertUser(user);
	}


	public List<User> findall() {
		// TODO Auto-generated method stub
		return userdao.findall();
	}

	

	public List<User> queryUserByname(String name) {
		// TODO Auto-generated method stub
		return userdao.queryUserByname(name);
	}

	public List<Mark> queryUserByCtime(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByCtime(maps);
	}

	public List<User> queryUserBySex(String sex) {
		// TODO Auto-generated method stub
		return userdao.queryUserBySex(sex);
	}

	public List<User> queryUserByAge(Map<Object, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByAge(maps);
	}

	public List<User> queryUserBynnc(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserBynnc(maps);
	}

	public List<Mark> findallmark() {
		// TODO Auto-generated method stub
		return userdao.findallmark();
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		userdao.insert(user);
	}

	public void insertuser(User user) {
		// TODO Auto-generated method stub
		userdao.insertuser(user);
	}

	public List<User> queryUserByidcard(String idcard) {
		// TODO Auto-generated method stub
		return userdao.queryUserByidcard(idcard);
	}

	public void insertctime(Mark mark) {
		// TODO Auto-generated method stub
		userdao.insertctime(mark);
	}

	public List<User> queryUserByuser(String usertype) {
		// TODO Auto-generated method stub
		return userdao.queryUserByuser(usertype);
	}

	public List<Mark> queryUserBydoorname(String doorname) {
		// TODO Auto-generated method stub
		return userdao.queryUserBydoorname(doorname);
	}

	public List<Community> findallcommunity() {
		// TODO Auto-generated method stub
		return userdao.findallcommunity();
	}

	public List<User> queryUserByuser1() {
		// TODO Auto-generated method stub
		return userdao.queryUserByuser1();
	}

	public List<User> queryUserByuser2() {
		// TODO Auto-generated method stub
		return userdao.queryUserByuser2();
	}

	public List<User> queryUserByuser3() {
		// TODO Auto-generated method stub
		return userdao.queryUserByuser3();
	}

	public List<Community> queryUserBycommunityname(String name) {
		// TODO Auto-generated method stub
		return userdao.queryUserBycommunityname(name);
	}

	public List<User> queryUserBycomanduser(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserBycomanduser(maps);
	}

	public List<User> queryUserByusername(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByusername(maps);
	}

	public List<User> queryUserByuserSex(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByuserSex(maps);
	}

	public List<User> queryUserByuserAge(Map<Object, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByuserAge(maps);
	}

	public List<Mark> querymark(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.querymark(maps);
	}

	public List<Mark> querymarkByname(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.querymarkByname(maps);
	}

	public List<Mark> querymarkByusertype(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.querymarkByusertype(maps);
	}

	public List<User> queryUserByusernnc(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.queryUserByusernnc(maps);
	}

	public List<Mark> querymarkByCtime(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return userdao.querymarkByCtime(maps);
	}

	public List<User> mohuquery(String name) {
		// TODO Auto-generated method stub
		return userdao.mohuquery(name);
	}

}
