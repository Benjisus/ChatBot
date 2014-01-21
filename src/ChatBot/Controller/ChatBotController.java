package ChatBot.Controller;

import java.util.ArrayList;

import ChatBot.Model.ChatBotModel;
import ChatBot.View.ChatBotFrame;
import ChatBot.View.ChatBotView;

/**
 * Controller Class For the ChatBot Project
 * @author Ben Hammond
 *@version 1.3 10/31/13 Removed old popup GUI, reference to ChatBot.
 */
public class ChatBotController
{
	
	// private ChatBotView myView;
	private ChatBotModel myChatBot;
	private ChatBotFrame appFrame;
	
	
	public ChatBotController()
	{
		// myView = new ChatBotView();
		myChatBot = new ChatBotModel();
		
	}
	
	public ChatBotModel getMyChatBot()
	{
		return myChatBot;
	}


	
	public void start()
	{
		// myView.showApp();
		appFrame = new ChatBotFrame(this);
	}
	
	private String conversationHelper(ArrayList<String> conversationList)
	{
		String currentConversationPiece = "";
		
		if(conversationList.size()>0)
		{
			currentConversationPiece = conversationList.remove(0);
		}
		
		return currentConversationPiece;
	}
	
	public String processConversation()
	{
		String currentConversation = "";
		
		currentConversation = conversationHelper(myChatBot.Conversation());
		
		return currentConversation;
	}
	
	public String processMeme(String currentInput)
	{
		String memeResponse = "You don't like memes?";
		
		if(myChatBot.memeChecker(currentInput))
		{
			memeResponse =currentInput + " is a meme cool";
		}
		return memeResponse;
	}
	
	public String processMusic(String currentInput)
	{
		String musicResponse = "You like music?";
		
		if(myChatBot.musicChecker(currentInput))
		{
			musicResponse = currentInput + " Music is a good thing";
			
		}
		return musicResponse;
	}
	
}
