package movieRecommender;


//import javax.xml.soap.Node;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.util.Iterator;

/**
 * A custom linked list that stores user info. Each node in the list is of type
 * UserNode.
 * FILL IN CODE. Also, add other methods as needed.
 *
 * @author okarpenko
 *
 */
public class UsersList {
    private UserNode head = null;
    private UserNode tail = null; // ok to store tail here, will be handy for appending


    /** Insert the rating for the given userId and given movieId.
     *
     * @param userId  id of the user
     * @param movieId id of the movie
     * @param rating  rating given by this user to this movie
     */
    public void insert(int userId, int movieId, double rating)
    {

        // Check if UserNode already exists;
        // if not, create it and append to this list.
        // Then call insert(movieId, rating) method on the UserNode

        // FILL IN CODE

        UserNode new_node = new UserNode(userId);


        if(head == null)
            append(new_node);
        new_node.insert(movieId, rating);

        UserNode curr = head;
        while(curr!=null)
        {
            if(curr.getId() == userId)
            {
                return;
            }

            curr = curr.next();
        }
        append(new_node);
        new_node.insert(movieId, rating);

    }




//
//
//    public void push(int userId, int movieId, double rating)
//    {
//        UserNode new_node = new UserNode(userId);
//        new_node.setNext(head);
//        head = new_node;
//    }

    public void printUserList()
    {

        UserNode current = head;
        while(current != null)
        {
            System.out.print(current.getId() + " ");
            current = current.next();
        }
        System.out.println();

        MovieRatingsList l = new MovieRatingsList();

    }


    /**
     * Append a new node to the list
     * @param newNode a new node to append to the list
     */

    public void append(UserNode newNode)
    {
        // This is where tail will come in handy
        // FILL IN CODE

        if (tail == null) {
            head = newNode;
            if (tail  == null)
                tail = head;;
            return;
        }

        else
            tail.setNext(newNode);
        tail = tail.next();

    }

    /** Return a UserNode given userId
     *
     * @param userId id of the user (as defined in ratings.csv)
     * @return UserNode for a given userId
     */
    public UserNode get(int userId)
    {
        // FILL IN CODE

        UserNode curr = head;

        UserNode found_id = null;
        while(curr!=null)
        {
            if(curr.getId() == userId)
            {
                found_id = curr;
//                System.out.println(found_id.getId());
            }

//            else
//            {
//                System.out.println("not found");
//            }

            curr = curr.next();
        }

        return found_id;


    } // get method


    /**
     * The method computes the similarity between the user with the given userid
     * and all the other users. Finds the maximum similarity and returns the
     * "most similar user".
     * Calls computeSimilarity method in class MovieRatingsList/
     *
     * @param userid id of the user
     * @return the node that corresponds to the most similar user
     */
    public UserNode findMostSimilarUser(int userid)
    {
        // FILL IN CODE

        UserNode mostSimilarUser = head;
        UserNode current = head;

        UserNode found_user = head;

        while (current != null)
        {
            if(current.getId() == userid)
            {
                found_user = current;
            }

            current = current.next();
        }

//        System.out.println(found_user.toString());


//
        UserNode curr = head;
        double max = 0.0;


        while (curr != null)
        {

            double temp = curr.computeSimilarity(found_user);

            System.out.println(temp);

            if(max < temp)
            {
                mostSimilarUser = curr;
                max = temp;

            }
            curr = curr.next();


        }



        return mostSimilarUser;

    }




    /** Print UsersList to a file  with the given name in the following format:
     (userid) movieId:rating; movieId:rating; movieId:rating;
     (userid) movieId:rating; movieId:rating;
     (userid) movieId:rating; movieId:rating; movieId:rating; movieId:rating;
     Info for each userid should be printed on a separate line
     * @param filename name of the file where to output UsersList info
     */
    public void print(String filename)
    {
        // FILL IN CODE


        UserNode curr = head;



        try (PrintWriter pw = new PrintWriter(filename))
        {


            while (curr != null)
            {
                pw.println(curr.toString());
                curr = curr.next();


            }



            pw.flush();

        }
        catch (IOException e) {
            System.out.println("Error writing to a file: "  + e);
        }



    }


    public void addData(UsersList users, int userId, int[] movies, double[] ratings) {
        if (users == null)
            users = new UsersList();
//            if (movies.length != ratings.length) {
//                Assert.fail("Wrong parameters in addData. # of movies != # of ratings");
//            }
        for (int i = 0; i < movies.length; i++) {
            users.insert(userId, movies[i], ratings[i]);
        }

    }


}
