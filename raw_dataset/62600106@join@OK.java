public static String join(int... i) {
    StringBuilder sb = new StringBuilder();
    for (int o : i) {
        sb.append(o);
        sb.append(" ");
    }
    if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
}