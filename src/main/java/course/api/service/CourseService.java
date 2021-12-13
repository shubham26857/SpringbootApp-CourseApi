package course.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.api.model.Course;
import course.api.model.Topic;
import course.api.repository.CourseRepository;
import course.api.repository.TopicRepository;

@Service
public class CourseService {
    
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Course> getAllCoursesByTopicId(Integer topicId){
		return courseRepository.findByTopicId(topicId);
	}          

	public Course getCourseById(Integer id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()){
			return course.get();
		}
		return null;
	}
	
	public void addCourse(Integer topicId, Course course) {
		Topic topic=  topicRepository.getById(topicId);
		course.setTopic(topic); 
		courseRepository.save(course);
	}

	public Course updateCourse(Integer courseId, Course course) {
		Optional<Course> ccourse = courseRepository.findById(courseId);
		if(ccourse.isPresent()){
			ccourse.get().setName(course.getName());
			ccourse.get().setDescription(course.getDescription());
			courseRepository.save(ccourse.get());
			return ccourse.get();
		}
		return null;
	}
		
	public void deleteCourseById(Integer id) {
		courseRepository.deleteById(id);
	}

	public List<Course> getAllCoursesPresent() {
		return courseRepository.findAll();
	}
}