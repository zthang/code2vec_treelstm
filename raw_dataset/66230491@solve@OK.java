private void solve() {
    int n = fr.nextInt();
    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
        str[i] = fr.next();
    }
    int[][] freq = new int[n][26];
    for (int i = 0; i < n; i++) {
        String s = str[i];
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            freq[i][ch - 'a'] = 1;
        }
    }
    HashSet<Integer> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < 26; i++) {
        if (!set.contains(i)) {
            int[] curr = new int[26];
            curr[i] = 1;
            boolean flag = false;
            for (int j = 0; j < 26; j++) {
                if (curr[j] != 0) {
                    for (int k = 0; k < n; k++) {
                        if (freq[k][j] == 1) {
                            flag = true;
                            curr = or(curr, freq[k]);
                        }
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                if (curr[j] == 1) {
                    set.add(j);
                }
            }
            count += flag ? 1 : 0;
        }
    }
    println(count);
}