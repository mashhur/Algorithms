package exercises;

import java.util.*;

class FindCandidates {
    static public void main( String args[] ) {
        System.out.println( "Practice makes Perfect!" );

        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> resultList = findCandidates(candidates, target);
        for (List<Integer> currList : resultList) {
            for (int item : currList) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }


    /*
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    find all unique combinations in candidates where the   candidate numbers sums to target.

    The same repeated number may be chosen from candidates unlimited number of times.

    Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
    [7],
    [2,2,3]
    ]

     root
  /  |  \  \
 2            3   5  7
/ | \                /
2  3 5 7
/ |
2 3




Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
["aa","b"],
["a","a","b"]
]


all possible combinations
all possible permutations
all possible ways

Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]


n! 5 * 4 * 3 * 2

2^n



 */

    public static List<List<Integer>> findCandidates(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        findCandidates(candidates, target, resultList, currList, 0);
        return resultList;
    }

    public static void findCandidates(int[] candidates, int target,  List<List<Integer>> resultList,  List<Integer> currList, int start) {
        if (target < 0) {
            //currList.clear();
            return;
        }

        if (target == 0) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currList.add(candidates[i]);
            int newTarget = target - candidates[i];
            findCandidates(candidates, newTarget, resultList, currList, i);
            currList.remove(currList.size() - 1);
        }
    }


}



