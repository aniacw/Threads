//package Exe2;
//
//
//public class Main {
//
//
//    public static void main(String[] args) {
//        splitArray(5, "Numbers.txt");
//
//    }
//
//    //wpisuje ile watkow (n)
//    public static void splitArray(int n, String filename) {
//        Numbers numbers = new Numbers(1000000);
//        numbers.readNumbers(filename);
//        numbers.splitArray(5);
//
//
//    }
//}
//
//
////Napisz program, który z pliku wczyta dane liczbowe (każda liczba oddzielona nową linią, dane wcześniej wylosuj)
////o odpowiednio dużym rozmiarze (np 1'000'000 liczb) i załaduje je do tablicy
//
////następnie rozkładając zadanie na kilka wątków podzieli tablicę na kilka części
////i wykona odpowiednio skomplikowaną funkcję (tak żeby czas działania był zauważalnie długi), np
////sin(cos(log(tan(x)))) + cos(sin(log(log(cot(x)))))
////na każdej liczbie, wyniki zapisując w tablicy.
//
////Kiedy wszystkie wątki skończą działanie zebrane w całość wyniki powinny zostać zapisane do nowego pliku.
////Zagwaratnuj, że ilość danych się zgadza, kolejność danych odpowida danym wejściowym i wyniki są poprawne.