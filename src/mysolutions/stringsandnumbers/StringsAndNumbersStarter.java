package mysolutions.stringsandnumbers;

import static mysolutions.stringsandnumbers.StringsAndNumbersSolver.*;

/**
 * @author m1st
 */
public class StringsAndNumbersStarter {
    public static void main(String[] args) {
        // 0. Ввести n строк с консоли.
        String[] sourceStrings = readInput();
        if (sourceStrings.length == 0) {
            System.out.println("Нет строк. Программа завершена.");
            System.exit(0);
        }

        // 1. Найти самую короткую и самую длинную строки. Вывести найденные
        // строки и их длину.
        findShortestAndLongestString(sourceStrings);

        // 2. Упорядочить и вывести строки в порядке возрастания (убывания)
        // значений их длины.
        findStringsLengthByAscAndDesc(sourceStrings);

        // 3. Вывести на консоль те строки, длина которых меньше (больше)
        // средней, а также длину.
        findStringsLessAndGreaterThanAverageLength(sourceStrings);

        // 4. Найти слово, в котором число различных символов минимально. Если
        // таких слов несколько, найти первое из них.
        String[] sourceWords = toStringArray(findWords(sourceStrings));
        findWordWithMinDifferentSymbols(sourceWords);

        // 5. Найти количество слов, содержащих только символы латинского
        // алфавита, а среди них – количество слов с равным числом гласных и
        // согласных букв.
        findWordsWithEqualNumberOfVowelsAndConsonantsInLatin(sourceWords);

        // 6. Найти слово, символы в котором идут в строгом порядке возрастания
        // их кодов. Если таких слов несколько, найти первое из них.
        findFirstWordWithSymbolCodesInAsc(sourceWords);

        // 7. Найти слово, состоящее только из различных символов. Если таких
        // слов несколько, найти первое из них.
        findWordWithOnlyDifferentSymbols(sourceWords);

        // 8. Среди слов, состоящих только из цифр, найти слово-палиндром. Если
        // таких слов больше одного, найти второе из них.
        findFirstOrSecondNumericPalindromicWord(sourceStrings);

        // 9. Написать программы решения задач 1–8, осуществляя ввод строк как
        // аргументов командной строки.
        /**
         * To uncomment the statements below for exercise 9
         */
//	 findShortestAndLongestString(sourceStrings); // 1.
//	 findStringsLengthByAscAndDesc(sourceStrings); // 2.
//	 findStringsLessAndGreaterThanAverageLength(sourceStrings); // 3.
//	 findWordWithMinDifferentSymbols(sourceStrings); // 4.
//	 findWordsWithEqualNumberOfVowelsAndConsonantsInLatin(sourceWords); // 5.
//	 findFirstWordWithSymbolCodesInAsc(sourceWords); // 6.
//	 findWordWithOnlyDifferentSymbols(sourceWords); // 7.
//	 findFirstOrSecondNumericPalindromicWord(sourceStrings); // 8.

        // 10. Используя оператор switch, написать программу, которая выводит на
        // экран сообщения о принадлежности некоторого значения k интервалам
        // (-10k, 0], (0, 5], (5, 10], (10, 10k].
        int[] kSourceValues = toIntArray(sourceStrings);
        isBelongToInterval(kSourceValues, "(-10000, 0]", "(0, 5]", "(5, 10]",
                "(10, 10000]");

        // 11. Используя оператор switch, написать программу, которая выводит на
        // экран сообщения о принадлежности некоторого значения k интервалам
        // (-10k, 5], [0, 10], [5, 15], [10, 10k].
        isBelongToInterval(kSourceValues, "(-10000, 5]", "[0, 10]", "[5, 15]",
                "[10, 10000]");

        // 12. Написать программу, которая выводит числа от 1 до 25 в виде
        // матрицы 5x5 слева направо и сверху вниз.
        printIntFilled5x5Matrix('→', '↓');

        // 13. Написать программу, позволяющую корректно находить корни
        // квадратного уравнения. Параметры уравнения должны задаваться с
        // командной строки.
        findQuadraticRoots(args);

        // 14. Ввести число от 1 до 12. Вывести на консоль название месяца,
        // соответствующего данному числу. (Осуществить проверку корректности
        // ввода чисел).
        getMonthFromInt(sourceStrings);
    }
}
