package lab3.reports;

import com.mongodb.DBCollection

import java.util.List

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
public class IndexController {

	@RequestMapping
	public String index(Model model) {
		
		def connectionStatus = 'PENDING'
		model.addAttribute('connectionStatus', connectionStatus)
		return "main"
		
	}
	
	@RequestMapping(value="followers", method=RequestMethod.GET)
	public String followers(Model model) {
		def followedFollowers
		
		// tag::exercise[]
		
		// TODO Exercise 1
		
		//end::exercise[]
		
		model.addAttribute("followers", followedFollowers);
		return "followers";
	}

	@RequestMapping(value="friends",method=RequestMethod.GET)
    public String friends(Model model) {
		List<FriendDto> friends = new ArrayList<FriendDto>()
        
		// tag::exercise[]
		
		// TODO Exercise 2
		
		//end::exercise[]
		
        model.addAttribute("friends", friends);
        return "friends";
    }

	
}
