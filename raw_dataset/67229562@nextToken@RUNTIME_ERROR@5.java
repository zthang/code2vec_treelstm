        String nextToken() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return tokenizer.nextToken();
        }