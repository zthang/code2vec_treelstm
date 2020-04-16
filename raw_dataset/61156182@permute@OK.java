void permute(int[] a, int l, int r) {
    // Base case
    if (l == r)
        p.add(a.clone());
    else {
        // Permutations made
        for (int i = l; i <= r; i++) {
            // Swapping done
            int t = a[l];
            a[l] = a[i];
            a[i] = t;
            // Recursion called
            permute(a, l + 1, r);
            // backtrack
            t = a[l];
            a[l] = a[i];
            a[i] = t;
        }
    }
}