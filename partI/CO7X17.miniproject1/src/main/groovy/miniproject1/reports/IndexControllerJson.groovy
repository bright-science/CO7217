package miniproject1.reports;

import java.util.List
import miniproject1.mongoDb.MongoDB
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/json")
public class IndexControllerJson {

	@RequestMapping
	public String index(Model model) {
		MongoDB mongo = new MongoDB()
		
		def connectionStatus = 'PENDING'
		if (mongo.connectionOk()) {
			connectionStatus = 'CONNECTED'
		}
		
		model.addAttribute('connectionStatus', connectionStatus)
		return "main"
		
	}
	
	@RequestMapping(value="friends",method=RequestMethod.GET)
    public String helloTwitter(Model model) {
		List<FriendDto> friends = new ArrayList<FriendDto>()
        
		def slurper = new groovy.json.JsonSlurper()
		def allFriends = slurper.parseText(new File("./friends.json").text)
		
		allFriends.users.each{ friend ->
			FriendDto dto = new FriendDto()
			dto.name=friend.name
			dto.description=friend.description
			
			def tweets = slurper.parseText(new File("./tweets.json").text)
			def userTweets = tweets.findAll({ tweet ->
				(tweet.user != null) && (tweet.user.id == friend.id)
			})
			dto.noFavoriteTweets = 0
			for (t in userTweets) {
				if (!(t.retweeted)) {
					dto.noFavoriteTweets += t.favorite_count
					if (t.favorite_count >= 5) 
						println 'favorite tweet: ' + t.text
				}
			}
			
			dto.noTweets = userTweets.size()
			
			friends.add(dto)
		}
		
        model.addAttribute("friends", friends);
        return "friends";
    }

	@RequestMapping(value="followers", method=RequestMethod.GET)
    public String classifyFollowers(Model model) {
		
		def followedFollowers = []
		def slurper = new groovy.json.JsonSlurper()
		def friends = slurper.parseText(new File("./friends.json").text)
		def followers = slurper.parseText(new File("./followers.json").text)
		followers.users.forEach{ follower ->
			def friend = friends.users.find{ friend ->
				friend.id==follower.id
			}
			if (friend != null) {
				followedFollowers << follower
				println follower.description + ' - following: ' + follower.following + ' - friendsCount: ' + follower.friends_count
				
			}
		}
	    	
		model.addAttribute("followers", followedFollowers);
	    	return "followers";
    }

}
