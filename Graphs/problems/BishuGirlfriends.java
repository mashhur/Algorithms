package Graphs.problems;

import java.util.*;

/**
 * Created by mashhur on 1/30/17.
 * DFS problem
 */

class Graph {
    public int idx;
    public List<Integer> nList = new ArrayList<>();

    Graph(int idx) {
        this.idx = idx;
    }

    Graph(int idx, int nVal) {
        this.idx = idx;
        nList.add(nVal);
    }
}

public class BishuGirlfriends {

    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Map<Integer, Graph> nMap = new HashMap<>();
        for (int i = 0; i < t - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (nMap.containsKey(u)) {
                Graph gr = nMap.get(u);
                gr.nList.add(v);
            } else {
                nMap.put(u, new Graph(u, v));
            }
        }

        int n = sc.nextInt();
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nList.add(sc.nextInt());
        }

        int nRet = getCountryOfGirl(nMap, nList);
        System.out.println(nRet == -1 ? "Not found." : nRet);
    }

    private static int getCountryOfGirl(Map<Integer, Graph> nMap, List<Integer> nList) {
        for (Map.Entry<Integer, Graph> entry : nMap.entrySet()) {
            List<Integer> nEntryList = entry.getValue().nList;
            for (int item : nEntryList) {
                if (nList.contains(item)) {
                    return item;
                }
            }
        }

        return -1;
    }
}
