void merge(int x, int y) {
    int parx = find(x), pary = find(y);
    if (parx == pary)
        return;
    long min1 = (size[parx] * (size[parx] - 1)) / 2;
    long min2 = (size[pary] * (size[pary] - 1)) / 2;
    if (size[parx] > size[pary]) {
        par[pary] = parx;
        size[parx] += size[pary];
        pairs += (size[parx] * (size[parx] - 1)) / 2;
    } else {
        par[parx] = pary;
        size[pary] += size[parx];
        pairs += (size[pary] * (size[pary] - 1)) / 2;
    }
    pairs -= min2 + min1;
}