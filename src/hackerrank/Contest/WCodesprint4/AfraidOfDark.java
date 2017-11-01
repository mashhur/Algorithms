package hackerrank.Contest.WCodesprint4;

import java.util.*;

/**
 * Created by mashhur on 10/28/17.
 */

class Room {

    int light = 0; // 0: off, 1: on
    int idx;
    List<Integer> corridors = new ArrayList<>();

    public void addCorridor(int corridor) {
        corridors.add(corridor);
    }

    public List<Integer> getCorridors() {
        return corridors;
    }

    public boolean turnOn() {
        if(light == 1) return true;

        if(idx % 2 == 0)
            return true;

        return false;
    }

}

public class AfraidOfDark {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();

            Room rooms[] = new Room[n];
            for(int i = 0; i < n; i++) {
                rooms[i] = new Room();
                rooms[i].light = in.nextInt();
            }

            for(int a1 = 0; a1 < n-1; a1++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;

                if(rooms[a] != null)
                    rooms[a].addCorridor(b);
                if(rooms[b] != null)
                    rooms[b].addCorridor(a);
            }
            System.out.println("##############################");
            BFS(rooms);
        }

        in.close();

    }

    private static void BFS(Room rooms[]) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] bVisitedArr = new boolean[rooms.length];

        for (int i=0; i<rooms.length; i++) {
            queue.add(i);

            int count = 0;
            while (queue.isEmpty() == false) {
                int idx = queue.poll();
                bVisitedArr[idx] = true;
                // visit
                Room room = rooms[idx];
                count++;

                for (int n : room.getCorridors()) {
                    if(rooms[n].turnOn() && bVisitedArr[n] == false)
                        queue.add(n);
                }
            }
            System.out.println(count);

        }
    }
}
