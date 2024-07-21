package com.social.network.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "socialnetworkpost")
@Data
public class SocialNetworkPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	
	@Column(name = "postdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postDate;

	@Column(name = "postcategory")
	private String postCategory;

	@Column(name = "author")
	private String author;

	@Column(name = "content")
	private String content;

	@Column(name = "viewcount")
	private int viewCount;
}
