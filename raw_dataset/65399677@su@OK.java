static void su(int sum, int temp, int[] a, int ind, int k) {
    if (temp == sum && lt.size() == k) {
        ct++;
    }
    for (int i = ind; i < a.length; i++) {
        temp += a[i];
        lt.add(a[i]);
        if (temp <= sum && lt.size() <= k)
            su(sum, temp, a, i + 1, k);
        temp -= a[i];
        lt.remove(lt.size() - 1);
    }
}