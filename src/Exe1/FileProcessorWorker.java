package Exe1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;


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

}