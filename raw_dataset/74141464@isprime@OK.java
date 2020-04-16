public static boolean isprime(long a) {
    if (a == 0 || a == 1) {
        return false;
    }
    if (a == 2) {
        return true;
    }
    for (int i = 2; i < Math.sqrt(a) + 1; i++) {
        if (a % i == 0) {
            return false;
        }
    }
    return true;
}