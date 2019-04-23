package Exe3;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataBase {

    private Parcel parcel;
    private ParcelLocker parcelLocker;
    private Map<ParcelLocker, Parcel> parcelLockerParcelInitialMap;
    private Map<ParcelLocker, Parcel> parcelLockerParcelFinalMap;
    private Pair<Parcel, ParcelLocker> parcelParcelLockerInitialPair;
    private Pair<Parcel, ParcelLocker> parcelParcelLockerFinalPair;
    private static DataBase instance;


    public static DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    public DataBase() {
        parcel = new Parcel();
        parcelLocker = new ParcelLocker();
        parcelLockerParcelInitialMap = new HashMap<>();
        parcelLockerParcelFinalMap = new HashMap<>();
        //    parcelParcelLockerFinalPair = new Pair<>();
    }


    public void initializeParcelLocker(int parcelLockerQty) {
        for (int i = 1; i <= parcelLockerQty; i++) {
            parcelLocker = new ParcelLocker();
            parcelLocker.setParcelLockerId(i);
            parcel.getParcelLockerList().add(parcelLocker);
        }
    }


    public void initializeParcel(int parcelQty) {
        parcel.setParcelId(1);
        parcel.addParcelToList(parcel);
        for (int i = 2; i <= parcelQty; i++) {
            Parcel parcel = new Parcel();
            parcel.setParcelId(i);
            parcel.addParcelToList(parcel);
        }
    }


    public ParcelLocker checkInitialParcelLocker(Parcel parcel) {
        return parcelLockerParcelInitialMap.entrySet()
                .stream()
                .filter(parcelLockerParcelEntry -> Objects.equals(parcelLockerParcelEntry.getValue(), parcel))
                .findAny().get().getKey();
    }


    //check czy paczkomat jest pusty
    public boolean ckeckIfEmpty(ParcelLocker parcelLocker) {
        return parcelLockerParcelInitialMap.containsKey(parcelLocker);
    }

    public Parcel getParcel() {
        return parcel;
    }

    public Map<ParcelLocker, Parcel> getParcelLockerParcelInitialMap() {
        return parcelLockerParcelInitialMap;
    }

    public Map<ParcelLocker, Parcel> getParcelLockerParcelFinalMap() {
        return parcelLockerParcelFinalMap;
    }
}
