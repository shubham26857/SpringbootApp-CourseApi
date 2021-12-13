package course.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import course.api.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findByTopicId(Integer topicId);

}
