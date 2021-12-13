package course.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import course.api.model.Course;
import course.api.service.CourseService;

@RequestMapping("api/v1/topics")
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value ="/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable Integer topicId){
		return courseService.getAllCoursesByTopicId(topicId);
	}
	
	@GetMapping(value ="/allcourses")
	public List<Course> getAllCoursesPresent(){
		return courseService.getAllCoursesPresent();
	}
    
	@GetMapping(value ="/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable Integer courseId){
		return courseService.getCourseById(courseId);
	}
	
	@PostMapping(value ="/{topicId}/courses")
	public void addCourse(@PathVariable Integer topicId,@RequestBody Course course) {
		courseService.addCourse(topicId,course);
	}
	
	@PutMapping(value = "/{id}/courses")
	public Course updateCourse(@PathVariable Integer id, @RequestBody Course course) {
		return courseService.updateCourse(id, course);
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public void deleteCourseById(@PathVariable Integer id){
		 courseService.deleteCourseById(id);
	}
}
