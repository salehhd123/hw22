package com.example.demo.Repository;

import com.example.demo.Model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info,Integer> {

Info findInfoById(Integer id);
}
