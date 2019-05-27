package Hackerrank.Graph;

import java.util.*;

/**
 * Created by mashhur on 2/12/17.
 */


/*
10 7
0 2
1 8
1 4
2 8
2 6
3 5
6 9
*/

public class JourneyToMoon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVertices = sc.nextInt();
        int nEdges = sc.nextInt();

        // init
        Map<Integer, Set<Integer>> nMat = new HashMap<>();
        for (int i = 0; i < nVertices; i++)
            nMat.put(i, new HashSet<>());

        // connect edges
        for (int i = 0; i < nEdges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Set<Integer> nListX = nMat.get(x);
            nListX.add(y);

            Set<Integer> nListY = nMat.get(y);
            nListY.add(x);
        }

        //print(nMat);

        List<Integer> nList = new ArrayList<>();

        // DFS
        boolean[] bVisit = new boolean[nVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nVertices; i++) {
            if (bVisit[i] == true) {
                continue;
            }

            stack.add(i);
            int nSize = 0;
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                bVisit[idx] = true;
                nSize++;
                Set<Integer> nSet = nMat.get(idx);
                for (int item : nSet) {
                    if (!bVisit[item]) {
                        stack.push(item);
                    }
                }
            }
            nList.add(nSize);

        }

        /*for (Integer size: nList) {
            System.out.println(size);
        }*/

        int nSum = 0;
        for (int i = 0; i < nList.size(); i++) {
            int nCurrVal = nList.get(i);
            for (int k = i + 1; k < nList.size(); k++) {
                nSum += (nCurrVal * nList.get(k));
                //System.out.print("Multiply : " + nCurrVal + " * " + nList.get(k));
            }
        }
        System.out.println(nSum);

    }

    static void print(Map<Integer, Set<Integer>> nMap) {
        for (int i = 0; i < nMap.size(); i++) {
            Set<Integer> nList = nMap.get(i);
            System.out.print("[" + i + "] ");

            for (int item : nList)
                System.out.print(item + " ");

            System.out.println();
        }
    }

    private static void JourneyToMoonUnion() {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();
        int nCounties = sc.nextInt();

        Union union = new Union(nSz);
        for (int i = 0; i < nCounties; i++) {
            union.connect(sc.nextInt(), sc.nextInt());
        }
        // sorting
        Arrays.sort(union.id);
        /*for (int i=0; i<union.id.length; i++) {
            System.out.print(union.id[i]+" ");
        }
        System.out.println();*/

        List<Integer> nList = new ArrayList<>();
        int nCounter = 1;
        for (int i = 1; i < union.id.length; i++) {
            if (union.id[i - 1] == union.id[i]) nCounter++;
            else {
                nList.add(nCounter);
                nCounter = 1;
            }
        }
        nList.add(nCounter);

        long nSum = 0;
        for (int i = 0; i < nList.size(); i++) {
            //System.out.print(nList.get(i) + " ");
            for (int k = i + 1; k < nList.size(); k++) {
                nSum += (nList.get(i) * nList.get(k));
                //System.out.println(nSum);
            }
        }
        //System.out.println();
        System.out.println(nSum);
    }
}

class Union {
    int[] id;
    int nUnion;

    Union(int n) {
        this.nUnion = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public void connect(int p, int q) {
        validate(p);
        validate(q);
        if (id[p] == id[q]) return;

        int pId = id[p];
        int qId = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        nUnion--;
    }

    private void validate(int n) {
        if (n < 0 || n > id.length)
            new IndexOutOfBoundsException();
    }

}