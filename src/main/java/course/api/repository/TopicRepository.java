package course.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import course.api.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{
	
	public List<Topic> findByDescriptionContaining(String value);

}
