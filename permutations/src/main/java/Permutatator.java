import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutatator {

    private List<Stack<Integer>> allPermutations;
    private int[] array;

    public Permutatator(int[] array) {
        this.allPermutations = new ArrayList<Stack<Integer>>();
        this.array = array;
    }

    public List<Stack<Integer>> getPermutatoins() {
        walkOnTheTree(new Stack<Integer>(), this.array);
        return this.allPermutations;
    }

    private void walkOnTheTree(Stack<Integer> stack, int... array) {
        if (array.length == 0) {
            this.allPermutations.add((Stack<Integer>) stack.clone());
        } else {
            for (int i = 0; i < array.length; i++) {
                stack.push(array[i]);
                int[] subarray = getComplement(i, array);
                walkOnTheTree(stack, subarray);
                stack.pop();
            }
        }
    }

    private static int[] getComplement(int complementor, int[] array) {
        int[] complement = new int[array.length - 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == complementor) {
                continue;
            }
            complement[index++] = array[i];
        }
        return complement;
    }


}
