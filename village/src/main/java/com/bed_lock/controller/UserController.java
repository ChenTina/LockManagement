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
	@RequestMapping("insertUser")		//应该是小程序那边（用户注册）
	public Map<String,Object> insertUser(User user) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println(user);
		userservice.insertUser(user);
		map.put("msg","注册成功");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","服务器异常");
			return map;
		}
	}
	
	
	
	
	
	//	查询所有用户信息
	@RequestMapping(value="findAlluser")
	@ResponseBody
	public Map<String,Object> findByPage1(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<User> user=userservice.findall();
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(user,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	查询所有出入记录信息
	@RequestMapping(value="findAllmark")
	@ResponseBody
	public Map<String,Object> findByPage(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<Mark> mark=userservice.findallmark();
		//使用pageInfo包装查询后的结果
		PageInfo<Mark> page=new PageInfo<Mark>(mark,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	查询所有常住人员信息
	@RequestMapping(value="findAllalwaysuser")
	@ResponseBody
	public Map<String,Object> findAllalwaysuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<User> mark=userservice.queryUserByuser1();
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	查询所有租户人员信息
	@RequestMapping(value="findAllzhuhuuser")
	@ResponseBody
	public Map<String,Object> findAllzhuhuuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<User> mark=userservice.queryUserByuser2();
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	查询所有访客人员信息
	@RequestMapping(value="findAllfangkeuser")
	@ResponseBody
	public Map<String,Object> findAllfangkeuser(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<User> mark=userservice.queryUserByuser3();
		//使用pageInfo包装查询后的结果
		PageInfo<User> page=new PageInfo<User>(mark,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
//	查询所有小区信息
	@RequestMapping(value="findAllcommunity")
	@ResponseBody
	public Map<String,Object> findBycommunity(
		@RequestParam(required=true,defaultValue="1") Integer pageNo,
		@RequestParam(required=false,defaultValue="5") Integer pageSize)throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		//紧跟着的第一个方法会被分页
		List<Community> community=userservice.findallcommunity();
		//使用pageInfo包装查询后的结果
		PageInfo<Community> page=new PageInfo<Community>(community,5);	//5表示页面需要连续显示的页码
		 Map<String,Object> map = new HashMap<String, Object>();
		 //map.put("list",list);
		 map.put("page",page);
		return map;
	}
	
	
	
	//  按照客户名称筛选查询 
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
			map.put("message","用户不存在");
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
			map.put("message","服务器异常");
			return map;
		}
	
	}
	
//  按照人员类别查询 
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
			map.put("message","用户不存在");
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
			map.put("message","服务器异常");
			return map;
		}
	
	}
	
//  按照门名称查询 
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
			map.put("message","用户不存在");
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
			map.put("message","服务器异常");
			return map;
		}
	
	}
	
//  按照小区名称查询 
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
			map.put("message","用户不存在");
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
			map.put("message","服务器异常");
			return map;
		}
	
	}
	
//  按照身份证查询 
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
			map.put("message","用户不存在");
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
			map.put("message","服务器异常");
			return map;
		}
	
	}
	
//  按照时段筛选查询 
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
			map.put("message","该时间不存在客户开锁");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照性别筛选查询 
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
			map.put("message","不存在该性别用户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照年龄段筛选查询 
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
			map.put("message","不存在时间该年龄段客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  精准查询 
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
			map.put("message","不存在该客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
	//上传图片
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST)

	public Map<String,Object> upload(User user,HttpServletRequest request) throws Exception{
		
		Map<String,Object> map = new HashMap<String, Object>();
	  //保存数据库的路径

	  String sqlPath = null; 

	  //定义文件保存的本地路径

      String localPath="D:\\File\\";
      System.out.println("哈哈哈哈哈哈哈");

      //定义 文件名

      String filename=null;  

      if(!user.getFile().isEmpty()){  

          //生成uuid作为文件名称  

          String uuid = UUID.randomUUID().toString().replaceAll("-","");  

          //获得文件类型（可以判断如果不是图片，禁止上传）  

          String contentType=user.getFile().getContentType();  

          //获得文件后缀名 

          String suffixName=contentType.substring(contentType.indexOf("/")+1);

          //得到 文件名

          filename=uuid+"."+suffixName; 

          //文件保存路径

          user.getFile().transferTo(new File(localPath+filename));  

      }

      //把图片的相对路径保存至数据库

      sqlPath = "/images/"+filename;

      System.out.println(sqlPath);

      user.setImage(sqlPath);

      userservice.insert(user);

      map.put("msg","成功");

	  return map;

	}

	@ResponseBody
	@RequestMapping("insertuser")		//应该是小程序那边（用户注册）
	public Map<String,Object> insertuser(User user) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.insertuser(user);
		map.put("msg","注册成功");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","服务器异常");
			return map;
		}
	}
	
	@ResponseBody
	@RequestMapping("insertctime")		
	public Map<String,Object> insertctime(Mark mark) {
		try {
		Map<String,Object> map = new HashMap<String, Object>();
		userservice.insertctime(mark);
		map.put("msg","插入成功");
		map.put("status", 0);
		return map;	
		}catch(Exception e){
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("status",-3);
			map.put("message","服务器异常");
			return map;
		}
	}
	
	
//  按照小区名称和人员类型查询 
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
			map.put("message","不存在客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照客户姓名查询 
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
			map.put("message","不存在客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照客户性别查询 
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
			map.put("message","不存在客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  精准查询 
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
			map.put("message","不存在客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照年龄段筛选查询 
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
			map.put("message","不存在时间该年龄段客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
	
//  按照小区名称和门名称查询出入记录
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
			map.put("message","无记录");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照小区名称和门名称和客户名称查询出入记录
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
			map.put("message","无记录");
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
			map.put("message","服务器异常");
			return map;
		}
	}
//  按照小区名称和门名称和人员类别查询出入记录
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
			map.put("message","无记录");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
//  按照小区名称和门名称和时间段查询出入记录
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
			map.put("message","该时间不存在客户开锁");
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
			map.put("message","服务器异常");
			return map;
		}
	}
	
	
//  精准查询 
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
			map.put("message","不存在客户");
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
			map.put("message","服务器异常");
			return map;
		}
	}
}
