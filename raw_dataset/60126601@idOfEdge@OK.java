public long idOfEdge(int a, int b) {
    if (a > b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    return (((long) a) << 32) | b;
}