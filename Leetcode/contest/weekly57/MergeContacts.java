package Leetcode.contest.weekly57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mashhur on 11/5/17.
 */
public class MergeContacts {

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnnybravo@mail.com");

        List<String> account3 = new ArrayList<>();
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");

        List<String> account4 = new ArrayList<>();
        account4.add("Mary");
        account4.add("mary@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            if (account.contains("delete"))
                continue;

            for (int k = i + 1; k < accounts.size(); k++) {
                List<String> account_next = accounts.get(k);

                // same account found
                if (account_next.contains("delete") || account.get(0) != account_next.get(0))
                    continue;

                List<String> temp = new ArrayList<>(account);
                boolean bMerge = false;
                for (int j = 1; j < account_next.size(); j++) { // index 0-> Name
                    if (account.contains(account_next.get(j))) // delete
                        bMerge = true;
                    else
                        temp.add(account_next.get(j));
                }

                if (bMerge) {
                    Collections.sort(temp);
                    accounts.set(i, temp);
                    account_next.add("delete");
                }
            }
        }

        Iterator<List<String>> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            List<String> account = iterator.next();
            if (account.contains("delete"))
                iterator.remove();
        }

        return accounts;
    }
}
