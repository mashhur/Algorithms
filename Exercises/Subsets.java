package Exercises;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static public void main(String args[]) {
        int[] array = {1, 2, 3};
        List<List<Integer>> list = subsets(array);

        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        subset(array, 0, resultList, currentList);
        return resultList;
    }

    public static void subset(int[] array, int index, List<List<Integer>> resultList, List<Integer> currentList) {

        if (index > array.length) {
            return;
        }

        resultList.add(new ArrayList<>(currentList));

        for (int i = index; i < array.length; i++) {
            currentList.add(array[i]);
            subset(array, i + 1, resultList, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }


  /*

1, 2 ,3

1
1, 2
1, 3
2
2, 3
3


abc

a
a, b
a, c
a, b, c
b,
b, c
b, c, a
c


             abc
        /         \
      (a, bc)    (, bc)

      /      \
     (ab, c) (a, c)

     Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]

 */

}



