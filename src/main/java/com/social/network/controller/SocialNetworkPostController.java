package com.social.network.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.entity.SocialNetworkPost;
import com.social.network.service.SocialNetworkPostService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins="*")  
public class SocialNetworkPostController {
	@Autowired
	SocialNetworkPostService socialNetworkPostService;

	@PostMapping("/social-media-network")
	@Operation(summary = "save-update social media network post.", description = "")
	public ResponseEntity<Object> saveUpdateSocialNetworkPost(@RequestBody SocialNetworkPost socialNetworkPost) {
		try {
			Set<SocialNetworkPost> snp = socialNetworkPostService.saveUpdateSocialNetworkPost(socialNetworkPost);
			if (snp != null) {
				return new ResponseEntity<>(snp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(snp, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error !", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/social-media-network")
	@Operation(summary = "find all social media network post details.", description = "")
	public ResponseEntity<Object> findAllSocialNetworkPost() {
		try {
			List<SocialNetworkPost> snp = socialNetworkPostService.findAllSocialNetworkPost();
			if (snp != null) {
				return new ResponseEntity<>(snp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(snp, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error !", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/social-media-network/{author}")
	@Operation(summary = "find social media network post details by author.", description = "")
	public ResponseEntity<Object> findByAuthor(@PathVariable("author") String author) {
		try {
			List<SocialNetworkPost> snp = socialNetworkPostService.findByAuthor(author);
			if (snp != null) {
				return new ResponseEntity<>(snp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(snp, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error !", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/social-media-network/{id}")
	@Operation(summary = "delete social media network post details by id.", description = "")
	public ResponseEntity<Object> deleteById(@PathVariable("id") int id) {
		try {
			String delbyid = socialNetworkPostService.deleteById(id);
			if (delbyid != null) {
				return new ResponseEntity<>(delbyid, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(delbyid, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error !", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
