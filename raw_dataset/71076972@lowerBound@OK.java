public int lowerBound(ArrayList<Integer> a, int x) {
    int l = 0;
    int r = a.size() - 1;
    if (a.get(l) >= x)
        return -1;
    if (a.get(r) < x)
        return r;
    int mid = -1;
    while (l <= r) {
        mid = (l + r) / 2;
        if (a.get(mid) == x && a.get(mid - 1) < x)
            return mid - 1;
        else if (a.get(mid) >= x)
            r = mid - 1;
        else if (a.get(mid) < x && a.get(mid + 1) >= x)
            return mid;
        else if (a.get(mid) < x && a.get(mid + 1) < x)
            l = mid + 1;
    }
    return mid;
}