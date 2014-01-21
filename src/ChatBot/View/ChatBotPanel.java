package ChatBot.View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ChatBot.Controller.ChatBotController;
import ChatBot.Model.ChatBotModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBotPanel extends JPanel
{
	//TOUCH THE SCROLL BAR... No Really Don't
	private ChatBotController baseController;
	private JButton submitButton;
	private JTextField userInputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private ChatBotModel appBot;
	private JScrollPane textPane;
	private int clickCount;
	
	public ChatBotPanel(ChatBotController baseController)
	{
	    //DONT TOUCH SCROLL BAR!!!!!
		this.baseController = baseController;
		this.appBot = baseController.getMyChatBot();
		
		chatArea = new JTextArea(10,38);
		submitButton = new JButton("Submit this to the ChatBot!");
		userInputField = new JTextField(30);
		textPane = new JScrollPane(chatArea);
		baseLayout = new SpringLayout();
		clickCount = 0;		
		setupPanel();
		setupLayout();
		setupListeners();
		
		startChat();
		
	}
	private void startChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
				
					
				chatArea.setLineWrap(true);
				chatArea.setWrapStyleWord(true);
	}
	
	private void setupLayout()
	{
		//TOUCH THIS AND I KIILLL YOU
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, userInputField);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 18, SpringLayout.SOUTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, userInputField, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 18, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 114, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 18, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 30, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -30, SpringLayout.EAST, this);
		
		setBackground(Color.GREEN);
		setForeground(Color.DARK_GRAY);
		submitButton.setBackground(Color.GRAY);
		chatArea.setForeground(Color.GRAY);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			/**
			 * This is what happens when I click the button.
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String currentInput = userInputField.getText();
				
				if(clickCount % 7 ==0)
				{
					String currentConversation = baseController.processConversation();
					if(currentConversation.length() != 0)
					{
						chatArea.append(currentConversation);
						clickCount--;
					}
					
				}
				else if(clickCount % 11 == 0)
				{
					chatArea.append(baseController.processMeme(currentInput));
				}
				else if(clickCount % 14 == 0)
				{
					chatArea.append(baseController.processMusic(currentInput));
				}
				else
				{
					chatArea.append("\n" + currentInput);
					chatArea.append("\n" + appBot.getRandomTopic());
				}
				
			}
		
		});

			
	}
}
