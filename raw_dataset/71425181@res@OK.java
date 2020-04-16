public static int res(ArrayList<ArrayList<Integer>> al, int[] sf) {
    bfs(al, 0, true);
    bfs(al, al.size() - 1, false);
    ArrayList<pair> al1 = new ArrayList<>();
    for (int i = 0; i < sf.length; i++) {
        int diff = gap[sf[i] - 1][0] - gap[sf[i] - 1][1];
        al1.add(new pair(diff, sf[i] - 1));
    }
    Collections.sort(al1);
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for (int i = 0; i < al1.size(); i++) {
        // System.out.println(al1.get(i).val+"#"+gap[al1.get(i).val][0]+"@"+gap[al1.get(i).val][1]);
        ans = Math.max(ans, max + gap[al1.get(i).val][1]);
        max = Math.max(max, gap[al1.get(i).val][0]);
    }
    // System.out.println(ans);
    return Math.min(gap[al.size() - 1][0], ans + 1);
}