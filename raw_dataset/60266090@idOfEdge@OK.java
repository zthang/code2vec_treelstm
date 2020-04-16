private static long idOfEdge(int i, int j) {
    if (i > j) {
        int tmp = i;
        i = j;
        j = tmp;
    }
    return (((long) i) << 32) | j;
}