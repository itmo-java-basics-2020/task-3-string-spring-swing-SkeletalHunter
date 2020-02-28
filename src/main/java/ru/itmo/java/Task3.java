package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray != null)
        {
            if(inputArray.length == 0 || inputArray.length == 1)
            {
                return inputArray;
            }else
            {
                int helper = inputArray[inputArray.length - 1];
                for(int i = inputArray.length - 1; i > 0; i--)
                {
                    inputArray[i] = inputArray[i - 1];
                }
                inputArray[0] = helper;
                return inputArray;
            }
        } else
            {
                return new int[]{};
            }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0){
            return 0;
        } else {
            if(inputArray.length == 1){
                return inputArray[0];
            } else {
                if (inputArray.length == 2){
                    return inputArray[0] * inputArray[1];
                }else{
                    int firstMax = Math.max(inputArray[0], inputArray[1]), secondMax = Math.min(inputArray[0], inputArray[1]);
                    for(int i = 2; i < inputArray.length; i++){
                        if(inputArray[i] > firstMax){
                            secondMax = firstMax;
                            firstMax = inputArray[i];
                        }else{
                            if (inputArray[i] > secondMax){
                                secondMax = inputArray[i];
                            }
                        }
                    }
                return firstMax * secondMax;
                }
            }
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }else{
            int amount = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'b' || input.charAt(i) == 'A' || input.charAt(i) == 'B'){
                    amount++;
                }
            }
            return amount * 100 / input.length();
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null){
            return false;
        }else{
            if(input.length() == 0){
                return true;
            }else{
                for(int i = 0; i < input.length() / 2; i++){
                    if(input.charAt(i) != input.charAt(input.length() - 1 - i)){
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if(input == null || input.length() == 0){
            return "";
        }else{
            String result = "";
            char previousLetter = input.charAt(0);
            int length = 0;
            for(int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == previousLetter) {
                    length++;
                } else {
                    result += "" + previousLetter + length;
                    previousLetter = input.charAt(i);
                    length = 1;
                }
            }
            result += "" + previousLetter + length;
            return result;
        }
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(one == null || two == null || one.length() == 0 || two.length() == 0){
            return false;
        }else{
            if(one.length() != two.length()){
                return false;
            }else{
                StringBuilder sb = new StringBuilder(two);
                for(int i = 0; i < one.length(); i++){
                    boolean found = false;
                    for(int j = 0; j < sb.length(); ){
                        if(one.charAt(i) == sb.charAt(j)){
                            sb.deleteCharAt(j);
                            found = true;
                            break;
                        }else{
                            j++;
                        }
                    }
                    if(!found){
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s.length() == 0){
            return false;
        }else{
            for(int i = 0; i < s.length() - 1; i++){
                for(int j = i + 1; j < s.length(); j++){
                    if(s.charAt(i) == s.charAt(j)){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m.length == 0){
            return new int[][]{{}, {}};
        }else{
            for(int i = 0; i < m.length; i++){
                for(int j = i + 1; j < m[i].length; j++){
                    int helper = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = helper;
                }
            }
            return m;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null || inputStrings.length == 0){
            return "";
        }else{
            if(separator == null){
                separator = ' ';
            }
            StringBuilder sb = new StringBuilder();
            sb.append(inputStrings[0]);
            for(int i = 1; i < inputStrings.length; i++){
                sb.append(separator)
                .append(inputStrings[i]);
            }
            return sb.toString();
        }
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || prefix == null){
            return 0;
        }else{
            int count = 0;
            for(int i = 0; i < inputStrings.length; i++){
                if(inputStrings[i].startsWith(prefix)){
                    count++;
                }
            }
            return count;
        }
    }
}
