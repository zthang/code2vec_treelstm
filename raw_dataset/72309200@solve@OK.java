private void solve() {
    int n = scanner.nextInt();
    List<String> s = new ArrayList<>();
    p = new int[26];
    size = new int[26];
    for (int i = 0; i < 26; i++) {
        make(i);
    }
    int[] used = new int[26];
    for (int i = 0; i < n; i++) {
        String next = scanner.nextLine();
        for (int j = 0; j < next.length(); j++) {
            used[next.charAt(j) - 'a'] = 1;
        }
        for (int j = 0; j < next.length() - 1; j++) {
            final int u = next.charAt(j) - 'a';
            final int v = next.charAt(j + 1) - 'a';
            union(u, v);
        }
    }
    Set<Integer> cnt = new HashSet<>();
    for (int i = 0; i < 26; i++) {
        if (used[i] == 1) {
            cnt.add(find(i));
        }
    }
    System.out.println(cnt.size());
}