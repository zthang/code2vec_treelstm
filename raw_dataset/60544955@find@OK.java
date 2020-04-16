public int find(int i) {
    return arr[i] = (arr[i] == i ? i : find(arr[i]));
}