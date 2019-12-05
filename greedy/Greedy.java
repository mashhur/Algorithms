package greedy;

import java.util.*;

/**
 * Created by mashhur on 1/30/16.
 */
public class Greedy {

    // Greed Challenge
    private static void GridChallenge() {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        while (nT > 0) {
            nT--;

            int nSz = sc.nextInt();
            sc.nextLine();
            char[][] nArr = new char[nSz][nSz];
            boolean bCont = true;
            for (int i = 0; i < nSz; i++) {          // Column
                // row
                nArr[i] = sc.nextLine().toCharArray();

                Arrays.sort(nArr[i]);
                bCont = IsRowBalanced(nArr[i]);
                if (!bCont)
                    break;
            }
            if (!bCont)
                continue;

            if (IsColBalanced(nArr))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean IsRowBalanced(char[] nArr) {
        for (int i = 1; i < nArr.length; i++) {
            if (nArr[i] < nArr[i - 1]) return false;
        }
        return true;
    }

    private static boolean IsColBalanced(char[][] nArr) {
        for (int i = 0; i < nArr.length; i++) {
            for (int j = 1; j < nArr.length; j++) {
                if (nArr[j][i] < nArr[j - 1][i]) return false;
            }
        }
        return true;
    }


    // Priyanka & Toys
    private static void PriyankaAndToys() {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();

        LinkedList<Integer> nList = new LinkedList<>();
        int i = 0;
        while (i < nSz) {
            nList.add(sc.nextInt());
            i++;
        }

        // sorting the array
        Collections.sort(nList);

        int nListSz = nList.size();
        for (int k = 1; k < nListSz; k++) {
            int nVal = nList.get(k - 1);
            while (nList.get(k) <= nVal + 4) {
                nList.remove(k);
                nListSz--;
                if (k == nListSz) break;
            }
        }
        System.out.print(nList.size());
    }

    // Largest Permutation array
    private static void MaxPermutation() {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();
        int nSwaps = sc.nextInt();

        int[] nArr = new int[nSz];
        int i = 0;
        while (i < nSz) {
            nArr[i] = sc.nextInt();
            i++;
        }

        int iSwap = 0;
        int k = 0;
        while (iSwap < nSwaps) {
            // 1. Number of swaps
            // 2. get a max from Sorted list
            // 3. swap with current index
            int idx = GetMaxIdx(nArr, k);
            if (idx != k) {
                swap(nArr, idx, k);
                iSwap++;
            }
            //System.out.println("SWAP: " + k + ", Value: " + nArr[k]);
            k++;
            if (k == nSz) break;
        }

        print_array(nArr, nSz);
    }

    private static int GetMaxIdx(int[] nArr, int nStart) {
        int idx = 0;
        int nMax = Integer.MIN_VALUE;
        for (int i = nStart; i < nArr.length; i++) {
            if (nMax < nArr[i]) {
                nMax = nArr[i];
                idx = i;
            }
        }
        return idx;
    }

    private static void swap(int[] nArr, int idx1, int idx2) {
        int nTemp = nArr[idx1];
        nArr[idx1] = nArr[idx2];
        nArr[idx2] = nTemp;
    }

    private static void print_array(int[] nArr, int nSz) {
        for (int i = 0; i < nSz; i++) {
            System.out.print(nArr[i] + " ");
        }
    }


    // Flowers
    private static void Flowers() {
        Scanner sc = new Scanner(System.in);
        int nFlower = sc.nextInt();
        int nPeople = sc.nextInt();

        int[] nArr = new int[nFlower]; // price listƒ
        for (int i = 0; i < nFlower; i++) {
            nArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);

        // initialize people list
        List<FlowerOwner> nPplList = new ArrayList<FlowerOwner>();
        for (int p = 0; p < nPeople; p++) {
            nPplList.add(new FlowerOwner(p));
        }

        int nSum = 0;
        for (int i = nFlower - 1; i >= 0; i--) {
            // get minimum flower owner
            Collections.sort(nPplList);
            FlowerOwner item = nPplList.get(0);
            int nCurrSum = (item.nFlowers.size() + 1) * nArr[i];
            nSum += nCurrSum;
            item.nFlowers.add(nCurrSum);
        }
        System.out.println(nSum);
    }

    // Meeting Point, used Manhattan Distance
    private static void MeetingPoint() {
        Scanner sc = new Scanner(System.in);
        long nSz = sc.nextLong();

        // Coordinate Points list
        Map<Long, Coord> nCoords = new HashMap<>();

        double nCenterX = 0;
        double nCenterY = 0;
        long i = 0;
        while (i < nSz) {
            i++;
            long x = sc.nextLong();
            long y = sc.nextLong();

            nCoords.put(i, new Coord(x, y));
            nCenterX += x;
            nCenterY += y;
        }

        if (nSz <= 1) {
            System.out.println(0);
            return;
        }

        nCenterX = nCenterX / nSz;
        nCenterY = nCenterY / nSz;
        long nMinIdx = 0;
        double nMinDist = Double.MAX_VALUE;
        for (Map.Entry<Long, Coord> item : nCoords.entrySet()) {
            double xDelta = item.getValue().x - nCenterX;
            double yDelta = item.getValue().y - nCenterY;
            double nDist = Math.sqrt(xDelta * xDelta + yDelta * yDelta);
            if (nMinDist > nDist) {
                nMinDist = nDist;
                nMinIdx = item.getKey();
            }
        }

        Coord nCurrCoord = nCoords.get(nMinIdx);
        long nSum = 0;
        for (Map.Entry<Long, Coord> item : nCoords.entrySet()) {

            long nItemXVal = Math.abs(item.getValue().x - nCurrCoord.x);
            long nItemYVal = Math.abs(item.getValue().y - nCurrCoord.y);
            long nDelta = (nItemXVal > nItemYVal) ? nItemXVal : nItemYVal;

            nSum += nDelta;
        }

        System.out.println(nSum);
    }

    // Min Max
    public static void MinMax() {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();
        int nK = sc.nextInt();

        int[] nArr = new int[nSz];
        int i = 0;
        while (i < nSz) {
            nArr[i] = sc.nextInt();
            i++;
        }

        // sorting
        Arrays.sort(nArr);

        PriorityQueue<Integer> nQueue = new PriorityQueue<>();

        // O(N) solution
        int nMin = Integer.MAX_VALUE;
        for (int n = 0; n <= nSz - nK; n++) {
            int nDelta = nArr[n + nK - 1] - nArr[n];
            if (nMin > nDelta) nMin = nDelta;
        }
        System.out.println(nMin);
    }

    // Mark and Toys
    public static void MarkAndToys() {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = stdin.nextInt();

        Arrays.sort(prices);
        int nCount = 0;
        long nSum = 0;

        while (nSum < k) {
            nSum += prices[nCount];
            if (nSum < k)
                nCount++;
        }

        System.out.println(nCount);
    }

    // Two arrays
    public static void TwoArrays() {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        while (nT > 0) {
            nT--;
            int nSz = sc.nextInt();
            int nK = sc.nextInt();

            int nArr1[] = new int[nSz];
            int nArr2[] = new int[nSz];
            for (int i = 0; i < nSz; i++)
                nArr1[i] = sc.nextInt();
            for (int i = 0; i < nSz; i++)
                nArr2[i] = sc.nextInt();

            Arrays.sort(nArr1);
            Arrays.sort(nArr2);

            boolean bFlag = false;
            for (int i = 0; i < nSz; i++) {
                if (nArr2[nSz - i - 1] + nArr1[i] < nK) {
                    bFlag = true;
                    break;
                }
            }

            System.out.println(!bFlag ? "YES" : "NO");
        }
    }

    // Jim and orders
    public static void JimAndOrder() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 1000 || n <= 0) return;

        int n_key = 0;
        ArrayList<Order> nList = new ArrayList<>();
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.n_order - o2.n_order;
            }
        };
        while (n > 0) {
            n--;
            n_key++;
            int n_order = sc.nextInt();
            int n_time = sc.nextInt();
            if (n_order > 1000000 || n_order <= 0) return;
            if (n_time > 1000000 || n_time <= 0) return;
            nList.add(new Order(n_key, n_order + n_time));
        }
        Collections.sort(nList, comparator);
        for (int i = 0; i < n_key; i++)
            System.out.print(nList.get(i).n_key + " ");
    }

    public static void UnitTest() {
        //GridChallenge();
        //PriyankaAndToys();
        //MaxPermutation();
        //Flowers();
        //MeetingPoint();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            System.out.println(isPrime(n) == true ? "Prime" : "Not prime");
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class Coord {
    long x, y;

    Coord(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class FlowerOwner implements Comparable<FlowerOwner> {
    int idx;
    List<Integer> nFlowers;
    FlowerOwner(int i) {
        this.idx = i;
        nFlowers = new ArrayList<>();
    }

    @Override
    public int compareTo(FlowerOwner o1) {
        return nFlowers.size() - o1.nFlowers.size();
    }
}

class Item implements Comparable<Item> {
    int idx;
    int nVal;
    Item(int i, int val) {
        this.idx = i;
        this.nVal = val;
    }

    @Override
    public int compareTo(Item o1) {
        return o1.nVal - this.nVal;
    }
}

class Order {
    int n_key;
    int n_order;
    Order(int key, int sum) {
        this.n_order = sum;
        this.n_key = key;
    }
}
