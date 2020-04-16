public static boolean solve() {
    type = new Integer[n];
    Arrays.fill(type, 0);
    Integer count[] = new Integer[] { 0, 0, 0 }, k = 1;
    for (int i = 0; i < n && k <= 3; i++) if (type[i] == 0) {
        for (int j = 0; j < n; j++) if (!adj[i].contains(j)) {
            if (type[j] != 0)
                return false;
            type[j] = k;
            count[k - 1] += 1;
        }
        k += 1;
    }
    int sum = 0;
    for (int i = 0; i < 3; i++) if (count[i] == 0)
        return false;
    else
        sum += count[i];
    if (sum != n)
        return false;
    for (int i = 0; i < n; i++) for (int item : adj[i]) if (type[i] == type[item])
        return false;
    long total = 0;
    for (int i = 0; i <= 2; i++) for (int j = i + 1; j <= 2; j++) total += count[i] * count[j];
    if (total != m)
        return false;
    return true;
}