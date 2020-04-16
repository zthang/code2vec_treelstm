// Creates n sets with single item in each
void makeSet() {
    for (int i = 0; i < n; i++) {
        // Initially, all elements are in
        // their own set.
        parent[i] = i;
    }
}