public int upperBound(ArrayList<Integer> a, int x) {
    int l = 0;
    int r = a.size() - 1;
    if (a.get(l) > x)
        return l;
    if (a.get(r) <= x)
        return r + 1;
    int mid = -1;
    while (l <= r) {
        mid = (l + r) / 2;
        if (a.get(mid) == x && a.get(mid + 1) > x)
            return mid + 1;
        else if (a.get(mid) <= x)
            l = mid + 1;
        else if (a.get(mid) > x && a.get(mid - 1) <= x)
            return mid;
        else if (a.get(mid) > x && a.get(mid - 1) > x)
            r = mid - 1;
    }
    return mid;
}