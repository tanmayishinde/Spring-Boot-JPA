package com.root.springdemo.services;

import java.util.List;

import com.root.springdemo.entities.Course;

public interface CourseService {

	public  List<Course> getCourses();
	
	public  Course  getCourseById(long courseId);

	public Course addCourse(Course course);

//	public void updateCourse(Course course, long courseId);
	public Course updateCourse(Course course);

	public void deleteCourseById(long courseId);


	
}
