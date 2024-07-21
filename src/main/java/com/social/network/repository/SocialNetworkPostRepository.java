package com.social.network.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.social.network.entity.SocialNetworkPost;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Integer> {

	@Query(value = "SELECT * FROM socialnetworkpost as s where s.author=:author", nativeQuery = true)
	public List<SocialNetworkPost> findByAuthor(String author);

	@Query(value = "SELECT * FROM socialnetworkpost order by viewcount limit 10 ", nativeQuery = true)
	public Set<SocialNetworkPost> getHighestVewCountPerPostCatg();
}
