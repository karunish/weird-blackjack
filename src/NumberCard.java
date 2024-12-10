public class NumberCard extends CardSuperItem

	//This class needs to be completed for the first part of the coursework (Difficulty #1: Number Cards Only)
	//Remember, this needs to be a subclass of the abstract CardSuperItem class!
	//YOU SHOULD NOT ADD ANY ADDITIONAL DATA FIELDS IN EITHER SUBCLASS!
	
	//To complete this class and complete Difficulty #1 you will have to:
	//1. Create the correct constructor so the class can be instantiated
	//2. Override both methods in the superclass with the behaviours expected in the courseworks specification
	
	//Hint: For each of the overriden methods in point 2 you will need to use getter methods you create in the superclass
	//      in order to get access to the data fields. You can use this to both print messages, and solve the "Extra
	//		Complexity" tasks.
		
	//Examples of expected behaviour including this class can be found in Appendix A, B, and C, in the coursework specification

{
    public NumberCard(int value, String cardName) 
    {
        super(value, cardName);
    }

    public int applyCardEffect() 
    {
        return getValue();
    }

    public void printCardDetails() 
    {
        String article = ("AEIOU".indexOf(getCardName().charAt(0)) >= 0) ? "An" : "A";
        System.out.println(article + " " + getCardName());
    }
    

}
