package leetcode.contest.weekly56;

/**
 * Created by mashhur on 10/29/17.
 */
public class BitCharacters {

    public boolean isOneBitCharacter(int[] bits) {

        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 1)
                return true;
            if (bits[i] == 1)
                i++;
        }

        return false;
    }
}
