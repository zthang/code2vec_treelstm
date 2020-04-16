public static int search(Node a, int q) {
    int lcount = 0;
    while (a != null) {
        if (a.v == q) {
            lcount += count(a.left);
            break;
        }
        if (q < a.v) {
            a = a.left;
        } else {
            lcount += count(a.left) + 1;
            a = a.right;
        }
    }
    return a == null ? -(lcount + 1) : lcount;
}