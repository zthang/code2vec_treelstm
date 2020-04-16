public static void SolveD() {
    Scanner sc = new Scanner(System.in);
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    // each character has an ArrayList
    ArrayList<Integer>[] ac = new ArrayList[26];
    // Root array, init is 0, no root
    int[] ar = new int[n + 1];
    for (int i = 0; i < 26; i++) ac[i] = new ArrayList();
    for (int i = 1; i <= n; i++) {
        // one line of password
        char[] oneline = sc.next().toCharArray();
        for (int j = 0; j < oneline.length; j++) {
            int curri = oneline[j] - 'a';
            if (ac[curri].isEmpty()) {
                if (ar[i] == 0) {
                    ac[curri].add(i);
                // ar[i] = i;
                } else {
                    union(ar, ar[i], i);
                    ac[curri].add(ar[i]);
                }
            } else {
                union(ar, ac[curri].get(0), find(ar, i));
            }
        }
    }
    int total = 0;
    HashSet<Integer> rootset = new HashSet();
    for (int i = 0; i < 26; i++) {
        if (!ac[i].isEmpty()) {
            int index = ac[i].get(0);
            if (!rootset.contains(index) && ar[index] == 0) {
                total++;
                rootset.add(index);
            }
        }
    }
    pw.println(total);
    pw.close();
}