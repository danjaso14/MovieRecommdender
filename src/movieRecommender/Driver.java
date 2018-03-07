package movieRecommender;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


import movieRecommender.UsersList;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** A driver class for the MovieRecommender. In the main method, we
 * create a movie recommender, load movie data from files and compute
 * recommendations and anti-recommendations for a particular user.
 */
public class Driver {
    public static void main(String[] args) {

       //==================================================================
        // Original main

        MovieRecommender recommender = new MovieRecommender();

//         movies.csv and ratings.csv should be in the project folder
        recommender.loadData("movies.csv","ratings.csv");
        System.out.println("Loaded movie data...");

        recommender.findRecommendations(3, 15, "recommendations");
        System.out.println();
        recommender.findAntiRecommendations(3, 15, "antiRecommendations");


//        String [] actualUser = {"Coco", "Turtle Ninjas", "P.S. I love You", "Thor", "Black Panther"};
//        String [] similarUser = {"Coco", "50 Shades of Gray", "Iron Man 3", "Thor", "Black Panther"};
//
//        for(int i = 0; i < actualUser.length; i++)
//        {
//            System.out.println(actualUser[i]);
//        }
//
//        System.out.println("===============================================");
//
//        for(int j = 0; j < similarUser.length; j++)
//        {
//            System.out.println(similarUser[j]);
//
//        }
//
//        System.out.println("========================================");
//        System.out.println("Reccommendation");
//
//        for(int i = 0; i < actualUser.length; i++)
//        {
//
//            for(int j = 0; j < similarUser.length; j++)
//            {
//                if(actualUser[i].equals(similarUser[j]))
//                {
//                    System.out.println(similarUser[j]);
//
//                }
//            }
//        }


        UserNode n = new UserNode(2);
        n.insert(2,5.0);
        n.insert(4,4.5);
        n.insert(10,3.0);
        n.insert(20,1.0);
        n.insert(30,2.5);

        System.out.println(n.getAllMovies(2));




//========================================================================================================


//        recommender.loadData("movies.csv","ratings.csv");
//        recommender.loadData("movies.csv");






//
//
//

//        UsersList n = new UsersList();
//        n.insert(1,1,4.0);
//        n.insert(1,2,5.0);
//        n.insert(1,3,4.8);
//
//        n.insert(2,1,2.0);
//        n.insert(2,2,1.0);
//        n.insert(2,3,4.0);
//
//        n.insert(3,1,4.0);
//        n.insert(3,2,4.0);
//        n.insert(3,3,4.0);
//
////        n.print("UserList_trial");
//
//        n.findMostSimilarUser(1);







//=========================================================
        //Userlist printer test case

//        UsersList u_l = new UsersList();
//        u_l.insert(2,3,3.3);
//        u_l.insert(3,4,4.4);
//        u_l.insert(3,3,3.0);
//        u_l.insert(40,10,3.0);
//        u_l.insert(42,9,3.9);
//        u_l.insert(41,20,4.9);
//        u_l.insert(39,2,2.2);

//        u_l.print("trial");


//        u_l.insert(2,1,3.3);
//        u_l.insert(2,2,4.4);
//        u_l.insert(2,3,3.0);
//
//        u_l.insert(4,1,3.0);
//        u_l.insert(4,2,3.9);
//        u_l.insert(4,3,4.9);

//        u_l.insert(3,1,2.2);
//        u_l.insert(3,2,2.2);
//        u_l.insert(3,3,2.2);





//
        //u_l.printUserList();

//        u_l.findMostSimilarUser(2);



        //===================================================
        // Usernode Best and Worst test cases

//        UserNode node_trial = new UserNode(2);
//        node_trial.insert(3,5.0);
//        node_trial.insert(4,0.5);
//        node_trial.insert(7,5.0);
//        node_trial.insert(10,5.0);
//        node_trial.insert(9,.9);
//        node_trial.insert(20,5.0);
//        node_trial.insert(2,5.0);
//        node_trial.insert(100,1.0);
//
//
//
//        node_trial.print();
//        System.out.println("Best");
//        node_trial.getFavoriteMovies(10);
//        System.out.println();
//        System.out.println("Worst");
//        node_trial.getLeastFavoriteMovies(4);





//====================================================================
        // ToString Userlist and other toString Methods cases
//

//        MovieRatingsList l = new MovieRatingsList();
//        l.insertByRating(2,3.3);
//        l.insertByRating(3,4.4);
//        l.insertByRating(10,3.0);
//        l.insertByRating(40,3.0);
//        l.insertByRating(42,3.9);
//        l.insertByRating(41,4.9);
//        l.insertByRating(39,2.2);
//        System.out.println(l.toString());
//
//        UserNode n = new UserNode(2);
//        n.insert(3,3.3);
//        n.insert(4,4.5);
//        n.insert(7,5.0);
//        n.insert(10,1.1);
//
//        System.out.println(n.toString());
//
//
//        UsersList u = new UsersList();
//        u.insert(1,6,4.4);
//
//        u.insert(50,5,3.5);
//        u.insert(30,20,2.2);
//        u.insert(10,50,0.9);
//
////        System.out.print(u.toString());
//
//        u.print("trial_");
//
//
//===================================================================



//         list.insertByRating(6, 1.0);
//        list.insertByRating(10, 1.0);
//
//
//
//
//
//         list.insertByRating(4, 3.5);
//         list.insertByRating(5, 1.0);
//         list.insertByRating(6, 2.5);
//         list.insertByRating(7, 4.5);
//         list.insertByRating(8, 5.0);
//         list.insertByRating(9, 1.0);

//
////        list.push(1, 3.0);
////        list.push(2, 5.0);
////        list.push(3, 4.5);

        // ===========================================================

//        MovieRatingsList list = new MovieRatingsList();
//
//=============================================================================
        //Test case for Pearson

//        list.insertByRating(1, 3.0);
//        list.insertByRating(2, 4.0);
//        list.insertByRating(3, 5.0);
//        list.insertByRating(5, 1.0);
//
//
//        list.print();
//
//        MovieRatingsList another = new MovieRatingsList();
//        another.insertByRating(0,1.0);
//        another.insertByRating(2,2.0);
//        another.insertByRating(3,5.0);
//        another.insertByRating(4,5.0);
//        another.insertByRating(5,5.0);
//
//
//        another.print();
//
//        list.computeSimilarity(another);

        //===================================================================================

        //Test case for usersSimilarity

//        UsersList u = new UsersList();


//        u.printUserList();
//
//        u.findMostSimilarUser(2);
//
//        int[] MOVIES1 = {1, 2, 3, 4, 5, 6, 7};
//        double[] RATINGS1 = {5, 5, 2, 5, 4, 3, 4};
//        int[] MOVIES2 = {2, 4, 7};
//        double[] RATINGS2 = {4, 1, 2};
//        int[] MOVIES3 = {1, 4, 5, 7};
//        double[] RATINGS3 = {3, 2, 5, 1};
//
//        u.addData(u, 1, MOVIES1, RATINGS1);
//        double[] ratings2 = {5, 4, 4};
//        u.addData(u, 2, MOVIES2, ratings2);
//        u.addData(u, 3, MOVIES3, RATINGS3);
//
//        int mostSimilar1 = u.findMostSimilarUser(1).getId();
//        System.out.println(mostSimilar1);
//        u.findMostSimilarUser(3);


        //===============================================================
////        UsersList u_l = new UsersList();
////
////
////        u_l.printUserList();
////
////        UserNode node = new UserNode(1);
////        UserNode node1 = new UserNode(13);
////        UserNode node2 = new UserNode(20);
//
//
//
////        u_l.insert(2,3,3.3);
////        u_l.insert(3,4,4.4);
////        u_l.insert(3,3,3.0);
////        u_l.insert(40,10,3.0);
////        u_l.insert(41,9,3.9);
////        u_l.insert(41,20,4.9);
////        u_l.insert(39,2,2.2);
//
////        u_l.printUserList();
//
////        u_l.get(3);
//
//        UserNode node_trial = new UserNode(2);
//        node_trial.insert(3,5.0);
//        node_trial.insert(4,4.4);
//        node_trial.insert(3,3.0);
//        node_trial.insert(10,3.0);
//        node_trial.insert(9,3.9);
//        node_trial.insert(20,4.9);
//        node_trial.insert(2,2.2);
////
////
//        node_trial.print();
////        node_trial.getFavoriteMovies(3);
//
////        node_trial.getFavoriteMovies(3).toString();
//
//        node_trial.getFavoriteMovies(3);
//
//
//
//
//
//
//
//
//        // Set rating test case
//
//        // list.setRating(2,0.5);
//        // list.print();
//
//        // get rating test case
//
////        System.out.println(list.getRating(20));
//
//        // Sublist test case
//
////        MovieRatingsList new_list=  list.sublist(4,5);
////        new_list.print();
//
//        // Get middleNode test case
//
//        //System.out.println(list.getMiddleNode());
//
//        // Get GetMedianRating test case
//
//        //System.out.println(list.getMedianRating());
//
//        // NBestRanked test case
//
////        MovieRatingsList best = list.getNBestRankedMovies(3);
////        best.print();
////
////        int [] trial_best = list.getNBestMovieId(3);
////        System.out.println(trial_best);
//
////        int [] best_= list.getBestMovies(3);
////        System.out.println(best_);
//
//        // NWorstRanked test case
//
////        MovieRatingsList worst = list.getNWorstRankedMovies(7);
////        worst.print();
//
//        // reverse_list test case
//
////         MovieRatingsList reverse_list =  list.reverse(list.headNode());
////         reverse_list.print();
//
//
//
//
////        HashMap<Integer, Double> map = new HashMap<Integer, Double>(){{
////            put(1, 4.5);
////            put(2, 2.0);
////            put(3, 3.8);
////        }};
//
////        System.out.println(map);
////        System.out.println();
////
////        MovieRatingsList similarity_list = new MovieRatingsList();
////        MovieRatingsList h = new MovieRatingsList();
////
////        h.push(1,2.0);
////        h.push(45,3.0);
////        h.push(4,4.0);
////
////        h.print();
//
////        MovieRatingsList h = new MovieRatingsList();
////        similarity_list.computeSimilarity(h);
//
//
//
//
////        UserNode u_list = new UserNode(4);
////        u_list.print();
//
//
////        MovieRatingsList it = new MovieRatingsList();
////        System.out.println(similarity_list.iterator());
//
//
//
////       ==============================================================
//
//
//
//
//
//


    }


}




