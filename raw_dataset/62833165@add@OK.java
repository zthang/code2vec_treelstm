void add(long p1, int q1, long p2, int q2) {
    if (q1 < q2) {
        p_ = (p1 % MD * pt[q2 - q1] + p2) % MD;
        q_ = q2;
    } else {
        p_ = (p1 + p2 % MD * pt[q1 - q2]) % MD;
        q_ = q1;
    }
}