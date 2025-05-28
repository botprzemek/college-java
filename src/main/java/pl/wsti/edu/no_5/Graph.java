package pl.wsti.edu.no_5;

import java.util.*;

class Graf {
    private int n;
    private LinkedList[] tab;

    public Graf(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];

        for (int i = 0; i < n; ++i) {
            tab[i] = new LinkedList();
        }
        while (st.hasMoreTokens()) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tab[from].add(to);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(i).append(": ");
            Iterator it = tab[i].iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
