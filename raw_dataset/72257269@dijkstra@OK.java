public static ArrayList<Pair> dijkstra(int start, ArrayList<ArrayList<Integer>> vec, int n) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(start);
    ArrayList<Pair> arr = new ArrayList<>();
    for (int i = 0; i <= n; ++i) {
        arr.add(new Pair());
    }
    arr.get(start).parCount = 0;
    arr.get(start).len = 0;
    // path[start] = 0;
    while (list.size() > 0) {
        int cur = list.poll();
        ArrayList<Integer> curList = vec.get(cur);
        for (int j = 0; j < curList.size(); ++j) {
            if (arr.get(curList.get(j)).len == 0 && curList.get(j) != start) {
                arr.get(curList.get(j)).len = arr.get(cur).len + 1;
                list.offer(curList.get(j));
                arr.get(curList.get(j)).parCount++;
            } else if (arr.get(curList.get(j)).len != 0 && arr.get(cur).len + 1 == arr.get(curList.get(j)).len)
                arr.get(curList.get(j)).parCount++;
        }
    }
    return arr;
}