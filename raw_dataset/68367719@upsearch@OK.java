int upsearch(ArrayList<Integer> al, int x) {
    int size = al.size();
    int l = 0, r = size - 1, p = size;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (al.get(mid) > x) {
            p = mid;
            r = mid - 1;
        } else
            l = mid + 1;
    }
    return p;
}