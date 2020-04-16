static long high(long n) {
    long p = (long) (Math.log(n) / Math.log(2L));
    return (long) Math.pow(2L, p);
}