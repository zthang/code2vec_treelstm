public void solve(int testNumber, inputClass sc, PrintWriter out) {
    int n = sc.nextInt();
    String[] tab = new String[n];
    for (int i = 0; i < n; i++) {
        tab[i] = sc.nextLine();
    }
    subsets = new DSecretPasswords.Subset[n];
    for (int i = 0; i < n; i++) {
        subsets[i] = new DSecretPasswords.Subset();
        subsets[i].parent = i;
        subsets[i].rank = 0;
    }
    for (char k = 'a'; k <= 'z'; k++) {
        int lst = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < tab[i].length(); j++) {
                if (tab[i].charAt(j) == k) {
                    if (lst == -1) {
                        lst = i;
                    } else {
                        union(lst, i);
                    }
                }
            }
        }
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
        map.put(find(i), 1);
    }
    out.println(map.size());
}