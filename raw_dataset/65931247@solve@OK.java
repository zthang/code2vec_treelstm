static int solve() {
    if (nFridges > nChains || nFridges < 3) {
        return -1;
    }
    int suma = 0;
    for (int i = 0; i < w.length; i++) {
        suma += w[i] * 2;
    }
    Arrays.parallelSort(w);
    suma += (nChains - nFridges) * (w[0] + w[1]);
    return suma;
}