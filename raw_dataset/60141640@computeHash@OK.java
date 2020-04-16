public long computeHash(String s) {
    long p = 31;
    long m = 1_000_000_009;
    long hashValue = 0L;
    long[] powers = computePowers(p, s.length(), m);
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        hashValue = (hashValue + (ch - 'a' + 1) * powers[i]) % m;
    }
    return hashValue;
}