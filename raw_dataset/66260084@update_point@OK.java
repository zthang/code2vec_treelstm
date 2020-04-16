// O(log n)
void update_point(// O(log n)
int index, // O(log n)
int val) {
    index += N - 1;
    sTree[index] += val;
    while (index > 1) {
        index >>= 1;
        sTree[index] = sTree[index << 1] + sTree[index << 1 | 1];
    }
}