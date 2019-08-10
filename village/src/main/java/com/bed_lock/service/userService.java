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
	
	
	public List<User> queryUserBycomanduser(Map<String, Object> maps);//��С�����ƺ���Ա���Ͳ�ѯ
	public List<User> queryUserByusername(Map<String, Object> maps);//��������ѯ
	public List<User> queryUserByuserSex(Map<String, Object> maps);//���Ա��ѯ
	public List<User> queryUserByuserAge(Map<Object, Object> maps);//������β�ѯ
	public List<User> queryUserByusernnc(Map<String, Object> maps);//��׼��ѯ
	
	public List<Mark>querymark(Map<String, Object> maps);//��С�����ƺ������Ʋ�ѯ
	public List<Mark> querymarkByname(Map<String, Object> maps);//��С�����ƺ������ƺͿͻ�������ѯ
	public List<Mark> querymarkByusertype(Map<String, Object> maps);//��С�����ƺ������ƺ���Ա����ѯ
	public List<Mark> querymarkByCtime(Map<String, Object> maps);//��С�����ƺ������ƺ�ʱ��β�ѯ
	
	public List<User> mohuquery(String name);	//ģ����ѯ
}
