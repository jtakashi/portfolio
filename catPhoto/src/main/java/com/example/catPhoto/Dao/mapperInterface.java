package com.example.catPhoto.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.catPhoto.Entity.messagesEntity;

@Mapper
public interface mapperInterface {

	@Autowired
	
	@Select("SELECT TEXT FROM MESSAGES")
	List<messagesEntity> findAll();
	
	@Insert("INSERT INTO MESSAGES(TEXT) VALUES(#{newText})")
	void insertNewText(String newText);
			
}
