package com.bed_lock.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bed_lock.bean.Community;
import com.bed_lock.bean.Mark;
import com.bed_lock.bean.User;
import com.bed_lock.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private userService userservice;
		
	@ResponseBody
	@RequestMapping("insertUser")		//Ӧ����С�����Ǳߣ��û�ע�ᣩ
	public Map<String,Object> insertUser(User user) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println(user);
		userservice.insertUser(user);
		map.put("msg","ע��ɹ�");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	
	
	
	
	//	��ѯ�����û���Ϣ
	@RequestMapping(value="findAlluser")
	@ResponseBody
	public Map<String,Object> findByPage1(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<User> user=userservice.findall();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<User> page=new PageInfo<User>(user,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	��ѯ���г����¼��Ϣ
	@RequestMapping(value="findAllmark")
	@ResponseBody
	public Map<String,Object> findByPage(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<Mark> mark=userservice.findallmark();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<Mark> page=new PageInfo<Mark>(mark,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	��ѯ���г�ס��Ա��Ϣ
	@RequestMapping(value="findAllalwaysuser")
	@ResponseBody
	public Map<String,Object> findAllalwaysuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<User> mark=userservice.queryUserByuser1();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	��ѯ�����⻧��Ա��Ϣ
	@RequestMapping(value="findAllzhuhuuser")
	@ResponseBody
	public Map<String,Object> findAllzhuhuuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<User> mark=userservice.queryUserByuser2();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	��ѯ���зÿ���Ա��Ϣ
	@RequestMapping(value="findAllfangkeuser")
	@ResponseBody
	public Map<String,Object> findAllfangkeuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<User> mark=userservice.queryUserByuser3();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	��ѯ����С����Ϣ
	@RequestMapping(value="findAllcommunity")
	@ResponseBody
	public Map<String,Object> findBycommunity(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//�����ŵĵ�һ�������ᱻ��ҳ
		List<Community> community=userservice.findallcommunity();
		//ʹ��pageInfo��װ��ѯ��Ľ��
		PageInfo<Community> page=new PageInfo<Community>(community,5);	//5��ʾҳ����Ҫ������ʾ��ҳ��
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
	
	
	//  ���տͻ�����ɸѡ��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByname")
	public Map<String,Object> queryUserByKname(String name, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByname(name);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�û�������");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	
	}
	
//  ������Ա����ѯ 
	@ResponseBody
	@RequestMapping("queryUserByuser")
	public Map<String,Object> queryUserByuser(String user, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<User> users = userservice.queryUserByuser(user);
		PageInfo<User> page=new PageInfo<User>(users);
		if(page.getTotal()==0) {
			map.put("message","�û�������");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	
	}
	
//  ���������Ʋ�ѯ 
	@ResponseBody
	@RequestMapping("queryUserBydoorname")
	public Map<String,Object> queryUserBydoorname(String doorname, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> users = userservice.queryUserBydoorname(doorname);
		PageInfo<Mark> page=new PageInfo<Mark>(users);
		if(page.getTotal()==0) {
			map.put("message","�û�������");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	
	}
	
//  ����С�����Ʋ�ѯ 
	@ResponseBody
	@RequestMapping("queryUserBycommunityname")
	public Map<String,Object> queryUserBycommunityname(String name, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<Community> users = userservice.queryUserBycommunityname(name);
		PageInfo<Community> page=new PageInfo<Community>(users);
		if(page.getTotal()==0) {
			map.put("message","�û�������");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	
	}
	
//  �������֤��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByidcard")
	public Map<String,Object> queryUserByidcard(String idcard, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByidcard(idcard);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�û�������");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	
	}
	
//  ����ʱ��ɸѡ��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByCtime")
	public Map<String,Object> queryUserByKname(String startTime, String endTime, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("startTime",startTime);
		maps.put("endTime",endTime);
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> mark = userservice.queryUserByCtime(maps);
		PageInfo<Mark> page=new PageInfo<Mark>(mark);
		if(page.getTotal()==0) {
			map.put("message","��ʱ�䲻���ڿͻ�����");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  �����Ա�ɸѡ��ѯ 
	@ResponseBody
	@RequestMapping("queryUserBySex")
	public Map<String,Object> queryUserBySex(String sex, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserBySex(sex);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڸ��Ա��û�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ���������ɸѡ��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByAge")
	public Map<String,Object> queryUserByAge(int ages, int agee, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<Object, Object> maps = new HashMap<Object, Object>();
		maps.put("ages",ages);
		maps.put("agee",agee);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByAge(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","������ʱ�������οͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ��׼��ѯ 
	@ResponseBody
	@RequestMapping("queryUserBynnc")
	public Map<String,Object> queryUserBynnc(String name, String idcard,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("name",name);
		maps.put("idcard",idcard);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserBynnc(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڸÿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	//�ϴ�ͼƬ
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST)

	public Map<String,Object> upload(User user,HttpServletRequest request) throws Exception{
		
		Map<String,Object> map = new HashMap<String, Object>();
	  //�������ݿ��·��

	  String sqlPath = null; 

	  //�����ļ�����ı���·��

      String localPath="D:\\File\\";
      System.out.println("��������������");

      //���� �ļ���

      String filename=null;  

      if(!user.getFile().isEmpty()){  

          //����uuid��Ϊ�ļ�����  

          String uuid = UUID.randomUUID().toString().replaceAll("-","");  

          //����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���  

          String contentType=user.getFile().getContentType();  

          //����ļ���׺�� 

          String suffixName=contentType.substring(contentType.indexOf("/")+1);

          //�õ� �ļ���

          filename=uuid+"."+suffixName; 

          //�ļ�����·��

          user.getFile().transferTo(new File(localPath+filename));  

      }

      //��ͼƬ�����·�����������ݿ�

      sqlPath = "/images/"+filename;

      System.out.println(sqlPath);

      user.setImage(sqlPath);

      userservice.insert(user);

      map.put("msg","�ɹ�");

	  return map;

	}

	@ResponseBody
	@RequestMapping("insertuser")		//Ӧ����С�����Ǳߣ��û�ע�ᣩ
	public Map<String,Object> insertuser(User user) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.insertuser(user);
		map.put("msg","ע��ɹ�");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	@ResponseBody
	@RequestMapping("insertctime")		
	public Map<String,Object> insertctime(Mark mark) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.insertctime(mark);
		map.put("msg","����ɹ�");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	
//  ����С�����ƺ���Ա���Ͳ�ѯ 
	@ResponseBody
	@RequestMapping("queryUserBycomanduser")
	public Map<String,Object> queryUserBycomanduser(String usertype, String community,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("usertype",usertype);
		maps.put("community",community);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserBycomanduser(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ���տͻ�������ѯ 
	@ResponseBody
	@RequestMapping("queryUserByusername")
	public Map<String,Object> queryUserByusername(String usertype, String community,String name,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("usertype",usertype);
		maps.put("community",community);
		maps.put("name",name);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByusername(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ���տͻ��Ա��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByuserSex")
	public Map<String,Object> queryUserByuserSex(String usertype, String community,String sex,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("usertype",usertype);
		maps.put("community",community);
		maps.put("sex",sex);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByuserSex(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ��׼��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByusernnc")
	public Map<String,Object> queryUserByusernnc(String name, String idcard,String usertype, String community,String sex,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("usertype",usertype);
		maps.put("community",community);
		maps.put("name",name);
		maps.put("idcard",idcard);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByusernnc(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ���������ɸѡ��ѯ 
	@ResponseBody
	@RequestMapping("queryUserByuserAge")
	public Map<String,Object> queryUserByuserAge(String usertype, String community,int ages, int agee, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<Object, Object> maps = new HashMap<Object, Object>();
		maps.put("ages",ages);
		maps.put("agee",agee);
		maps.put("usertype",usertype);
		maps.put("community",community);
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.queryUserByuserAge(maps);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","������ʱ�������οͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	
//  ����С�����ƺ������Ʋ�ѯ�����¼
	@ResponseBody
	@RequestMapping("querymark")
	public Map<String,Object> querymark(String community, String doorname, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("community",community);
		maps.put("doorname",doorname);
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> mark = userservice.querymark(maps);
		PageInfo<Mark> page=new PageInfo<Mark>(mark);
		if(page.getTotal()==0) {
			map.put("message","�޼�¼");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ����С�����ƺ������ƺͿͻ����Ʋ�ѯ�����¼
	@ResponseBody
	@RequestMapping("querymarkByname")
	public Map<String,Object> querymarkByname(String community, String doorname,String name, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("community",community);
		maps.put("doorname",doorname);
		maps.put("name",name);
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> mark = userservice.querymarkByname(maps);
		PageInfo<Mark> page=new PageInfo<Mark>(mark);
		if(page.getTotal()==0) {
			map.put("message","�޼�¼");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
//  ����С�����ƺ������ƺ���Ա����ѯ�����¼
	@ResponseBody
	@RequestMapping("querymarkByusertype")
	public Map<String,Object> querymarkByusertype(String community, String doorname,String usertype, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("community",community);
		maps.put("doorname",doorname);
		maps.put("usertype",usertype);
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> mark = userservice.querymarkByusertype(maps);
		PageInfo<Mark> page=new PageInfo<Mark>(mark);
		if(page.getTotal()==0) {
			map.put("message","�޼�¼");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
//  ����С�����ƺ������ƺ�ʱ��β�ѯ�����¼
	@ResponseBody
	@RequestMapping("querymarkByCtime")
	public Map<String,Object> querymarkByCtime(String community, String doorname,String startTime, String endTime, @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("community",community);
		maps.put("doorname",doorname);
		maps.put("startTime",startTime);
		maps.put("endTime",endTime);
		PageHelper.startPage(pageNo, pageSize);
		List<Mark> mark = userservice.querymarkByCtime(maps);
		PageInfo<Mark> page=new PageInfo<Mark>(mark);
		if(page.getTotal()==0) {
			map.put("message","��ʱ�䲻���ڿͻ�����");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
	
	
//  ��׼��ѯ 
	@ResponseBody
	@RequestMapping("mohuquery")
	public Map<String,Object> mohuquery(String name,@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize) throws Exception{
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<User> user = userservice.mohuquery(name);
		PageInfo<User> page=new PageInfo<User>(user);
		if(page.getTotal()==0) {
			map.put("message","�����ڿͻ�");
			map.put("status",-1);
			return map;
		}else {
		map.put("page",page);
		map.put("status", 0);
		return map;
		}
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","�������쳣");
			return map;
		}
	}
}
