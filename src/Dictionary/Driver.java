package Dictionary;//import javax.xml.soap.Node;

/** The Driver class for CompactPrefixTree */
public class Driver {
    public static void main(String[] args)
    {
            //============================================================
            // Main method

//
//            Dictionary dict = new CompactPrefixTree();
//            dict.add("cat");
//            dict.add("cart");
//            dict.add("carts");
//            dict.add("case");
//            dict.add("doge");
//            dict.add("doghouse");
//            dict.add("wrist");
//            dict.add("wrath");
//            dict.add("wristle");
//            dict.print();



        // =====================================================================
        CompactPrefixTree tree = new CompactPrefixTree();

//        cp.add("hamburger");
//        cp.add("hamster");
//        cp.add("hammer");
//        cp.add("ape");
//        cp.add("apple");
//        cp.add("apples");
//        cp.add("application");
//        cp.add("green");
//        cp.add("great");



//            cp.add("cat");
//            cp.add("cart");
//            cp.add("carts");
//            cp.add("case");
//            cp.add("doge");
//            cp.add("doghouse");
//            cp.add("wrist");
//            cp.add("wrath");
//            cp.add("wristle");
//            cp.print();

//        ===================================================

        //  TEST CASE 1
        tree.add("cat");
        tree.add("ape");
        tree.add("apple");
        tree.add("cart");
        tree.add("cats");
        tree.add("cat");
        tree.add("demon");
        tree.add("dog");
        tree.add("demons");

        tree.printTree();


//        ==================================================
        //  TEST CASE 2
        tree.add("liberty");
        tree.add("life");
//        tree.add("lavender");
        tree.add("list");
        tree.add("youtube");
        tree.add("your");
//        tree.add("you");
        tree.add("wrist");
        tree.add("wrath");
        tree.add("wristle");

        tree.print();
        tree.printTree();


//
//
//        System.out.println("Tree output:");
//        cp.printTree();
//        System.out.println("\nWords printed:");
//        cp.print();


//        String s1 = "ham";
//        String s2 = "hammer";
//
//        if(s2.startsWith(s1))
//        {
//            System.out.println(true);
//        }
//        else
//            System.out.println(false);





//        cp.addTempMethod();
//        cp.print();
//        cp.printTree();





//        String s1 = "apple";
//        String s2 = "app";
//
//        int len = s2.length();
//        System.out.println(len);
//
//        System.out.println(s1.substring(len));






//        cp.findLongestCommonPrefix("green", "gre");
//        cp.getIndexOfCharacter('x');



//        cp.addTempMethod();
//        cp.print();
//        cp.printTree();


//        cp.printTree("Tree");

//        Boolean result = cp.checkPrefix("ca");
//        System.out.println(result);
//
//
//        System.out.println(cp.check("apple"));

//        String s = cp.getPrefix("ap");
//        System.out.println(s);


//
//        System.out.println(s3.length());







        // Test case for getIndexCharacter

//        char[] letters = new char[26];
//
//        int index = 0;
//        char find = 'x';
//
//        for (char ch = 'a'; ch <= 'z'; ch++)
//        {
////            letters[ch - 'a'] = String.valueOf(ch);
////            System.out.println(ch);
//
//
//
//            if(ch == find)
//            {
//                index = (int) ch - (int) 'a';
//                System.out.println(index);
//
//            }
//
//
//        }

//        cp.getIndexOfCharacter('x');

        //============================================================================

        // Test cases for CommonPrefix


//        String s1 = "application";
//        String s2 = "applicable";
//
//        String small_prefix, large_prefix;
//
//        int index = 0;
//
//        if(s1.length() > s2.length())
//        {
//            large_prefix = s1;
//            small_prefix = s2;
//        }
//
//        else
//        {
//            large_prefix = s2;
//            small_prefix = s1;
//        }
//
////        System.out.println(small_prefix);
//
//        for(char ch : large_prefix.toCharArray())
//        {
//            // Gets the length of the small_prefix
//            if(index == small_prefix.length())
//            {
//                break;
//            }
////            System.out.println(index);
//
//
//
//            // Iterates in the large_prefix (ch array) and compares ch data with small_prefix
//            if(ch != small_prefix.charAt(index))
//            {
//                break;
//            }
//
//            index++;
//        }
//
//        if(index == 0)
//        {
//            System.out.println(" No common prefix");
//        }
//
//        else System.out.println(large_prefix.substring(0,index));

//        cp.findLongestCommonPrefix("application", "applicable");

        //====================================================================

//        CompactPrefixTree tree = new CompactPrefixTree();









    }
}
