package ChatBot.View;

import javax.swing.JFrame;

import ChatBot.Controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotController baseController;
	private ChatBotPanel basePanel;
	
	public ChatBotFrame(ChatBotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatBotPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}

	
}
