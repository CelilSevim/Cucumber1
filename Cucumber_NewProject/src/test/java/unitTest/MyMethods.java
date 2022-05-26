package unitTest;

public class MyMethods {

    public int sum(int... num) {
        int toplam = 0;
        for (int i : num) {
            toplam += i;
        }
        return toplam;
    }
}
