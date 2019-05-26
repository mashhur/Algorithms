package Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 2/8/17.
 */
public class RegExProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> nListName = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] sLine = sc.nextLine().split(" ");
            String sName = sLine[0];
            String sEmail = sLine[1];
            if (sEmail.contains("@gmail.com")) {
                nListName.add(sName);
            }
        }

        Collections.sort(nListName);
        for (String name : nListName) {
            System.out.println(name);
        }
    }
}
