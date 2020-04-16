// O(log n), update = increment
void point_update(// O(log n), update = increment
int k, // O(log n), update = increment
int val) {
    while (k <= n) {
        ft[k] += val;
        k += k & -k;
    }
// min?
}