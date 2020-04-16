        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), m = s.nextInt();
            int[] deb = new int[n];
            while (m-- > 0) {
                int x = s.nextInt() - 1, y = s.nextInt() - 1, z = s.nextInt();
                deb[x] += z;
                deb[y] -= z;
            }
            ArrayList<pair<Integer, Integer>> pos = new ArrayList<>(), neg = new ArrayList<>();
            ArrayList<dist> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (deb[i] > 0) pos.add(new pair<>(i + 1, deb[i]));
                else if (deb[i] < 0) neg.add(new pair<>(i + 1, -deb[i]));
            }
            int cpos = 0, cneg = 0;
            while (cpos < pos.size()) {
                int min = Math.min(pos.get(cpos).y, neg.get(cneg).y);
                if (pos.get(cpos).y < neg.get(cneg).y) {
                    ans.add(new dist(pos.get(cpos).x, neg.get(cneg).x, min));
                    neg.get(cneg).y -= min;
                    pos.get(cpos).y -= min;
                    cpos++;
                } else if (pos.get(cpos).y > neg.get(cneg).y) {
                    ans.add(new dist(pos.get(cpos).x, neg.get(cneg).x, min));
                    neg.get(cneg).y -= min;
                    pos.get(cpos).y -= min;
                    cneg++;
                } else {
                    ans.add(new dist(pos.get(cpos).x, neg.get(cneg).x, min));
                    neg.get(cneg).y -= min;
                    pos.get(cpos).y -= min;
                    cpos++;
                    cneg++;
                }
            }
            w.println(ans.size());
            for (dist d : ans) w.println(d.x + " " + d.y + " " + d.z);
        }