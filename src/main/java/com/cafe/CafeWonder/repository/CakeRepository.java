package com.cafe.CafeWonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.CafeWonder.entity.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Long>{

}
