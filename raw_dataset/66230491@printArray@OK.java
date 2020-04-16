public static void printArray(Object[] str) {
    for (Object s : str) {
        try {
            out.write(str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}