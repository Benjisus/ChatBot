package ChatBot.Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * ChatBot in which you talk back and forth, it will check for memes, and things about snowboarding.
 * @author Ben Hammond
 *@version 1.4 10/15/13
 */

/**
 * One to Two sentence explanation of the method. Full sentences with punctuation. 
 * @param currentInput Explanation of the variable
 * @return
 */
public class ChatBotModel
{
	
	public ArrayList<String> getMyMusic()
	{
		return myMusic;
	}
	public ArrayList<String> getMyResort()
	{
		return myResort;
	}
	public ArrayList<String> getOtherResorts()
	{
		return otherResorts;
	}
	public ArrayList<String> getRandomList()
	{
		return randomList;
	}

	public ArrayList<String> getMyMemes()
	{
		return myMemes;
	}
	

	

	private ArrayList<String> myMemes;
	private ArrayList<String> myMusic;
	private ArrayList<String> myResort;
	private ArrayList<String> otherResorts;
	private ArrayList<String> randomList;
	private ArrayList<String> Conversation;
	public ChatBotModel()
	
	{
		/**
		 * An Arraylist of Strings that hold the things for the program.
		 */
		myMemes = new ArrayList<String>();
		myMusic = new ArrayList<String>();
	    myResort = new ArrayList<String>();
	    otherResorts = new ArrayList<String>();
	    randomList = new ArrayList<String>();
		fillTheList();
		musicList();
		resortList();
		otherResortsList();
		fillTheRandomList();
	}
	/**
	 * Fills the randomlist with various Strings for the chatbot.
	 */
	private void fillTheRandomList()
	{
		randomList.add("I like cheese");
		randomList.add("I hate essays");
		randomList.add("I like cereal");
		randomList.add("This is random");
		randomList.add("I like typing");
		
	}
	/**
	 * This method chooses a random item from the randomList.
	 * @return A random element from the randomList.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandom = Math.random();
		int myRandomListPosition = (int) (myRandom * randomList.size());
		randomTopic = randomList.get(myRandomListPosition);
		
		return randomTopic;
		
	}
	
	private void resortList()
	/**
	 * This list checks for the word Brighton when asked what ski resort they go to.
	 */
	{
		myResort.add("Brighton");
	}
	
	private void otherResortsList()
	/**
	 * This will check for any of the following resorts for a second answer.
	 */
	{
		otherResorts.add("Park City");
		otherResorts.add("Canyons");
		otherResorts.add("Snow Bird");
		otherResorts.add("Alta");
		otherResorts.add("Deer Valley");
		otherResorts.add("Solitude");
		otherResorts.add("SnowBasin");
		otherResorts.add("Powder Mountain");
		otherResorts.add("Wolf Mountain");
		otherResorts.add("Beaver Mountain");
		
	}
	
	public ArrayList<String> Conversation()
	
		
	
	/**
	 * This is the conversation about snowboarding. Where we use the resort lists.
	 */
	{
		String startConversation;
		String skiResorts;
		
		startConversation = JOptionPane.showInputDialog("Do you snowboard?");
		if(startConversation.equalsIgnoreCase("yes"))
		{
			skiResorts = JOptionPane.showInputDialog("Awesome! Where do you snowboard?");
			if(myResortChecker(skiResorts))
			{
				JOptionPane.showMessageDialog(null,  "No way! Thats where I go!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "I have only been there a few times! But I do like that resort!");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Oh well thats a bummer...");
		}
		ArrayList<String> conversation = new ArrayList<String>();
		
		
		return conversation;
			
	
	}
	
	boolean myResortChecker(String currentInput) 
	/**
	 * This is checking if the word Brighton is used for a resort.
	 */
	{
		boolean hasResort = false;
		
		
		for(String currentPhrase : myResort)
		{
			if(currentPhrase.equalsIgnoreCase(currentInput))
			{
				hasResort = true;
			}
		}
		
		return hasResort;
	}
	
	boolean otherResortChecker(String currentInput) 
	/**
	 * This is checking for any of the other resort names being used.
	 */
	{
		boolean hasResort = false;
		
		
		for(String currentPhrase : otherResorts)
		{
			if(currentPhrase.equalsIgnoreCase(currentInput))
			{
				hasResort = true;
			}
		}
		
		return hasResort;
	}
	
	
	
	private void fillTheList()
	/**
	 * This is a list of memes for the ChatBot to look for.
	 */
	{
		myMemes.add("nicolas cage");
		myMemes.add("Arrow to the knee");
		myMemes.add("one does no simply");
		myMemes.add("y u no");
	}

	
	public boolean memeChecker(String currentInput) 
	/**
	 * This is the checker to see if any of the words in the meme list are being used.
	 */
	{
		boolean hasMeme = false;
		//loop over all the items in the list, if the input matches a meme, change hasMeme to true.
		
		for(String currentPhrase : myMemes)
		{
			if(currentPhrase.equalsIgnoreCase(currentInput))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	private void musicList() //The list to check for music.
	/**
	 * This list is of all the music that we will be looking for used in ChatBot.
	 */
	{
		myMusic.add("rock");
		myMusic.add("rap");
		myMusic.add("dubstep");
		myMusic.add("raggae");
		myMusic.add("polka");
		myMusic.add("classical");
		myMusic.add("jazz");
		myMusic.add("music");
		myMusic.add("song");
		myMusic.add("pop");
		myMusic.add("country");
		
	}

	public boolean musicChecker(String currentInput)
	/**
	 * Checks to see if any of the music list words are being used in ChatBot.
	 */
	{
		boolean hasMusic = false;
		
		for(String currentPhrase : myMusic)
		{
			if(currentPhrase.equalsIgnoreCase(currentInput))
			{
				hasMusic = true;
			}
			
		}
			return hasMusic;	
	}

	public String alphabetizeYourName(String first, String middle, String last)
	/**
	 * This String will be checking a person first, middle, and last name, and then alphabetizing them.
	 */
	{
		String nameInOrder = "";
		/**
		 * Comparing the first name to middle and last.
		 */
		if(first.compareTo(middle)<0)
		{
			if(first.compareTo(last)<0)
				/**
				 * If the previous if's are true, then it goes and compares the middle name to last.
				 */
			{
				if(middle.compareTo(last)<0)
				{
					nameInOrder = first + ", " + last + ", " + last;	
				}
				else
				{
					nameInOrder = first + ", " + last + "; " + middle;
				}
			}
			else 
			{
				nameInOrder = last + ", " + first + ", " + middle;
			}
		}
		/**
		 * If the first if fails (first compare to middle) then it jumps down here, and checks the middle name.
		 */
		else
		{
			if(middle.compareTo(last)< 0)
			{
				if(first.compareTo(last) < 0)
				{
					nameInOrder = middle + ", " + first + ", " + last;
				}
				else
				{
					nameInOrder = middle + ", " + last  + ", " + first;
				}
			}
			else
			{
				nameInOrder = last + ", " + middle + ", " + first;
			}
		}
		return nameInOrder;
	}
	
	
	public ArrayList<String> getConversation()
	{
		return Conversation;
	}
	public void setConversation(ArrayList<String> conversation)
	{
		Conversation = conversation;
	}
		
	

}
