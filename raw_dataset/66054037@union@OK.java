public static void union(int[] ar, int x, int y) {
    int rx = find(ar, x);
    int ry = find(ar, y);
    if (// Fixed case #2
    rx == ry)
        // abc
        return;
    if (rx < ry)
        ar[ry] = rx;
    else
        ar[rx] = ry;
}