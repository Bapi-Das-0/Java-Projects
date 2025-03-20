import java.util.Random;
import java.util.Scanner;

public class slotmachine {
    public slotmachine() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 100;
        System.out.println("******************************** ");
        System.out.println("      SLOT MACHINE GAME");
        System.out.println("Symbols: \ud83c\udf55 | \ud83c\udfb8 | \ud83d\udcb8 | \ud83c\udf6b | \ud83d\udece️");
        System.out.println("******************************** ");

        while(balance > 0) {
            System.out.println("current balance: $" + balance);
            System.out.print("Place your bet amount: $");
            int bet = sc.nextInt();
            if (bet > balance) {
                System.out.println("Insufficient Funds");
            } else if (bet <= 0) {
                System.out.println("Bet must be greater than 0");
            } else {
                balance -= bet;
            }

            System.out.println("Spinning...");
            String[] row = spinRow();
            printRow(row);
            getPayout(row, bet);
            int payout = getPayout(row, bet);
            if (payout > 0) {
                System.out.println("YOU WON $" + payout);
                balance += payout;
            } else {
                System.out.println("SORRY,you lost this round");
            }

            System.out.println("Do you want to play again? (Y/N)");
            sc.nextLine();
            String playAgain = sc.nextLine().toUpperCase();
            if (!playAgain.equals("Y")) {
                System.out.println("Thankyou for playing");
                break;
            }
        }

        System.out.println("Your Final balance is $" + balance);
        sc.close();
    }

    static String[] spinRow() {
        String[] symbols = new String[]{"\ud83c\udf55", "\ud83c\udfb8", "\ud83d\udcb8", "\ud83c\udf6b", "\ud83d\udece️"};
        String[] row = new String[3];
        Random random = new Random();

        for(int i = 0; i < 3; ++i) {
            row[i] = symbols[random.nextInt(0, 5)];
        }

        return row;
    }

    static void printRow(String[] row) {
        System.out.println(" " + String.join(" |", row));
    }

    static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            int var9;
            switch (row[1]) {
                case "\ud83c\udf55" -> var9 = bet * 3;
                case "\ud83c\udfb8" -> var9 = bet * 4;
                case "\ud83c\udf6b" -> var9 = bet * 5;
                case "\ud83d\udece️" -> var9 = bet * 10;
                case "\ud83d\udcb8" -> var9 = bet * 20;
                default -> var9 = 0;
            }

            return var9;
        } else if (row[0].equals(row[1])) {
            int var8;
            switch (row[0]) {
                case "\ud83c\udf55" -> var8 = bet * 2;
                case "\ud83c\udfb8" -> var8 = bet * 3;
                case "\ud83c\udf6b" -> var8 = bet * 4;
                case "\ud83d\udece️" -> var8 = bet * 5;
                case "\ud83d\udcb8" -> var8 = bet * 10;
                default -> var8 = 0;
            }

            return var8;
        } else if (row[1].equals(row[2])) {
            int var10000;
            switch (row[1]) {
                case "\ud83c\udf55" -> var10000 = bet * 2;
                case "\ud83c\udfb8" -> var10000 = bet * 3;
                case "\ud83c\udf6b" -> var10000 = bet * 4;
                case "\ud83d\udece️" -> var10000 = bet * 5;
                case "\ud83d\udcb8" -> var10000 = bet * 10;
                default -> var10000 = 0;
            }

            return var10000;
        }
        else if (row[0].equals(row[2])) {
            int var10000;
            switch (row[0]) {
                case "\ud83c\udf55" -> var10000 = bet * 2;
                case "\ud83c\udfb8" -> var10000 = bet * 3;
                case "\ud83c\udf6b" -> var10000 = bet * 4;
                case "\ud83d\udece️" -> var10000 = bet * 5;
                case "\ud83d\udcb8" -> var10000 = bet * 10;
                default -> var10000 = 0;
            }

            return var10000;
        }else {
            return 0;
        }
    }
}

