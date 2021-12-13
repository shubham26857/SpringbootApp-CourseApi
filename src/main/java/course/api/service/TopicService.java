package course.api.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import course.api.model.Topic;
import course.api.repository.TopicRepository;

@Service
public class TopicService {
    
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic(1, "First island", "A first island basically"),
//			new Topic(2, "Second island", "A second island basically"),
//			new Topic(3, "Third island", "A Third island basically"),
//			new Topic(4, "Fourth island", "A Fourth island basically")));

	public List<Topic> getalltopics(){
		return topicRepository.findAll();
	}          

	public Topic getTopicById(Integer id) {
//		for(Topic topic: topics) {
//			if(topic.getId() == id) {
//				return topic;
//			}
//		}
//		return null;
		Optional<Topic> topic = topicRepository.findById(id);
		if(topic.isPresent()){
			return topic.get();
		}
		return null;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public Topic updateTopic(Integer id, Topic topic) {
		Optional<Topic> ctopic = topicRepository.findById(id);
		if(ctopic.isPresent()){
			ctopic.get().setName(topic.getName());
			ctopic.get().setDescription(topic.getDescription());
			topicRepository.save(ctopic.get());
			return ctopic.get();
		}
		return null;
	}
		
//		for(Topic ctopic: topics) {
//			if(ctopic.getId() == id) {
//				ctopic.setName(topic.getName());
//				ctopic.setDescription(topic.getDescription());
//				return ctopic;
//			}
//		}
//		return null;
//	}

	public void deleteTopicById(Integer id) {
		topicRepository.deleteById(id);
}
	
	public List<String> getAllMatchingDescriptions(String value){
		List<Topic> topics = topicRepository.findByDescriptionContaining(value);
		System.out.println(topics.size());
		List<String> DescString = new ArrayList<>();
		for(Topic topic : topics) {
			DescString.add(topic.getDescription());
		}
		return DescString;
		
	}

}