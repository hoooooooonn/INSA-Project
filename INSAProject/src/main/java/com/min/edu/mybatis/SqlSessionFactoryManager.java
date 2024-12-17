package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	
	private static SqlSessionFactory factory;
	
	static {
		String path = "com/min/edu/mybatis/Configuration.xml";
		try {
			 Reader reader = Resources.getResourceAsReader(path);
			 factory = new SqlSessionFactoryBuilder().build(reader);
			 reader.close();
			System.out.println("SqlSessionFactory 객체 생성 성공");

		} catch (IOException e) {
			System.out.println("SqlSessionFactory 객체 생성 실패");
			e.printStackTrace();
		}
		
		
		
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	

}
