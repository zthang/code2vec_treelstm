static int getIdx(ArrayList<Pair> list, int k) {
    int sz = list.size() - 1;
    if (list.get(sz).x < k)
        return -1;
    int low = 0, high = sz, ans = sz, mid;
    while (low <= high) {
        mid = (low + high) >> 1;
        if (list.get(mid).x >= k) {
            ans = mid;
            high = --mid;
        } else {
            low = ++mid;
        }
    }
    return ans;
}