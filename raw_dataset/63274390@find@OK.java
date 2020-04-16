public int find(int a) {
    if (arr[a] != a)
        arr[a] = find(arr[a]);
    return arr[a];
}