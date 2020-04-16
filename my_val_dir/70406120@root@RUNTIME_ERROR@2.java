        private int root(int i) {
            if (data[i] == i) return i;
            return root(data[i]);
        }