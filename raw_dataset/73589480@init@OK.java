void init(int primeMax) {
    factor = new int[primeMax];
    for (int i = 2; i < primeMax; i++) {
        if (factor[i] == 0) {
            for (int j = i; j >= i && j < primeMax; j += i) {
                if (factor[j] == 0) {
                    factor[j] = i;
                }
            }
        }
    }
}