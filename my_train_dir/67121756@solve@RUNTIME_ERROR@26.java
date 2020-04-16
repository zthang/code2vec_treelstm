        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            List<Hashtable<Integer, Long>> give = new ArrayList<>();
            List<Hashtable<Integer, Long>> receive = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                give.add(new Hashtable<Integer, Long>());
                receive.add(new Hashtable<Integer, Long>());
            }
            for (int i = 0; i < M; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1, d = in.nextInt();
                if (give.get(u).containsKey(v)) {
                    give.get(u).put(v, give.get(u).get(v) + d);
                } else {
                    give.get(u).put(v, (long) d);
                }
                if (receive.get(v).containsKey(u)) {
                    receive.get(v).put(v, receive.get(v).get(u) + d);
                } else {
                    receive.get(v).put(u, (long) d);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int u : give.get(i).keySet()) {
                    long amountGive = give.get(i).get(u);
                    Hashtable<Integer, Long> receiveRemove = new Hashtable<>();
                    for (int v : receive.get(i).keySet()) {
                        if (amountGive <= 0) {
                            break;
                        }
                        long x = receive.get(i).get(v);
                        if (x <= 0) {
                            continue;
                        }
                        long min = Math.min(amountGive, x);
                        amountGive -= min;
                        x -= min;
                        receiveRemove.put(v, x);

                        if (give.get(v).containsKey(u)) {
                            give.get(v).put(u, give.get(v).get(u) + min);
                        } else {
                            give.get(v).put(u, min);
                        }
                        if (give.get(v).containsKey(i)) {
                            long y = give.get(v).get(i);
                            if (y <= min) {
                                give.get(v).remove(i);
                            } else {
                                give.get(v).put(i, y - min);
                            }
                        }
                        if (receive.get(u).containsKey(v)) {
                            receive.get(u).put(v, receive.get(u).get(v) + min);
                        } else {
                            receive.get(u).put(v, min);
                        }
                        if (receive.get(u).containsKey(i)) {
                            if (receive.get(u).get(i) == min) {
                                receive.get(u).remove(i);
                            } else {
                                receive.get(u).put(i, receive.get(u).get(i) - min);
                            }
                        }
                    }
                    for (int v : receiveRemove.keySet()) {
                        if (receiveRemove.get(v) == 0) {
                            receive.get(i).remove(v);
                        } else {
                            receive.get(i).put(v, receiveRemove.get(v));
                        }
                    }
                    give.get(i).put(u, amountGive);
                }
            }
            ArrayList<String> answers = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int u : give.get(i).keySet()) {
                    if (give.get(i).get(u) > 0) {
                        answers.add((i + 1) + " " + (u + 1) + " " + give.get(i).get(u));
                    }
                }
            }
            out.printLine(answers.size());
            for (String s : answers) {
                out.printLine(s);
            }
        }