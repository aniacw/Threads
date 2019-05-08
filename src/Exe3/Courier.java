package Exe3;


public class Courier extends Thread {
    private DataBase dataBase;
    private Parcel parcel;
    private ParcelLocker parcelLocker;

    //sprawdzanie stanu paczkomatów
    //napotkanie paczki do dostarczenia
    //wyjęcie paczki - delay
    //dostarczenie - delay w zal od dystansu
    //delay - bezczynny


    public Courier() {
        dataBase = DataBase.getInstance();
        parcel = new Parcel();
        parcelLocker = new ParcelLocker();
    }


    public void run() {
        checkParcelLocker();
        deliverParcel();
    }


    public void checkParcelLocker() {
        for (ParcelLocker locker : dataBase.getParcelLockerList())
           parcel = locker.tryGetParcel();
    }


    public void deliverParcel() {
        parcel.getFinalParcelLocker().addParcel(parcel);
    }
}
