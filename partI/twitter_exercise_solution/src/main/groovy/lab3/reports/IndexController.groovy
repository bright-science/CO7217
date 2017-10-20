package lab3.reports;

import com.mongodb.DBCollection
import java.util.List
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
		def followedFollowers = []
		
		// tag::exercise[]
		// TODO Exercise 1
		def slurper = new groovy.json.JsonSlurper()
		def friends = slurper.parseText(new File("./src/main/resources/twitter/friends.json").text)
		def followers = slurper.parseText(new File("./src/main/resources/twitter/followers.json").text)
		followers.users.forEach{ follower ->
			def friend = friends.users.find{ friend ->
				friend.id==follower.id
			}
			if (friend != null) {
				followedFollowers << follower
			}
		}
		//end::exercise[]
		
		model.addAttribute("followers", followedFollowers);
		return "followers";
	}

	@RequestMapping(value="friends",method=RequestMethod.GET)
    public String friends(Model model) {
		List<FriendDto> friends = new ArrayList<FriendDto>()
        
		// tag::exercise[]
		// TODO Exercise 2
		def slurper = new groovy.json.JsonSlurper()
		def allFriends = slurper.parseText(new File("./src/main/resources/twitter/friends.json").text)
		
		allFriends.users.each{ friend ->
			FriendDto dto = new FriendDto()
			dto.name=friend.name
			dto.description=friend.description
			
			def tweets = slurper.parseText(new File("./src/main/resources/twitter/tweets.json").text)
			def userTweets = tweets.findAll({ tweet ->
				(tweet.user != null) && (tweet.user.id == friend.id)
			})
			dto.noFavoriteTweets = 0
			for (t in userTweets) {
				dto.noFavoriteTweets += t.favorite_count
				if (t.favorite_count >= 5)
					dto.noPopularTweets++
			}
			
			dto.noTweets = userTweets.size()
			
			friends.add(dto)
		}
		//end::exercise[]
		
        model.addAttribute("friends", friends);
        return "friends";
    }

	
}
