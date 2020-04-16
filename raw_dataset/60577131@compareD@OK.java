int compareD(Node a, Node b) {
    if (a.len != b.len) {
        return Integer.compare(a.len, b.len);
    }
    if (a.len == 1) {
        return Integer.compare(a.d, b.d);
    }
    if (a.hash == b.hash) {
        return 0;
    }
    for (int h = k - 1; h >= 0; h--) {
        if (a.p[h].hash != b.p[h].hash) {
            return compare(a.p[h], b.p[h]);
        }
    }
    return Integer.compare(a.d, b.d);
}