private void init() throws FileNotFoundException {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    try {
        if (System.getProperty("user.name").equals("puneet")) {
            outputStream = new FileOutputStream("/home/puneet/Desktop/output.txt");
            inputStream = new FileInputStream("/home/puneet/Desktop/input.txt");
        }
    } catch (Exception ignored) {
    }
    out = new PrintWriter(outputStream);
    in = new FastInput(inputStream);
}