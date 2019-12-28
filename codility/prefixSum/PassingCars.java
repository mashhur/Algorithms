package codility.prefixSum;

public class PassingCars {

    public static void main(String args[]) {
        //int[] cars = {0, 1, 0, 1, 1};
        int[] cars = {0, 0, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(PassingCars.solution(cars));
    }

    public static int solution(int[] A) {
        int[] eastPassingCars = new int[A.length];
        int[] westPassingCars = new int[A.length];

        if (A[0] == 0) eastPassingCars[0] = 1;
        else westPassingCars[0] = 1;

        int pairsCount = 0;
        for (int i=1; i<A.length; i++) {
            if (A[i] == 0) {
                eastPassingCars[i] = eastPassingCars[i-1] + 1;
                westPassingCars[i] = westPassingCars[i-1];
                //pairsCount += westPassingCars[i];
            } else {
                eastPassingCars[i] = eastPassingCars[i-1];
                westPassingCars[i] = westPassingCars[i-1] + 1;
                pairsCount += eastPassingCars[i];
            }

            if (pairsCount > 1000000000)
                return -1;
            //System.out.println(pairsCount);
        }

        return pairsCount;
    }
}
