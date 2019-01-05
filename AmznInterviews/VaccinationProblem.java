package AmznInterviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by MIK on 11/1/2015.
 */

class City{
    int nPopulation;
    int nClinics;
    int nLoad;
}

public class VaccinationProblem {
    public static void VaccinationProblem2(String[] args) {
        Scanner in = new Scanner(System.in);
        Comparator<City> CITYASC = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.nLoad - o2.nLoad;
            }
        };
        int numOfCities, numOfClinics;

        numOfCities = in.nextInt();
        numOfClinics = in.nextInt();

        City[] cities = new City[numOfCities];


        for(int i = 0; i < numOfCities; i++) {
            City c = new City();
            c.nPopulation = in.nextInt();
            /* Initial load per clinic is total population of city */
            c.nLoad = c.nPopulation;
            /* assign one clinic per city */
            c.nClinics = 1;
            cities[i] = c;
        }


        /* sort on the basis of load per clinic in increasing order*/
        Arrays.sort(cities, CITYASC);

        /* assign one remaining clinic to the city
        * having highest load (array is sorted in increasing
        * order) in each iteration to reduce the max load
        */

        for(int i = 0; i < (numOfClinics - numOfCities); i++) {
            cities[numOfCities - 1].nClinics++;
            cities[numOfCities - 1].nLoad = cities[numOfCities - 1].nPopulation / cities[numOfCities - 1].nClinics;

            /* population=1001 and clinics=2 then load=501 */
            if(cities[numOfCities - 1].nPopulation % cities[numOfCities - 1].nClinics != 0) {
                cities[numOfCities - 1].nLoad++;

            }


            /* Keep the array sorted in increasing order of load */
            Arrays.sort(cities, CITYASC);
        }

        System.out.println(cities[numOfCities - 1].nLoad);
    }
}
