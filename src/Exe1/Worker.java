package Exe1;

import java.io.*;

public class Worker extends Thread {

    private String inInput;
    private String outInput;
    private User user;
    private String content;


    public Worker() {
//        this.
//        this.
    }

    public void run() {
        inInput = user.getIn();
        System.out.println(inInput);
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
        inInput = user.getIn();
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
        outInput = user.getOut();
        FileOutputStream fileOutputStream = new FileOutputStream("resources\\" + outInput + ".txt");
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
