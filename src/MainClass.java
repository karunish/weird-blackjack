import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainClass
{
    // DO NOT CHANGE THIS ARRAYLIST!
    public static ArrayList<CardSuperItem> drawDeck;
    // DO NOT CHANGE THIS ARRAYLIST!
    
    // YOU NEED TO ADD A NEW ARRAYLIST HERE TO REPRESENT THE CARDS IN A PLAYER'S HAND (see name from coursework)
    public static ArrayList<CardSuperItem> playerHand = new ArrayList<>();
    public static Random random = new Random();

    public static void main(String[] args) 
    {
    	/**
		 * STEP 0: The code below WILL NOT COMPILE. Fix it, so you have the correct local variables. For later tasks you might need to add
		 * 	       variables here too. See coursework spec.
		 */

        Scanner input = new Scanner(System.in);
        int currentHandTotal = 0;
        boolean kingEffect = false; 
        CardSuperItem drawnCard;
        
        drawDeck = new ArrayList<>();
        
        System.out.println("Welcome to Weird Blackjack! Your aim is to draw as many cards as you can, without going over a value of 21!");
        System.out.println("Select which you want to play with:\n1. Number Cards Only\n2. Include Face Cards");
        String choice = input.nextLine();
        
        /**
		 * STEP 1: You should create your deck of cards for the game here, based upon the player's response above.
		 *         To do this, you should call a version of createDeckOfCards() you have completed or created depending on mode chosen.
		 */

        while (true)
        {
            if (choice.equals("1")) 
            {
                System.out.println("\nNumber Cards Only mode selected.\n");
                createDeckOfCards();
                break;
            }
            if (choice.equals("2")) 
            {
                System.out.println("Include Face Cards mode selected.");
                while (true)
                {
                    System.out.println("Enter the number of suits to include (1-4):");
                    int numberOfSuits = input.nextInt();
                    input.nextLine();
                    if (numberOfSuits >= 1 && numberOfSuits <= 4) 
                    {
                        createDeckOfCards(numberOfSuits);
                        break;
                    } 
                    else 
                    {
                        System.out.println("Invalid number of suits. Please enter a value between 1 and 4.");
                    }
                }
                break;
            }
            else 
            {
                System.out.println("Invalid Option Selected, please try again.");
                choice = input.nextLine();
            }   
        }
        
        /**
		 * STEP 2: You should now draw a card for the player, apply its effects (if any) and put it in their hand. Remember to check if they've gone bust!
		 * 	       HINT: cards should be removed from drawDeck when drawn, so you cannot draw the same card twice, and
		 * 		         then put in another ArrayList to track the cards the player has drawn.
		 */

        
        mainLoop:
        while (true)
        {
            if (drawDeck.isEmpty()) {
                System.out.println("The deck is empty. Game over.");
                break;
            }
            drawnCard = drawDeck.remove(random.nextInt(drawDeck.size()));
            playerHand.add(drawnCard);

            int effect = drawnCard.applyCardEffect();
            switch (effect) 
            {
                case -99:
                    currentHandTotal /= 2; // Jack effect
                    System.out.println("Jack effect! Current hand is halved");
                    break;
                case -98:
                    currentHandTotal *= 2; // Queen effect
                    System.out.println("Queen effect! Current hand is doubled");
                    break;
                case -97:
                    kingEffect = true; // King effect (set flag)
                    System.out.println("King effect! The next card is doubled if it is a number card ");
                    break;
                default:
                    if (kingEffect) 
                    {
                        effect *= 2;
                        kingEffect = false; 
                    }
                    currentHandTotal += effect;
                    break;
            }
            System.out.println(drawnCard.getCardArt());
            if (drawnCard.getSuit() != null) {
                System.out.println("Drew " + getArticle(drawnCard.getCardName()) + " " + drawnCard.getCardName() + " of " + drawnCard.getSuit() + ", Current hand total: " + currentHandTotal);
            } else {
                System.out.println("Drew " + getArticle(drawnCard.getCardName()) + " " + drawnCard.getCardName() + ", Current hand total: " + currentHandTotal);
            }
            
            /**
    		 * STEP 3: Finally you should tell the players how they've done. Remember there are three possible outcomes:
    		 *         * They got Blackjack (exactly 21)
    		 *         * They went bust (over 21)
    		 *         * They decided to stop drawing cards!
    		 */

            if (currentHandTotal > 21) 
            { 
                System.out.println("Bust! You went over 21."); 
                break; 
            } 
            else if (currentHandTotal == 21) 
            { 
                System.out.println("Blackjack! You got exactly 21, well done!"); 
                break;
            }
            System.out.println("Do you want to draw another card? (Y/N)"); 
            String drawChoice = input.nextLine();
            
            while (true) 
            {
                if (drawChoice.equalsIgnoreCase("N")) 
                { 
                    System.out.println("Alright, ending round...");
                    break mainLoop;
                }
                else if (drawChoice.equalsIgnoreCase("Y"))
                {
                    System.out.println("\nOkay, drawing a new card:\n");
                    break;
                }
                else
                {
                    System.out.println("Invalid response, please enter a valid response (Y/N)");
                    drawChoice = input.nextLine();
                }
            }
        }
        System.out.println();
        
        System.out.println("Final hand total: " + currentHandTotal); 
        System.out.println("Cards in your hand:");
        
        for (CardSuperItem card : playerHand) 
        {
            card.printCardDetails();
        }
        input.close();
    }
    
    private static void createDeckOfCards()
    
    	//This should fill the drawDeck variable with the expected number of card objects. for Difficulty #1.
	
  		//This initial version should just create the correct number of NumberCards, with the expected values of 1 to 6, as in the coursework specification
  		
  		//Hint: When adding a new NumberCard to the drawDeck ArrayList, make sure you call the correct Constructor as explained in the teaching materials!
  		//      You should use the the two arrays from the CardDetails class to determine the values and related card names. 
  		

    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 1; j <= 6; j++) 
            {
                String cardName = CardsDetails.cardsNames[j - 1];
                NumberCard card = new NumberCard(j, cardName);
                drawDeck.add(card);
            }
        }
    }
    
    private static void createDeckOfCards(int numberOfSuits) 
    
    //For Difficulty #2 you should create a new method here which overloads createDeckOfCards(). This method will create SuitedCards,
  	//instead of NumberCards. There are more details in the coursework specification about how to do this.
  	//MAKE SURE YOU DIFFICULTY #1 IS FULLY WORKING BEFORE ATTEMPTING THIS!

    {
        String[] suits = CardsDetails.suitNames;
        int[] values = {1, 2, 3, 7, 8, 9, 11, 12, 13};

        for (int i = 0; i < numberOfSuits && i < suits.length; i++) 
        {
            for (int value : values) 
            {
                String cardName = CardsDetails.cardsNames[value - 1];
                SuitedCard card = new SuitedCard(value, cardName, suits[i]);
                drawDeck.add(card);
            }
        }
    }

    /**
     * Method to determine if the article for a card name should be 'a' or 'an'.
     * It checks if the first letter of the card name is a vowel (A, E, I, O, U).
     */
    
    private static String getArticle(String cardName)
    {
        return ("AEIOU".indexOf(cardName.charAt(0)) >= 0) ? "an" : "a";
    }
}
