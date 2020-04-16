static boolean check(long mid, long a, long b) {
    long count = 1;
    while (count <= mid) {
        count++;
        if (a < b)
            a += count;
        else
            b += count;
        if (a == b)
            return true;
    }
    return false;
}