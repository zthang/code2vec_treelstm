public static void print(Object str) {
    try {
        out.write(str.toString().getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}