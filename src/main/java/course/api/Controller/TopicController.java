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

import course.api.model.Topic;
import course.api.service.TopicService;

@RequestMapping("api/v1/topics")
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping
	public List<Topic> getAllTopics(){
		return topicService.getalltopics();
	}
    
	@GetMapping(value ="/{id}")
	public Topic getTopicById(@PathVariable Integer id){
		return topicService.getTopicById(id);
	}
	
	@PostMapping()
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping(value = "/{id}")
	public Topic updateTopic(@PathVariable Integer id, @RequestBody Topic topic) {
		return topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping(value ="/{id}")
	public void deleteTopicById(@PathVariable Integer id){
		 topicService.deleteTopicById(id);
	}
	
	@GetMapping(value ="/match/{match}")
	public List<String> getAllMatchingDescriptions(@PathVariable("match") String value){
		return topicService.getAllMatchingDescriptions(value);
	}
}
