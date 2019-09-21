public class Lista {
    private int start;
    private int end;
    private int[] arr;
    private int total;
    private int size;

    public Lista() {
        this.start = 5000000;
        this.end = 5000001;
        this.arr = new int[10000000];
        this.size = 10000000;
        this.total = 0;
    }

    void lisaaAlkuun(int x) {
        this.arr[start] = x;
        this.start--;
        this.total++;
//        if (this.start == 0) {
//
//        }
    }

    void lisaaLoppuun(int x) {
        this.arr[end] = x;
        this.end++;
        this.total++;
//        if (this.end == this.size) {
//            int[] newArr = new int[this.size * 2];
//            this.size = this.size * 2;
//            this.end =
//
//            for (int i = 0; i < newArr.length; i++) {
//
//            }
//
//        }
    }

    int haeAlkio(int k) {
        // if (k >= this.total) { }
        int index = start + k + 1;
        return arr[index];
    }
}
