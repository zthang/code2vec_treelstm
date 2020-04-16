private void getanswer(int i) {
    if (i == vertices + 1) {
        ans = Math.max(ans, check());
        return;
    }
    for (int k = 1; k <= 6; k++) {
        x[i] = k;
        getanswer(i + 1);
    }
}