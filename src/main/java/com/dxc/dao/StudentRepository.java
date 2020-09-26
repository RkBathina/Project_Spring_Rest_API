package com.dxc.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dxc.beans.Student1;

public interface StudentRepository extends CrudRepository<Student1, Integer> {

}
