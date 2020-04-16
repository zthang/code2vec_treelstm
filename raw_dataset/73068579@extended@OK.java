public void extended(int a, int b) {
    if (b == 0) {
        d = a;
        p = 1;
        q = 0;
    } else {
        extended(b, a % b);
        int temp = p;
        p = q;
        q = temp - (a / b) * q;
    }
}