package Backtracking;

public class StringPermutation {

    /* In case of length
     * step 1 -> if(0) print(A)
     * step 2 -> print(B) -> step 1
     *      swap (A,B) -> print(B) -> step 1
     *
     * step 3 -> print (A) -> step 2
     *           swap (A,B) -> print(B) -> step 2
     *
     * */


    public void permute(int index, int length, String word) {
        if (index == length) {
            System.out.println(word);
            return;
        }

        for (int i = index; i <= length; i++) {
            if (i != index)
                word = swap(word, index, i);

            permute(index + 1, length, word);

            if (i != index)
                word = swap(word, index, i);
        }
    }

    private String swap(String word, int from, int to) {
        char[] array = word.toCharArray();
        char temp = array[from];

        array[from] = array[to];
        array[to] = temp;

        return new String(array);
    }

    public void distinctPermute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        boolean alpha[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String ros = str.substring(0, i) + str.substring(i + 1);
            if (alpha[ch - 'a'] == false)
                distinctPermute(ros, ans + ch);
            alpha[ch - 'a'] = true;
        }
    }


    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        System.out.println();
        permutation.permute(0, "abac".length()-1, "AB");
        permutation.distinctPermute("abac", "");
    }
}
