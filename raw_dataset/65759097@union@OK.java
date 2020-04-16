private static void union(int a, int b) {
    int ra = root(a);
    int rb = root(b);
    if (size[ra] < size[rb]) {
        arr[ra] = arr[rb];
        size[rb] += size[ra];
    } else {
        arr[rb] = arr[ra];
        size[ra] += size[rb];
    }
    min[ra] = Math.min(min[ra], min[rb]);
    min[rb] = Math.min(min[ra], min[rb]);
    max[ra] = Math.max(max[ra], max[rb]);
    max[rb] = Math.max(max[ra], max[rb]);
}