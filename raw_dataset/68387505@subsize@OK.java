static void subsize(int curr, int parent) {
    subsize[curr] = 1;
    for (int next : tree[curr]) {
        if (next != parent) {
            subsize(next, curr);
        }
    }
    for (int next : tree[curr]) {
        if (next != parent) {
            subsize[curr] += subsize[next];
        }
    }
}