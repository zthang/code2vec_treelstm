public String nextLine() {
    try {
        StringBuilder sb = new StringBuilder();
        int b = input.read();
        while (b != -1 && b != '\n') {
            sb.append((char) b);
            b = input.read();
        }
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}