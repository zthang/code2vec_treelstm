public int compare(Pairl p1, Pairl p2) {
    long a = p1.u * p2.v;
    long b = p2.u * p1.v;
    if (a > b) {
        return -1;
    } else if (a < b) {
        return 1;
    } else {
        return 0;
    }
}