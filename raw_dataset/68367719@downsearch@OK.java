int downsearch(ArrayList<Integer> al, int x) {
    int size = al.size();
    int l = 0, r = size - 1, p = -1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (al.get(mid) < x) {
            p = mid;
            l = mid + 1;
        } else
            r = mid - 1;
    }
    return p;
}