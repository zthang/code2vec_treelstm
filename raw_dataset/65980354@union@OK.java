boolean union(int x, int y) {
    int parX = findParent(x);
    int parY = findParent(y);
    if (parX == parY)
        return false;
    if (height[parX] < height[parY]) {
        root[parY] = parX;
        height[parX] += height[parY] + 1;
    } else {
        root[parX] = parY;
        height[parY] += height[parX] + 1;
    }
    size--;
    return true;
}