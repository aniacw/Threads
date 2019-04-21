package Exe2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Numbers extends Thread {

    private byte numbersList[];
    private Integer randomNumbersArray[];
    private Integer[] newArray;

    //od razu w konstruktorze uzupelnial tablice wylosowanymi liczbami
    public Numbers() {
        numbersList = new byte[1000000];
        randomNumbersArray = new Integer[1000000];
        newArray = new Integer[1000000];
        draw();
    }


    //czytanie liczb z pliku
    public void readNumbers(String fileName) throws IOException {
        numbersList = Files.readAllBytes(Paths.get("resources\\" + fileName));
        synchronized (randomNumbersArray) {
            for (int i = 0; i < numbersList.length; i++) {
                randomNumbersArray[i] = (int) numbersList[i];
            }
        }
    }


    //losowanie liczb
    public void draw() {
        for (int i = 0; i < 1000000; i++) {
            int random = (int) Math.random();
            byte b = (byte) random;
            numbersList[i] = b;
        }
    }

    //zapisywanie przeliczonych fragmentow tablicy do nowej tablicy
    public void write(String fileName, int splitIndex) throws IOException {
        for(int i = 0; i < splitIndex; i++){
            newArray[i] = 
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
