package hackerrank.contest.w33;

import java.util.*;

/**
 * Created by mashhur on 7/22/17.
 */
public class TwinArrays {

    static int twinArrays(Container[] A, Container[] B) {

        Comparator<Container> comparator = new Comparator<Container>() {
            @Override
            public int compare(Container o1, Container o2) {
                return o1.value - o2.value;
            }
        };

        Arrays.sort(A, comparator);
        Arrays.sort(B, comparator);

        return helper(A,B);
    }

    static int helper(Container[] A, Container[] B) {
        int i=0, j=0;
        while (i>=0 && j>=0 && i<A.length && j<B.length){
            if(A[i].idx == B[j].idx) {
                if(A[i+1].value < B[j+1].value)
                    i++;
                else
                    j++;
            } else
                return A[i].value + B[j].value;
        }

        return 0;

        /*
        4
        1  15 20 30
        1  15 18 20
        */
        /*for (int i =0; i<A.length; i++){
            System.err.println("A idx: " + A[i].idx + " A val: " + A[i].value);
        }*/
    }

    /**
     5
     5 4 3 2 1
     1 2 3 4 5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Container[] containerA = new Container[n];
        for(int i = 0; i < n; i++){
            containerA[i] = new Container(i,  in.nextInt());
        }

        Container[] containerB = new Container[n];
        for(int i = 0; i < n; i++){
            containerB[i] = new Container(i,  in.nextInt());
        }
        int result = twinArrays(containerA, containerB);
        System.out.println(result);
    }
}

class Container implements Comparator<Container>{
    int idx;
    int value;

    Container(int idx, int val){
        this.idx = idx;
        this.value = val;
    }

    // Overriding the compare method to sort the age
    public int compare(Container d, Container d1) {
        return d.value- d1.value;
    }
}
