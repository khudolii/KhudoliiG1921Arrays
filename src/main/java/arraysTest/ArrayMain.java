package arraysTest;

import java.util.Arrays;
import java.util.Random;

/*
Khudolii Yevhenii G1921
*/
public class ArrayMain {

    /*Counting matches of 'main' string (War and Peace) with elements of another string (letters)*/
    public static int counterOfLetters(String text, String letters) {
        int allLetter = 0; //number of identical elements
        for (int i = 0; i < letters.length(); i++) {
            int counter = 0; //number of matches for a single elements
            for (int j = 0; j < text.length(); j++) {
                if (letters.charAt(i) == text.toLowerCase().charAt(j)) { //comparing each element of first string with elements of another string
                    counter++;
                    allLetter++;
                }

            }
            System.out.println(letters.charAt(i) + ": " + counter);
        }
        return allLetter;
    }

    /*Search for the sum of negative elements of a two-dimensional array*/
    public static void negativeSumDbArr() {
        int[][] a = new int[5][5];
        int sum = 0;
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd.nextInt(21) - 10;
                if (a[i][j] < 0) {
                    sum += a[i][j];
                }
            }
        }
        for (int i = 0; i < a.length; i++, System.out.println()) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
        }
        System.out.println("Sum of negative: " + sum);
    }

    /*Finding a multiplication of dividing by 4 between two first elements with value 5*/
    public static void mulOfFirstFives() {
        int[] a = {5, 6, 35, 1, 5, 2, 3, 6, 2, 1, 4, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int count = 0; //counter of elements with value '5'
        float mul = 1; //result of multiplication
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 5) { //search of ellemnts with value '5'
                count++;
            }
            if (count == 2) { //when a second element with value 5 is found
                int j = i - 1;
                while (a[j] != 5) { // go in the opposite direction and find the result. Stop when find the first element with value 5
                    mul *= a[j] % 4;
                    j--;
                }
                System.out.println("\nMul " + mul);
                break;
            }
        }
        if (count < 2) { //when elements with value '5' < 2x
            System.out.println("The calculation is impossible. No 2х'5'");
        }
    }

    /*Finding percentage between the results of two arrays*/
    public static void divOfArrays() {
        int[] a = new int[12];
        int[] b = new int[12];
        //int [] a = {4,5,7,20,14,11,10,2,5,7,8};
        double mulA = 1;
        int sumB = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10);
            b[i] = ((int) (Math.random() * 10));
            mulA *= a[i] % 3;
            sumB += b[i] % 4;
        }
        System.out.println("A: " + Arrays.toString(a) + "|Mul*=  A % 3 = " + mulA);
        System.out.println("B: " + Arrays.toString(b) + "|Sum*=  B % 4 = " + sumB);
        if (mulA > sumB) {
            System.out.println("MulA > SumB");
        } else if (mulA < sumB) {
            System.out.println("MulA < SumB");
        } else {
            System.out.println("MulA = SumB");
        }

    }

    /*Search for words that are repeated in a string*/
    public static void repeatedWords(String text) {
        String resultValue; //takes the value of a word for comparison
        int counter = 0; // counter to switch to the next word
        text = text.replaceAll("[-.:\",?!]", "").toLowerCase();//remove punctuation marks from a string. Converts all characters to lowercase
        String[] subStr = text.split(" "); //splits strings into an array. Where array element == word
        Arrays.sort(subStr);
        for (int i = 0; i < subStr.length; i++) {
            resultValue = subStr[i];
            int resultCount = 0; //counter of repeat
            for (int j = 0; j < subStr.length; j++) {
                if ((subStr[j].equals(resultValue))) {
                    resultCount++;
                    counter = j; // takes the element number of the last matching word
                }
            }
            i = counter;//switch to the next word
            System.out.println(resultValue + ": " + resultCount);
        }
    }

    /*Search for characters that are repeated more than two times. Creating a separate array from these elements*/
    public static void doubleRepeatInArray() {
        int[] a = {5, 7, 9, 5, 4, 3, 12, 18, 5, 7, 7, 4, 4, 4, 4, 18};
        System.out.println("Input array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        String s = new String();
        Arrays.sort(a);
        int counter = 0;
        Arrays.sort(a);
        int counterUniq = 0;
        for (int i = 0; i < a.length; i++) { //repetition search
            int resultValue = a[i];
            int resultCount = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == resultValue) {
                    resultCount++;
                    counter = j;
                }
            }
            i = counter;
            if (resultCount > 2) {//write elements that are repeated more than two times in string
                s += Integer.toString(resultValue) + " ";
            }
        }
        String strArr[] = s.split(" ");//split a string into an array of strings (where array element == number from the first array)
        int numArr[] = new int[strArr.length];
        System.out.println("\nOutput array: ");
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);//translation of an array of strings into an array of numbers
            System.out.print(numArr[i] + " ");
        }
    }

    public static void main(String[] args) {
        String text = "Над ним не было ничего уже, кроме неба, - высокого неба, не ясного, но все-таки неизмеримо высокого, с тихо ползущими по нём серыми облаками. \"Как тихо, спокойно и торжественно, совсем не так, как я бежал, - подумал князь Андрей, - не так, как мы бежали, кричали и дрались, совсем не так, как с озлобленными и испуганными лицами тащили друг у друга банник француз и артиллерист, - совсем не так ползут облака по этому высокому бесконечному небу. Как же я не видал прежде этого высокого неба? И как я счастлив, что узнал его наконец. Да! Все пустое, все обман, кроме этого бесконечного неба. Ничего, ничего нет, кроме его. Но и того даже нет, ничего нет, кроме тишины, успокоения. И слава богу!\n";
        String vowels = "аеёиоуыэюя";
        String consonants = "бвгджзйклмнпрстфхцчшщъь";

        System.out.println("1. Найти сумму отрицательных чисел двумерного массива.");
        negativeSumDbArr();

        System.out.println("\n2. Найти произведение остатков от деления на 4 всех чисел массива расположенных между двумя первыми 5.");
        mulOfFirstFives();

        System.out.println("\n3. Задать 2 массива. Проверить больше ли произведение остатков от деления на " +
                "3 всех элементов первого массива, сумму остатков от деления на 4 второго массива.");
        divOfArrays();

        System.out.println("\n4. Найти сумму количества всех гласных букв из задачи отрывка \n All vowels letter: ");
        counterOfLetters(text, vowels);

        System.out.println("\n5. Найти количество повторений каждого слова в отрывке");
        repeatedWords(text);

        System.out.println( "\n6. Рассчитать процентное соотношение гласных букв к согласным из отрывка. \n All vowels letter:");
        double allVowels = counterOfLetters(text, vowels);
        System.out.println("All consonants letter: ");
        double allСonsonants = counterOfLetters(text, consonants);
        System.out.println("Vowels: " + allVowels + "\n Consonants: " + allСonsonants + "\n Percentage ratio: " +
                "" + ((allVowels / allСonsonants) * 100) + "%");

        System.out.println("\n7*.Получить массив содержащий все числа из исходного массива которые повторяются более двух раз.");
        doubleRepeatInArray();

    }
}

