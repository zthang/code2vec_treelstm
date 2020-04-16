public void solve(int testNumber, Scanner in, PrintWriter out) {
    int N = in.nextInt();
    String temp;
    boolean[] total = new boolean[26], flag;
    TaskD.dsu obj = new TaskD.dsu();
    while (N-- > 0) {
        temp = in.next();
        flag = new boolean[26];
        for (char item : temp.toCharArray()) {
            flag[item - 'a'] = true;
        }
        for (int i = 0; i < 26; ++i) {
            if (flag[i]) {
                total[i] = true;
                obj.union(temp.charAt(0) - 'a', i);
            }
        }
    }
    int count = 0;
    for (int i = 0; i < 26; ++i) {
        if (total[i] && obj.find(i) == i) {
            count += 1;
        }
    }
    out.println(count);
}