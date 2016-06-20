Solutions
=========

Задача из hackerrank.com: Ominous Cities
==
1. Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
2. Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
3. Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше) средней, а также длину.
4. Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если таких слов несколько, найти первое из них.
5. Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
6. Ввести n слов с консоли. Найти слово, символы в котором идут в стро-гом порядке возрастания их кодов. Если таких слов несколько, найти первое из них.
7. Ввести n слов с консоли. Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.
8. Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром. Если таких слов больше одного, найти второе из них.
9. Написать программы решения задач 1–8, осуществляя ввод строк как аргументов командной строки.
10. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k].
11. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 5], [0, 10], [5, 15], [10, 10k].
12. Написать программу, которая выводит числа от 1 до 25 в виде матрицы 5x5 слева направо и сверху вниз.
13. Написать программу, позволяющую корректно находить корни квад-ратного уравнения. Параметры уравнения должны задаваться с ко-мандной строки.
14. Ввести число от 1 до 12. Вывести на консоль название месяца, соответ-ствующего данному числу. (Осуществить проверку корректности ввода чисел).
==
Problem 1.
Given array a of N elements transpose it as follows
{a[N-1], a[N-2],…, a[0]}
Memory consumption (not including the space for array) – O(1)
Running time – O(N)

Problem 2. 
Given sorted arrays a of n elements and b of m elements produce sorted array c of n+m elements that consists of all elements from arrays a and b.
Program reads and stores the arrays in files a, b and c one number per line.
Memory consumption – O(1)
Running time – O(n+m)

Problem 3. 
The following function double rand() returns a random floating point number evenly distributed over interval [0;1).
Write an expression (or a function) that returns
a) a random integer N so that 7 <= N <= 23
b) a random number N from set {3.5, 4.5, 5.5, …, 13.5}
c) a random string from set { “asdf”, “a”, “jkl;”, “cc”, “zaxd” }

Problem 4. 
Given array a of N (N > 1) elements and integer K (0 < K <= N-1) transpose the array as follows
{a[K], …, a[N-1], a[0],…, a[K-1]}
Memory consumption (not including the space for array) – O(1)
Running time – O(N).

What data structure(s) can be used to implement the mini-framework for this problem effectively?

Problem 5. 
Write a program that prints all permutations (in any order) of sequence {1, 2, 3, …, N}.
Hint: there are N! permutations.

Problem 6. 
Write a program that takes a string as a parameter and prints out all substrings of the following format: <tag>some text</tag>.
Here ‘tag’ can be any alphanumeric character string.
The input string is assumed not to have nested tags.
Hint: regular expressions should be used for string matching

What updates will be required in your program in case of nested tags?
==
Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
1. Четные и нечетные числа.
2. Наибольшее и наименьшее число.
3. Числа, которые делятся на 3 или на 9.
4. Числа, которые делятся на 5 и на 7.
5. Элементы, расположенные методом пузырька по убыванию модулей.
6. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Наибольший общий делитель и наименьшее общее кратное этих чисел.
8. Простые числа.
9. Отсортированные числа в порядке возрастания и убывания.
10. Числа в порядке убывания частоты встречаемости чисел.
11. “Счастливые” числа.
12. Числа Фибоначчи: f0 = f1 = 1, f (n) = f (n–1) + f (n–2).
13. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.
14. Элементы, которые равны полусумме соседних эле¬ментов.
15. Период десятичной дроби p = m/n для первых двух целых положительных чисел n и m, расположенных подряд.
16. Построить треугольник Паскаля для первого положительного числа. 
