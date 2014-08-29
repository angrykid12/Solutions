package mysolutions.numbers;

import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

import static mysolutions.CommonMethods.print;
import static mysolutions.CommonMethods.println;

/**
 * @author m1st
 */
public class NumbersSolver {
    public static int[] toIntArray(Collection<Integer> list) {
        int[] result = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result[i] = it.next();
        }
        return result;
    }

    public static int[] readInput(Scanner sc) {
        List<Integer> input = new ArrayList<Integer>();
        print("Введите целые числа через пробел, для окончания введите q: ");
        while (sc.hasNext()) {
            String number = sc.next();
            if (number.equals("q")) {
                break;
            } else {
                try {
                    input.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    System.err.println("Неправильный формат: " + e + "\n");
                }
            }
        }
        return toIntArray(input);
    }

    public static int[] readInput(InputStream is) {
        return readInput(new Scanner(is));
    }

    public static int[] readInput() {
        return readInput(System.in);
    }

    public static List<Integer> toIntegerList(int[] array) {
        List<Integer> result = new ArrayList<Integer>(array.length);
        for (int element : array) {
            result.add(element);
        }
        return result;
    }

    public static void findEvenAndOddNumbers(int[] sourceNumbers) {
        List<Integer> evens = new ArrayList<Integer>();
        List<Integer> odds = new ArrayList<Integer>();
        for (int sourceNumber : sourceNumbers) {
            if (sourceNumber % 2 == 0) {
                evens.add(sourceNumber);
            } else {
                odds.add(sourceNumber);
            }
        }
        println("Чётные числа: " + evens);
        println("Нечётные числа: " + odds);
    }

    public static void findMaxAndMinNumbers(int[] sourceNumbers) {
        List<Integer> numbers = toIntegerList(sourceNumbers);
        println("Наибольшее число: " + Collections.max(numbers));
        println("Наименьшее число: " + Collections.min(numbers));
    }

    public static void findModNumbers(int[] sourceNumbers, int... args) {
        print("Числа, которые делятся на " + Arrays.toString(args) + ": ");
        if (args.length == 1) {
            for (int sourceNumber : sourceNumbers) {
                if (sourceNumber % args[0] == 0) {
                    print(sourceNumber + ", ");
                }
            }
        } else if (args.length == 2) {
            for (int sourceNumber : sourceNumbers) {
                if ((sourceNumber % args[0] == 0 && sourceNumber % args[1] == 0)) {
                    print(sourceNumber + ", ");
                }
            }
        } else if (args.length >= 3) {
            HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
            for (int sourceNumber : sourceNumbers) {
                for (int i = 0; i < args.length - 1; i++) {
                    for (int i2 = 2; i2 < args.length; i2++) {
                        if ((sourceNumber % args[i] == 0 && sourceNumber
                                % args[i + 1] == 0)
                                && (sourceNumber % args[0] == 0 && sourceNumber
                                % args[i2] == 0)) {
                            if (uniqueNumbers.add(sourceNumber)) {
                                print(sourceNumber + ", ");
                            }
                        }
                    }
                }
            }
        }
        println();
    }

    public static void sortNumbersWithBubbleReverseByAbs(int[] sourceNumbers) {
        boolean swapped;
        int temp, j = 0;
        do {
            swapped = false;
            j++;
            for (int i = 0; i < sourceNumbers.length - j; i++) {
                if (Math.abs((long) sourceNumbers[i]) < Math
                        .abs((long) sourceNumbers[i + 1])) {
                    temp = sourceNumbers[i];
                    sourceNumbers[i] = sourceNumbers[i + 1];
                    sourceNumbers[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        print("Элементы, расположенные методом пузырька по убыванию модулей: "
                + Arrays.toString(sourceNumbers) + "\n");
    }

    public static void findNumbersWithThreeDifferentDigits(int[] sourceNumbers) {
        int digit1, digit2, digit3;
        print("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр: ");
        for (int sourceNumber : sourceNumbers) {
            digit1 = sourceNumber / 100;
            digit2 = sourceNumber / 10 % 10;
            digit3 = sourceNumber % 10;
            // Ищем трехзначные числа
            if ((sourceNumber >= 100 && sourceNumber <= 999)
                    || (sourceNumber <= -100 && sourceNumber >= -999)) {
                if ((digit1 != digit2) && (digit2 != digit3)
                        && (digit1 != digit3)) {
                    print(sourceNumber + ", ");
                }
            }
        }
        println();
    }

    public static long findGreatestCommonDivisor(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void findGreatestCommonDivisor(int[] sourceNumbers) {
        long result = sourceNumbers[0];
        if (result == 0) {
            println("Наибольший общий делитель: " + result);
        } else {
            for (int i = 1; i < sourceNumbers.length; i++) {
                result = findGreatestCommonDivisor(result, sourceNumbers[i]);
            }
            println("Наибольший общий делитель: " + result);
        }
    }

    public static long findLeastCommonMultiple(long a, long b) {
        return a * (b / findGreatestCommonDivisor(a, b));
    }

    /**
     * Метод вычисляет НОК чисел в массиве. Вычисление завершается на первом
     * нулевом числе (оно не входит в НОК). <strong>Результат метода в случае
     * переполнения не определен</strong>
     *
     * @param sourceNumbers числа для нахождения НОК
     * @return НОК. В случае переполнения результат не определен.
     */
    public static void findLeastCommonMultiple(int[] sourceNumbers) {
        long result = sourceNumbers[0];
        if (result == 0) {
            println("Наименьшее общее кратное: " + result);
        } else {
            for (int i = 1; i < sourceNumbers.length; i++) {
                if (sourceNumbers[i] == 0) {
                    break;
                }
                result = findLeastCommonMultiple(result, sourceNumbers[i]);
            }
        }
        println("Наименьшее общее кратное: " + result);
    }

    //TODO: fix (prime nums: 2, 3, 5, 7, 11, 13, ...)
    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 != 0) {
            return true;
        }
        final double ceiledNumberSqrt = Math.ceil(Math.sqrt(number));
        for (long i = 3; i <= ceiledNumberSqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return false;
    }

    public static void findPrimeNumbers(int[] sourceNumbers) {
        print("Простые числа: ");
        for (int sourceNumber : sourceNumbers) {
            if (isPrimeNumber(sourceNumber)) {
                print(sourceNumber + ", ");
            }
        }
        println();
    }

    public static void sortNumbersByAscAndDesc(int[] sourceNumbers) {
        List<Integer> numbers = toIntegerList(sourceNumbers);
        Collections.sort(numbers);
        println("Отсортированные числа в порядке возрастания: " + numbers);
        Collections.reverse(numbers);
        println("Отсортированные числа в порядке убывания: " + numbers);
    }

    public static Map<Integer, Integer> sortNumbersWithDescByValue(
            Map<Integer, Integer> map) {
        List<Entry<Integer, Integer>> frequencyList = new ArrayList<Entry<Integer, Integer>>(
                map.entrySet());
        Collections.sort(frequencyList,
                new Comparator<Entry<Integer, Integer>>() {
                    public int compare(Entry<Integer, Integer> o1,
                                       Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Entry<Integer, Integer> frequency : frequencyList) {
            result.put(frequency.getKey(), frequency.getValue());
        }
        return result;
    }

    public static void findNumbersFrequencyByDesc(int[] sourceNumbers) {
        List<Integer> numbers = toIntegerList(sourceNumbers);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int frequency = 1;
        for (Integer number : numbers) {
            if (map.containsKey(number)) {
                map.put(number, ++frequency);
            } else {
                map.put(number, 1);
            }
        }
        println("Числа в порядке убывания частоты встречаемости чисел (число=встречаемость): "
                + sortNumbersWithDescByValue(map));
    }

    public static void findHappyNumbers(int[] sourceNumbers) {
        print("“Счастливые” числа (сумма 1-ой пары чисел = сумме 2-ой пары): ");
        int digit1, digit2, digit3, digit4;
        for (int sourceNumber : sourceNumbers) {
            if ((sourceNumber >= 1000 && sourceNumber <= 9999)
                    || (sourceNumber <= -1000 && sourceNumber >= -9999)) {
                digit1 = sourceNumber / 1000;
                digit2 = sourceNumber / 100 % 10;
                digit3 = sourceNumber % 100 / 10;
                digit4 = sourceNumber % 10;
                if (digit1 + digit2 == digit3 + digit4) {
                    print(sourceNumber + ", ");
                }
            }
        }
        println();

    }

    /**
     * Метод находит числа Фибоначчи в массиве. <strong>Результат метода в
     * случае переполнения не определен</strong>
     *
     * @param sourceNumbers числа для нахождения чисел Фибоначчи
     * @return числа Фибоначчи. В случае переполнения результат не определен.
     */
    public static void findFibonacciNumbers(int[] sourceNumbers) {
        print("Числа Фибоначчи: ");
        if (sourceNumbers.length < 3) {
            println("Количество чисел меньше < 3");
            return;
        }
        if (sourceNumbers[0] == 0) {
            print("0, ");
            if (sourceNumbers[1] == 1) {
                print("1, ");
            }
        }
        for (int i = 2; i < sourceNumbers.length; i++) {
            if (sourceNumbers[i] == ((long) sourceNumbers[i - 2] + (long) sourceNumbers[i - 1])) {
                print(sourceNumbers[i] + ", ");
            }
        }
        println();
    }

    public static long reverseInt(int value) {
        long result = 0;
        while (value != 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }
        return result;
    }

    public static void findPalindromicNumbers(int[] sourceNumbers) {
        print("Числа-палиндромы: ");
        for (int sourceNumber : sourceNumbers) {
            if (sourceNumber == reverseInt(sourceNumber)) {
                print(sourceNumber + ", ");
            }
        }
        println();
    }

    /**
     * Метод находит элементы, которые равны полусумме соседних элементов в
     * массиве. <strong>Результат метода в случае переполнения не
     * определен</strong>
     *
     * @param sourceNumbers числа для нахождения элементов, которые равны полусумме
     *                      соседних элементов в массиве
     * @return элементы, которые равны полусумме соседних элементов в массиве. В
     * случае переполнения результат не определен.
     */
    public static void findNumbersOfHalfSumOfNeighbors(int[] sourceNumbers) {
        print("Элементы, которые равны полусумме соседних элементов: ");
        if (sourceNumbers.length < 3) {
            println("Количество чисел меньше < 3");
            return;
        }
        for (int i = 1; i < sourceNumbers.length - 1; i++) {
            if (sourceNumbers[i] == ((double) ((long) sourceNumbers[i - 1] + (long) sourceNumbers[i + 1]) / 2)) {
                print(sourceNumbers[i] + ", ");
            }
        }
        println();
    }

    public static int[] findFirstTwoPositiveNumbersInARow(int[] sourceNumbers) {
        int[] twoPositiveNumbers = new int[2];
        for (int i = 0; i < sourceNumbers.length - 1; i++) {
            if ((sourceNumbers[i] > 0) && (sourceNumbers[i + 1] > 0)) {
                twoPositiveNumbers[0] = sourceNumbers[i];
                twoPositiveNumbers[1] = sourceNumbers[i + 1];
                break;
            }
        }
        return twoPositiveNumbers;
    }

    public static void findPeriodForFirstTwoPositiveNumbersInARow(
            int[] sourceNumbers) {
        final String message = "Период десятичной дроби для первых двух целых положительных чисел, расположенных подряд: ";
        if (sourceNumbers.length < 2) {
            println(message + "Количество чисел < 2");
            return;
        }
        int[] twoPositiveNumbers = findFirstTwoPositiveNumbersInARow(sourceNumbers);
        if ((twoPositiveNumbers[0] <= 0) && (twoPositiveNumbers[1] <= 0)) {
            println(message
                    + "Нет двух целых положительных чисел, расположенных подряд");
            return;
        }
        int numerator = twoPositiveNumbers[0];
        int denominator = twoPositiveNumbers[1];
        if (numerator % denominator == 0) {
            println(message + numerator / denominator + ".(0) = " + numerator
                    + " / " + denominator);
            return;
        }
        // Выделение из знаменателя наибольшей 2^
        int s = denominator % 2;
        int l = 0;
        while (s == 0) {
            denominator = denominator / 2;
            s = denominator % 2;
            l++;
        }
        // Выделение из знаменателя наибольшей 5^
        s = denominator % 5;
        int l1 = 0;
        while (s == 0) {
            denominator = denominator / 5;
            s = denominator % 5;
            l1++;
        }
        // Вычисление длины периода с новым знаменателем
        int periodLenth = 1;
        int r = 10;
        while (r != 1) {
            r = (10 * r) % denominator;
            if (r == 0) {
                break;
            }
            periodLenth++;
        }
        long beforePeriodLenth;
        if (l1 > l) {
            beforePeriodLenth = l1;
        } else {
            beforePeriodLenth = l;
        }
        denominator = twoPositiveNumbers[1];
        print(message + numerator / denominator + ".");
        numerator = numerator % denominator;
        for (int i = 0; i < beforePeriodLenth; i++) {
            print((numerator * 10) / denominator);
            numerator = (numerator * 10) % denominator;
        }
        print("(");
        for (int i = 0; i < periodLenth; i++) {
            print((numerator * 10) / denominator);
            numerator = (numerator * 10) % denominator;
        }
        print(") = " + twoPositiveNumbers[0] + " / " + twoPositiveNumbers[1]
                + "\n");
    }

    public static int findFirstPositiveNumber(int[] sourceNumbers) {
        for (int sourceNumber : sourceNumbers) {
            if (sourceNumber > 0) {
                return sourceNumber;
            }
        }
        return 0;
    }

    public static void buildPascalTriangleForFirstPositiveNumber(
            int[] sourceNumbers) {
        final int firstPositiveNumber = findFirstPositiveNumber(sourceNumbers);
        final String message = "Треугольник Паскаля для первого положительного числа: ";
        if (firstPositiveNumber == 0) {
            println(message + "Нет чисел > 0");
        }
        final int rows = 5;
        println(message);
        for (int y = 0; y < rows; y++) {
            int c = firstPositiveNumber;
            for (int i = 0; i < rows - y; i++) {
                print("   ");
            }
            for (int x = 0; x <= y; x++) {
                print("   " + c + " ");
                c = c * (y - x) / (x + 1);
            }

            println();
        }
    }
}
