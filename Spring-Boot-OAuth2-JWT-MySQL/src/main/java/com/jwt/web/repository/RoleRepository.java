package com.jwt.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.web.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT a FROM Role a WHERE a.code = :code")
	public Role findByCode(@Param("code") String code);

}
