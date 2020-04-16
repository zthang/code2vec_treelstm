public int compareTo(Event e2) {
    int v1 = (l == -1) ? r : l;
    int v2 = (e2.l == -1) ? e2.r : e2.l;
    if (v1 == v2) {
        if (r == -1)
            return -1;
        else
            return 1;
    }
    return v1 - v2;
}