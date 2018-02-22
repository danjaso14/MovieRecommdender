package movieRecommender;

/**
 * MovieRatingsList.
 * A class that stores movie ratings for a user in a custom singly linked list of
 * MovieRatingNode objects. Has various methods to manipulate the list. Stores
 * only the head of the list (no tail! no size!). The list should be sorted by
 * rating (from highest to smallest).
 * Fill in code in the methods of this class.
 * Do not modify signatures of methods. Not all methods are needed to compute recommendations,
 * but all methods are required for the assignment.
 */

//import javax.xml.soap.Node;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.Math.*;

public class MovieRatingsList implements Iterable<MovieRatingNode> {

	private MovieRatingNode head;
	// Note: you are not allowed to store the tail or the size of this list


	/**
	 * Changes the rating for a given movie to newRating. The position of the
	 * node within the list should be changed accordingly, so that the list
	 * remains sorted by rating (from largest to smallest).
	 *
	 * @param movieId id of the movie
	 * @param newRating new rating of this movie
	 */
	public void setRating(int movieId, double newRating)
	{
		// FILL IN CODE




		MovieRatingNode m = head, temp = head, prev = head;


		while (m != null && m.getMovieId() != movieId)
		{
			m = m.next();
		}

		m.setMovieRating(newRating); // found movie Id with new rating

		int id = m.getMovieId();
		double rating = m.getMovieRating();

		// Deletion of node
		// head case
		if (head == null || head.getMovieId() == movieId)
		{
			head = head.next();
			prev.setNext(null);

		}

		//general case
		while (temp != null && temp.getMovieId() != movieId)
		{
			prev = temp;
			temp = temp.next();
		}
		prev.setNext(temp.next()); // Unlink n





		// insert function for node with new rating

		MovieRatingsList n_list = new MovieRatingsList();
		n_list.insertByRating(id, rating);

		//System.out.println(id + " " + rating);

		MovieRatingNode n = new MovieRatingNode(id, rating);

		if(head == null ||
				head.getMovieRating() <= n.getMovieRating())
		{
			n.setNext(head);
			head = n;
		}

		else
		{
			MovieRatingNode curr = head;

			while (curr.next() != null &&
					curr.next().getMovieRating() > n.getMovieRating())
			{
				curr = curr.next();
			}

			n.setNext(curr.next());
			curr.setNext(n);
		}

	}



	/**
	 * Return the rating for a given movie. If the movie is not in the list,
	 * returns -1.
	 * @param movieId movie id
	 * @return rating of a movie with this movie id
	 */
	public double getRating(int movieId)
	{
		// FILL IN CODE

		MovieRatingNode curr = head;


		while (curr != null)
		{
			if(curr.getMovieId() == movieId)
			{
				return curr.getMovieRating();
			}

			curr = curr.next();


		}

		return -1;

	}

//    public int [] getNBestMovieId(int n)
//    {
//        // FILL IN CODE
//
//        MovieRatingNode curr = head;
//        int [] list = new int [n];
//        int i = 0;
//        while (i != n)
//        {
//            if(curr.getMovieRating() >= 5)
//            {
//                list[i] = curr.getMovieId();
//
//            }
//
//            curr = curr.next();
//            i++;
//
//
//        }
//
//        return list;
//
//    }

	public double getRatings()
	{
		// FILL IN CODE

		MovieRatingNode curr = head;


		while (curr != null)
		{
			curr = curr.next();
		}

		return curr.getMovieRating();


	}


	/**
	 * Insert a new node (with a given movie id and a given rating) into the list.
	 * Insert it in the right place based on the value of the rating. Assume
	 * the list is sorted by the value of ratings, from highest to smallest. The
	 * list should remain sorted after this insert operation.
	 *
	 * @param movieId id of the movie
	 * @param rating rating of the movie
	 */
	public void insertByRating(int movieId, double rating)
	{
		// FILL IN CODE. Make sure to test this method thoroughly

		MovieRatingNode n = new MovieRatingNode(movieId, rating);

		if(head == null || head.getMovieRating() <= n.getMovieRating())
		{
			n.setNext(head);
			head = n;
		}

		else
		{
			MovieRatingNode curr = head, prev = null;

			while (curr.next() != null &&
					curr.next().getMovieRating() > n.getMovieRating())
			{
				curr = curr.next();
			}

			n.setNext(curr.next());
			curr.setNext(n);
		}

	}




	/**
	 * Computes similarity between two lists of ratings using Pearson correlation.
	 * https://en.wikipedia.org/wiki/Pearson_correlation_coefficient
	 * Note: You are allowed to use a HashMap for this method.
	 *
	 * @param otherList another MovieRatingList
	 * @return similarity computed using Pearson correlation
	 */
	public double computeSimilarity(MovieRatingsList otherList) {
		// FILL IN CODE

		double similarity = 0;

		double summation_x = 0;
		double summation_y = 0;
		double summation_x2 = 0;
		double summation_y2 = 0;
		double summation_xy = 0;

		double cov_XY = 0;



		MovieRatingNode curr = head;
		HashMap <Integer, Double> tempMap = new HashMap();

//        UserNode n = new UserNode();

		double user1 = 0;
		double user2 = 0;
		while (curr != null)
		{
			tempMap.put(curr.getMovieId(),curr.getMovieRating());
			curr = curr.next();
		}
		System.out.println(tempMap);
		Iterator it = otherList.iterator();
//        System.out.println(it.hasNext());
		int n = 0;
		while (it.hasNext())
		{
			MovieRatingNode current = (MovieRatingNode) it.next();
			if(tempMap.containsKey(current.getMovieId()))
			{
				user1 = tempMap.get(current.getMovieId());
				user2 = current.getMovieRating();

				summation_x =+ summation_x + user1;
				summation_y =+ summation_y + user2;

				summation_x2 =+ summation_x2 + (user1*user1);
				summation_y2 =+ summation_y2 + (user2*user2);

				summation_xy =+ summation_xy + (user1*user2);

				n++;




			}
//			System.out.println(user1 + " " + user2);


		}

		cov_XY = (n*summation_xy -(summation_x*summation_y));


		double variance_X = Math.sqrt(n*summation_x2 - (summation_x*summation_x));
		double variance_y = Math.sqrt(n*summation_y2 - (summation_y*summation_y));



//		System.out.println("Summation of X: " + summation_x);
//		System.out.println("Summation of Y: " + summation_y);
//
//		System.out.println("Summation of X^2: " + summation_x2);
//		System.out.println("Summation of Y^2: " + summation_y2);
//
//		System.out.println("Summation of XY: " + summation_xy);
//
//		System.out.println("Covarinace: " + cov_XY);
//
//		System.out.println("Variance of X " + variance_X);
//
//		System.out.println("Variance of y " + variance_y);
//
//		System.out.println("Variance_X * Variance_Y: " + (variance_X*variance_y));
//
//		System.out.println("Pearson Correlation: " + (cov_XY/(variance_X*variance_y)) );

		similarity = (cov_XY/(variance_X*variance_y));




		return similarity;

	}

//    public void print() {
//        MovieRatingsListIterator it = new MovieRatingsListIterator();
//        while (!it.hasNext()) {
//            System.out.print(it.next() + "  ");
//        }
//        System.out.println();
//    }




	/**
	 * Returns a sublist of this list where the rating values are in the range
	 * from begRating to endRating, inclusive.
	 *
	 * @param begRating lower bound for ratings in the resulting list
	 * @param endRating upper bound for ratings in the resulting list
	 * @return sublist of the MovieRatingsList that contains only nodes with
	 * rating in the given interval
	 */
	public MovieRatingsList sublist(int begRating, int endRating)
	{


		MovieRatingsList res = new MovieRatingsList();



		MovieRatingNode curr = head;

		while (curr != null)
		{
			if(curr.getMovieRating() >= begRating &&
					curr.getMovieRating() <= endRating)
			{
				res.insertByRating(curr.getMovieId(), curr.getMovieRating());
			}

			curr = curr.next();

		}

		return res;



	}

	/** Traverses the list and prints the ratings list in the following format:
	 *  movieId:rating; movieId:rating; movieId:rating;  */
	public void print()
	{

		// FILL IN CODE

		MovieRatingNode current = head;
		while(current != null)
		{
			System.out.print(current.getMovieId()+":"+current.getMovieRating()+"; ");
			current = current.next();
		}
		System.out.println();

		MovieRatingsList l = new MovieRatingsList();

	}

	/**
	 * Returns the middle node in the list - the one half way into the list.
	 * Needs to have the running time O(n), and should be done in one pass
	 * using slow & fast pointers (as described in class).
	 *
	 * @return the middle MovieRatingNode
	 */
	public MovieRatingNode getMiddleNode()
	{

		// FILL IN CODE

		MovieRatingNode slow = head;
		MovieRatingNode fast = head;



		if(head != null)
		{
			while (fast != null && fast.next() != null)
			{
				fast = fast.next().next();
				slow = slow.next();
			}

		}

		return  slow;

	}

	/**
	 * Returns the median rating (the number that is halfway into the sorted
	 * list). To compute it, find the middle node and return it's rating. If the
	 * middle node is null, return -1.
	 *
	 * @return rating stored in the node in the middle of the list
	 */
	public double getMedianRating()
	{
		// FILL IN CODE
		double m = 0;
		if(getMiddleNode() == null)
			return -1;

		else
			m = getMiddleNode().getMovieRating();

		return m;

	}

	/**
	 * Returns a RatingsList that contains n best rated movies. These are
	 * essentially first n movies from the beginning of the list. If the list is
	 * shorter than size n, it will return the whole list.
	 *
	 * @param n the maximum number of movies to return
	 * @return MovieRatingsList containing movies rated as 5
	 */
	public MovieRatingsList getNBestRankedMovies(int n)
	{
		// FILL IN CODE

		MovieRatingsList list_best = new MovieRatingsList();

		MovieRatingNode curr = head;

		int i = 0;
		while(i != n)
		{
			list_best.insertByRating(curr.getMovieId(), curr.getMovieRating());
			curr = curr.next();
			i++;
		}

		return list_best;
	}

//    public int [] getBestMovies (int n)
//    {
//        int [] r = new int [n];
//
//        MovieRatingsList list_best = new MovieRatingsList();
//
//
//        MovieRatingNode curr = head;
//        int i = 0;
//        while (i != n)
//        {
//            r[i] = curr.getMovieId();
//            curr = curr.next();
//
//        }
//
//
//        return r;
//    }
//




	/**
	 * * Returns a RatingsList that contains n worst rated movies for this user.
	 * Essentially, these are the last n movies from the end of the list. You are required to
	 * use slow & fast pointers to find the n-th node from the end (as discussed in class).
	 * Note: This method should compute the result in one pass. Do not use size variable
	 * Do NOT use reverse(). Do not destroy the list.
	 *
	 * @param n the maximum number of movies to return
	 * @return MovieRatingsList containing movies rated as 1
	 */
	public MovieRatingsList getNWorstRankedMovies(int n) {

		// FILL IN CODE

		MovieRatingsList list_worst = new MovieRatingsList();

		MovieRatingNode pt1 = head, pt2 = head;
		int counter = 0;

		while (counter < n)
		{
			pt2 = pt2.next();
			counter++;
		}

		while (pt2 != null)
		{
			pt2 = pt2.next();
			pt1 = pt1.next();
		}

		while (pt1 != null)
		{
			list_worst.insertByRating(pt1.getMovieId(), pt1.getMovieRating());
			pt1 = pt1.next();
		}



		return list_worst;
	}

	/**
	 * Return a new list that is the reverse of the original list. The returned
	 * list is sorted from lowest ranked movies to the highest rated movies.
	 * Use only one additional MovieRatingsList (the one you return) and constant amount
	 * of memory. You may NOT use arrays, ArrayList and other built-in Java Collections classes.
	 * Read description carefully for requirements regarding implementation of this method.
	 *
	 * @param h head of the MovieRatingList to reverse
	 * @return reversed list
	 */
	public MovieRatingsList reverse(MovieRatingNode h) {
		MovieRatingsList r = new MovieRatingsList();

		// FILL IN CODE

		MovieRatingsList reverse_list = new MovieRatingsList();
		MovieRatingNode prev = null, current = head, next = null;

		while (current != null) {
			next = current.next();
			current.setNext(prev);
			prev = current;
			current = next;

			reverse_list.push(prev.getMovieId(), prev.getMovieRating());
		}



		return reverse_list;
	}

	public MovieRatingNode headNode()
	{
		return this.head;
	}

	public void push(int movieID, double rating)
	{
		MovieRatingNode new_node = new MovieRatingNode(movieID, rating);
		new_node.setNext(head);
		head = new_node;
	}

	public String toString (){
		MovieRatingNode curr = head;
		String list = " ";

		while (curr != null)
		{
			list += " " + Integer.toString(curr.getMovieId()) + ":" + Double.toString(curr.getMovieRating()) + "; ";
			curr = curr.next();

		}

		return list;

	}

	public Iterator<MovieRatingNode> iterator() {

		return new MovieRatingsListIterator(0);
	}

	/**
	 * Inner class, MovieRatingsListIterator
	 * The iterator for the ratings list. Allows iterating over the MovieRatingNode-s of
	 * the list.
	 * FILL IN CODE
	 */
	private class MovieRatingsListIterator implements Iterator<MovieRatingNode> {

		MovieRatingNode curr;

		public MovieRatingsListIterator(int index)
		{
			// FILL IN CODE


			//points to dummy variable
			curr = head;

			for (int i = 0; i < index; i++)
			{
				curr = curr.next();
			}




		}

		@Override
		public boolean hasNext()
		{
			// FILL IN CODE
			return curr != null;
		}

		@Override
		public MovieRatingNode next() {
			// FILL IN CODE

			if(!hasNext())
			{
				System.out.println("No next element");
				return null;
			}

			MovieRatingNode current = curr;
			curr = curr.next();
			return current;



		}

		public void print() {
			MovieRatingsListIterator it = new MovieRatingsListIterator(0);
			while (it.next() != null) {
				System.out.print(it.next() + "  ");
			}
			System.out.println();
		}

	}

}
