package mysolutions.algorithms;

import org.apache.commons.io.FileUtils;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;

/**
 * @author m1st
 *         todo: JUnit tests, JavaDocs, Comments, less Memory and Running time consumption, more Negative cases and Exceptions handling
 */
public class AlgorithmsSolver {
    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static Object[] transposeArray(Object[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }

    public static Object[] readFile(String filePath) throws FileNotFoundException {
        ArrayList<Object> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list.toArray();
    }

    public static void writeFile(String filePath, Object[] data) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(filePath));
        for (Object object : data) {
            writer.println(object);
        }
        writer.close();
    }

    /**
     * The key is to use merge sorting.
     */
    public static void produceSortedArray(String aPath, String bPath, String cPath) throws FileNotFoundException {
        Object[] a = readFile(aPath);
        Object[] b = readFile(bPath);
        ArrayList list = new ArrayList(a.length + b.length);
        list.addAll(asList(a));
        list.addAll(asList(b));
        Collections.sort(list);
        Object[] c = list.toArray();
        writeFile(cPath, c);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static float randFloat(List<Float> list) {
        shuffle(list);
        return list.get(0);
    }

    public static String randString(List<String> list) {
        shuffle(list);
        return list.get(0);
    }

    /**
     * Don't reinvent the wheel. Usage of CombinatoricsLib library.
     */
    public static void permutations(Integer... numbers) {
        ICombinatoricsVector<Integer> initialVector = Factory.createVector(numbers);
        Generator<Integer> generator = Factory.createPermutationGenerator(initialVector);
        for (ICombinatoricsVector<Integer> perm : generator) {
            System.out.println(perm);
        }
    }

    /**
     * Don't reinvent the wheel. Usage of Commons IO library.
     */
    public static void allSubstringsOfNestedTags(String filePath) throws IOException {
        File file = new File(filePath);
        String nestedTags = FileUtils.readFileToString(file);
        String noTagsString = null;
        if (nestedTags != null) {
            noTagsString = nestedTags.replaceAll("\\<.*?\\>", "").replaceAll("\\r\\n\\t", "").replaceAll("\\r\\n", "");
        }
        String[] result = new String[6];
        if (noTagsString != null) {
            result = noTagsString.split("\\s");
        }
        String sub;
        for (String string : result) {
            int length = string.length();
            for (int c = 0; c < length; c++) {
                for (int i = 1; i <= length - c; i++) {
                    sub = string.substring(c, c + i);
                    System.out.println(sub);
                }
            }
        }
    }
}
