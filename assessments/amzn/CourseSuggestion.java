package assessments.amzn; /**
 * Created by MIK on 1/23/2016.
 */

import java.util.*;

/*
example visuals

All users and friends:
abdulla:{ anne, david,  }
anne:{ david, abdulla, andrew, john,  }
john:{ anne, nick,  }
david:{ abdulla, anne, nick,  }
nick:{ john, david,  }
andrew:{ anne,  }
----------------------

1. cloud computing -- newest course
2. software testing
3. artificial intelligence
4. multimedia
5. statistics
6. operating systems
7. calculus
8. differential calculus
9. linear algebra
10. combinatorics -- oldest course


All users and courses:
abdulla:{ artificial intelligence, differential calculus,}
anne:{ statistics, calculus, linear algebra, combinatorics,  }
john:{ cloud computing, multimedia, calculus, linear algebra,   }
david:{ operating systems, differential calculus,   }
brian:{ cloud computing, software testing, artificial intelligence, multimedia,  }
andrew:{ cloud computing, operating systems, calculus, differential calculus,   }
-- level 3
eddie:{ calculus, differential calculus, linear algebra,  }
kim:{ statistics, operating systems, calculus,  }
nash:{ multimedia, differential calculus, combinatorics,  }

(abdulla) - (david-l1)
       \   /      \
     (anne-l1)  (brian-l2)
       /     \     /     \
(andrew-l2) (john-l2) -  (eddie-l3)
     /         /
(kim-l3) - (nash-l3)


*/

//provided
//getDirectFriendsForUser(user)
//getAttendedCoursesForUser(user)
public class CourseSuggestion {

    Map<String,List<String>> userAndCourses;
    Map<String,List<String>> userAndFriends;

    Map<String,List<String>> createUsersAndCourses(){
        //just for easy of test we create hardcoded dictionary values
        //ideally need to create random assigned student name & course names
        userAndCourses = new HashMap<String,List<String>>();

        List<String> lAttendedCourses1 = new ArrayList<String>();
        lAttendedCourses1.add("artificial intelligence");
        lAttendedCourses1.add("differential calculus");
        userAndCourses.put("abdulla", lAttendedCourses1);

        List<String> lAttendedCourses2 = new ArrayList<String>();
        lAttendedCourses2.add("statistics");
        lAttendedCourses2.add("calculus");
        lAttendedCourses2.add("linear algebra");
        lAttendedCourses2.add("combinatorics");
        userAndCourses.put("anne", lAttendedCourses2);

        List<String> lAttendedCourses3 = new ArrayList<String>();
        lAttendedCourses3.add("operating systems");
        lAttendedCourses3.add("differential calculus");
        userAndCourses.put("david", lAttendedCourses3);

        List<String> lAttendedCourses4 = new ArrayList<String>();
        lAttendedCourses4.add("multimedia");
        lAttendedCourses4.add("software testing");
        lAttendedCourses4.add("artificial intelligence");
        lAttendedCourses4.add("cloud computing");
        userAndCourses.put("nick", lAttendedCourses4);

        List<String> lAttendedCourses5 = new ArrayList<String>();
        lAttendedCourses5.add("cloud computing");
        lAttendedCourses5.add("differential calculus");
        lAttendedCourses5.add("operating systems");
        lAttendedCourses5.add("calculus");
        userAndCourses.put("andrew", lAttendedCourses5);

        List<String> lAttendedCourses6 = new ArrayList<String>();
        lAttendedCourses6.add("linear algebra");
        lAttendedCourses6.add("calculus");
        lAttendedCourses6.add("cloud computing");
        lAttendedCourses6.add("multimedia");
        userAndCourses.put("john", lAttendedCourses6);

        return userAndCourses;
    }

    Map<String,List<String>> createFriendsForUsers(){
        //Map<String,list<String>> friendsDB = new HashMap<String,list<String>>();
        userAndFriends = new HashMap<String,List<String>>();
        //just for easy of test we create hard-coded dictionary values
        //ideally need to create random assigned student name & course names
        List<String> shavkatFriends= new ArrayList<String>();
        shavkatFriends.add("anne");
        shavkatFriends.add("david");
        userAndFriends.put("abdulla", shavkatFriends);

        List<String> anneFriends= new ArrayList<String>();
        anneFriends.add("david");
        anneFriends.add("abdulla");
        anneFriends.add("andrew");
        anneFriends.add("john");
        userAndFriends.put("anne", anneFriends);

        List<String> davidFriends = new ArrayList<String>();
        davidFriends.add("abdulla");
        davidFriends.add("anne");
        davidFriends.add("nick");
        userAndFriends.put("david", davidFriends);

        List<String> brianFriends= new ArrayList<String>();
        brianFriends.add("john");
        brianFriends.add("david");
        userAndFriends.put("nick", brianFriends);

        List<String> andrewFriends= new ArrayList<String>();
        andrewFriends.add("anne");
        userAndFriends.put("andrew", andrewFriends);

        List<String> johnFriends = new ArrayList<String>();
        johnFriends.add("anne");
        johnFriends.add("nick");
        userAndFriends.put("john", johnFriends);

        return userAndFriends;
    }

    void createAllUsersAndCourses(){
        createFriendsForUsers();
        createUsersAndCourses();
    }

    void printAllFriendsAndCourses(){
        System.out.println("All users and friends:");
        List<String> lFriends = new ArrayList<String>();
        for (String user : userAndFriends.keySet()) {
            lFriends = userAndFriends.get(user);
            System.out.print(user + ":{ ");
            for (String friend : lFriends) {
                System.out.print(friend + ", ");
            }
            System.out.print(" } \n");
        }

        System.out.println("----------------------");

        System.out.println("All users and courses:");
        List<String> lCourses = new ArrayList<String>();
        for (String user : userAndCourses.keySet()) {
            lCourses = userAndCourses.get(user);
            System.out.print(user + ":{ ");
            for (String course : lCourses) {
                System.out.print(course + ", ");
            }
            System.out.print(" } \n");
        }

        System.out.println("----------------------");

    }

    public List<String> getDirectFriendsForUser(String user){
        if(userAndFriends.isEmpty())
            createFriendsForUsers();
        List<String> lDirectFriends = userAndFriends.get(user);
        return lDirectFriends;
    }
    public List<String> getAttendedCoursesForUser(String user){
        if(userAndCourses.isEmpty())
            createUsersAndCourses();
        List<String> lCourses = userAndCourses.get(user);
        return lCourses;
    }

    public List<String> recommendedForUser(String user) {
        Queue<String> toTraverse = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> mapCourses = new HashMap<>();

        //keep all courses sorted by attendance, ex: {Math,5}; {Physics,3};....
        PriorityQueue<RankedCourse> pqCoursesByRank = new PriorityQueue<>(20, Collections.reverseOrder());
        //start from current user
        toTraverse.add(user);
        int level = 0;

        while(!toTraverse.isEmpty()) {
            level++;
            String current = toTraverse.remove();
            List<String> lFriends = getDirectFriendsForUser(current);//friends={anne.david}


            ListIterator<String> it = lFriends.listIterator(lFriends.size());
            while(it.hasPrevious()) {
                String next = it.previous();
                if(!visited.contains(next)) {
                    visited.add(next);
                    toTraverse.add(next);
                    List<String> lAttendedCources = getAttendedCoursesForUser(next); //user -> next
                    for(String c : lAttendedCources) {
                        if(!mapCourses.containsKey(c)) {
                            mapCourses.put(c, 1);
                        } else {
                            mapCourses.put(c, mapCourses.get(c) + 1);
                        }
                    }
                }
            }
        }
        System.out.println("checking map of courses:");
        for(Map.Entry<String, Integer> entry : mapCourses.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
            RankedCourse c = new RankedCourse(entry.getKey(), entry.getValue());
            pqCoursesByRank.add(c);
        }

        List<String> lRecomended = new ArrayList<String>();
        System.out.println("checking recommended list by highest:");
        List<String> lExceptCourses = getAttendedCoursesForUser(user);

        while(!pqCoursesByRank.isEmpty()){
            RankedCourse c = pqCoursesByRank.poll();
            if(!lExceptCourses.contains(c.name))
                lRecomended.add(c.name);
            System.out.println(c.name + " : " + c.attended);
        }
        return lRecomended;
    }

    static class RankedCourse implements Comparable<RankedCourse> {
        String name;
        int attended;

        public RankedCourse(String n, int a) {
            name = n;
            attended = a;
        }

        @Override
        public int compareTo(RankedCourse o) {
            return this.attended - o.attended;
        }
    }

    /*
    * My logic
    */

    public List<String> getRankedCourses(String user) {
        // Set to store unique users in a Network,
        // if there are common friends in a direct friends social network
        // Set ignores duplicate common friends and saves only one user name
        Set<String> setFriends = new HashSet<>();
        List<String> lstMyCourses = getAttendedCoursesForUser(user); // user attended courses

        // get direct friends and direct friends of direct friends
        // only 2 depth Social Network friends considered
        for(String strFriend : getDirectFriendsForUser(user)){
            setFriends.add(strFriend);

            List<String> lst = getDirectFriendsForUser(strFriend); // my direct friends of direct friends
            for (String strFriend2:lst) {
                setFriends.add(strFriend2);
            }
        }

        // store two depth direct friends' name to Set to avoid common friends collision
        for (String strNetwok: setFriends) {
            System.out.println(strNetwok);
        }

        // a map to store all courses to get ranked
        Map<String, Integer> lstAllCources = new HashMap<String, Integer>();

        // get attended courses by direct friend name
        // loop : courses
        // insert if the course is not stored (where rank's initial value is 1) in map
        // increase the rank & update if already stores a course
        for (String strNetwok: setFriends) {
            List<String> lstFriendCourses = getAttendedCoursesForUser(strNetwok);
            for (String strCourse: lstFriendCourses) {
                if(lstMyCourses.contains(strCourse))
                    continue; // the course I have taken

                if(!lstAllCources.containsKey(strCourse))
                    lstAllCources.put(strCourse, 1);
                else { // increase a course rank
                    int nVal = lstAllCources.get(strCourse) + 1;
                    lstAllCources.put(strCourse, nVal);
                }
            }
        }

        // sort the map by value
        // copy all values of the map to return list
        List<String> lstRankedCourses = new ArrayList<>(); // ranked course
        lstAllCources = sortMap(lstAllCources);
        for (Map.Entry<String, Integer> entry : lstAllCources.entrySet()) {
            String sVal = entry.getValue().toString();
            System.out.println("Key : " + entry.getKey() + "    -----   Value : " + sVal);
            lstRankedCourses.add(sVal);
        }

        return lstRankedCourses;
    }

    private static Map<String, Integer> sortMap(Map<String, Integer> nMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(nMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}