package com.social.network.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.network.entity.SocialNetworkPost;
import com.social.network.repository.SocialNetworkPostRepository;

@Service
public class SocialNetworkPostService {
	private static final Logger log = LoggerFactory.getLogger(SocialNetworkPostService.class);
	@Autowired
	SocialNetworkPostRepository socialNetworkPostRepository;

	public Set<SocialNetworkPost> saveUpdateSocialNetworkPost(SocialNetworkPost socialNetworkPost) {
		try {
			 socialNetworkPostRepository.saveAndFlush(socialNetworkPost);
			 return socialNetworkPostRepository.getHighestVewCountPerPostCatg();
		} catch (Exception e) {
			log.error("Error -> ", e);
			return Collections.emptySet();
		}
	}

	public List<SocialNetworkPost> findAllSocialNetworkPost() {
		try {
			return socialNetworkPostRepository.findAll();
		} catch (Exception e) {
			log.error("Error -> ", e);
			return Collections.emptyList();
		}
	}

	public String deleteById(int id) {
		try {
			socialNetworkPostRepository.deleteById(id);
			return "Student with id " + id + " deleted successfully !";
		} catch (Exception e) {
			log.error("Error -> ", e);
			return null;
		}
	}
	
	public List<SocialNetworkPost> findByAuthor(String author) {
		try {
			return socialNetworkPostRepository.findByAuthor(author);
		} catch (Exception e) {
			log.error("Error -> ", e);
			return Collections.emptyList();
		}
	}
}
