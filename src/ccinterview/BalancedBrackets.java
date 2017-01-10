package ccinterview;


import java.util.*;

/**
 * Created by mashhur on 1/8/17.
 * Point : Stacks
 */
public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        Map<Character, Character> mBrackets = new HashMap<>();
        mBrackets.put('{', '}');
        mBrackets.put('[', ']');
        mBrackets.put('(', ')');

        Stack<Character> stack = new Stack<>();
        char[] chArr = expression.toCharArray();
        for (char ch: chArr) {
            if(mBrackets.containsKey(ch)) {
                stack.push(ch);
            } else if(mBrackets.containsValue(ch)) {
                if(stack.isEmpty())
                    return false;
                char chKey = stack.pop();
                if(mBrackets.containsKey(chKey)) {
                    if(ch != mBrackets.get(chKey))
                        return false;
                } else
                    return false;
            } else
                return false;
        }
        if(stack.size() > 0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
