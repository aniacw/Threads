package Exe3;

import java.util.ArrayList;
import java.util.List;

public class Courier extends Thread {
    private DataBase dataBase;
    private Parcel parcel;
    private ParcelLocker parcelLocker;


    public Courier() {
        dataBase = DataBase.getInstance();
        parcel = new Parcel();
        parcelLocker = new ParcelLocker();
    }


    public void run() {
        checkParcelLocker();
    }

    //tu cos namieszalam
    public void checkParcelLocker(ParcelLocker parcelLocker) {
        for (ParcelLocker locker : dataBase.getParcel().getParcelLockerList()) {
            if (dataBase.getParcelLockerParcelInitialMap().containsKey(locker)) {
                List<Parcel> parcelPerKeyList = (ArrayList) dataBase.getParcelLockerParcelInitialMap().values();
                assignParcelToCourier(parcelPerKeyList.get(0));
                removeAssignedParcel(parcelPerKeyList.get(0));
            }
        }
        dataBase.ckeckIfEmpty(parcelLocker);
    }


    public void removeAssignedParcel(Parcel parcelToBeRemoved) {
        dataBase.getParcelLockerParcelInitialMap().entrySet()
                .removeIf(parcelLockerParcelEntry -> parcelToBeRemoved.equals(parcelLockerParcelEntry.getValue()));
    }


    public void assignParcelToCourier(Parcel parcel) {

    }


    public void deliverParcel(Parcel parcel) {

    }
}
