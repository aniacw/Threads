package Exe1;

import java.io.*;

public class Worker extends Thread {

    private String inInput;
    private String outInput;
    private User u = new User();
    private String content;


    public Worker() {
        u = new User();
        this.inInput = u.getIn();
        this.outInput = u.getOut();
    }

    public void run() {

        try {
            readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writeFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("resources\\" + inInput + ".txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            content = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Ania\\Desktop\\nnn.txt");
        byte[] b = content.getBytes();
        byte[] reversedB = new byte[b.length];
        int index = 0;

        for (int i = b.length; i > 0; i--) {
            reversedB[index] = b[i - 1];
            index++;
        }
        try {
            fileOutputStream.write(reversedB);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
