public void add(long x) {
    if (abc[0] < x) {
        abc[0] = x;
    }
    if (abc[1] < x) {
        abc[0] = abc[1];
        abc[1] = x;
    }
    if (abc[2] < x) {
        abc[1] = abc[2];
        abc[2] = x;
    }
}