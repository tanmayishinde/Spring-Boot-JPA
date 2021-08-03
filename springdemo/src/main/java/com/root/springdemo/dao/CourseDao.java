package com.root.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.springdemo.entities.Course;

public interface CourseDao extends JpaRepository<Course ,Long>
{

}
