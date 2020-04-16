static int getMax(ArrayList<Pair> list) {
    N = list.size();
    Collections.sort(list);
    int[] suff_max = new int[N];
    for (int i = N - 1; i >= 0; --i) {
        suff_max[i] = list.get(i).y;
        if (i + 1 < N) {
            suff_max[i] = max(suff_max[i], suff_max[i + 1]);
        }
    }
    int low = 0, high = 1000000, ans = 0, mid;
    while (low <= high) {
        mid = (low + high) >> 1;
        if (check(mid, list, suff_max)) {
            ans = mid;
            low = ++mid;
        } else {
            high = --mid;
        }
    }
    return ans;
}