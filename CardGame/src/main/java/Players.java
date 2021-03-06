public class Players {
   public int numberOfPlayer;

   /**
    * Method to set number of Player.
    */
   public void setNumberOfPlayer(int numberOfPlayer){
      if (numberOfPlayer <= 1){
         throw new RuntimeException("number of Player should be greater than or equal to two1");
      }
      this.numberOfPlayer = numberOfPlayer;
   }

   /**
    * returns Number of Player.
    */
   public int getNumberOfPlayer(){
      return this.numberOfPlayer;
   }

   /**
    * Add number of player to current players..
    */
   public void addPlayer(int numberOfPlayer){
      this.numberOfPlayer += numberOfPlayer;
      if (this.numberOfPlayer > 52){
         this.numberOfPlayer -= numberOfPlayer;
         throw new RuntimeException("number of players cannot be more than 52");
      }
   }

   /**
    * remove the player.
    */
   public  void removePlayer(int numberOfPlayer){
      this.numberOfPlayer -= numberOfPlayer;
      if (this.numberOfPlayer < 2){
         this.numberOfPlayer += numberOfPlayer;
         throw new RuntimeException("number of players cannot be less than 2");
      }
   }
}
