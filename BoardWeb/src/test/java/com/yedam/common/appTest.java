package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.mapper.BoardMapper;

public class appTest {
	public static void main(String[] args) {
		SqlSession sqlSeesion = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSeesion.getMapper(BoardMapper.class);
		
		List<Map> list = mapper.selectUserByCount();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
		System.out.println(json);
	}
}
