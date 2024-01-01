import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {

        int i = 0;
        String champion = "";

        while (!StdIn.isEmpty()) {
            String nextWord = StdIn.readString();
            i++;
            if (StdRandom.bernoulli((double) 1 / i)) {
                champion = nextWord;
            }
        }
        StdOut.println(champion);
    }

}

