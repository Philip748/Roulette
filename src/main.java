import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int i = 0;
        int wins = 0;
        int losses = 0;
        int profit = 0;
        double winRatio = 0;
        int startingBet = 1;
        int amountOfBets = 1000000;
        int betLimit = 1000;
        int[] tracker;
        tracker = new int[amountOfBets];

        while (i < amountOfBets){
            int bet = selectBetSize1(startingBet, profit);
            if (bet > betLimit){
                bet = betLimit;
            }
            profit -= bet;
            int winnings = run(bet);
            if (winnings == 0){
                losses += 1;
            }
            else{
                wins += 1;
            }
            profit += winnings;
            tracker[i] = profit;
            i++;
        }
        winRatio = wins/(double)amountOfBets;
        System.out.println("profit:" + profit + "   wins:" + wins + "   losses:" + losses + "   win ratio:" + winRatio);
    }


    public static int run(int bet){
        Random rand = new Random();
        if (rand.nextInt(100)<49){
            return bet*2;
        }
        else{
            return 0;
        }
    }


    public static int selectBetSizeControl(int startingBet){
        return startingBet;
    }


    public static int selectBetSize1(int startingBet, int profit){
        if (profit < 0){
            return profit * (-1);
        }
        else{
            return startingBet;
        }
    }
}

