package Hackerrank.contest.RookiRank2;

import java.util.*;

/**
 * Created by mashhur on 2/11/17.
 */


class Bird {
    int type;
    int count;

    Bird(int type, int count) {
        this.type = type;
        this.count = count;
    }
}

public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Bird> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nType = in.nextInt();
            if (hMap.containsKey(nType)) {
                Bird bird = hMap.get(nType);
                bird.count++;
            } else
                hMap.put(nType, new Bird(nType, 1));
        }

        List<Map.Entry<Integer, Bird>> list = new LinkedList<>(hMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Bird>>() {
            @Override
            public int compare(Map.Entry<Integer, Bird> o1, Map.Entry<Integer, Bird> o2) {
                if (o1.getValue().count == o2.getValue().count)
                    return 0;
                else if (o1.getValue().count < o2.getValue().count)
                    return 1;

                return -1;
            }
        });

        System.out.println(list.get(0).getValue().type);
    }
}
