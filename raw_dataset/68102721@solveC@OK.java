private void solveC() throws IOException {
    String s = in.next();
    boolean[] del = new boolean[s.length()];
    for (int i = 0; i + 4 < s.length(); i++) {
        if (s.substring(i, i + 5).equals("twone"))
            del[i + 2] = true;
    }
    for (int i = 0; i + 2 < s.length(); i++) {
        if (s.substring(i, i + 3).equals("two") && !del[i + 2])
            del[i + 1] = true;
        if (s.substring(i, i + 3).equals("one") && !del[i])
            del[i + 1] = true;
    }
    int cnt = 0;
    for (boolean b : del) if (b)
        cnt++;
    out.println(cnt);
    for (int i = 0; i < s.length(); i++) {
        if (del[i])
            out.print(i + 1 + " ");
    }
    out.println();
}