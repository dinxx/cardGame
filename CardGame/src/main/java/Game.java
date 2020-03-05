import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {


   /**
    * Method to deal card to player.
    * Return mapping of player number and card which player is holding.
    * */
   public Map<Card, Integer> dealCards(Players players, Deck deck){
      System.out.println("*****************Start Game******************");
      Map<Card, Integer> PlayerAndCardMapping = new HashMap<>();
      for (int i = 0;i < players.numberOfPlayer; i++){
         PlayerAndCardMapping.put(deck.takeCard(), i);
      }
      return PlayerAndCardMapping;
   }

   /**
    *  Method to show game result.
    *  Return which player has won the game.
    * */
   public int gameResult(Map<Card, Integer> playerCard){
      List<Card> cardList = new ArrayList<>();
      for (Map.Entry<Card, Integer> eachPlayerCard : playerCard.entrySet()){
         cardList.add(eachPlayerCard.getKey());
      }
      Collections.sort(cardList);
      return playerCard.get(cardList.get(0))+1;
   }

   /**
    * Method To show players Card on table.
    * */
   public void showPlayerCard(Map<Card, Integer> playerCard){
      for (Map.Entry<Card, Integer> eachPlayerCard : playerCard.entrySet()){
         System.out.println("Player"+ (eachPlayerCard.getValue()+1) +" has "+ eachPlayerCard.getKey());
      }
   }

   /**
    * Method to endGame
    * */
   public void endGame(Deck deck, Map<Card, Integer> playerCard){
      deck.refresh();
      playerCard.clear();
   }

   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      Players players = new Players();
      System.out.println("Enter any character to start game");
      scan.next();
      System.out.println("Enter Number of Player: ");
      int numberOfPlayers = scan.nextInt();
      players.setNumberOfPlayer(numberOfPlayers);
      Game game = new Game();
      Deck deck = new Deck();
      while (true){
         try {
            String option;
            System.out.println("Want to See cards in deck: y/n");
            option = scan.next();
            if ("y".equals(option)){
               deck.print();
            }else if(!"n".equals(option)){
               throw new RuntimeException("invalid input use only: y or n");
            }
            System.out.println("Want to Shuffle card: y/n");
            option = scan.next();
            if ("y".equals(option)){
               deck.shuffle();
            }else if(!"n".equals(option)){
               throw new RuntimeException("invalid input use only: y or n");
            }
            Map<Card, Integer> playerCard = game.dealCards(players, deck);
            game.showPlayerCard(playerCard);
            System.out.println("Player " + game.gameResult(playerCard) +" has won");
            game.endGame(deck, playerCard);
            System.out.println("*****************End Game******************");
            System.out.println("Want to Modify Player number: y/n");
            option = scan.next();
            if (option.equals("y")){
               System.out.println("Want To add or Remove: +/-");
               option = scan.next();
               if("+".equals(option)){
                  System.out.println("Please give number of Player you want to add:");
                  players.addPlayer(scan.nextInt());
               }else if("-".equals(option)){
                  System.out.println("Please give number of Player you want to remove:");
                  players.removePlayer(scan.nextInt());
               }else {
                  throw new RuntimeException("invalid input use only: add/remove");
               }
            }else if (!"n".equals(option)){
               throw new RuntimeException("invalid input use only: y or n");
            }
         } catch (Exception ex){
            System.out.println(ex);
         }
      }

   }
}
