public static boolean check(ArrayList<Integer> points, int jump) {
    int m = points.size();
    boolean[] flag = new boolean[jump];
    int[] color = new int[jump];
    for (int i = 0; i < jump; i++) {
        flag[i] = true;
        color[i] = colors[points.get(i)];
    }
    for (int i = 0; i < m; i++) {
        flag[i % jump] &= (color[i % jump] == colors[points.get(i)]);
    }
    for (int i = 0; i < jump; i++) {
        if (flag[i]) {
            return true;
        }
    }
    return false;
}