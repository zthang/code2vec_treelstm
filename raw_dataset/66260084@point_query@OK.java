// c * O(log n), c < 1
int point_query(// c * O(log n), c < 1
int idx) {
    int sum = ft[idx];
    if (idx > 0) {
        int z = idx ^ (idx & -idx);
        --idx;
        while (idx != z) {
            sum -= ft[idx];
            idx ^= idx & -idx;
        }
    }
    return sum;
}