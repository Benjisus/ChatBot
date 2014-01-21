package ChatBot.View;

import javax.swing.JOptionPane;
import ChatBot.Model.ChatBotModel;
public class ChatBotView
{
	private ChatBotModel myChatBot;
	/**
	 * Creating of myChatBot.
	 */
	
	public ChatBotView()
	{
		myChatBot = new ChatBotModel();
	}

		public void showApp()
		/**
		 * The starter of the conversation. Asking if they would like to talk.
		 */
		{
			String answer = "keep going";
			
			while(answer ==null || !answer.equals("no") )
			{
				answer = JOptionPane.showInputDialog("Do you want to talk?");
				useInput(answer);
				JOptionPane.showMessageDialog(null, myChatBot.getRandomTopic());
				
				myChatBot.Conversation();
			}
			
		}
		
		public String getInput()
		/**
		 * If the person replies "yes" then it will jump down here with the following reply.
		 */
		{
			String input;
			
			input = JOptionPane.showInputDialog("What would you like to talk about?");
			
			return input;
			
		}
		
		private void useInput(String currentInput)
		/**
		 * This string is going to check for certain words or phrases that the user may type in.
		 */
		{
			JOptionPane.showMessageDialog(null, "Seriously?");
			if (myChatBot.memeChecker(currentInput))
			{
				JOptionPane.showMessageDialog(null, "you like memes huh?");
			}
			if (myChatBot.musicChecker(currentInput))
			{
				JOptionPane.showMessageDialog(null, "Oh so you like music?");
			}
		}
		
		
}
