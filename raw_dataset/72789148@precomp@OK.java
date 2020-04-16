static void precomp() {
    if (precomped)
        return;
    precomped = true;
    s1Pow = new long[1000_000];
    s2Pow = new long[1000_000];
    s1Pow[0] = s2Pow[0] = 1;
    for (int i = 1; i < s1Pow.length; i++) s1Pow[i] = (s1Pow[i - 1] * s1) % m1;
    for (int i = 1; i < s2Pow.length; i++) s2Pow[i] = (s2Pow[i - 1] * s2) % m2;
}