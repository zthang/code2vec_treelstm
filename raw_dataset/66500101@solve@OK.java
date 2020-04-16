public static void solve() throws IOException {
    int n = nextInt();
    Group[] list = new Group[n];
    for (int i = 0; i < n; i++) {
        list[i] = new Group(in.readLine(), -1);
    }
    list[0].grp = 1;
    int count = 1;
    List<int[]> groups = new ArrayList<>();
    findAllMembers(list, 0, groups, count);
    for (int i = 1; i < n; i++) {
        if (list[i].grp != -1)
            continue;
        for (int j = 0; j < groups.size(); j++) {
            int[] tmp = groups.get(j);
            if (equivalent(tmp, list[i].word)) {
                addToChars(groups, j, list[i].word);
                list[i].grp = j + 1;
                break;
            }
        }
        if (list[i].grp == -1) {
            list[i].grp = ++count;
            findAllMembers(list, i, groups, count);
        }
    }
    System.out.println(count);
}