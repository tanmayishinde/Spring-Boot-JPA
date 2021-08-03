package com.root.springdemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.springdemo.dao.CourseDao;
import com.root.springdemo.entities.Course;



@Service
public class CourseServiceImpl implements CourseService
{

	//	private List<Course> list;
	
	//For JPA
	@Autowired
	private CourseDao courseDao;
	
	 public CourseServiceImpl() 
	 {
		 
		 
//		 
//		 list = new ArrayList<>();
//		 list.add(new Course(145, 	"Java Core Course", "this course contains basics of java"));
//		 list.add(new Course(4343, 	"Spring Boot Course", "Creating rest API using Spring Boot"));

		 
		 
	}
	 
	 @Override
	public List<Course> getCourses() 
	{		
		//return list;
		
		/*
		 * For JPA fillAll()-Picks List of Courses form db makes its object and
		 *  give it to us
		 */		
		 return courseDao.findAll();
	}
	
	@Override
	public  Course  getCourseById(long courseId)
	{
//		Course c = null;
//		for (Course 	i:list) 
//		{
//			if (i.getId() == courseId) 
//			{
//				c=i;
//				break;
//			}
//		}
//		return c;
		
		//For JPA 
		return courseDao.getById(courseId); 
		
	}


	@Override
	public Course addCourse(Course course) {
		
		
	//	list.add(course);
	//	return course;
		
		//For JPA 
		courseDao.save(course);
		return course;
		
	}


	/* Both the below methods perform they same job but are implemented in different way.
	 * @Override public void updateCourse(Course course, long courseId) {
	 * 
	 * for (int i=0;i<list.size();i++) { Course c = list.get(i); if (c.getId() ==
	 * courseId) { list.set(i, course); return; } }
	 * 
	 * }
	 */
	 //OR
	@Override
	public Course updateCourse(Course course)
	{
//		list.forEach(e ->{
//			if(e.getId() == course.getId())
//			{
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		
		
		/*
		 * For JPA here update will check if course is there and 
		 * add else if course not
		 * there add new course and save it
		 */
		courseDao.save(course);
		return course;
		
		
		
	}


	@Override
	public void deleteCourseById(long courseId) {
//		for (int i=0;i<list.size();i++) 
//		{
//			Course c = list.get(i);
//			if (c.getId() == courseId) 
//			{
//				 list.remove(i);
//				return;
//			}
//		}
		
		
		/*
		 * For JPA here we first get that entity and then 
		 * we pass that entity to delete
		 */
		Course entity = courseDao.getById(courseId);
		courseDao.delete(entity);
		
	}


	
}
