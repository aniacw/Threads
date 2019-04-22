package Exe3;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private Parcel parcel;
    private ParcelLocker parcelLocker;
    private Map<ParcelLocker, Parcel> parcelLockerParcelInitialMap;
    private Pair<Parcel, ParcelLocker> parcelParcelLockerInitialPair;
    private Pair<Parcel, ParcelLocker> parcelParcelLockerFinalPair;


    public DataBase() {
        parcel = new Parcel();
        parcelLocker = new ParcelLocker();
        parcelLockerParcelInitialMap = new HashMap<>();
    //    parcelParcelLockerFinalPair = new Pair<>();
    }


    public void initializeParcelLocker(int parcelLockerQty) {
        for (int i = 1; i <= parcelLockerQty; i++) {
            parcelLocker = new ParcelLocker();
            parcelLocker.setParcelLockerId(i);
        }
    }


    public void initializeParcel(int parcelQty) {
        for (int i = 1; i <= parcelQty; i++) {
            parcel = new Parcel();
            parcel.setParcelId(i);
            parcel.addParcelToList(parcel);
        }
    }

    public Parcel getParcel() {
        return parcel;
    }

    public Map<ParcelLocker, Parcel> getParcelLockerParcelInitialMap() {
        return parcelLockerParcelInitialMap;
    }
}
