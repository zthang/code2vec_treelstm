int[] sort(int[] a) {
    final int SHIFT = 16, MASK = (1 << SHIFT) - 1, SIZE = (1 << SHIFT) + 1;
    int n = a.length, ta[] = new int[n], ai[] = new int[SIZE];
    for (int i = 0; i < n; ai[(a[i] & MASK) + 1]++, i++) ;
    for (int i = 1; i < SIZE; ai[i] += ai[i - 1], i++) ;
    for (int i = 0; i < n; ta[ai[a[i] & MASK]++] = a[i], i++) ;
    int[] t = a;
    a = ta;
    ta = t;
    ai = new int[SIZE];
    for (int i = 0; i < n; ai[(a[i] >> SHIFT) + 1]++, i++) ;
    for (int i = 1; i < SIZE; ai[i] += ai[i - 1], i++) ;
    for (int i = 0; i < n; ta[ai[a[i] >> SHIFT]++] = a[i], i++) ;
    return ta;
}