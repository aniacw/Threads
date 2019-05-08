package Exe3;

public class Parcel {

    private int parcelId;
    private ParcelLocker initialParcelLocker;
    private ParcelLocker finalParcelLocker;


    public Parcel() {
        parcelId = 0;
        initialParcelLocker = new ParcelLocker();
        finalParcelLocker = new ParcelLocker();
    }


    public int getParcelId() {
        return parcelId;
    }


    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }


    public ParcelLocker getInitialParcelLocker() {
        return initialParcelLocker;
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