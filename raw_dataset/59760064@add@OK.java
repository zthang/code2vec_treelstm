// add k to the i-th element.
public void add(long k, int i) {
    int node = i + 1;
    while (node < arr.length) {
        arr[node] += k;
        node += node & (-node);
    }
}