package Exe3;

public class Main {

    public static void main(String[] args) {

        DataBase dataBase = new DataBase();
        dataBase.initializeParcelLocker(10);
        dataBase.initializeParcel(50);

        for(Parcel p : dataBase.getParcel().getParcelList()){
            p.drawInitialParcelLocker(p.getParcelId(), 50);
        }




    }
}


//Napisz z użyciem mechanizmów wielowątkowości system paczkomatów.
//System składa się z paczkomatów, paczek i kurierów. Kurierzy są traktowani jako osobne byty,
//reprezentowane przez oddzielne wątki, wykonujące określone czynności.
// Baza paczek i paczkomatów jest dla ułatwienia ogólnodostępna i jest traktowana jako zasób, do którego chcą dostawać się kurierzy.
//Wkładanie paczek do paczkomatów jest realizowane po prostu jako wylosowanie paczkomatu źródłowego, zaadresowanym do losowego docelowego
//i umieszczenie paczki w źródłowym. Takie zdarzenie powinno odbywać się losowo i powinien wykonywać to wątek główny.
//Każdy kurier sprawdza stan paczkomatów i jeżeli wykryje paczkę wyciąga ją i transportuje do docelowego paczkomatu.
//Po dostarczeniu paczka znika z systemu.
//Paczkomaty rozłożone są na mapie, każdy ma swoją pozycję (x,y). Na tej podstawie określamy odlełość (w linii prostej), co wpływa na czas transportu.
//
//Każda poniższa czynność trwa określoną ilość czasu (czasy przykładowe):
//Losowanie nowej paczki - co 0.5s - 1s
//Wyjęcie paczki przez kuriera - 1s
//Włożenie paczki do docelowego paczkomatu - 1s
//Czas transportu - 1s*odlełość
//Odpoczynek kuriera po dostarczeniu paczki - 2s
//
//Dodatkowo muszą zostać zapewnione restrykcje:
//Dwóch kurierów nie może jednocześnie korzystać z jednego paczkomatu. (wersja trudniejsza: z paczkomatu może korzystac na raz max 2 kurierów)
//Żadna paczka nie może się zgubić.
//Paczka nie może mieć tego samego paczkomatu źródłowego i docelowego.
//Kurier może przewozić tylko jedną paczkę jednocześnie
//Paczka nie może zostać zabrana przez 2 kurierów
//W paczkomacie nie może być więcej niż 10 paczek
//
//Program powinien wyświetlać informacje w konsoli o tym co się dzieje, np
//kurier 13 wyjął paczkę 4673 z paczkomatu 71
//itp
//
//Przetestuj system dla różnych ilości kurierów