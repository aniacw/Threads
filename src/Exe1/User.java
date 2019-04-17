package Exe1;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Thread {

    public class MessageHandler implements Exe1.MessageHandler {
        public void send(String message){
            synchronized (messages){
                messages.add(message);
            }
        }
    }

    private List<FileProcessorWorker> workers;
    private List<String> messages;
    private MessageHandler messageHandler;

    public User() {
        this.workers = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.messageHandler=new MessageHandler();
    }

    public void addWorker(FileProcessorWorker w){
        workers.add(w);
        w.setMessageHandler(messageHandler);
    }

    public void addWorkers(List<FileProcessorWorker> workers){
        for (FileProcessorWorker w : workers)
            addWorker(w);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("Type 'in' and 'out' file name");
        line = scanner.nextLine();
        while(!line.equals("!")) {
            if (line.equals("@"))
                printReports();
            else{
                String[] parts = line.split("\\s+");
                FileProcessorWorker worker = waitForAnyFreeWorker(500);
                worker.addTask(parts[0], parts[1]);
                System.out.println("Type 'in' and 'out' file name");
            }
            line = scanner.nextLine();
        }
        finishWorkers();
    }

    private void finishWorkers(){
        for (FileProcessorWorker w : workers)
            w.finish();
        for (FileProcessorWorker w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printReports(){
        synchronized (messages){
            for (String s : messages)
                System.out.println(s);
            messages.clear();
        }
    }

    private FileProcessorWorker waitForAnyFreeWorker(int waitTimeMs){
        FileProcessorWorker w = findFreeWorker();
        if (w == null){
            System.out.print("Waiting for worker");
            //System.out.flush();
            while (w == null){
                System.out.print(".");
                //System.out.flush();
                try {
                    Thread.sleep(waitTimeMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                w = findFreeWorker();
            }
            System.out.println();
        }
        return w;
    }

    private FileProcessorWorker findFreeWorker(){
        for (FileProcessorWorker w: workers){
            if (!w.isBusy())
                return w;
        }
        return null;
    }
}
