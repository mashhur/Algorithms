package Sorting.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by mashhur on 1/29/17.
 */

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // Used for sorting in ascending order of score
    @Override
    public int compare(Player a, Player b) {
        if (a.score - b.score > 0)
            return -1;
        else if (a.score - b.score < 0)
            return 1;
        else {
            return b.name.compareTo(a.name);
        }
    }
}

public class ComparatorSample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
