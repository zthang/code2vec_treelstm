static int inver(long x) {
    int a = (int) x;
    int e = (13 - 2);
    int res = 1;
    while (e > 0) {
        if ((e & 1) == 1) {
            // System.out.println(res*a);
            res = (int) ((1l * res * a) % 13);
        }
        a = (int) ((1l * a * a) % 13);
        e >>= 1;
    }
    // out.println(res+" "+x);
    return res % 13;
}