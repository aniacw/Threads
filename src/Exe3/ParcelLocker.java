package Exe3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParcelLocker {

    private int parcelLockerId;
    private int positionHorizontal;
    private int positionVertical;
    private Queue<Parcel> parcelList;

    public ParcelLocker() {
        parcelList = new LinkedList<>();
        positionHorizontal = 0;
        positionVertical = 0;
    }


    public ParcelLocker(int positionHorizontal, int positionVertical) {
        this.positionVertical = positionVertical;
        this.positionHorizontal = positionHorizontal;
    }


    public int getParcelLockerId() {
        return parcelLockerId;
    }

    public void setParcelLockerId(int parcelLockerId) {
        this.parcelLockerId = parcelLockerId;
    }

    public void addParcel(Parcel p){
        synchronized (parcelList) {
            parcelList.add(p);
        }
    }

    public boolean isEmpty(){
        synchronized (parcelList){
            return parcelList.isEmpty();
        }
    }

    public Parcel tryGetParcel(){
        synchronized (parcelList){
            try {
                Thread.sleep(Global.parcelPollDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return parcelList.poll();
        }
    }

}
