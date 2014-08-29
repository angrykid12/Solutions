package mysolutions.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author m1st
 */
public class AlgorithmsStarter {
    public static void main(String[] args) throws IOException {
/**
 * Problem 1.
 * Given array a of N elements transpose it as follows
 * {a[N-1], a[N-2],…, a[0]}
 * Memory consumption (not including the space for array) – O(1)
 * Running time – O(N)
 */
        Object[] array = {1, 5, 2, 9, 0};
        AlgorithmsSolver.transposeArray(array);
        AlgorithmsSolver.println("Problem 1: " + Arrays.asList(array));

/**
 * Problem 2.
 * Given sorted arrays a of n elements and b of m elements produce sorted array c of n+m elements that consists of all elements from arrays a and b.
 * Program reads and stores the arrays in files a, b and c one number per line.
 * Memory consumption – O(1)
 * Running time – O(n+m)
 */
        AlgorithmsSolver.produceSortedArray("C:\\a.txt", "C:\\b.txt", "C:\\c.txt");
        AlgorithmsSolver.println("Problem 2: see stored file 'c.txt'");

/**
 * Problem 3.
 * The following function double rand() returns a random floating point number evenly distributed over interval [0;1).
 * Write an expression (or a function) that returns
 */
        //a)    a random integer N so that 7 <= N <= 23
        AlgorithmsSolver.println("Problem 3 (a random integer N so that 7 <= N <= 23): " + AlgorithmsSolver.randInt(7, 23));

        //b)    a random number N from set {3.5, 4.5, 5.5, …, 13.5}
        List<Float> numbers = Arrays.asList(3.5f, 4.5f, 5.5f, 6.5f, 7.5f, 8.5f, 9.5f, 10.5f, 11.5f, 12.5f, 13.5f);
        AlgorithmsSolver.println("Problem 3 (a random number N from set {3.5, 4.5, 5.5, …, 13.5}): " + AlgorithmsSolver.randFloat(numbers));

        //c)    a random string from set { “asdf”, “a”, “jkl;”, “cc”, “zaxd” }
        List<String> strings = Arrays.asList("asdf", "a", "jkl;", "cc", "zaxd");
        AlgorithmsSolver.println("Problem 3 (a random string from set { “asdf”, “a”, “jkl;”, “cc”, “zaxd” }): " + AlgorithmsSolver.randString(strings));

/**
 * Problem 4.
 * Given array a of N (N > 1) elements and integer K (0 < K <= N-1) transpose the array as follows
 * {a[K], …, a[N-1], a[0],…, a[K-1]}
 * Memory consumption (not including the space for array) – O(1)
 * Running time – O(N).
 *
 * What data structure(s) can be used to implement the mini-framework for this problem effectively?
 */
        // todo code & answer here
        AlgorithmsSolver.println("Problem 4: todo");

/**
 * Problem 5.
 * Write a program that prints all permutations (in any order) of sequence {1, 2, 3, …, N}.
 * Hint: there are N! permutations.
 */
        // Could be initialized with N elements and it generates all permutations
        AlgorithmsSolver.println("Problem 5 (start):");
        AlgorithmsSolver.permutations(1, 2, 3);
        AlgorithmsSolver.println("Problem 5 (end).");

/**
 * Problem 6.
 * Write a program that takes a string as a parameter and prints out all substrings of the following format: <tag>some text</tag>.
 * Here ‘tag’ can be any alphanumeric character string.
 * The input string is assumed not to have nested tags.
 * Hint: regular expressions should be used for string matching
 *
 * What updates will be required in your program in case of nested tags?
 */
        // Enchantments: Takes a file as a parameter. The case of nested tags resolved also.
        AlgorithmsSolver.println("Problem 6 (start):");
        AlgorithmsSolver.allSubstringsOfNestedTags("C:\\nested_tags.html"); // However, I think that regular expressions are not the best answer here. I'd use XPath to find elements I'm interested in.
        AlgorithmsSolver.println("Problem 6 (end).");
    }
}
