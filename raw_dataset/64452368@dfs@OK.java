static void dfs(int index) {
    hs.remove(index);
    int demo = 0;
    while (true) {
        Integer temp = hs.higher(demo);
        if (temp == null)
            break;
        if (!graph[index].contains(temp)) {
            // System.out.println(index+" "+temp);
            dfs(temp);
        }
        demo = temp;
    }
}