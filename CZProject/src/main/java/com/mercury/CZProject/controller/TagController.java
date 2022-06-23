package com.mercury.CZProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.CZProject.bean.Tag;
import com.mercury.CZProject.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@GetMapping
	@PreAuthorize("permitAll()")
	public List<Tag> getAll() {
		return tagService.getAll();
	}
	
	@PostMapping("/createTag")
	@PreAuthorize("hasRole('ADMIN')")
	public String createTag(@RequestBody Tag tag) {
		return tagService.createTag(tag);
	}
}
