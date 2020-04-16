static boolean find(int[] a, int A, int B) {
    if (// if A and B have the same root, it means that they are connected.
    root(a, A) == root(a, B))
        return true;
    else
        return false;
}