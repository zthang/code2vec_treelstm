public void input() {
    n = cin.nextInt();
    c = new boolean[26][26];
    visit = new boolean[26];
    a = new boolean[26];
    for (int i = 0; i < n; i++) {
        String str = cin.next();
        wf(str);
    }
}