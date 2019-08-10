package com.bed_lock.service;

import java.util.List;
import java.util.Map;

import com.bed_lock.bean.Community;
import com.bed_lock.bean.Mark;
import com.bed_lock.bean.User;

public interface userService {
	public void insertUser(User user);
	public List<User> findall();
	public List<Mark> findallmark();
	public List<Community> findallcommunity();
	public List<User> queryUserByname(String name);
	public List<Mark> queryUserByCtime(Map<String, Object> maps);
	public List<User> queryUserBySex(String sex);
	public List<User> queryUserByAge(Map<Object, Object> maps);
	public List<User> queryUserBynnc(Map<String, Object> maps);
	public void insert(User user);
	public void insertuser(User user);
	
	public List<User> queryUserByidcard(String idcard);
	public void insertctime(Mark mark);
	
	public List<User> queryUserByuser(String usertype);
	public List<Mark> queryUserBydoorname(String doorname);
	public List<User> queryUserByuser1();
	public List<User> queryUserByuser2();
	public List<User> queryUserByuser3();
	public List<Community> queryUserBycommunityname(String name);
	
	
	public List<User> queryUserBycomanduser(Map<String, Object> maps);//按小区名称和人员类型查询
	public List<User> queryUserByusername(Map<String, Object> maps);//按姓名查询
	public List<User> queryUserByuserSex(Map<String, Object> maps);//按性别查询
	public List<User> queryUserByuserAge(Map<Object, Object> maps);//按年龄段查询
	public List<User> queryUserByusernnc(Map<String, Object> maps);//精准查询
	
	public List<Mark>querymark(Map<String, Object> maps);//按小区名称和门名称查询
	public List<Mark> querymarkByname(Map<String, Object> maps);//按小区名称和门名称和客户姓名查询
	public List<Mark> querymarkByusertype(Map<String, Object> maps);//按小区名称和门名称和人员类别查询
	public List<Mark> querymarkByCtime(Map<String, Object> maps);//按小区名称和门名称和时间段查询
	
	public List<User> mohuquery(String name);	//模糊查询
}
