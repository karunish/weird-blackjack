public class SuitedCard extends CardSuperItem

	//This class needs to be completed for the second part of the coursework (Difficulty #2: Include Face Cards)

	//This second difficulty is designed to be a more difficult task for students to show their understanding.
	//As such, you are expected to solve this problem using the knowledge you have learnt from the teaching materials
	//and completing Difficulty #1. Do not attempt to solve this until you have the rest working!
	
	//Examples of expected behaviour including this class can be found in Appendix D and E in the coursework specification

{
    public SuitedCard(int value, String cardName, String suit) 
    {
        super(value, cardName, suit);
    }

    public int applyCardEffect() 
    {
        if (getCardName().equals("Jack"))
        {
            return -99; // Halve the total
        }
        else if (getCardName().equals("Queen"))
        {
            return -98; // Double the total
        }
        else if (getCardName().equals("King"))
        {
            return -97; // King effect (double next card)
        }
        else 
        {
            if (getSuit().equals("Spades") || getSuit().equals("Clubs")) 
            {
                return getValue(); // Black suits, add value
            }
            else 
            {
                return -(getValue() / 2); // Red suits, halve and subtract value
            }
        }
    }

    public void printCardDetails() 
    {
        String article = ("AEIOU".indexOf(getCardName().charAt(0)) >= 0) ? "An" : "A";
        System.out.println(article + " " + getCardName() + " of " + getSuit());
    }
}
