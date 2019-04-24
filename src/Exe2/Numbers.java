package Exe2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

//numbers do wczytania, zapisu danych i podzialu na wątki
//konkretne dzialania niech wykona oddzielna klasa Worker wewnętrzna względem Numbers
//Worker dostaje ref na tablicę, tab wynikową i zakres indeksów na których przeprowadza obliczenia
//iteruje po danych, wykonuje oper mat, zapisuje w tab wynikowej na takim samym indeksie
public class Numbers extends Thread {

    private double[] numbersList;
    private double[] newArray;

    //od razu w konstruktorze uzupelnial tablice wylosowanymi liczbami
    public Numbers(int arraySize) {
        numbersList = new Integer[arraySize];
        newArray = new Integer[arraySize];
        draw();
    }


    //czytanie liczb z pliku
    public void readNumbers(String fileName) throws IOException {
        int i = 0;
        Scanner scanner = new Scanner("resources\\" + fileName);
        while(scanner.hasNextLine()){
            synchronized (numbersList) {
                String newLine = scanner.nextLine();
                numbersList[i] = Integer.parseInt(newLine);
                i++;
            }
        }
            }


    //losowanie liczb
    public void draw() {
        for (int i = 0; i < 1000000; i++) {
            int random = (int) (Math.random()*100);
            Integer s = random;
            numbersList[i] = s;
        }
    }

    //zapisywanie przeliczonych fragmentow tablicy do nowej tablicy
    public void write(String fileName, int splitIndex) throws IOException {
        for (int i = 0; i < splitIndex; i++) {
            synchronized (newArray) {
               // newArray[i] =
            }
        }
        Files.write(Paths.get("resources\\" + fileName), numbersList);
    }


    public void run() {
        for (Integer integer : randomNumbersArray)
            Math.sin((Math.cos(Math.log(Math.tan(integer)))) + Math.cos(Math.sin(Math.log(Math.log(1.0 / Math.tan(integer))))));

    }

    public Integer[] getRandomNumbersArray() {
        return randomNumbersArray;
    }
}
