static void p(char[][] ar) {
    StringBuilder sb;
    for (char[] a : ar) {
        sb = new StringBuilder("");
        for (char aa : a) sb.append(aa + " ");
        System.out.println(sb);
    }
}