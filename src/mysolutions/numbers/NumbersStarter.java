package mysolutions.numbers;

import static mysolutions.numbers.NumbersSolver.*;

/**
 * @author m1st
 */
public class NumbersStarter {
    public static void main(String[] args) {
        // 0. Ввести с консоли n целых чисел и поместить их в массив. На консоль
        // вывести:
        int[] sourceNumbers = readInput();
        if (sourceNumbers.length == 0) {
            System.out.println("Нет чисел. Программа завершена.");
            System.exit(0);
        }

        // 1. Четные и нечетные числа
        findEvenAndOddNumbers(sourceNumbers);

        // 2. Наибольшее и наименьшее число.
        findMaxAndMinNumbers(sourceNumbers);

        // 3. Числа, которые делятся на 3 или на 9.
        findModNumbers(sourceNumbers, 3);
        // 4. Числа, которые делятся на 5 и на 7.

        findModNumbers(sourceNumbers, 5, 7);
        // 5. Элементы, расположенные методом пузырька по убыванию модулей.
        int[] sourceNumbersClone1 = sourceNumbers.clone();
        sortNumbersWithBubbleReverseByAbs(sourceNumbersClone1);

        // 6. Все трехзначные числа, в десятичной записи которых нет одинаковых
        // цифр.
        findNumbersWithThreeDifferentDigits(sourceNumbers);

        // 7. Наибольший общий делитель и наименьшее общее кратное этих чисел.
        findGreatestCommonDivisor(sourceNumbers);
        findLeastCommonMultiple(sourceNumbers);

        // 8. Простые числа.
        findPrimeNumbers(sourceNumbers);

        // 9. Отсортированные числа в порядке возрастания и убывания.
        sortNumbersByAscAndDesc(sourceNumbers);

        // 10. Числа в порядке убывания частоты встречаемости чисел.
        findNumbersFrequencyByDesc(sourceNumbers);

        // 11. “Счастливые” числа.
        findHappyNumbers(sourceNumbers);

        // 12. Числа Фибоначчи: f0 = f1 = 1, f (n) = f (n–1) + f (n–2).
        findFibonacciNumbers(sourceNumbers);

        // 13. Числа-палиндромы, значения которых в прямом и обратном порядке
        // совпадают.
        findPalindromicNumbers(sourceNumbers);

        // 14. Элементы, которые равны полусумме соседних элементов.
        int[] sourceNumbersClone2 = sourceNumbers.clone();
        findNumbersOfHalfSumOfNeighbors(sourceNumbersClone2);

        // 15. Период десятичной дроби p = m/n для первых двух целых
        // положительных чисел n и m, расположенных подряд.
        findPeriodForFirstTwoPositiveNumbersInARow(sourceNumbers);

        // 16. Построить треугольник Паскаля для первого положительного числа.
        buildPascalTriangleForFirstPositiveNumber(sourceNumbers);
    }
}