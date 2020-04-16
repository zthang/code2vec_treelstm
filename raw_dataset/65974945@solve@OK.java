private static int solve(int n, String[] passwords) {
    boolean[] exists = new boolean[26];
    UnionFind unionFind = new UnionFind(26);
    for (String password : passwords) {
        int i1 = password.charAt(0) - 'a';
        for (char c : password.toCharArray()) {
            int i2 = c - 'a';
            exists[i2] = true;
            unionFind.merge(i1, i2);
        }
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
        if (!exists[i]) {
            continue;
        }
        boolean same = false;
        for (int j = 0; j < i; j++) {
            if (unionFind.sameGroup(i, j)) {
                same = true;
                break;
            }
        }
        if (!same) {
            count++;
        }
    }
    return count;
}