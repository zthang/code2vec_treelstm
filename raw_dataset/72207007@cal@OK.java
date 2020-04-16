static long cal(int i, int j) {
    return (Math.min(i, n - r) - Math.max(0, i - r + 1) + 1) * 1l * (Math.min(j, m - r) - Math.max(0, j - r + 1) + 1);
}