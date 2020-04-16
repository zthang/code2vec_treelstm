        public int find(int i) {
            while (i != id[i]) {
                i = id[i];
            }
            return i;
        }