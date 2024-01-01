import java.util.Arrays;

public class QuickFind {
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void display() {
        System.out.println(Arrays.toString(id));
    }

    public boolean connected(int p, int q) {
        boolean isConnected = id[p] == id[q];
        System.out.println("Are " + p + " and " + q + " connected?: " + isConnected);
        return isConnected;
    }

    public void union(int p, int q) {
        int p_component = id[p];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == p_component) {
                id[i] = id[q];
            }
        }
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);
        qf.union(9, 4);
        qf.union(2, 1);
        qf.connected(8, 9);
        qf.connected(5, 4);
    }
}
