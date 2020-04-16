static public long gcdF(long a, long b) {
    while (b != 0) {
        long na = b;
        long nb = a % b;
        a = na;
        b = nb;
    }
    return a;
}