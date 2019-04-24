package Exe3;

import java.util.*;

public class DataBase implements Runnable {

    private List<ParcelLocker> parcelLockerList;
    private static DataBase instance;
    private ParcelLocker  initialParcelLocker;
    private ParcelLocker  finalParcelLocker;
    private int[] parcelLockerIndexes;


    public static DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    public DataBase() {
        parcelLockerList = new ArrayList<>();
    }


    public void initializeParcelLocker(int parcelLockerQty) {
        parcelLockerIndexes = new int[parcelLockerQty];
        for (int i = 1; i <= parcelLockerQty; i++) {
            ParcelLocker parcelLocker = new ParcelLocker();
            parcelLocker.setParcelLockerId(i);
            parcelLockerList.add(parcelLocker);
            parcelLockerIndexes[i-1] = i-1;
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


    void createNewParcel(){
        Random r = new Random();
        int i = r.nextInt(parcelLockerIndexes.length);
        int parcelLocekrIdx1 = parcelLockerIndexes[i];
        int temp = parcelLockerIndexes[i];
        parcelLockerIndexes[i] = parcelLockerIndexes[parcelLockerIndexes.length-1];
        parcelLockerIndexes[parcelLockerIndexes.length-1]=temp;
        int parcelLockerIdx2 = parcelLockerIndexes[r.nextInt(parcelLockerIndexes.length-1)];
        Parcel parcel=new Parcel();
        ParcelLocker initialLocker = parcelLockerList.get(parcelLocekrIdx1);
        parcel.setInitialParcelLocker(initialLocker);
        parcel.setFinalParcelLocker(parcelLockerList.get(parcelLockerIdx2));
        initialLocker.addParcel(parcel);

    }



    public ParcelLocker randomizeInitialParcelLocker(int parcelId, int parcelLockerQty) {
        Random random = new Random();

        int result = random.nextInt(parcelLockerQty);
        initialParcelLocker = parcelLockerList.get(result);
        return initialParcelLocker;
    }


    public ParcelLocker randomizeFinalParcelLocker(Parcel parcel, int parcelLockerQty) {
        int result;

        for (int i = 1; i <= parcelLockerQty; i++) {
            initialParcelLocker = checkInitialParcelLocker(parcel);
            Random random = new Random();
            result = random.nextInt(parcelLockerQty);

            if (initialParcelLocker.equals(parcelLockerList.get(result))) {
                randomizeFinalParcelLocker(parcel, parcelLockerQty);
            } else {
                finalParcelLocker = parcelLockerList.get(result);
            }
        }
        return finalParcelLocker;
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

    @Override
    public void run() {
        Random r =new Random();
        while (true){
            createNewParcel();
            int sleepTime = r.nextInt(500) + 800;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
