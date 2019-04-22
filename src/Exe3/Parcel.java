package Exe3;

import java.util.ArrayList;
import java.util.List;

public class Parcel {

    private int parcelId;
    private ParcelLocker parcelLocker;
    private List<Parcel> parcelList;
    private ParcelLocker initialParcelLocker;
    private List<ParcelLocker> parcelLockerList;


    public Parcel() {
        parcelLocker = new ParcelLocker();
        parcelList = new ArrayList<>();
        parcelLockerList = new ArrayList<>();
    }


    public int getParcelId() {
        return parcelId;
    }


    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }


    public void addParcelToList(Parcel newParcelId){
        parcelList.add(newParcelId);
    }


    public ParcelLocker drawInitialParcelLocker(int parcelId, int parcelLockerQty) {
        for (int i = 0; i < parcelLockerQty; i++) {
            int initialParcelLockerId = (int) Math.random() * (parcelLockerQty - 1);
            initialParcelLocker = parcelLockerList.get(initialParcelLockerId);
        }

    }

    public List<Parcel> getParcelList() {
        return parcelList;
    }
}
