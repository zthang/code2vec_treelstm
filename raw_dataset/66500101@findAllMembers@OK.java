private static void findAllMembers(Group[] list, int i, List<int[]> groups, int count) {
    int[] tmp = new int[26];
    for (char c : list[i].word.toCharArray()) {
        tmp[c - 'a'] = 1;
    }
    groups.add(tmp);
    for (int index = 0; index < list.length; index++) {
        if (list[index].grp != -1)
            continue;
        if (equivalent(tmp, list[index].word)) {
            list[index].grp = count;
            addToChars(groups, groups.size() - 1, list[index].word);
        }
    }
}