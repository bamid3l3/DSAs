import java.util.Arrays;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        int parent = id[i];

        if (i == parent) {
            return i;
        }
        return root(parent);

//        course implementation
//        while (i != id[i]) {
//            i = id[i];
//        }
//
//        return i;

    }

    public void union(int p, int q) {
        id[root(p)] = id[root(q)];
        display();
    }

    public void display() {
        System.out.println(Arrays.toString(id));
    }

    public boolean connected(int p, int q) {
        boolean isConnected = root(p) == root(q);
        System.out.println("Are " + p + " and " + q + " connected?: " + isConnected);
        return isConnected;
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(6, 5);
        qu.union(9, 4);
        qu.union(2, 1);
        qu.connected(8, 9);
        qu.connected(5, 4);
//        qu.union(5, 0);
//        qu.union(7, 2);
//        qu.union(6, 1);
//        qu.union(7, 3);
    }
}
