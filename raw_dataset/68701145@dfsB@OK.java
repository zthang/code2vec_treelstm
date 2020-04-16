static void dfsB(int i, int p) {
    // if(v[i])return;
    v[i] = true;
    cou++;
    for (int j : arr[i]) {
        if (!v[j] && j != a)
            dfsB(j, i);
    }
}