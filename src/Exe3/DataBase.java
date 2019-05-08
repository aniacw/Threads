package Exe3;

import java.util.*;

public class DataBase implements Runnable {

    private List<ParcelLocker> parcelLockerList;
    private static DataBase instance;
//    private ParcelLocker initialParcelLocker;
//    private ParcelLocker finalParcelLocker;
    private int[] parcelLockerIndexes;
    private List<Parcel> parcelList;
    private int parcelLockerIdx1;
    private int parcelLockerIdx2;


    public static DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }


    public DataBase() {
        parcelLockerList = new ArrayList<>();
        parcelList = new ArrayList<>();
        parcelLockerIdx1 = 0;
        parcelLockerIdx2 = 0;
    }


    public void initializeParcelLocker(int parcelLockerQty) {
        parcelLockerIndexes = new int[parcelLockerQty];
        for (int i = 1; i <= parcelLockerQty; i++) {
            ParcelLocker parcelLocker = new ParcelLocker();
            parcelLocker.setParcelLockerId(i);
            parcelLockerList.add(parcelLocker);
            parcelLockerIndexes[i - 1] = i - 1;
        }
    }


    public void initializeParcel(int parcelQty) {
        for (int i = 1; i <= parcelQty; i++) {
            Parcel parcel = new Parcel();
            parcel.setParcelId(i);
            parcelList.add(parcel);
        }
    }

    List<Parcel> getParcelList() {
        return parcelList;
    }

    void setParcelLockersInitial() {
        randomizeParcelLockers();
        for (Parcel p : parcelList)
            setParcelLockers(p);
    }


    private void randomizeParcelLockers() {
        Random r = new Random();
        int i = r.nextInt(parcelLockerIndexes.length);
        parcelLockerIdx1 = parcelLockerIndexes[i];
        int temp = parcelLockerIndexes[i];
        parcelLockerIndexes[i] = parcelLockerIndexes[parcelLockerIndexes.length - 1];
        parcelLockerIndexes[parcelLockerIndexes.length - 1] = temp;
        parcelLockerIdx2 = parcelLockerIndexes[r.nextInt(parcelLockerIndexes.length - 1)];
    }


    private void createNewParcel() {
        randomizeParcelLockers();
        Parcel parcel = new Parcel();
        setParcelLockers(parcel);
        parcelList.add(parcel);
    }


    public void setParcelLockers(Parcel parcel) {
        ParcelLocker initialLocker = parcelLockerList.get(parcelLockerIdx1);
        parcel.setInitialParcelLocker(initialLocker);
        parcel.setFinalParcelLocker(parcelLockerList.get(parcelLockerIdx2));
        initialLocker.addParcel(parcel);
    }


    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            createNewParcel();
            System.out.println(parcelList.get(parcelList.size()-1));
            System.out.println(parcelList.size());
            int sleepTime = r.nextInt(500) + 800;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public List<ParcelLocker> getParcelLockerList() {
        return parcelLockerList;
    }


    public int[] getParcelLockerIndexes() {
        return parcelLockerIndexes;
    }
}
