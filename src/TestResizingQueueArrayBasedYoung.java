import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**CSC 1600
 * Data Structures
 *
 * Lab Description:
 * The array based implementation of the ADT queue in this chapter assumed a maximum queue size of 50 items.
 * Modify this implementation so that when the queue becomes full, the size of the array is doubled. Write a
 * test program which can demonstrate the added feature of doubling size of the array.
 *
 * The TestResizingQueueArrayBasedYoung class tests the ResizingQueueArrayBasedYoung class by using a Queue and Stack
 * to check if the words in a dictionary are a palindrome. The dictionary used is the default dictionary included in
 * any Unix system located at /usr/share/dict/words.
 *
 * @author Brandon Young
 */
// File Name: TestResizingQueueArrayBasedYoung.java
public class TestResizingQueueArrayBasedYoung {

    public static void main(String[] args) {

        // The file name of the Dictionary being used
        final String DICTIONARY_NAME = "british-english.txt";
        // Holds the number of Palindromes in the dictionary
        int count = 0;
        //holds the current word in the dictionary
        String currWord;

        Scanner dictionary;

        File fileIn = new File(DICTIONARY_NAME);
        if (!fileIn.exists()) {
            System.out.println("File does not exist. Please place the dictionary file in the root folder of the program.");
        }

        try {
            dictionary = new Scanner(fileIn);
            while(dictionary.hasNext()) {
                currWord = dictionary.next();
                // check to see if it is a palindrome
                if (isPalindrome(currWord)) {
                    count++;
                } // end if
            } // end while
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } // end try catch statement

        System.out.printf("Total words in Dictionary: %9d \n", fileIn.length());
        System.out.printf("Palindromes in Dictionary: %9d",  count);
    } // end main

    /**
     * Checks to see if a word is a palindromw (word that is spelled the same reversed.
     * Precondition: word is a String
     * Post Condition: Returns true if the word is a palindrome and false if it is not
     * @param word String: The word to check for palindrome
     * @return (boolean): True if the word is palindrome, false otherwise
     */
    public static boolean isPalindrome(String word) {
        // Creates an empty Queue
        ResizingQueueArrayBasedYoung aQueue = new ResizingQueueArrayBasedYoung();
        // Creates an empty Stack
        ArrayStackYoung aStack = new ArrayStackYoung();

        // Adds Each character of word to a Stack and Queue in order to check later
        for (int index = 0; index < word.length(); index++) {
            // The current letter in the string
            String nextChar = String.valueOf(word.charAt(index));
            aQueue.enqueue(nextChar);
            aStack.push(nextChar);
        } // end for loop
        // Sentinel Value
        boolean charactersAreEqual = true;
        // Compares each letter to see if equal
        while (!aQueue.isEmpty() && charactersAreEqual == true) {
            String queueFront = (String) aQueue.dequeue();
            String stackTop = (String) aStack.pop();
            if (queueFront.equalsIgnoreCase(stackTop)) {
                charactersAreEqual = false;
            } // end if
        } // end while
        return charactersAreEqual;
    }

} // endTestResizingQueueArrayBasedYoung

/*
    Sample Output:

    Total words in Dictionary:    938969
    Palindromes in Dictionary:     76391
    Process finished with exit code 0

 */
