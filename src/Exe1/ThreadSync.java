package Exe1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ThreadSync {


    public static double func(double x){
        Math.sin(Math.cos(Math.log(Math.tan(x)))) + Math.cos(Math.sin(Math.log(Math.log(1.0 / Math.tan(x)))))
    }


    public static void main(String[] args) {
        User u=new User();
        List<FileProcessorWorker> workers = initWorkers(2, SleepWorker.class);
        u.addWorkers(workers);
        u.start();
        try {
            u.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<FileProcessorWorker> initWorkers(int n, Class workerClass){
        List<FileProcessorWorker> workers=new ArrayList<>();
        try {
            for (int i = 0; i < n; ++i) {
                FileProcessorWorker w = (FileProcessorWorker)workerClass.getConstructor().newInstance();
                w.start();
                workers.add(w);
            }
        }catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e){
            e.printStackTrace();
        }
        return workers;
    }


}


//Napisz program, który uruchamia 2 wątki: jeden (U)ser, komunikujący się z użytkownikiem w konsoli,
//drugi (W)orker działający w tle i czekający na polecenia.
//U czeka na input z konsoli - nazwy plików tekstowych in i out.
//Przekazuje nazwy do W, a on ładuje plik in, odwraca całą jego zawartość i zapisuje w out.
//Kiedy użytkownik poda nazwy plików, a W jest akurat zajęty, U powinien wyświetlić komunikat i prośba
//zostaje anulowana.
//Program nie powinien w żadnym momencie stracić responsywności.
//Program kończy się po wpisaniu "q".