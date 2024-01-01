import edu.princeton.cs.algs4.StdIn;

public class SocialNetwork {

    public static void main(String[] args) {
        int n = 10;
        QuickUnionWeighted qu = new QuickUnionWeighted(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            int timestamp = StdIn.readInt();
            qu.union(p, q);

            if (qu.nodeSize(p) == n) {
                System.out.println("Earliest time at which all members are connected: " + timestamp);
                break;
            }
        }
    }
}

