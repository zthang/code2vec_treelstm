static int log(int n) {
    int result = 0;
    long st = 1;
    for (int i = 0; st <= n; i++) {
        result = i;
        st *= 2L;
    }
    return result;
}