int find(int v) {
    if (v == arr[v])
        return v;
    return arr[v] = find(arr[v]);
}