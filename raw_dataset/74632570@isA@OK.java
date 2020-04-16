public boolean isA(int a, int b) {
    return inT[a] <= inT[b] && outT[a] >= outT[b];
}