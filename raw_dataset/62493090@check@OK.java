public int check(int i, ArrayList<Integer>[] arr, int prev) {
    for (int j = 0; j < arr[i].size(); j++) {
        if (arr[i].get(j) != prev) {
            return 1 + check(arr[i].get(j), arr, i);
        }
    }
    return 1;
}