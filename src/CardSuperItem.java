public abstract class CardSuperItem
{
	/**
	 * Each instantiated version of this class (or more accurately of its subclasses) represents a single card in the deck or player's hand.
	 */

    // DO NOT CHANGE THESE ROWS!
    private int value;
    private String cardName;
    private String suit;
    // DO NOT CHANGE THESE ROWS!
    
    public CardSuperItem(int value, String cardName)
    {
    	//Implement this constructor for Difficulty #1 by passing the constructor parameters to the relevant data fields!
    	//Ignore 'suit' for now.
        this.value = value;
        this.cardName = cardName;
    }
    
  //For Difficulty #2 you will have to overload the constructor above with a new one. 
  //This constructor will set all data fields, but you should not attempt this until you have completed Difficulty #1.
  	

    public CardSuperItem(int value, String cardName, String suit)
    {
        this.value = value;
        this.cardName = cardName;
        this.suit = suit;
    }
    
    public abstract int applyCardEffect();
    
    public abstract void printCardDetails();
    
	//You should write getters (but not setters) for the data fields here


    public int getValue() 
    {
        return value;
    }
    
    public String getCardName()
    {
        return cardName;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public abstract String getCardArt();

}
