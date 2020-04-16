static String preprocess(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append("@#");
    for (int i = 0; i < s.length(); i++) {
        sb.append(s.charAt(i)).append("#");
    }
    sb.append("$");
    return sb.toString();
}