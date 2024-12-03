/******************************************************************************
 *  Compilation:  javac TextCompressor.java
 *  Execution:    java TextCompressor - < input.txt   (compress)
 *  Execution:    java TextCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   abra.txt
 *                jabberwocky.txt
 *                shakespeare.txt
 *                virus.txt
 *
 *  % java DumpBinary 0 < abra.txt
 *  136 bits
 *
 *  % java TextCompressor - < abra.txt | java DumpBinary 0
 *  104 bits    (when using 8-bit codes)
 *
 *  % java DumpBinary 0 < alice.txt
 *  1104064 bits
 *  % java TextCompressor - < alice.txt | java DumpBinary 0
 *  480760 bits
 *  = 43.54% compression ratio!
 ******************************************************************************/

/**
 *
 * Best thing to do is choose most Feasible option and then pursue the most simple version of that algorithm, and restart
 * as needed after pursuing that option.
 *
 * The {@code TextCompressor} class provides static methods for compressing
 *  and expanding natural language through textfile input.
 *
 *  @author Zach Blick, Damian Villarreal-Ayala
 *
 *  - Ideas for patterns & ways to compress:
 *  - Pattern-idea:
 *
 *  Based on different pre- & suffixes
 *  Letter pairings
 *  Words
 *  - including spaces around words? (if present)
 *  - Avoid fixed-length sequences bc it's not that flexible (maybe window of 3...)
 *  - n-squared algorithms and larger won't work because it starts to become prohibitive
 *  Codes(n) <-> Letters (6)<-> ASCII (2 escape codes per state?)
 *  2^n
 *
 * Would it make sense to read thorugh file, save the most freq. appearing words, and then use MFA words to compress?
 * - As list of words runs out, refresh list of MFA words? - Save list of words as file is initially being read through
 * - As the list of words runs out, the textfile will become empty
 *
 * ASCII values for null, beginning and end of alpha
 * 0 - null
 * 1 - [START OF HEADING]
 * 2 - [START OF TEXT]
 * 3 - [END OF TEXT]
 * 11 - [VERTICAL TAB] - does this mean a break line when u press shift? would removing even help compress?
 * 32 - [SPACE] - doesn't print anything out
 * 65 - A
 * 90 - Z
 * 97 - a
 * 122 - z
 *
 * Would it make sense to assign a number to each char as a signifier of how many times they appear?
 * if the char appears more than once in subsequent order, replace subsequent chars with number of chars - 1.
 * Does it make more sense to compress spaces and line breaks at the end? Feel like it'll make compressing letters hard.
 */

public class TextCompressor {

    private static void compress() {
        /**
         * To begin, start by reading in using either a window of 3 or by focusing most frequently used words in first 100.
         * A header is gonna be needed
         * Read in each char and
         */
        char test = BinaryStdIn.readChar();


        // TODO: Complete the compress() method

        BinaryStdOut.close();
    }

    private static void expand() {
        /**
         *
         */
        // TODO: Complete the expand() method

        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
