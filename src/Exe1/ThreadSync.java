package Exe1;

public class ThreadSync {


    public static void main(String[] args) {
        User u = new User();
        Worker w = new Worker();
        u.start();
        try {
            u.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        w.start();
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