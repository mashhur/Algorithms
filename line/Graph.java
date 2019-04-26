package line;

import java.util.*;

public class Graph {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0; i<t; i++){
            int nVertices = sc.nextInt();
            List<Integer>[] alist = new ArrayList[nVertices];
            int nEdges = sc.nextInt();
            for (int k=0; k<nVertices; k++)
                alist[k] = new ArrayList<>();

            for (int k=0; k<nEdges; k++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                alist[u].add(v);
            }

            System.out.println(isCyclic(nVertices, alist));
        }
    }

    static boolean isCyclic(int v, List<Integer>[] list) {

        boolean[] bVisit = new boolean[list.length];
        for (int i=0; i<v; i++) {

            int nStart = i;
            if(bVisit[i])
                continue;

            // DFS
            Stack<Integer> stack = new Stack<>();
            stack.push(nStart);

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                if (bVisit[idx])
                    continue;

                bVisit[idx] = true;
                List<Integer> nList = list[idx];
                for (int item : nList) {
                    if (nStart == item)
                        return true;
                    else
                        stack.add(item);
                }
            }
        }
        return false;
    }
}
