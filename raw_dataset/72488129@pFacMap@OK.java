static Map<Long, Integer> pFacMap(long x) {
    Map<Long, Integer> mp = new HashMap<>();
    long t = x;
    for (long i = 2; i * i <= x && i <= t; i++) {
        if (t % i == 0) {
            int num = 0;
            while (t % i == 0) {
                t /= i;
                num++;
            }
            mp.put(i, num);
        }
    }
    if (t != 1) {
        mp.put(t, 1);
    }
    return mp;
}