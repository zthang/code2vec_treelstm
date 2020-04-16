private static int findTheoreticalMin(int[] a, int m) {
    int n = a.length;
    int[] s = a.clone();
    Arrays.sort(s);
    Util.ASSERT(m >= n);
    int min = s[0];
    int min2 = s[1];
    int tot = 0;
    for (int x : s) {
        tot += x;
    }
    int cost = 0;
    // deg(each) >= 2
    cost += 2 * tot;
    // deg(min) <= sum[deg(rest)] therefore deg(min) <= totaldeg - deg(min)
    // therefore 2deg(min) <= totaldeg = m * 2
    // every node has at least 1 edge not including min. so there are at least
    // n-1 unavailable degree. so deg(min) <= 2*m - (n-1) - deg(min)
    // deg(min) <= m - (n-1)/2
    int deg2OfEach = 2 * (n - 1);
    int degMin = Math.min(m - (n - 1 + 1) / 2, 2 * m - deg2OfEach);
    cost += (degMin - 2) * min;
    int degMin2 = 2 * m - 2 * (n - 2) - degMin;
    cost += (degMin2 - 2) * min2;
    return cost;
}