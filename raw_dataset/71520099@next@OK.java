String next() {
    while (st == null || !st.hasMoreElements()) {
        try {
            String line = br.readLine();
            if (line == null || line.length() == 0)
                return "";
            st = new StringTokenizer(line);
        } catch (IOException e) {
            return "";
        // e.printStackTrace();
        }
    }
    return st.nextToken();
}