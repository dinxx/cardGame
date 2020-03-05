/**
 * Class representing a playing card from a standard 52-card deck.
 */
public class Card implements Comparable<Card>{

   @Override
   public int compareTo(Card card) {
      if (this.getRank() > card.getRank()){
         return -1;
      }
      else if(this.getRank() == card.getRank()){
         return  this.getSuit().ordinal()- card.getSuit().ordinal();
      }
      else{
         return 1;
      }
   }

   /**
    * Enum representing playing card suits.
    */
   public enum Suit {
      SPADES, HEARTS, CLUBS, DIAMONDS;
   }

   // The min and max valid card ranks
   private static final int MIN_RANK = 1;
   private static final int MAX_RANK = 13;

   // This instance's rank and suit
   private int rank;
   private Suit suit;

   /**
    * Construct a Card with a given rank and suit.
    */
   public Card(int rank, Suit suit) {
      setRank(rank);
      setSuit(suit);
   }

   /**
    * Return the card's rank.
    */
   public int getRank() {
      return rank;
   }

   /**
    * Set the card's rank, with input validation.
    */
   public void setRank(int rank) {
      if (rank < MIN_RANK || rank > MAX_RANK) {
         throw new RuntimeException(
               String.format("Invalid rank: %d (must be between %d and %d inclusive)",
                     rank, MIN_RANK, MAX_RANK));
      }
      this.rank = rank;
   }

   /**
    * Return the card's suit.
    */
   public Suit getSuit() {
      return suit;
   }

   /**
    * Set the card's suit, with input validation.
    */
   public void setSuit(Suit suit) {
      if (suit == null) {
         throw new RuntimeException("Suit must be non-null");
      }
      this.suit = suit;
   }

   @Override
   public String toString() {
      return String.format("%s[rank=%d, suit=%s]",
            getClass().getSimpleName(),
            getRank(),
            getSuit().name());
   }

   /**
    * Return the minimum allowed rank.
    */
   public static int getMinRank() {
      return MIN_RANK;
   }

   /**
    * Return the maximum allowed rank.
    */
   public static int getMaxRank() {
      return MAX_RANK;
   }

   /**
    * Return an array of the available suits.
    */
   public static Suit[] getSuits() {
      return Suit.values();
   }

}
