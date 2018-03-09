package Dictionary;

import java.io.IOException;
import java.io.PrintWriter;

/** CompactPrefixTree class, implements Dictionary ADT and
 *  several additional methods. Can be used as a spell checker.
 *  Fill in code in the methods of this class. You may add additional methods. */
public class CompactPrefixTree implements Dictionary {



        private Node root; // the root of the tree

        /**
         * Default constructor.
         * Creates an empty "dictionary" (compact prefix tree).
         */
        public CompactPrefixTree() {

            root = new Node();


        }



        //===================Helper method add==================================


        public void addTempMethod() {

            Node child1 = new Node();
            Node child5 = new Node();
            Node child6 = new Node();
            Node child7 = new Node();
            Node child8 = new Node();





//        child1.prefix = "gre";
//        child1.isWord = false;
//        root.children[getIndexOfCharacter('g')] = child1;
//        Node child4 = new Node();
//
//        child4.prefix = "en";
//        child4.isWord = true;
//        child1.children[getIndexOfCharacter('e')] = child4;

            child1.prefix = "ap";
            child1.isWord = false;
            root.children[getIndexOfCharacter('a')] = child1;

            Node child4 = new Node();
            child4.prefix = "ple";
            child4.isWord = true;
            child1.children[getIndexOfCharacter('p')] = child4;

            child5.prefix = "e";
            child5.isWord = true;
            child1.children[getIndexOfCharacter('e')] = child5;



            Node child2 = new Node();
            child2.prefix = "ca";
            child2.isWord = false;
            root.children[getIndexOfCharacter('c')] = child2;

            child6.prefix = "t";
            child6.isWord = true;
            child2.children[getIndexOfCharacter('t')] = child6;

            child7.prefix = "p";
            child7.isWord = true;
            child2.children[getIndexOfCharacter('p')] = child7;
//
            child8.prefix = "s";
            child8.isWord = true;
            child6.children[getIndexOfCharacter('s')] = child8;
//
//
//
            Node child3 = new Node();
            child3.prefix = "do";
            child3.isWord = false;
            root.children[getIndexOfCharacter('d')] = child3;

            Node child9 = new Node();
            child9.prefix = "ge";
            child9.isWord = true;
            child3.children[getIndexOfCharacter('g')] = child9;

            Node child30 = new Node();
            child30.prefix = "gre";
            child30.isWord = false;
            root.children[getIndexOfCharacter('g')] = child30;

            Node child31 = new Node();
            child31.prefix = "en";
            child31.isWord = true;
            child30.children[getIndexOfCharacter('e')] = child31;









        }


        //============================================================================


        /**
         * Creates a dictionary ("compact prefix tree")
         * using words from the given file.
         *
         * @param filename the name of the file with words
         */
        public CompactPrefixTree(String filename) {
            // FILL IN CODE:
            // Read each word from the file, add it to the tree


        }

        /**
         * Adds a given word to the dictionary.
         *
         * @param word the word to add to the dictionary
         */
        public void add(String word) {
            add(word.toLowerCase(), root); // Calling private add method
        }

        /**
         * Checks if a given word is in the dictionary
         *
         * @param word the word to check
         * @return true if the word is in the dictionary, false otherwise
         */
        public boolean check(String word) {
            return check(word.toLowerCase(), root); // Calling private check method
        }

        /**
         * Checks if a given prefix is stored in the dictionary
         *
         * @param prefix The prefix of a word
         * @return true if the prefix is in the dictionary, false otherwise
         */
        public boolean checkPrefix(String prefix) {
            return checkPrefix(prefix.toLowerCase(), root); // Calling private checkPrefix method
        }



//








        /**
         * Prints all the words in the dictionary, in alphabetical order,
         * one word per line.
         */
        public void print() {
            print("", root); // Calling private print method
        }

        /**
         * Print out the nodes of the compact prefix tree, in a pre-order fashion.
         * First, print out the root at the current indentation level
         * (followed by * if the node's valid bit is set to true),
         * then print out the children of the node at a higher indentation level.
         */
        public void printTree()
        {
            // FILL IN CODE

//        System.out.println(" ");
            System.out.println(root.prefix);
            toString(root, 0);








        }
        // Return it to private
        //system.line speratrir
        private void toString(Node tree, int indent)
        {

            if(tree != null)
            {

                for (int i = 0; i < tree.children.length; i++)
                {
                    if (tree.children[i] != null && tree.children[i].isWord)
                    {
                        for (int j = 0; j < indent; j++)
                        {
                            System.out.print(" ");
                        }
                        System.out.print(tree.children[i].prefix);
                        System.out.println("*");
                    }
                    else if (tree.children[i] != null){
                        for (int j = 0; j < indent; j++)
                        {
                            System.out.print(" ");
                        }
                        System.out.println(tree.children[i].prefix);
                    }
                    toString(tree.children[i], indent + 1);



                }
            }

        }


        private String toStringFile (Node tree, int indent)
        {
            String s = "";

            if(tree == null)
            {
                return "";
            }


            for (int j = 0; j < indent; j++)
            {

                s += " ";

            }

            if(tree.isWord == true)
            {
                s += tree.prefix + "*\n";

            }

            else
            {
                s += tree.prefix + "\n";
            }

            for (int i = 0; i < tree.children.length; i++)
            {
                s += toStringFile(tree.children[i], indent + 1);
            }

            return s;
        }









        /**
         * Print out the nodes of the tree to a file, using indentations to specify the level
         * of the node.
         *
         * @param filename the name of the file where to output the tree
         */
        public void printTree(String filename)

        {
            // FILL IN CODE
            // Same as printTree, but outputs info to a file


            try (PrintWriter pw = new PrintWriter(filename))
            {
                String s = "";
//           pw.println(" ");
//           pw.println(" ");
                s = toStringFile(root, 0);
                pw.print(s);


            }



            catch (IOException e) {
                System.out.println("Error writing to a file: " + e);
            }


        }

        /**
         * Return an array of the entries in the dictionary that are as close as possible to
         * the parameter word.  If the word passed in is in the dictionary, then
         * return an array of length 1 that contains only that word.  If the word is
         * not in the dictionary, then return an array of numSuggestions different words
         * that are in the dictionary, that are as close as possible to the target word.
         * Implementation details are up to you, but you are required to make it efficient
         * and make good use ot the compact prefix tree.
         *
         * @param word           The word to check
         * @param numSuggestions The length of the array to return.  Note that if the word is
         *                       in the dictionary, this parameter will be ignored, and the array will contain a
         *                       single world.
         * @return An array of the closest entries in the dictionary to the target word
         */

        public String[] suggest(String word, int numSuggestions)
        {
            // FILL IN CODE
            // Note: you need to create a private suggest method in this class
            // (like we did for methods add, check, checkPrefix)


            return null; // don't forget to change it
        }


        //===========================Private helper methods============================================

        public int getIndexOfCharacter(char letter_given) {
            char[] letters = new char[26];

            int index = 0;

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == letter_given) {
                    index = (int) ch - (int) 'a';
                    return index;
//                System.out.println(index);
                }
            }

            return index;
        }

        public String findLongestCommonPrefix(String s1, String s2) {
            String commonPrefix = "";

//        String s1 = "cat";
//        String s2 = "cats";

            String small_prefix, large_prefix;

            int index = 0;

            if (s1.length() > s2.length()) {
                large_prefix = s1;
                small_prefix = s2;
            } else {
                large_prefix = s2;
                small_prefix = s1;
            }

//        System.out.println(small_prefix);

            for (char ch : large_prefix.toCharArray()) {
                // Gets the length of the small_prefix
                if (index == small_prefix.length()) {
                    break;
                }
//            System.out.println(index);


                // Iterates in the large_prefix (ch array) and compares ch data with small_prefix
                if (ch != small_prefix.charAt(index)) {
                    break;
                }

                index++;
            }


//        System.out.println(large_prefix.substring(0, index));
            commonPrefix = large_prefix.substring(0, index);

            return commonPrefix;
        }


        //=================================================================================================


        // ---------- Private helper methods ---------------


        private int getIndexDifferent (String word, Node node)
        {
            int index = 0;

            for(int i = 0; i < node.children.length; i++)
            {
                if(node.children[i] != null && node.prefix.charAt(i) == word.charAt(i))
                {
                    index++;
                }

            }
            return index;


        }

        /**
         * A private add method that adds a given string to the tree
         *
         * @param s    the string to add
         * @param node the root of a tree where we want to add a new string
         * @return a reference to the root of the tree that contains s
         */
        private Node add(String s, Node node)
        {
            // FILL IN CODE

            Node new_node = null;
            char first_letter = '\u0000';
            int store_index = 0;
            String common_prefix = "";
            String suffix_node = "";
            String suffix_word = "";
            char first_LetterNodeParent = '\u0000';
            Node new_NodeParent = null;
            int store_IndexParent = 0;

            String common_prefix_else = "";

            // Empty tree: create a new node whose prefix is the word
            // we are looking for and whose valid bit is true. Return this node





            if(node.hasChildren() == false)
            {

                new_node = new Node();
                new_node.isWord = true;
                new_node.prefix = s;
                first_letter = s.charAt(0);
                store_index = getIndexOfCharacter(first_letter);

                node.children[store_index] = new_node;


                return new_node;

            }

            if(node.prefix.equals(s) && node.isWord == false)
            {
                return  node;

            }



            else if(node.prefix.equals(s) && node.isWord == true)
            {
                node.isWord = true;
                return node;

            }



            else
            {
                char f_letter = s.charAt(0);
                int index = getIndexOfCharacter(f_letter);

                for(int i = 0; i < node.children.length; i++)
                {
                    if(node.children[i] != null && node.children[i].prefix.equals(s) && node.children[i].isWord == false)
                    {
                        node.children[i].isWord = true;
                        return node.children[i];
                    }


                    if(node.children[i] != null  && s.charAt(0) == node.children[i].prefix.charAt(0))
                    {
                        common_prefix = findLongestCommonPrefix(s, node.children[i].prefix);
                        int len = common_prefix.length();
                        suffix_node = node.children[i].prefix.substring(len);
                        suffix_word = s.substring(len);

                        if(suffix_node.equals("") && suffix_word.equals(""))
                        {
                            return node;
                        }

                        if(suffix_node.equals(""))
                        {
                            add(suffix_word, node.children[i]);
                            return new_node;

                        }



                        new_NodeParent = new Node();
                        new_NodeParent.isWord = false;
                        new_NodeParent.prefix = common_prefix;
                        first_LetterNodeParent = common_prefix.charAt(0);
                        store_IndexParent = getIndexOfCharacter(first_LetterNodeParent);

                        node.children[i].prefix = suffix_node;

//                    if(suffix_node.equals(""))
//                    {
//                        add(suffix_word, node.children[i]);
//                        return new_node;
//
//                    }


                        first_letter = suffix_node.charAt(0);
                        store_index = getIndexOfCharacter(first_letter);
                        new_NodeParent.children[store_index] = node.children[i];
                        node.children[store_IndexParent] = new_NodeParent;
                        add(suffix_word, new_NodeParent);
                        return new_NodeParent;



                    }

                    else if(i == index  && node.children[i] == null)
                    {

                        new_node = new Node();
                        new_node.isWord = true;
                        new_node.prefix = s;
                        first_letter =s.charAt(0);
                        store_index = getIndexOfCharacter(first_letter);
                        node.children[store_index] = new_node;
                        return new_node;


                    }

                }

            }



            return  node;


        }


        /**
         * A private method to check whether a given string is stored in the tree.
         *
         * @param s    the string to check
         * @param node the root of a tree
         * @return true if the prefix is in the dictionary, false otherwise
         */
        private boolean check(String s, Node node)
        {
            // FILL IN CODE

            // Base cases ======================================================================

            // Base case if tree is empty
            if(root == null)
            {
                return false;

            }

            for(int i = 0; i < root.children.length; i++)
            {
                // If prefix stored at root of tree is not a prefix of the word, the word is not in the tree

                if(root.children[i] != null)
                {
                    // If word is the same as the prefix && the valid bit for the root is set to true
//                System.out.println("s value: " +s+ "\n" + "Prefix node: " + root.children[i].prefix + "\n" + "Value of word bit: " + root.children[i].isWord);
                    if (s.equals(root.children[i].prefix) && (root.children[i].isWord == true))
                    {return true;}

                    // If word is the same as the prefix && the valid bit for the root is set to false
                    if (s.equals(root.children[i].prefix) && (root.children[i].isWord == false))
                    {return false;}
                }






            }

            //===================================================================================

            // Recursive cases




            String commonPrefix = "";
            String suffix = " ";
            int len = 0;
            if(node != null)
            {
                for(int i = 0; i < node.children.length; i++)
                {
                    if(node.children[i]!= null)
//                    System.out.println(node.children[i].prefix + " check first letter: " + s);

                        if (node.children[i] != null && node.children[i].prefix.charAt(0) == s.charAt(0))
                        {


//                    System.out.println("Node first: " + node.children[i].prefix.charAt(0) + "||"
//                    + " first letter of word given: " + s.charAt(0));

//                    System.out.println("Word before commonPrefix called: " + node.children[i].prefix);

                            commonPrefix = findLongestCommonPrefix(s, node.children[i].prefix);
//                    System.out.println("Common prefix is this: " + commonPrefix);

                            len = commonPrefix.length();
                            suffix = s.substring(len);



                            if(checkPrefix(suffix ,node.children[i]))
                            {
                                System.out.println("enter common prefix node if statement");
                                System.out.println("common suffix:" + suffix + "|| node:" + node.children[i].prefix);


                                return true;



                            }

                        }

                    check(suffix, node.children[i]);


                }

            }

            return false; // don't forget to change it
        }




        /**
         * A private recursive method to check whether a given prefix is in the tree
         *
         * @param prefix the prefix
         * @param node   the root of the tree
         * @return true if the prefix is in the dictionary, false otherwise
         */
        private boolean checkPrefix(String prefix, Node node)
        {
            // FILL IN CODE


            // Base case if tree is empty
            if(node != null) {


                for (int i = 0; i < node.children.length; i++)
                {
//                System.out.println("enter for loop:");

                    if (node.children[i] != null && prefix.equals(node.children[i].prefix))
                    {

//                    System.out.println(prefix + " :compare: " + node.children[i].prefix);
//                    System.out.println("found");
                        return true;



                    }
                    checkPrefix(prefix, node.children[i]);


                }


            }
//        System.out.println("not found");


            return false;


        }

        private String getPrefix(String prefix, Node node)
        {
            // FILL IN CODE


            String temp = "";

            // Base case if tree is empty
            if(node != null) {


                for (int i = 0; i < node.children.length; i++)
                {
//                System.out.println("enter for loop:");

                    if (node.children[i] != null && prefix.equals(node.children[i].prefix))
                    {

//                    System.out.println(prefix + " :compare: " + node.children[i].prefix);
//                    System.out.println("found");
                        temp = node.children[i].prefix;
//                    System.out.println("shoudl return this " + temp);
                        return temp;



                    }
                    checkPrefix(prefix, node.children[i]);


                }


            }
//        System.out.println("not found");
            return temp;


        }

        /**
         * Outputs all the words stored in the dictionary
         * to the console, in alphabetical order, one word per line.
         *
         * @param s    the string obtained by concatenating prefixes on the way to this node
         * @param node the root of the tree
         */
        private void print(String s, Node node) {

            // FILL IN CODE
            int i;
            if (node.isWord)
            {
                System.out.println(s+node.prefix);

            }

            else
            {
                for(i = 0; i < node.children.length; i++)
                {
                    if(node.children[i] != null)
                    {
                        print(node.prefix, node.children[i]);
                    }


                }


            }




        }




        // ================Helper method =========================

//    private void print(Node node, String soFar) {
//        Node curr = root;
//
//
//    }
        //==========================================================


        // FILL IN CODE: add a private suggest method. Decide which parameters
        // it should have

        private void suggest ()
        {

        }

        // --------- Private class Node ------------
        // Represents a node in a compact prefix tree
        private class Node {
            String prefix; // prefix stored in the node
            Node children[]; // array of children (26 children)
            boolean isWord; // true if by concatenating all prefixes on the path from the root to this node, we get a valid word


            Node() {
                isWord = false;
                prefix = "";
                children = new Node[26]; // initialize the array of children


            }

            private Node getRoot()
            {
                return root;
            }

            protected boolean hasChildren()
            {


                for(int i = 0; i < root.children.length; i++)
                {
                    if(root.children[i] != null)
                    {
                        return true;
                    }



                }

                return  false;
            }

        }
}








