package com.Test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.model.User;


public class MybatisTest {
	@Test
	
	public void text()throws IOException{
		//1.锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟接的会话锟侥癸拷锟斤拷锟洁，锟斤拷锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷
		InputStream inputStream=Resources.getResourceAsStream("mybatisConfig.xml");
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通锟斤拷锟斤拷锟斤拷锟洁，锟斤拷取锟斤拷锟斤拷锟捷匡拷锟斤拷锟接的会话
		SqlSession session=sqlSessionFactory.openSession(ExecutorType.BATCH);//批量加入
		
		//3.通锟斤拷session锟斤拷锟斤拷锟斤拷锟捷匡拷
		try{
			
			UserMapper usermapper=session.getMapper(UserMapper.class);
			List<User> user=usermapper.getUserByP(1, 9);
			System.out.println(user);
			
			/*14.批量插入耗时
			 * long start=System.currentTimeMillis();
			for(int i=0;i<=10000;i++)
			{
				usermapper.insertSelective(new User("aaa"+i,"bbb"+i));
			}
			session.commit();
			long end=System.currentTimeMillis();
			System.out.println("批量插入耗时"+(end-start)+"毫秒");*/
			
			/* 13.分页查询
			 * UserMapper usermapper=session.getMapper(UserMapper.class);
			 * Page<User> page=PageHelper.startPage(2,5); //分页查询第二页，共五条数据
			List<User> user=usermapper.selectAllUser();
			PageInfo<User> pageinfo=new PageInfo<User>(user);
			//User user=usermapper.selectByPrimaryKey(1);
			for(User u:user)
			{
				System.out.println(u);
			}
			System.out.println(page.getPageNum());
			System.out.println(page.getPageSize());
			System.out.println(page.getPages());
			System.out.println(page.getTotal());
			
			System.out.println(pageinfo.getPageSize());
			System.out.println(pageinfo.isHasNextPage());		
			 */
			
			 /*
			  * 12. bind 实现传值
			  * List<User> list=usermapper.getUserByLike("aa","");
			  * System.out.println(list);			 
			  */
				
			
			/*11 foreach实现mysql
			 * List<User> list=new LinkedList<User>();
			User user1=new User("1yy","1pp",1);
			User user2=new User("2yy","2pp",1);
			User user3=new User("3yy","3pp",1);
			User user4=new User("4yy","4pp",1);		
			list.add(user1);
			list.add(user2);
			list.add(user3);
			list.add(user4);
			usermapper.insertUsers(list);
			session.commit();*/
			/*
			 * 10 a6标签foreach			  			 
			int[] ids= {1,2,3,4,5};
			List<User> list=usermapper.getUsersByIds(ids);
			System.out.println(list);*/
			/*
			 * 9 a5标签set
			 * User user=new User(); 
			user.setId(8);
			user.setPasword("111");
			usermapper.updateUser(user);
			session.commit();*/
			
			 /* 8 a1-a4标签if where trim choose
			  * List<User> list=usermapper.getUserByLike("%aa%","");			 
			  * System.out.println(list);*/
			
			/*7
			 * User user=usermapper.getOneUserById(1);
			System.out.println(user);//第一个会话关闭之前，清空自己的一级缓存，清空之前会转存到二级缓存；
			session.close();
			
			SqlSession session2=sqlSessionFactory.openSession();
			UserMapper usermapper2=session2.getMapper(UserMapper.class);
			User user2=usermapper2.getOneUserById(1);
			System.out.println(user2);
			session2.close();*/
			
	     /* 6
	      * User user=session.selectOne("com.model.selectOneUser",1);
		  System.out.println(user);*/
			
			//锟街诧拷锟斤拷询 锟斤拷锟揭�  锟绞猴拷Rolemapper.xml 锟斤拷锟斤拷锟斤拷锟街诧拷询1 2
			/*RoleMapper rolemapper=session.getMapper(RoleMapper.class);
			Role role=rolemapper.getAllProRoleById(1);
			
			System.out.println(role.getRoleName());
			System.out.println(role.getUsers().size());*/
			
			/*锟街诧拷锟斤拷询一锟皆讹拷
			 * UserMapper mapper=session.getMapper(UserMapper.class);
			User user=mapper.getOneUserById(1);//实锟街癸拷锟斤拷锟斤拷询
			System.out.println(user);*/
			
			/*List<User> user=mapper.getAllUsers();
			System.out.println(user);*/
			
			//5 锟斤拷锟斤拷array
			/*int a[]= {1,4};
			List<User> user=mapper.getOneUserById(a);
			System.out.println(user);*/
			
			/* 4 list锟斤拷锟斤拷
			 * List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(4);
			List<User> user=mapper.getOneUserById(list);
			System.out.println(user);*/
			
			/*3 map锟斤拷锟斤拷
			 * Map<String,Object>  map=new HashMap<String, Object>();
			map.put("start_id",2);
			map.put("end_id", 4);
			List<User> user=mapper.getOneUserById(map);
			System.out.println(user);*/
			
			/*2 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			 * List<User> user=mapper.getOneUserById(1, 4);
			System.out.println(user);*/
			
			/*1
			 * User user=new User("bcsss","16",null,1);
			int cs=mapper.insertUser(user);
			System.out.println(user.getId());*/
			//mapper.insertUser(user);
			
			//user.setId(4);
			//mapper.updateUser(user);
			//mapper.deleteUser(1);
		
			//session.commit();//锟斤拷锟剿诧拷询锟斤拷
			//System.out.println(user);
			
		}
		finally {
			session.close();
		}
   }
	
	
}
