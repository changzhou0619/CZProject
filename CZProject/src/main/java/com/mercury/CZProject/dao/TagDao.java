package com.mercury.CZProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.CZProject.bean.Tag;

public interface TagDao extends JpaRepository<Tag, Integer> {
	
	Tag findByTagid(int tagId);
	
	Tag findByTagname(String tagName);
}
