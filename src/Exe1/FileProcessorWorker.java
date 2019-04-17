package Exe1;

import javafx.util.Pair;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

public abstract class FileProcessorWorker extends Thread {

    protected static class InOutFilenames {
        public String in;
        public String out;

        public InOutFilenames(String in, String out) {
            this.in = in;
            this.out = out;
        }
    }

    private static int lastId = 0;
    private int id;
    private Queue<InOutFilenames> filesQueue;
    private String content;
    private AtomicBoolean running;
    private AtomicBoolean busy;
    private MessageHandler messageHandler;

    public FileProcessorWorker() {
        id = ++lastId;
        filesQueue = new LinkedList<>();
        running = new AtomicBoolean(false);
        busy = new AtomicBoolean(false);
    }

    public void addTask(String inFile, String outFile){
        synchronized (filesQueue){
            filesQueue.add(new InOutFilenames(inFile, outFile));
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }


    public void run() {
        running.set(true);
        while (running.get()) {
            InOutFilenames filenames;
            synchronized (filesQueue){
                filenames = filesQueue.poll();
            }
            try {
                if (filenames == null)
                    Thread.sleep(50);
                else {
                    busy.set(true);
                    long t0 = System.currentTimeMillis();
                    processFile(filenames);
                    long time = System.currentTimeMillis() - t0;
                    if (messageHandler != null)
                        messageHandler.send("Worker " + id + " finished: " + Long.toString(time));
                    busy.set(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void finish(){
        running.set(false);
    }

    public boolean isBusy(){
        return busy.get();
    }

    protected abstract void processFile(InOutFilenames filenames);

//    private void readFile(String filename) throws FileNotFoundException {
//
//        BufferedReader br = new BufferedReader(new FileReader("resources\\" + filename));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            content = sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void writeFile(String filename) throws FileNotFoundException {
//
//        FileOutputStream fileOutputStream = new FileOutputStream("resources\\" + filename);
//        byte[] b = content.getBytes();
//        byte[] reversedB = new byte[b.length];
//        int index = 0;
//
//        for (int i = b.length; i > 0; i--) {
//            reversedB[index] = b[i - 1];
//            index++;
//        }
//        try {
//            fileOutputStream.write(reversedB);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
