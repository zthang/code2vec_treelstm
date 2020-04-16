public static int lowerBound(Node a, int q) {
    int lcount = 0;
    while (a != null) {
        if (a.v >= q) {
            a = a.left;
        } else {
            lcount += count(a.left) + 1;
            a = a.right;
        }
    }
    return lcount;
}