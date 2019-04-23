package Exe3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parcel {

    private int parcelId;
    private ParcelLocker parcelLocker;
    private List<Parcel> parcelList;
    private ParcelLocker initialParcelLocker;
    private ParcelLocker finalParcelLocker;
    private List<ParcelLocker> parcelLockerList;
    private DataBase dataBase;


    public Parcel() {
        parcelLocker = new ParcelLocker();
        parcelList = new ArrayList<>();
        parcelLockerList = new ArrayList<>();
        initialParcelLocker = new ParcelLocker();
        finalParcelLocker = new ParcelLocker();
        dataBase = DataBase.getInstance();
    }


    public int getParcelId() {
        return parcelId;
    }


    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }


    public void addParcelToList(Parcel newParcelId) {
        parcelList.add(newParcelId);
    }


    public ParcelLocker drawInitialParcelLocker(int parcelId, int parcelLockerQty) {
        for (int i = 1; i <= parcelLockerQty; i++) {
            Random random = new Random();
            int result = random.nextInt(parcelLockerQty);
            //int initialParcelLockerId = (int) Math.random() * (parcelLockerQty - 1);
            initialParcelLocker = parcelLockerList.get(result);
        }
        return initialParcelLocker;
    }


    public ParcelLocker drawFinalParcelLocker(Parcel parcel, int parcelLockerQty) {
        int result;

        for (int i = 1; i <= parcelLockerQty; i++) {
            initialParcelLocker = dataBase.checkInitialParcelLocker(parcel);
            Random random = new Random();
            result = random.nextInt(parcelLockerQty);

            if (initialParcelLocker.equals(parcelLockerList.get(result))) {
                drawFinalParcelLocker(parcel, parcelLockerQty);
            } else {
                finalParcelLocker = parcelLockerList.get(result);
            }
        }
        return finalParcelLocker;
    }


    public List<Parcel> getParcelList() {
        return parcelList;
    }


    public ParcelLocker getInitialParcelLocker() {
        return initialParcelLocker;
    }

    public List<ParcelLocker> getParcelLockerList() {
        return parcelLockerList;
    }

    public ParcelLocker getFinalParcelLocker() {
        return finalParcelLocker;
    }
}
