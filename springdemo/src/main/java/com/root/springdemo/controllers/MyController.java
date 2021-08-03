package com.root.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.springdemo.entities.Course;
import com.root.springdemo.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Courses Application";
	}
	
	//Get the List of Course 
	@GetMapping("/courses")
	public List<Course> getCourses() 
	{
		return this.courseService.getCourses();
	}
	
	//Get the Course by Id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable  String courseId) 
	{
		return this.courseService.getCourseById(Long.parseLong(courseId));
	}
	
	//Add new Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody  Course course) 
	{
		return this.courseService.addCourse(course);
	}
	
	//Update the Course
//		@PutMapping("/courses/{courseId}")
//		public void updateCourse(@RequestBody  Course course,@PathVariable  String courseId) 
//		{
//			this.courseService.updateCourse(course,Long.parseLong(courseId));
//		}
	//OR
	
	
	   @PutMapping("/courses/{courseId}")
		public Course updateCourse(@RequestBody  Course course) 
		{
			return this.courseService.updateCourse(course);
		}
		
		

		//Delete  the Course by Id
	   
		/*
		 * @DeleteMapping("/courses/{courseId}") public void
		 * deleteCourseById(@PathVariable String courseId) {
		 * this.courseService.deleteCourseById(Long.parseLong(courseId)); }
		 */
	   
	   
		//OR
		//For sending HTTP status 
		//For eg if we send any req 404 not found
		//or server error shows INTERNAL Server error
	   //Note: this only shows excepts when we pass characters as they are not acceptable
	
	   @DeleteMapping("/courses/{courseId}") 
	   public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable String courseId) 
	   {
		   try 
		   { 
			   this.courseService.deleteCourseById(Long.parseLong(courseId));
			   return new ResponseEntity<>(HttpStatus.OK);
		   }
		   catch(Exception e)
		   {
			   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		
		 }
	
	
	
	
	
}
