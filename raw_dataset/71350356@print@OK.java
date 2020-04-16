private void print(int min, int[] res) {
    StringBuffer sb = new StringBuffer();
    for (int i : res) sb.append(i - min + 1).append(' ');
    out.println(sb);
}