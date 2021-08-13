package com.example.catPhoto.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface mapperInterface {

	@Select("SELECT TEXT FROM MESSAGES")
	String findAll();
	
	@Insert("INSERT INTO MESSAGES(TEXT) VALUES(#{newText})")
	void insertNewText(String newText);
			
}
