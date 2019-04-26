package hackerrank;

import java.math.BigInteger;
import java.util.*;

class Node {
    public int frequency; // the frequency of this tree
    public char data;
    public Node left, right;
}

public class Solution {
    public static void TimeConversion() {

        Scanner sc = new Scanner(System.in);
        String sTime = sc.nextLine();
        if (sTime.length() != 10) return;

        if (sTime.compareTo("12:00:00AM") == 0) {
            System.out.println("00:00:00");
            return;
        }

        if (sTime.compareTo("12:00:00PM") == 0) {
            System.out.println("12:00:00");
            return;
        }

        try {
            String[] sTimeArr = sTime.split(":");
            if (sTimeArr.length != 3) return;

            int nHour = Integer.parseInt(sTimeArr[0]);
            if (nHour < 0 || nHour > 12) return;

            int nMin = Integer.parseInt(sTimeArr[1]);
            if (nMin < 0 || nMin > 59) return;

            int nSec = Integer.parseInt(sTimeArr[2].substring(0, 2));
            if (nSec < 0 || nSec > 59) return;

            String sAMPM = sTimeArr[2].substring(2, 4);
            boolean bRet = false;
            if (sAMPM.compareTo("AM") == 0)
                bRet = true;
            if (sAMPM.compareTo("PM") == 0)
                bRet = true;
            if (!bRet) return;

            switch (sAMPM) {
                case "AM":
                    if (nHour >= 12) {
                        nHour = nHour - 12;
                        System.out.print(String.format("%02d", nHour) + ":");
                        System.out.print(String.format("%02d", nMin) + ":");
                        System.out.print(String.format("%02d", nSec));
                        return;
                    } else
                        System.out.println(sTime.substring(0, 8));
                    break;
                case "PM":
                    if (nHour >= 12) {
                        System.out.println(sTime.substring(0, 8));
                        return;
                    }
                    int nTotalSec = nSec + nMin * 60 + nHour * 3600;
                    nTotalSec = nTotalSec + 12 * 3600; // conversion to PM
                    nHour = (nTotalSec / 3600);
                    nMin = (nTotalSec % 3600) / 60;
                    nSec = nSec;
                    System.out.print(String.format("%02d", nHour) + ":");
                    System.out.print(String.format("%02d", nMin) + ":");
                    System.out.print(String.format("%02d", nSec));
                    break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void Temp() {
        Scanner sc = new Scanner(System.in);
        int nRetD = sc.nextInt();
        int nRetM = sc.nextInt();
        int nRetY = sc.nextInt();

        int nExpcD = sc.nextInt();
        int nExpcM = sc.nextInt();
        int nExpcY = sc.nextInt();

        if (nRetD < 1 || nRetD > 31) return;
        if (nRetM < 1 || nRetM > 12) return;
        if (nRetY < 1 || nRetY > 3000) return;

        if (nExpcD < 1 || nExpcD > 31) return;
        if (nExpcM < 1 || nExpcM > 12) return;
        if (nExpcY < 1 || nExpcY > 3000) return;

        int nYear = nRetY - nExpcY;
        int nMonth = nRetM - nExpcM;
        int nDay = nRetD - nExpcD;

        int nDays = nYear * 360 + nMonth * 30 + nDay;
        if (nDays < 0) {
            System.out.println(0);
            return;
        }

        if (nDays >= 360) {
            System.out.println(10000);
            return;
        }

        if (nDays >= 30 && nDays < 360) {
            int nDiv = (nDays / 30) * 500;
            System.out.println(nDiv);
        }

        if (nDays > 0 && nDays < 30) {
            System.out.println(nDays * 15);
            return;
        }
    }

    // --------- Find Digits -------------
    public static void FindDigits(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        if (nT < 1 || nT > 15) return;

        while (nT > 0) {
            long nNumber = sc.nextLong();
            if (nNumber < 0 || nNumber > Math.pow(10, 10)) return;

            long nDigit = nNumber;
            long nDivCnt = 0;
            while (nDigit >= 9) {
                long nRemain = GetRemain(nDigit, 10);
                if (nRemain != 0)
                    if (GetRemain(nNumber, nRemain) == 0) nDivCnt++;

                //System.out.println(nRemain);
                nDigit = nDigit / 10;
                if (nDigit > 0 && nDigit < 10) {
                    nRemain = nDigit;
                    if (nRemain != 0)
                        if (GetRemain(nNumber, nRemain) == 0) nDivCnt++;
                    //System.out.println(nRemain);
                }
            }
            nT--;
            System.out.println(nDivCnt);
        }
    }

    static long GetRemain(long nNumber, long nDiv) {
        return nNumber % nDiv;
    }

    // -------- Sherlock Holmes 1 -----------
    public static void SherlockAndBeats(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int m3 = n / 3;
            int r3 = n % 3;

            int m5 = r3 / 5;
            int r5 = r3 % 5;
            while (r5 != 0 && m3 > 0) {
                r3 += 3;
                m3--;

                m5 = r3 / 5;
                r5 = r3 % 5;
            }

            if (r5 != 0) {
                System.out.print("-1");
            } else {
                for (int j = 0; j < m3; j++) {
                    System.out.print("555");
                }

                for (int j = 0; j < m5; j++) {
                    System.out.print("33333");
                }
            }

            System.out.println();

        }
    }

    // --------- Sherlock And Squares --------
    public static void SherlockAndSquares(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        if (t < 1 || t > 100) return;

        while (t > 0) {
            t--;
            long nA = sc.nextLong();
            long nB = sc.nextLong();
            if (nA < 1 || nA > nB) return;
            if (nB < nA || nB > Math.pow(10, 9)) return;

            double dValSt = Math.sqrt(nA);
            long nStart = (dValSt > (double) ((int) dValSt)) ? (long) (dValSt) + 1 : (long) dValSt;

            double dValEnd = Math.sqrt(nB) + 1;
            long nEnd = (long) dValEnd;

            System.out.println(nEnd - nStart);
        }
    }

    // -------- CHOCO ------------------------
    public static void Choco(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }

    private static long Solve(int N, int C, int M) {

        //Write code to solve each of the test over here
        int nWrap = N / C;
        int nChoco = nWrap;
        while (nWrap >= M) {
            nWrap -= M;
            nChoco++;
            nWrap++;
        }

        return nChoco;
    }

    static String getFifteenChars(String strIn) {
        String strNew = "               ";
        if (strIn.length() > 15) {
            strNew = strIn.substring(0, 15);
        } else {
            strNew = strIn + strNew.substring(0, (15 - strIn.length()));
        }
        return strNew;
    }

    private static void Calculate(int a, int b, int n) {
        int nSum = 0, nLoop = 0;
        while (nLoop < n) {
            if (nLoop != 0) {
                nSum += b * Math.pow(2, nLoop);
                System.out.print(" ");
            } else
                nSum += a + b * Math.pow(2, nLoop);
            System.out.print(nSum);
            nLoop++;
        }
    }

    // ----------------------------------------------------
    public static void StackProblem() {

        Scanner sc = new Scanner(System.in);

        List stackList = new ArrayList<>();
        stackList.add('[');
        stackList.add(']');
        stackList.add('{');
        stackList.add('}');
        stackList.add('(');
        stackList.add(')');

        String strInput = "";
        while (sc.hasNextLine()) {
            if (!sc.hasNext()) continue;

            strInput = sc.nextLine();
            //System.out.println("Input String : " + strInput);
            if (strInput.isEmpty()) {
                System.out.println("true");
                continue;
            }

            boolean bTrue = true;
            for (int i = 0; i < stackList.size() - 1; i += 2) {
                char cStart = (char) stackList.get(i);
                //System.out.println("Check for start : " + cStart);
                int nIndex = strInput.indexOf(cStart, 0);
                int nStartCnt = 0;
                while (nIndex > -1) {
                    nStartCnt++;
                    nIndex = strInput.indexOf(cStart, nIndex + 1);
                }
                //System.out.println("start index count : " + nStartCnt );

                char cEnd = (char) stackList.get(i + 1);
                //System.out.println("Check for end : " + cEnd);
                int nEndCnt = 0;
                nIndex = strInput.indexOf(cEnd, 0);
                while (nIndex > -1) {
                    nEndCnt++;
                    nIndex = strInput.indexOf(cEnd, nIndex + 1);
                }

                //System.out.println("start index count : " + nEndCnt);

                if (nStartCnt != nEndCnt) {
                    bTrue = false;
                    System.out.println("false");
                    break;
                }
            }

            if (bTrue)
                System.out.println("true");
        }
    }

    // ----------------------------------------------------
    public static void AngryProf(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nT = sc.nextInt();
        if (nT < 1 || nT > 10) return;

        for (int i = 0; i < nT; i++) {

            int nStud = sc.nextInt();
            if (nStud < 1 || nStud > 1000) return;

            int nExpcStud = sc.nextInt();
            if (nExpcStud < 1 || nExpcStud > nStud) return;

            int nOnTimeCnt = 0;

            while (nStud > 0) {
                int nTime = sc.nextInt();
                if (nTime <= 0) nOnTimeCnt++;

                if (nTime < -100 || nTime > 100) return;
                nStud--;
            }

            if (nOnTimeCnt >= nExpcStud)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

    //------------ Sherlock and The Beast ----------------
    public static void SherlockAndBeast(String[] args) {
        // 3, 5
        Scanner sc = new Scanner(System.in);
        int nTime = sc.nextInt();
        if (nTime < 1 || nTime > 20) return;


        for (int i = 0; i < nTime; i++) {
            int nNum = sc.nextInt();
            if (nNum < 1 || nNum > 100000) return;

            if (nNum == 1) {
                System.out.println("-1");
                continue;
            }

            if (Integer.toString(nNum).indexOf('5') > 0) {

            } else if (Integer.toString(nNum).indexOf('3') > 0) {

            } else {

            }

            for (int k = 0; k < nNum; k++)
                System.out.print(5);
            System.out.println();
        }
    }

    // ----- String Encryption -----------------
    public static void StringEncryption(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nLength = sc.nextInt();
        sc.nextLine();
        char[] sArr = sc.nextLine().toCharArray();
        int nK = sc.nextInt();
        if (nK >= 26)
            nK = nK % 26;

        String sEncrypt = "";
        for (int i = 0; i < nLength; i++) {
            char chNew = sArr[i];
            if (chNew >= 'a' && chNew <= 'z') {
                chNew += nK;
                if (chNew > 'z')
                    chNew -= 26;
            } else if (chNew >= 'A' && chNew <= 'Z') {
                chNew += nK;
                if (chNew > 'Z')
                    chNew -= 26;
            }

            sEncrypt += chNew;
        }
        System.out.println(sEncrypt);
    }

    // -------- Cavity Calculation ------------
    public static void CavitySolution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();
        sc.nextLine();
        if (nSz < 1 || nSz > 100) return;

        BigInteger[][] nArr = new BigInteger[nSz][nSz];

        for (int i = 0; i < nSz; i++) {
            BigInteger nNum = new BigInteger(sc.nextLine());

            for (int k = nSz - 1; k >= 0; k--) {
                nArr[i][k] = nNum.mod(BigInteger.TEN);
                nNum = nNum.divide(BigInteger.TEN);
            }
        }

        for (int i = 0; i < nSz; i++) {
            for (int k = 0; k < nSz; k++) {
                if (i == 0 || k == 0 || i == nSz - 1 || k == nSz - 1) {
                    System.out.print(nArr[i][k]);
                } else if (nArr[i][k].compareTo(nArr[i - 1][k]) > 0 &&
                        nArr[i][k].compareTo(nArr[i + 1][k]) > 0 &&
                        nArr[i][k].compareTo(nArr[i][k - 1]) > 0 &&
                        nArr[i][k].compareTo(nArr[i][k + 1]) > 0) {
                    System.out.print("X");
                } else
                    System.out.print(nArr[i][k]);
            }
            System.out.println();
        }
    }

    // ----------------------------------------
    public static void FindSubArray(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        if (nT > 5 || nT < 1) return;
        while (nT > 0) {
            nT--;

            int nR = sc.nextInt();
            int nC = sc.nextInt();
            sc.nextLine();

            if (nR < 1 || nR > 1000) return;
            if (nC < 1 || nC > 1000) return;

            byte[][] nArr = new byte[nR][nC];

            for (int i = 0; i < nR; i++) {
                char[] chArr = sc.nextLine().toCharArray();
                for (int k = 0; k < nC; k++) {
                    nArr[i][k] = Byte.parseByte(chArr[k] + "");
                    System.out.print(nArr[i][k]);
                }
                System.out.println();
            }


            int nr = sc.nextInt();
            int nc = sc.nextInt();
            sc.nextLine();
            System.out.println(nr);
            System.out.println(nc);

            byte[][] nArrSub = new byte[nr][nc];
            for (int i = 0; i < nr; i++) {
                char[] chArr = sc.nextLine().toCharArray();
                for (int k = 0; k < nc; k++) {
                    nArrSub[i][k] = Byte.parseByte(chArr[k] + "");
                    System.out.print(nArrSub[i][k]);
                }
                System.out.println();
            }


        }
    }

    static int FindSubArray(byte[] nArr, byte[] nArrSub, int nIndex) {
        int n = 0;
        int nSubIndex = 0;
        for (int i = nIndex; i < nArr.length; i++) {
            if (nArr[i] == nArrSub[nSubIndex]) {

                n = i;
                nSubIndex++;
            }
        }

        return n;
    }

    // -------------------------------------------
    public static void MaxTeamWithTopic(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nPeople = sc.nextInt();
        int nTopic = sc.nextInt();
        sc.nextLine();

        if (nPeople < 2 || nPeople > 500) return;
        if (nTopic < 1 || nTopic > 500) return;

        byte[][] nArr = new byte[nPeople][nTopic];

        for (int i = 0; i < nPeople; i++) {
            char[] chArr = sc.nextLine().toCharArray();
            for (int k = 0; k < nTopic; k++) {
                nArr[i][k] = Byte.parseByte(chArr[k] + "");
                //System.out.print(nArr[i][k]);
            }
            //System.out.println();
        }

        int nMaxNum = 0;
        int nTeams = 0;
        for (int i = 0; i < nPeople; i++) {
            for (int k = i + 1; k < nPeople; k++) {
                int bTopic = TeamTopicMax(nArr[i], nArr[k]);
                if (nMaxNum < bTopic) {
                    nMaxNum = bTopic;
                    nTeams = 0;
                }

                if (nMaxNum == bTopic) nTeams++;
            }
        }

        System.out.println(nMaxNum);
        System.out.println(nTeams);
    }

    static int TeamTopicMax(byte[] nArr1, byte[] nArr2) {
        int nMaxTopic = 0;
        for (int i = 0; i < nArr1.length; i++) {
            if (nArr1[i] == 1 || nArr2[i] == 1)
                nMaxTopic++;
        }

        return nMaxTopic;
    }

    // ------- Time in Words ----------------------------
    public static void TimeInWords(String[] args) {
        String[] strMin = {
                "one minute",
                "two minutes",
                "three minutes",
                "four minutes",
                "five minutes",
                "six minutes",
                "seven minutes",
                "eight minutes",
                "nine minutes",
                "ten minutes",
                "eleven minutes",
                "twelve minutes",
                "thirteen minutes",
                "fourteen minutes",
                "quarter",
                "sixteen minutes",
                "seventeen minutes",
                "eighteen minutes",
                "nineteen minutes",
                "twenty minutes",
                "twenty one minutes",
                "twenty two minutes",
                "twenty three minutes",
                "twenty four minutes",
                "twenty five minutes",
                "twenty six minutes",
                "twenty seven minutes",
                "twenty eight minutes",
                "twenty nine minutes",
                "half"
        };

        String[] sHours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};

        ArrayList<String> minArr = new ArrayList<String>();
        for (String sMin : strMin) {
            minArr.add(sMin);
        }

        ArrayList<String> hourArr = new ArrayList<String>();
        for (String sHour : sHours) {
            hourArr.add(sHour);
        }

        String sResult = "";

        Scanner sc = new Scanner(System.in);
        int nHour = sc.nextInt();
        int nMin = sc.nextInt();

        sResult = hourArr.get(nHour - 1);

        if (nMin <= 30) {
            if (nMin == 0)
                sResult += " o' clock";
            else
                sResult = minArr.get(nMin - 1) + " past " + sResult;
        } else {
            nMin = 60 - nMin;
            sResult = minArr.get(nMin - 1) + " to " + hourArr.get(nHour);
        }

        System.out.println(sResult);

    }

    // ----------- Hourglass problem ------
    public static void Hourglass(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 6;
        int[][] bArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                bArr[k][i] = sc.nextInt();
                //System.out.print(bArr[k][i]);
            }
            //System.out.println();
        }

        int nSum = GetHourGlassSum(bArr, 0, 0, 6);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                int nCurrSum = GetHourGlassSum(bArr, i, k, n);
                if (nSum < nCurrSum)
                    nSum = nCurrSum;
            }
        }
        System.out.print(nSum);
    }

    static int GetHourGlassSum(int[][] bArr, int xStart, int yStart, int nSz) {

        if (xStart + 3 > nSz || yStart + 3 > nSz)
            return Integer.MIN_VALUE;

        int nCurrSum = bArr[xStart][yStart] + bArr[xStart + 1][yStart] + bArr[xStart + 2][yStart] +
                bArr[xStart + 1][yStart + 1] +
                bArr[xStart][yStart + 2] + bArr[xStart + 1][yStart + 2] + bArr[xStart + 2][yStart + 2];
        return nCurrSum;
    }

    // ------------ Funny String ------------------
    public static void FunnyString(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        sc.nextLine();
        while (nT > 0) {
            nT--;
            String sLine = sc.nextLine();
            if (isFunny(sLine))
                System.out.println("Funny");
            else
                System.out.println("Not Funny");
        }
    }

    static boolean isFunny(String sLine) {
        String sReverse = new StringBuilder(sLine).reverse().toString();
        char[] chStr = sLine.toCharArray();
        char[] chRevStr = sReverse.toCharArray();

        for (int i = 1; i < sLine.length(); i++) {
            if (Math.abs(chStr[i] - chStr[i - 1]) != Math.abs(chRevStr[i] - chRevStr[i - 1]))
                return false;
        }

        return true;
    }

    // -------- Pangram Sentence --------------------
    public static void Pangram(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sLine = sc.nextLine();
        LinkedList<Character> nList = new LinkedList<Character>();
        for (char ch = 'a'; ch <= 'z'; ch++)
            nList.add(ch);

        char[] chArr = sLine.toCharArray();
        for (char ch : chArr) {
            char chNew = Character.toLowerCase(ch);
            if (nList.contains(chNew))
                nList.remove((Object) chNew);

            if (nList.size() == 0)
                break;
        }

        if (nList.size() == 0)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }

    public static void IndexOfProblem(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nV = sc.nextInt();
        int nIndex = -1;
        int nArrSz = sc.nextInt();
        int[] nArr = new int[nArrSz];
        for (int i = 0; i < nArrSz; i++) {
            nArr[i] = sc.nextInt();
            if (nArr[i] == nV)
                nIndex = i;
        }

        System.out.println(nIndex);
    }

    // ------- Finding Sub array -------------------
    public static void SubArrayFind(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        while (nT > 0) {
            nT--;
            int nY = sc.nextInt();
            int nX = sc.nextInt();
            sc.nextLine();
            int[][] nArrMain = new int[nY][nX];

            for (int i = 0; i < nY; i++) {
                char[] chArr = sc.nextLine().toCharArray();
                for (int k = 0; k < nX; k++) {
                    nArrMain[i][k] = Integer.parseInt(chArr[k] + "");
                    //System.out.print(nArrMain[i][k]);
                }
                //System.out.println();
            }
            //System.out.println();

            int nYSub = sc.nextInt();
            int nXSub = sc.nextInt();
            sc.nextLine();
            int[][] nArrSub = new int[nXSub][nYSub];
            for (int i = 0; i < nYSub; i++) {
                char[] chArr = sc.nextLine().toCharArray();
                for (int k = 0; k < nXSub; k++) {
                    nArrSub[k][i] = Integer.parseInt(chArr[k] + "");
                    //System.out.print(nArrSub[k][i]);
                }
                //System.out.println();
            }

            boolean bOut = false;
            for (int i = 0; i < nY; i++) {
                if (bOut) break;
                for (int k = 0; k < nX; k++) {
                    boolean bRet = FindSubArray(nArrMain, i, k, nY, nX, nArrSub, nXSub, nYSub);
                    if (bRet) {
                        //System.out.println(bRet);
                        bOut = true;
                        break;
                    }
                }
            }

            if (bOut)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

    static boolean FindSubArray(int[][] nMainArr, int yStart, int xStart,
                                int nYLength, int nXLength,
                                int[][] nSubArr, int nSXLength, int ySLength) {

        if (nXLength - xStart < nSXLength || nYLength - yStart < ySLength)
            return false;

        for (int y = 0; y < ySLength; y++) {
            for (int x = 0; x < nSXLength; x++) {
                //System.out.println(nMainArr[y+yStart][x+xStart]);
                //System.out.println(nSubArr[x][y]);
                if (nMainArr[y + yStart][x + xStart] != nSubArr[x][y])
                    return false;
            }
        }
        return true;
    }

    // ----------- Pairs -------------------------
    public static void Pairs(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nDiff = sc.nextInt();

        int[] nNums = new int[N];
        for (int i = 0; i < N; i++) {
            nNums[i] = sc.nextInt();
        }

        Arrays.sort(nNums);
        System.out.println(countAtKDiff(nNums, N, nDiff));
    }

    private static int countAtKDiff(int[] array, int arraySize, int k) {

        int count = 0; // initialize the counter

        for (int i = 0, j = 1; i < arraySize && j < arraySize; ) {
            if (array[j] - array[i] == k) { // found a pair
                count++;
                i++;
                j++;
            } else if (array[j] - array[i] < k) { // difference is less than wanted so increment right pointer
                j++;
            } else { // difference is more than wanted so increment the left pointer
                i++;
            }
        }

        return count;
    }

    // ---------- Lonely Integer ---------------
    static int lonelyinteger(int[] a) {
        if (a.length == 1)
            return a[0];

        Arrays.sort(a);
        int nNum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a.length - 1 == i) return a[i];
            if (a[i] == a[i + 1]) {
                i++;
                continue;
            } else {
                nNum = a[i];
                break;
            }
        }
        return nNum;
    }

    public static void LonelyINT(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }

    // --------- Maximizing XOR ----------------
    public static void MaximizeXOR(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nL = sc.nextInt();
        int nR = sc.nextInt();

        int nMax = 0;
        for (int n = nL; n <= nR; n++) {
            for (int k = nL; k <= nR; k++) {
                int nVal = n ^ k;
                if (nMax < nVal) nMax = nVal;
            }
        }

        System.out.println(nMax);
    }

    // --------------- Maximize XOR ---------------------------
    public static void MaxXOR(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nL = sc.nextInt();
        int nR = sc.nextInt();

        int nMax = 0;
        for (int n = nL; n <= nR; n++) {
            for (int k = nL; k <= nR; k++) {
                int nVal = n ^ k;
                if (nMax < nVal) nMax = nVal;
            }
        }

        System.out.println(nMax);
        System.out.println(maxXorC(nL, nR));

    }

    static int maxXorC(int l, int r) {
        if (l == r)
            return 0;
        else {
            int bitLen = (int) (Math.log(l ^ r) / Math.log(2));
            return (2 << bitLen) - 1;
        }
    }

    // -------------- Counter game ----------------
    public static void CounterGame(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();
        sc.nextLine();
        if (nT > 10 || nT < 1) return;

        while (nT > 0) {
            nT--;

            long n = sc.nextLong();
            int nCounter = 0;
            while (n != 1) {
                double dLog = log2(n);
                // case 1: N equals to power of 2
                if ((dLog - (int) dLog) == 0)
                    n = n / 2;
                else { // case 2: N not equal to power of 2
                    n = n - (int) dLog;
                }
                nCounter++;
                //System.out.println(n);
            }
            if (nCounter == 0) {
                System.out.println("Richard");
                continue;
            }

            //System.out.println(nCounter);
            if (nCounter % 2 == 0)
                System.out.println("Louise");
            else
                System.out.println("Richard");

        }
    }

    public static double log2(double n) {
        return (Math.log(n) / Math.log(2));
    }

    // ------ Sub array XOR ----------------------
    public static void SubArrayXOR(String[] args) {
        Stack<Integer> m_stack = new Stack<>();
        m_stack.push(1);
        m_stack.push(null);
        for (Integer i : m_stack)
            System.out.println(i);

        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();

        while (nT > 0) {
            nT--;

            int nArrSz = sc.nextInt();
            int[] nArr = new int[nArrSz];

            for (int i = 0; i < nArrSz; i++) {
                nArr[i] = sc.nextInt();
            }

            int nXOR = 0;
            for (int i = 0; i < nArrSz; i++) {
                for (int k = i + 1; k < nArrSz; k++) {
                    nXOR ^= (nArr[i] ^ nArr[k]);
                    System.out.print(nArr[i]);
                    System.out.print(nArr[k]);
                }
                System.out.println();
            }

            System.out.println(nXOR);

        }
    }

    // ------ Anagram Solution -------------
    static boolean isAnagram(String A, String B) {
        char[] chArr1 = A.toCharArray();
        char[] chArr2 = B.toCharArray();

        for (int i = 0; i < chArr1.length; i++) {
            chArr1[i] = Character.toLowerCase(chArr1[i]);
            chArr2[i] = Character.toLowerCase(chArr2[i]);
        }

        Arrays.sort(chArr1);
        Arrays.sort(chArr2);
        for (int i = 0; i < chArr1.length; i++)
            if (Character.toLowerCase(chArr1[i]) != Character.toLowerCase(chArr2[i]))
                return false;

        return true;
    }

    public static void AnagramMain(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        boolean ret = isAnagram(A, B);
        if (ret) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");
    }

    /// ------ Iterator Solution ---------------
    static Iterator func(ArrayList mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            it.remove();
            if (element.toString() == "###")
                break;
        }
        return it;

    }

    public static void IteratorMain(String[] argh) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }
        mylist.add("###");
        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }


        Iterator it = func(mylist);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String) element);
        }
    }

    // ---------Binary Search --------------------------
    public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void BinarySearch(String[] args) {
    /*int[] whitelist = In.readInts(args[0]);
    Arrays.sort(whitelist);
    while (!StdIn.isEmpty())
    { // Read key, print if not in whitelist.
        int key = StdIn.readInt();
        if (rank(key, whitelist) < 0)
            StdOut.println(key);
    }*/
    }

    // ---- FibonacciModified -------------
    public static void FibonacciModified(String[] args) {

        //decode("1001011", new Node());
        Scanner sc = new Scanner(System.in);
        int nA = sc.nextInt();
        int nB = sc.nextInt();

        if (nA < 0 || nA > 2) return;
        if (nB < 0 || nB > 2) return;

        long n = sc.nextLong();
        if (n < 3 || n > 20) return;

        BigInteger[] nT = new BigInteger[(int) n - 2];
        int nFinal = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0) {
                nT[0] = FibonacciModern(BigInteger.valueOf(nB), BigInteger.valueOf(nA));
            } else if (i == 1) {
                nT[1] = FibonacciModern(nT[0], BigInteger.valueOf(nB));
            } else {
                nT[i] = FibonacciModern(nT[i - 1], nT[i - 2]);
            }
            nFinal = i;
        }
        System.out.println(nT[nFinal]);
    }

    static BigInteger FibonacciModern(BigInteger nT1, BigInteger nT0) {
        return nT1.pow(2).add(nT0);
    }

    // -------- Huffman decoding --------------
    static void decode(String S, Node root) {
        /*  A - 1
	        B - 00
	        C - 01  */
        StringBuilder output = new StringBuilder();

        Node base = root;
        char[] chArr = S.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '0') {
                base = base.left;
            } else {
                base = base.right;
            }
            if (base.left == null && base.right == null) {
                output.append(base.data);
                base = root;
            }
        }
    }

    // --- Perfect Array ------------
    public static void PerfectArray(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        int nNumOfSwaps = 0;
        boolean bEvenOrder = false;
        if (nArr[0] % 2 == 0) {
            for (int i = 2; i < n; i += 2) {
                if (nArr[i] % 2 != 0) {
                    int nTemp = nArr[i];
                    nArr[i] = nArr[i - 1];
                    nArr[i - 1] = nTemp;
                    nNumOfSwaps++;
                }
            }
        } else {
            for (int i = 1; i < n; i += 2) {
                if (nArr[i] % 2 == 0) {
                    int nTemp = nArr[i];
                    nArr[i] = nArr[i - 1];
                    nArr[i - 1] = nTemp;
                    nNumOfSwaps++;
                }
            }
        }

        //nNumOfSwaps = quickSort(nArr, 0, 3) -1;
        System.out.println(nNumOfSwaps);
        for (int i = 0; i < n; i++)
            System.out.print(nArr[i] + " ");
    }

    static void exchangeNumbers(int[] nArr, int i, int j) {
        int temp = nArr[i];
        nArr[i] = nArr[j];
        nArr[j] = temp;
        System.out.println("Swapped : " + nArr[i] + " with " + temp);
    }

    static int quickSort(int[] nArr, int lowerIndex, int higherIndex) {
        int nSwap = 0;
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = nArr[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (nArr[i] < pivot) {
                i++;
            }
            while (nArr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(nArr, i, j);
                nSwap++;
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            nSwap += quickSort(nArr, lowerIndex, j);
        if (i < higherIndex)
            nSwap += quickSort(nArr, i, higherIndex);

        return nSwap;
    }

    public static void GCDProblem(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];

        int[] nGCD = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
            nGCD[i] = getGCD(nArr[i], nArr[i]);
        }
    }

    private static int getGCD(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    // ---- Fibonacci with BigInteger --------------
    public static void BigFibonacci(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger nBig = fibonacci2(BigInteger.valueOf(n));
        System.out.println(nBig);
    }

    public static BigInteger fibonacci2(BigInteger n) {
        if (n == BigInteger.ONE || n == BigInteger.ZERO) {
            return BigInteger.ONE;
        }
        return n.multiply(fibonacci2(n.subtract(BigInteger.ONE)));
    }

    // --------- Alice and Candies -------------------
    public static void AliceAndCandies(String[] args) {

        //decode("1001011", new Node());
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();
        int[] nArr = new int[nSz];

        for (int i = 0; i < nSz; i++) {
            nArr[i] = sc.nextInt();
        }

        int nNumOfCandies = nSz; //one candy for each
        for (int i = 1; i < nSz; i += 2) {
            if (nArr[i] != nArr[i - 1])
                nNumOfCandies++;
        }

        System.out.println(nNumOfCandies);
    }

    // -------- Stock Maxsimize ---------------
    public static void StockMaximize(String[] srgs) {
        Scanner sc = new Scanner(System.in);
        long nT = sc.nextLong();

        while (nT > 0) {
            nT--;
            int nDays = sc.nextInt();
            long[] nStock = new long[nDays];

            for (int i = 0; i < nDays; i++) {
                nStock[i] = sc.nextInt();
            }

            long nProfit = 0;
            int nSartIndex = 0;
            int nMaxIndex = 0;
            long nMax = nStock[0];
            for (int i = 1; i < nDays; i++) {
                if (nMax < nStock[i]) {
                    nMax = nStock[i];
                    nMaxIndex = i;
                }

                if (i == nDays - 1) {
                    nProfit += GetProfit(nStock, nSartIndex, nMaxIndex);
                    nMax = 0;
                    nSartIndex = nMaxIndex + 1;
                    i = nMaxIndex;
                }
            }
            System.out.println(nProfit);
        }
    }

    static long GetProfit(long[] nStock, int nStart, int nEnd) {
        long nProfit = 0;
        int nShareCnt = 0;
        int nBuySum = 0;
        for (int i = nStart; i < nEnd; i++) {
            nShareCnt++;
            nBuySum += nStock[i];
        }

        nProfit += (nStock[nEnd] * nShareCnt) - nBuySum;
        return nProfit;
    }

    /// ---------- Print Example
    public static void PrintExample(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int nLines = sc.nextInt();
        for (int i = 0; i < nLines; i++) {
            for (int k = nLines - 1; k >= 0; k--) {
                if (i < k)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    // -------- Sum of contiguous and non-contiguous sub array --------
    public static void SumOfSubArrays(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nT = sc.nextInt();

        while (nT > 0) {
            nT--;

            int nSz = sc.nextInt();
            long[] nArr = new long[nSz];
            long nSum = 0; // sum of non-contiguous array
            for (int i = 0; i < nSz; i++) {
                nArr[i] = sc.nextLong();
                if (nArr[i] > 0)
                    nSum += nArr[i];
            }

            for (int i = 0; i < nSz; i++) {
                long nSzCon = 0;
                for (int k = 0; k < nSz; k++) {
                    //nSzCon
                }
            }

            System.out.print(nSum + " ");
            System.out.println(nSum);

        }
    }

    /// ------
    public static void Hackathon(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++)
            Operation(nArr, sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    static void Operation(int[] nArr, int x, int k, int type) {
        if (type == 0) {   // type == 0
            for (int i = 0; i < nArr.length; i++) {
                if (x <= nArr[i]) {
                    if (x < nArr[i]) i--;
                    if (i + k >= nArr.length) {
                        System.out.println(-1);
                        return;
                    } else {
                        System.out.println(nArr[i + k]);
                        return;
                    }
                }
            }
        } else {            // type == 1
            for (int i = 0; i < nArr.length; i++) {
                if (x <= nArr[i]) {
                    //if(x == nArr[i]) i++;
                    if (i - k >= nArr.length || i - k < 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        System.out.println(nArr[i - k]);
                        return;
                    }
                }
            }
        }
    }

    // ----
    static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static void printArray(int[] ar, int left, int right) {
        for (int n = left; n <= right; n++) {
            System.out.print(ar[n] + " ");
        }
        System.out.println();
    }

    static void quickSort(int[] ar) {
        partition(ar, 0, ar.length - 1);
    }

    static void partition(int[] ar, int left, int right) {
        int pivot = ar[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (ar[i] < pivot)
                i++;
            while (ar[j] > pivot)
                j--;

            if (i <= j) {
                swap(ar, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            printArray(ar);
            partition(ar, left, j);
        }
        if (i < right)
            partition(ar, i, right);

        //printArray(ar, left, right);
    }

    static void swap(int[] ar, int n, int k) {
        int nVal = ar[n];
        ar[n] = ar[k];
        ar[k] = nVal;
        //printArray(ar);
    }

    public static void Sorts(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        //insertionSort(ar);
        quickSort(ar);
    }

    /// Counting sort
    public static void CountingSort(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int sz = sc.nextInt();
            int apqCount = sc.nextInt();

            int[] nArr = new int[sz];
            for (int i = 0; i < sz; i++) {
                nArr[i] = sc.nextInt();
            }

            int[] aArr = new int[sz];
            int[] pArr = new int[sz];
            int[] qArr = new int[sz];
            for (int i = 0; i < apqCount; i++) {
                aArr[i] = sc.nextInt();
                pArr[i] = sc.nextInt();
                qArr[i] = sc.nextInt();
            }

            // operation
            for (int i = 0; i < apqCount; i++) {
                int a = aArr[i];
                int p = pArr[i] - 1;
                int q = qArr[i] - 1;

                if (q >= sz)
                    q = sz - 1;

                int nMaxVal = 0;
                for (int k = p; k <= q; k++) {
                    int nVal = a ^ nArr[k]; // XOR
                    if (nVal > nMaxVal)
                        nMaxVal = nVal;
                }

                System.out.println(nMaxVal);
            }
        }
    }

    //
    public static void SumOfArray(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sz = sc.nextInt();
            int[] nArr = new int[sz];

            int nSum1 = 0; // non-contiguous sum
            for (int i = 0; i < sz; i++) {
                nArr[i] = sc.nextInt();
                if (nArr[i] > 0)
                    nSum1 += nArr[i];
            }

            int nSum = GetSumOfContious(nArr);
            System.out.println(nSum + " " + nSum1);
        }
    }

    static int GetSumOfContious(int[] nArr) {
        int nMaxSum = 0;
        int nNegSum = 0, nPosSum = 0;
        boolean bNegFound = false;
        if (nArr[0] < 0) bNegFound = true;

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] < 0) {
                bNegFound = true;
                nNegSum += nArr[i];
                // nPosSum = 0;
            } else {
                if (bNegFound) {
                    bNegFound = false;

                    if (nNegSum + nPosSum > 0) {
                        nPosSum = (nNegSum + nPosSum);
                        nNegSum = 0;
                    } else
                        nPosSum = 0;
                }
                nPosSum += nArr[i];
                if (nPosSum > nMaxSum)
                    nMaxSum = nPosSum;
            }
        }

        return nMaxSum;
    }

    //
    public static void StringToInt(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sNum = sc.nextLine();

        int nNum = ParseString(sNum);
        System.out.println(nNum);
    }

    static int ParseString(String sNum) {
        int nNum = 0;
        int nLength = sNum.length();
        char[] chArr = sNum.toCharArray();
        int k = nLength - 1;
        for (int i = 0; i < nLength; i++) {
            nNum += GetNum(chArr[k - i]) * Math.pow(10, i);
        }

        return nNum;
    }

    static int GetNum(char ch) {
        int nNum = 0;
        while (nNum < 10) {
            if (String.valueOf(nNum).compareTo(ch + "") == 0)
                break;
            nNum++;
        }
        return nNum;
    }

    // Fibonacci Separation
    public static void FibonacciSeparation(String args[]) {
        isFibonacci(10);

        LinkedList<Integer> llist = new LinkedList<Integer>();
        llist.add(10);
        llist.add(15);
        llist.add(1);
        llist.add(3);
        llist.add(5);
        llist.add(17);
        separateLinkedList(llist);
    }

    public static void separateLinkedList(LinkedList<Integer> llist) {

        if (llist == null) {
            return;
        }

        LinkedList<Integer> fibSeriesList = new LinkedList<Integer>();
        LinkedList<Integer> noSeriesList = new LinkedList<Integer>();

        Iterator<Integer> ll = llist.iterator();
        int num = -1;
        while (ll.hasNext()) {
            num = ll.next();
            if (isFibonacci(num)) {
                fibSeriesList.add(num);
            } else {
                noSeriesList.add(num);
            }
        }

        System.out.println(fibSeriesList);
        System.out.println(noSeriesList);
    }

    public static boolean isFibonacci(int num) {

        int num1 = 5 * num * num - 4;
        int num2 = 5 * num * num + 4;
        boolean result = isPerfectSqr(num1) || isPerfectSqr(num2);
        System.out.println("Run Fibonacci Test > " + num + " | Result > " + result);
        return result;

    }

    public static boolean isPerfectSqr(int num) {

        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // Bigger is Greater
    public static void BiggerIsGreater(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String w = sc.nextLine();
            if (w.length() <= 1) {
                System.out.println("no answer");
                continue;
            }

            char[] chArr = w.toCharArray();

            String s = GetMinString(chArr);
            System.out.println(s);
        }
    }

    static String GetMinString(char[] chArr) {
        String str = "";
        int i = chArr.length - 1;
        while (i > 0 && chArr[i] <= chArr[i - 1]) {
            i--;
        }

        char ch = chArr[i];
        if (i != 0) i--;
        SortCharArray(chArr, i, chArr.length - 1);

        str = new String(chArr);
        return str;
    }

    static void SortCharArray(char[] chArr, int left, int right) {
        int pivot = chArr[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (chArr[i] < pivot)
                i++;
            while (chArr[j] > pivot)
                j--;

            if (i <= j) {
                swap(chArr, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            SortCharArray(chArr, left, j);
        }
        if (i < right)
            SortCharArray(chArr, i, right);
    }

    static void swap(char[] chArr, int n, int k) {
        char temp = chArr[n];
        chArr[n] = chArr[k];
        chArr[k] = temp;
    }

    // Palindrome
    public static void Palindrome(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sLine = sc.nextLine().replaceAll("\\s", "");
        System.out.println(IsPalindrome(sLine) ? "Y" : "N");
    }

    public static boolean IsPalindrome(String str) {
        char[] chArr = str.toCharArray();
        int i = 0, j = chArr.length - 1, n = chArr.length / 2;
        while (i < n) {
            if (Character.toLowerCase(chArr[i]) != Character.toLowerCase(chArr[j]))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Minimum Platform count
    public static void MaxPlatformCount(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (0 >= n || n >= 1000) return;

        ArrayList<TrainTime> nList = new ArrayList<TrainTime>();
        Comparator<TrainTime> comparator = new Comparator<TrainTime>() {
            @Override
            public int compare(TrainTime o1, TrainTime o2) {
                return o1.time - o2.time;
            }
        };

        while (n > 0) {
            n--;
            int nArrNew = sc.nextInt();
            int nDepNew = sc.nextInt();
            if (nArrNew < 0 || nArrNew > nDepNew || nDepNew > 2359) return;
            nList.add(new TrainTime('A', nArrNew));
            nList.add(new TrainTime('D', nDepNew));
        }

        // sorting if there are some un-ordered input arrival times
        Collections.sort(nList, comparator);

        int nCount = 0;
        int nMax = 0;
        for (int i = 0; i < nList.size(); i++) {
            TrainTime t = nList.get(i);
            //System.out.println(t.sign + " " + t.time);
            if (t.sign == 'A')
                nCount++; // arrived
            else
                nCount--; // departured
            if (nMax < nCount)
                nMax = nCount;
        }

        System.out.println(nMax);
    }

    public static void SparseArray(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        *   1≤N≤1000
            1≤Q≤1000
            1≤ length of any string≤20
        */

        int nSz1 = sc.nextInt();
        sc.nextLine();
        if (nSz1 < 1 || nSz1 > 1000) return;

        String[] strArr1 = new String[nSz1];
        int i = 0;
        while (i < nSz1) {
            strArr1[i] = sc.nextLine();
            if (strArr1[i].length() > 20) return;
            i++;
        }

        int nSz2 = sc.nextInt();
        sc.nextLine();
        if (nSz2 < 1 || nSz2 > 1000) return;
        String[] strArr2 = new String[nSz2];
        i = 0;
        while (i < nSz2) {
            strArr2[i] = sc.nextLine();
            if (strArr2[i].length() > 20) return;
            i++;
        }

        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Arrays.sort(strArr1, myComparator);
        //Arrays.sort(strArr2, myComparator);

        int nCounter = 0;
        boolean bFound = false;
        for (int m = 0; m < nSz2; m++) {
            String str2 = strArr2[m];
            for (int n = 0; n < nSz1; n++) { // Sorted String Array iteration
                String str1 = strArr1[n];
                if (str1.equals(str2)) {
                    bFound = true;
                    nCounter++;
                } else {
                    if (bFound) break;
                }
            }
            System.out.println(nCounter);
            nCounter = 0;
            bFound = false;
        }
    }

    public static void QHEAP1() {
        Scanner sc = new Scanner(System.in);
        int nTest = sc.nextInt();

        Queue<Queries> queries = new LinkedList<>();
        while (nTest > 0) {
            nTest--;

            long nVal = 0;
            int nType = sc.nextInt();

            if (nType != 3)
                nVal = sc.nextLong();
            queries.add(new Queries(nType, nVal));
        }

        PriorityQueue<Long> qList = new PriorityQueue<>();
        while (!queries.isEmpty()) {
            Queries q = queries.poll();
            switch (q.nType) {
                case 1: // insert
                    qList.add(q.data);
                    break;
                case 2: // remove
                    qList.remove(q.data);
                    break;
                case 3: // print minimum
                    long nVal = qList.poll();
                    System.out.println(nVal);
                    qList.add(nVal);
                    break;
            }
        }
    }

    public static void TreeQuery() {
        /* Input
        8 4
        1 2 3 4 5 6 7 8
        1 2 4
        2 3 5
        1 4 7
        2 1 4
        */
        /* Output
        1
        2 3 6 5 7 8 4 1
        */
        Scanner sc = new Scanner(System.in);
        int nArrSz = sc.nextInt();
        int nQueries = sc.nextInt();

        LinkedList<Integer> nList = new LinkedList<>(); // Tree
        for (int i = 0; i < nArrSz; i++) {
            nList.add(sc.nextInt());
        }

        Queue<Queries> nQueues = new LinkedList<>();
        while (nQueries > 0) {
            Queries q = new Queries(sc.nextInt(), sc.nextInt() - 1, sc.nextInt() - 1);
            nQueues.add(q);
            nQueries--;
        }

        while (nQueues.size() > 0) {
            Queries q = nQueues.poll();

            if (q.nType == 1) {   // add i~j to front
                for (int i = q.j; i >= q.i; i--) {
                    int n = nList.remove(q.j);
                    nList.add(0, n);
                }
            } else {             // move i~j to back
                for (int i = q.i; i <= q.j; i++) {
                    int n = nList.remove(q.i);
                    nList.add(n);
                }
            }
        }

        System.out.println(Math.abs(nList.get(nList.size() - 1) - nList.get(0)));
        for (int i = 0; i < nList.size(); i++)
            System.out.print(nList.get(i) + " ");
    }

    public static void task1() {
        Scanner sc = new Scanner(System.in);
        int cWidth = sc.nextInt();
        int cHeight = sc.nextInt();

        int nLength = sc.nextInt();
        int[] nArrX = new int[nLength];
        int[] nArrY = new int[nLength];
        int i = 0;
        while (i < nLength) {
            nArrX[i] = sc.nextInt() - 1;
            nArrY[i] = sc.nextInt() - 1;
            i++;
        }

        for (int y = 0; y < cHeight; y++) {
            for (int x = 0; x < cWidth; x++) {
                i = 0;
                int nMin = Integer.MAX_VALUE;
                while (i < nLength) {
                    int n = Math.abs(x - nArrX[i]) + Math.abs(y - nArrY[i]);
                    i++;
                    if (nMin > n)
                        nMin = n;
                }
                System.out.print(nMin);
            }
            System.out.println();
        }
    }

    // Find Median Solution
    public static void FindMedian() {
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();

        PriorityQueue<Double> nQueue = new PriorityQueue<>();
        while (nSz > 0) {
            nQueue.add((double) sc.nextInt());

            if (nQueue.size() == 1)
                System.out.println(nQueue.peek());
            else if (nQueue.size() == 2) {
                Object[] ob = nQueue.toArray();
                double dVal = ((double) ob[0] + (double) ob[1]) / 2;
                System.out.format("%.1f%n", dVal);
            } else
                System.out.format("%.1f%n", GetMean(nQueue));
            nSz--;
        }
    }

    public static double GetMean(PriorityQueue<Double> pQueue) {
        Object[] ob = pQueue.toArray();
        double dVal = 0;
        dVal = (double) ob[pQueue.size() / 2];
        int nMod = pQueue.size() % 2;
        if (nMod != 1)
            dVal = (dVal + (double) ob[pQueue.size() / 2 - 1]) / 2;
        return dVal;
    }

    // choco equal solution
    public static void ChocolateDistribute() {
        Scanner sc = new Scanner(System.in);
        int nTest = sc.nextInt();

        while (nTest > 0) {
            nTest--;
            int nSz = sc.nextInt();

            TreeSet<Integer> nSet = new TreeSet<>();
            for (int i = 0; i < nSz; i++) {
                int nVal = sc.nextInt();
                nSet.add(nVal);
            }

            int nCount = 0;
            while (!IsEqual(nSet)) {
                nSet = DistributeChoco(nSet);
                //print_tree(nSet);
                nCount++;
            }

            System.out.println(nCount);
        }
    }

    static TreeSet<Integer> DistributeChoco(TreeSet<Integer> tree) {
        TreeSet<Integer> nSet = new TreeSet<>();

        int nDelta = tree.last() - tree.first();
        if (nDelta > 5) nDelta = 5;
        else if (nDelta > 2 && nDelta < 5) nDelta = 2;

        nSet.add(tree.pollLast());
        int nSz = tree.size();
        for (int i = 0; i < nSz; i++) {
            int nVal = tree.pollFirst();
            nSet.add(nVal + nDelta);
        }

        return nSet;
    }

    static boolean IsEqual(TreeSet<Integer> sSet) {
        if (sSet.size() < 2) return true;
        Iterator iter = sSet.iterator();
        Object nVal = iter.next();
        while (iter.hasNext()) {
            if (iter.next() != nVal) return false;
        }

        return true;
    }

    static void print_tree(TreeSet<Integer> sSet) {
        Iterator<Integer> iter = sSet.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    // Matrix Rotation
    public static void RotateMatrix() {
        Scanner sc = new Scanner(System.in);

        int nCol = sc.nextInt();
        int nRow = sc.nextInt();
        int nRotate = sc.nextInt();

        int nCyc = Math.min(nRow, nCol);
        if (nCyc % 2 != 0) return;
        nCyc = nCyc / 2;
        // validation
        if (nRow < 2 || nRow > 300) return;
        if (nCol < 2 || nCol > 300) return;
        if (nRotate < 1 || nRotate > 1000000000) return;

        int[][] nArr = new int[nCol][nRow];
        for (int col = 0; col < nCol; col++) {
            for (int row = 0; row < nRow; row++) {
                nArr[col][row] = sc.nextInt();
                // validation
                if (nArr[col][row] < 1 || nArr[col][row] > 100000000) return;
            }
        }

        // escape repeated rotations
        nRotate = nRotate % (nCol * nRow);

        for (int rot = 0; rot < nRotate; rot++) {
            for (int nCycle = 0; nCycle < nCyc; nCycle++) {
                int col = nCycle, row = nCycle;
                int nTemp = nArr[col][row];

                // X axis right
                for (row = nCycle; row < nRow - nCycle - 1; row++) {
                    nArr[col][row] = nArr[col][row + 1];
                }

                print_array(nArr, nRow, nCol);
                // Y axis down
                for (col = nCycle; col < nCol - nCycle - 1; col++) {
                    nArr[col][row] = nArr[col + 1][row];
                }

                print_array(nArr, nRow, nCol);
                // X axis left
                for (row = nRow - nCycle - 1; row > nCycle; row--) {
                    nArr[col][row] = nArr[col][row - 1];
                }

                print_array(nArr, nRow, nCol);
                // Y axis up
                for (col = nCol - nCycle - 1; col > nCycle; col--) {
                    nArr[col][row] = nArr[col - 1][row];
                }
                nArr[col + 1][row] = nTemp;
                print_array(nArr, nRow, nCol);
            }
        }
    }

    static void print_array(int[][] nArr, int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(nArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void DequeProblem() {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }

        //System.out.println("----- START -----");

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        Queue<Integer> queInner = new LinkedList<Integer>();

        Iterator it = deque.iterator();
        int i = 0;

        boolean bInit = false;
        Set<Integer> set = new TreeSet<>();
        while (it.hasNext()) {
            int nVal = 0;
            while (i < m && it.hasNext()) {
                nVal = (int) it.next();
                queInner.add(nVal);
                i++;
            }

            // decrement i to get next sub array value
            --i;

            set = new HashSet<>(queInner);
            pQueue.add(set.size());
            queInner.remove();
            if (set.size() == m)
                break;
        }


        System.out.println(pQueue.poll());
    }

    private static long complement(long num) {
        long maxInt = (long) Math.pow(2, 32) - 1;
        return maxInt - num;
    }

    static int countRepeatVisitors(List<LogEntry> logEntries) {
        if (logEntries == null || logEntries.size() <= 0) return 0;

        Map<String, List<String>> entryMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < logEntries.size(); i++) {
            String date = logEntries.get(i).getDate();
            String user = logEntries.get(i).getName();

            if (!entryMap.containsKey(user)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(date);
                entryMap.put(user, tmp);
            } else {
                if (!entryMap.get(user).contains(date)) {
                    //System.out.println(user);
                    count++;
                    List<String> tmp = new ArrayList<>();
                    tmp.add(date);
                    entryMap.put(user, tmp);
                }
            }
        }

        return count;
    }

    public static void AmazonTxProblem() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<LogEntry> nLog = new ArrayList<LogEntry>();

        for (int i = 0; i < n; i++) {
            String strLine = sc.nextLine();
            String[] sArr = strLine.split(" ");

            String dt = sArr[0];
            String strName = sArr[1];

            LogEntry entry = new LogEntry(dt, strName);
            if (!nLog.contains(entry))
                nLog.add(entry);
        }
        countRepeatVisitors(nLog);
    }

    public static void main(String[] args) {

        //AmazonTxProblem();

        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        System.out.println(complement(l));

        /*
        boolean[] bytes = IntToByteArray(n);

        for (int i=0; i<32; i++){
            bytes[i] = !bytes[i];
        }
        System.out.println(BitArrToInteger(bytes) * 2);
        */
    }

    public void Java_Output_Formatting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            s1 = getFifteenChars(s1);
            int x = sc.nextInt();
            //Complete this line
            System.out.println(s1 + String.format("%1$03d", x));
        }
        System.out.println("================================");

    }

    //-----------------------------------------
    public void JavaLoop() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int t1 = t;
        Queue<Integer> fifo = new LinkedList<Integer>();
        while (t > 0) {
            String strLine = sc.nextLine();
            int a = Integer.parseInt(strLine.split(" ")[0]);
            if (a < 0 || a > 50) {
                System.out.println("You entered wrong a.");
                return;
            }

            int b = Integer.parseInt(strLine.split(" ")[1]);
            if (b < 0 || b > 50) {
                System.out.println("You entered wrong b.");
                return;
            }

            int n = Integer.parseInt(strLine.split(" ")[2]);
            if (n < 1 || n > 15) {
                System.out.println("You entered wrong n.");
                return;
            }
            fifo.add(a);
            fifo.add(b);
            fifo.add(n);
            t--;
        }

        while (t1 > 0) {
            Calculate(fifo.poll(), fifo.poll(), fifo.poll());
            System.out.println();
            t1--;
        }
    }

    // ------------------------------------------------------
    public void DatTypes() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            long x = 0;
            try {
                x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) System.out.println("* byte");
                if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) System.out.println("* short");
                if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) System.out.println("* int");
                if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) System.out.println("* long");
            } catch (Exception ex) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
            t--;
        }
    }

    public void Java_EOF() {
        Scanner userInput = new Scanner(System.in);
        int lineNum = 1;
        while (userInput.hasNextLine()) {
            if (userInput.hasNext()) {
                System.out.println(lineNum + " " + userInput.nextLine());
                lineNum++;
            }
        }
    }
}

class LogEntry {
    private String date;
    private String name;

    LogEntry(String dt, String name) {
        this.date = dt;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}

class Queries {
    int nType;
    int i, j;
    long data;
    Queries(int type, long data) {
        this.nType = type;
        this.data = data;
    }
    Queries(int type, int idx, int jdx) {
        this.nType = type;
        this.i = idx;
        this.j = jdx;
    }
}

class TrainTime {
    public char sign;
    public int time;
    TrainTime(char ch, int t) {
        this.sign = ch;
        this.time = t;
    }
}
