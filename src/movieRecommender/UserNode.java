package movieRecommender;

import java.util.Iterator;

/** UserNode. The class represents a node in the UsersList.
 *  Stores a userId, a list of ratings of type MovieRatingsList,
 *  and a reference to the "next" user in the list.
 *  FILL IN CODE in methods getFavoriteMovies and getLeastFavoriteMovies
 *
 *  Do not modify signatures of methods.
 *  */
public class UserNode {
    private int userId;
    private MovieRatingsList movieRatings;
    private UserNode nextUser;


    public MovieRatingsList getMovieRatings() {
        return movieRatings;
    }

    /** A constructor for the UserNode.
     * @param id 	User id
     * */
    public UserNode(int id) {
        userId = id;
        movieRatings = new MovieRatingsList();
        nextUser = null;
    }
// getMovieRatingsList method - want to return movieRatingsList
// Insert the movie into the list using movieRatingsList.insertByRating();
    /**
     * Getter for the next reference
     * @return the next node in the linked list of users
     */
    public UserNode next() {
        return nextUser;
    }

    /**
     * Setter for the next reference
     * @param anotherUserNode A user node
     */
    public void setNext(UserNode anotherUserNode) {
        this.nextUser = anotherUserNode;
    }

    /** Return a userId stored in this node */
    public int getId() {
        return userId;
    }

    /** Print info contained in this node:
     *  userId and a list of ratings.
     *  Expected format: (userid) movieId:rating; movieId:rating; movieId:rating; */
    public void print() {
        System.out.print("(" + userId + ") ");
        movieRatings.print();

    }

    public String toString() {

        String list = "";

        list += "(" + userId + ")" + movieRatings.toString();


//        Iterator it = movieRatings.iterator();
//        MovieRatingNode current = null;
//
//        while (it.hasNext())
//        {
//            current = (MovieRatingNode) it.next();
//            list += "(" + userId + ")" + movieRatings.toString() + ";";
////            System.out.println("hello");
//
//        }
//        System.out.println(list);






        return  list;



    }


    /**
     * Add rating info for a given movie to the MovieRatingsList
     *  for this user node
     *
     * @param movieId id of the movie
     * @param rating  rating of the movie
     */
    public void insert(int movieId, double rating)
    {
        movieRatings.insertByRating(movieId, rating);

    }

    /**
     * Returns an array of user's favorite movies (up to n). These are the
     * movies that this user gave the rating of 5.
     *
     * @param n  the maximum number of movies to return
     * @return array containing movie ids of movies rated as 5 (by this user)
     */
    public int[] getFavoriteMovies(int n)
        {
            // FILL IN CODE

            int [] best = new int[n];

            Iterator it = movieRatings.iterator();
            int i = 0;
//        int j = 0;
            while(it.hasNext() && i < n)
            {
                MovieRatingNode current = (MovieRatingNode) it.next();

                if(current.getMovieRating() >= 5)
                {
                    best[i] = current.getMovieId();
                    i++;
//                j++;
                }


            }




            return best;
    }

    public int [] getAllMovies(int userId)
    {
        // FILL IN CODE



        int [] getAllMovies = new int[100000];

        Iterator it = movieRatings.iterator();
        int i = 0;

        while(it.hasNext())
        {
            MovieRatingNode current = (MovieRatingNode) it.next();
            getAllMovies[i] = current.getMovieId();


        }



        return getAllMovies;
    }





    /**
     * Returns an array of movies the user likes the least (up to n). These
     * are the movies that this user gave the rating of 1.
     *
     * @param n the maximum number of movies to return
     * @return array of movie ids of movies rated as 1
     */
    public int[] getLeastFavoriteMovies(int n) {
        // FILL IN CODE

        int [] worstMovies = new int[n];

        Iterator it = movieRatings.iterator();
        int i = 0;
//        int j = 0;
        while(it.hasNext() && i < n)
        {
            MovieRatingNode current = (MovieRatingNode) it.next();

            if(current.getMovieRating() <= 1)
            {
                worstMovies[i] = current.getMovieId();
                i++;
//                j++;
            }


        }




        return worstMovies;
    }

    /**
     * Computes the similarity of this user with the given "other" user using
     * Pearson correlation - simply calls computeSimilarity method
     * from MovieRatingsList
     *
     * @param otherUser a user to compare the current user with
     * @return similarity score
     */
    public double computeSimilarity(UserNode otherUser) {
        return movieRatings.computeSimilarity(otherUser.movieRatings);
    }

}
