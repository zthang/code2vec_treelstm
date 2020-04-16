List<Integer>[] lists(int n) {
    List<Integer>[] lists = new List[n];
    for (int i = 0; i < n; i++) {
        lists[i] = new ArrayList<Integer>();
    }
    return lists;
}