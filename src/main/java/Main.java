

public class Main {
    private static int count = 0;

    public static void main(String[] args){
        String arr[][] = {{"4", "5", "6", "2"}, {"3", "4", "5", "8"}, {"8", "10", "15", "0"}, {"7", "s", "6", "23"}};
        try {
            arraySum(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println("Сумма элементов массива равна: " + count);
    }


    public static void arraySum (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].length != 4 || arr.length != 4){
                    throw new MyArraySizeException(" Массив должен иметь размер 4х4");
                }
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Находится в ячейке " + i + " " + j);
                }
            }
        }
    }
}

