public String nextStr() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (Character.isWhitespace(b)) {
            b = input.read();
        }
        while (b != -1 && !Character.isWhitespace(b)) {
            sb.append((char) b);
            b = input.read();
        }
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}