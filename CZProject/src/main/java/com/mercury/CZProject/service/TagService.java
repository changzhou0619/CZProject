package com.mercury.CZProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.Tag;
import com.mercury.CZProject.dao.TagDao;

@Service
public class TagService {
	
	@Autowired
	private TagDao tagDao;
	
	public List<Tag> getAll() {
		return tagDao.findAll();
	}
	
	public String createTag(Tag tag) {
		if(tagDao.findByTagname(tag.getTagname()) == null) {
			tagDao.save(tag);
			return "Successful create a tag";
		}
		return "Tag already exist";
		
	}
	
	public String editTag(Tag tag) {
		if(tagDao.findByTagname(tag.getTagname()) == null && tagDao.findById(tag.getTagid()).get().getTagname() == tag.getTagname()) {
			tagDao.save(tag);
			return "Tag edit Successful";
		}
		return "Tag edit Fail, tag name already exist or new tag name is same as old tag name";
		
	}
	
	public String deleteTag(Tag tag) {
		if(tagDao.findByTagname(tag.getTagname()) == null) {
			
			tagDao.delete(tag);
			return "Successful delete tag";
		}
		return "Delete tag fail";

	}
}
