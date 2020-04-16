public Debug debug(String name, Object x, int... indexes) {
    if (offline) {
        if (x == null || !x.getClass().isArray()) {
            out.append(name);
            for (int i : indexes) {
                out.printf("[%d]", i);
            }
            out.append("=").append("" + x);
            out.println();
        } else {
            indexes = Arrays.copyOf(indexes, indexes.length + 1);
            if (x instanceof byte[]) {
                byte[] arr = (byte[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof short[]) {
                short[] arr = (short[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof boolean[]) {
                boolean[] arr = (boolean[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof char[]) {
                char[] arr = (char[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof int[]) {
                int[] arr = (int[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof float[]) {
                float[] arr = (float[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof double[]) {
                double[] arr = (double[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else if (x instanceof long[]) {
                long[] arr = (long[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            } else {
                Object[] arr = (Object[]) x;
                for (int i = 0; i < arr.length; i++) {
                    indexes[indexes.length - 1] = i;
                    debug(name, arr[i], indexes);
                }
            }
        }
    }
    return this;
}