public static boolean isPrime(long n) {
    boolean res = true;
    List l = sieve((int) Math.sqrt(n));
    for (int i = 0; i < l.size(); i++) {
        int curPrime = (int) l.get(i);
        if (n % curPrime == 0) {
            res = false;
            break;
        }
    }
    return res;
}