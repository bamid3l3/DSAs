import edu.princeton.cs.algs4.StdIn;

// Social network connectivity. Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, 
// design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). 
// Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be log mlogn or better and use extra space proportional to n.

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

