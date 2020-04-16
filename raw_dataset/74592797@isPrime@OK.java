boolean isPrime(int v) {
    if (v <= 1) {
        return false;
    }
    if (v <= 3) {
        return true;
    }
    if (((v & 1) == 0) || ((v % 3) == 0)) {
        return false;
    }
    for (int m = 5, n = (int) sqrt(v); m <= n; m += 6) {
        if (((v % m) == 0) || ((v % (m + 2)) == 0)) {
            return false;
        }
    }
    return true;
}