package Graphs.problems;

import java.util.*;

/**
 * Created by mashhur on 1/31/17.
 */


public class ShortestReach {
    /*
    * 2
4 2
1 2
1 3
1
3 1
2 3
2
    * */

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i=0; i<q; i++){
            int n = sc.nextInt();
            Map<Integer, Graph> nMap = new HashMap<>();
            for (int k=1; k<=n; k++)
                nMap.put(k, new Graph(k));

            int m = sc.nextInt();
            for (int k=0; k<m; k++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                if(nMap.containsKey(u)){
                    Graph gr = nMap.get(u);
                    gr.nList.add(v);
                } else {
                    nMap.put(u, new Graph(u, v));
                }
            }

            int nStart = sc.nextInt();
            Graph gr = nMap.get(nStart);
            Stack<Graph> stack = new Stack<>();
            stack.push(gr);

            List<Integer> nList = new ArrayList<>();
            // BFS traversal
            while (!stack.isEmpty()){
                Graph graph = stack.pop();
                for (int item : graph.nList){
                    if(nMap.containsKey(item)){
                        System.out.print("6 ");
                        nList.add(graph.idx);
                        stack.push(nMap.get(item));
                    } else
                        System.out.print("-1 ");
                }
            }

            /*for (Map.Entry<Integer, Graph> entry : nMap.entrySet()){
                if(nList.contains(entry.getKey()))
                    System.out.print("6 ");
                else
                    System.out.print("-1 ");
            }*/

            System.out.println();
        }
    }
}
