package Exe3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parcel {

    private int parcelId;


    private ParcelLocker initialParcelLocker;
    private ParcelLocker finalParcelLocker;




    public Parcel() {


        initialParcelLocker = new ParcelLocker();
        finalParcelLocker = new ParcelLocker();

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

    public void setFinalParcelLocker(ParcelLocker finalParcelLocker) {
        this.finalParcelLocker = finalParcelLocker;
    }

    public void setInitialParcelLocker(ParcelLocker initialParcelLocker) {
        this.initialParcelLocker = initialParcelLocker;
    }
}
