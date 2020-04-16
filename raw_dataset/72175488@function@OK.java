public long function(long a, long b) {
    return branchUp ^ a < b ? a : b;
}