public static int find(int i) {
    if (arr[i] == i)
        return i;
    else {
        int result = find(arr[i]);
        arr[i] = result;
        return result;
    }
}