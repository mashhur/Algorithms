package AmznInterviews.mashhur;

import java.util.*;

/**
 * Created by mashhur on 1/15/17.
 */

class Movie{
    private int movieId;
    private float rating;
    private ArrayList similarMovies;

    public Movie(int movieId, float rating){
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getId(){
        return movieId;
    }

    public float getRating(){
        return rating;
    }

    public void addSimilarMovie(Movie movie) {}

    public List getSimilarMovies() {
        return similarMovies;
    }
}

public class MoviePriority {

    public static void main(String args[]){

        System.out.println(totalScore(new String[]{"1", "2", "+", "Z"}, 4));
    }

    public Set<Movie> getMovieRecommendations (Movie movie, int N)
    {
        // WRITE YOUR CODE HERE
        List<Movie> list = movie.getSimilarMovies();

        Collections.sort(list, new Comparator<Movie>(){
            @Override
            public int compare(Movie m1, Movie m2){
                if(m1.getRating() > m2.getRating())
                    return 1;
                else if(m1.getRating() < m2.getRating())
                    return -1;
                return 0;
            }
        });
        int n = list.size() > N ? N : list.size();
        @SuppressWarnings("unchecked")
        Set<Movie> orderedSet = new HashSet<Movie>(list.subList(0,n));
        return orderedSet;
    }

    public static int totalScore(String[] blocks, int n)
    {
        int nTotalScore = 0;
        int nLastScore = 0;
        int nPrevScore = 0;
        for(int i=0; i<n; i++){
            //System.out.println(blocks[i]);
            if(blocks[i].equals("X")){
                nTotalScore = nTotalScore*nTotalScore;
            } else if(blocks[i].equals("+")){
                nPrevScore = nLastScore;
                nLastScore = nTotalScore;
                nTotalScore += nLastScore;
                nTotalScore += nPrevScore;
            } else if(blocks[i].equals("Z")){
                nTotalScore -= nLastScore;
                nPrevScore = nLastScore;
                nLastScore = nTotalScore;
            } else{
                    try {
                        int nVal = Integer.parseInt(blocks[i]);
                        nPrevScore = nLastScore;
                        nLastScore = nVal;
                        nTotalScore += nVal;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            //System.out.println("Block: " + blocks[i]);
            //System.out.println("Total: " + nTotalScore);
            System.out.println("Prev: " + nPrevScore);
            System.out.println("Last: " + nLastScore);
        }

        return nTotalScore;
    }

}
