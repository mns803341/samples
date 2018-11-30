import java.util.List;
import java.util.Stack;

/**
 * Created by mns803341 on 30.11.2018.
 */
public class MakePermutationsTest {

    public static void main(String[] args) {

        int arraySize = 5;
        Permutatator permutatator = new Permutatator(generateArray(arraySize));
        List<Stack<Integer>> allPermutations = permutatator.getPermutatoins();

        testCount(allPermutations, arraySize);

        testResult(allPermutations);

        output(allPermutations);
    }

    private static void testCount(List<Stack<Integer>> allPermutations, int arraySize) {
        int factorial = factorial(arraySize);
        if (allPermutations.size() != factorial) {
            throw new RuntimeException("The number of permutations is wrong");
        };
    }

    private static void testResult(List<Stack<Integer>> allPermutations) {

        for (int i = 0; i < allPermutations.size() - 1; i++) {
            Stack<Integer> stackA = allPermutations.get(i);
            for (int j = i + 1; j < allPermutations.size(); j++) {
                Stack<Integer> stackB = allPermutations.get(j);

                if (stackA.equals(stackB)) {
                    throw new RuntimeException("The permutations contain two equals permutations");
                }
            }
        }
    }

    private static void output(List<Stack<Integer>> allPermutations) {

        for (Stack<Integer> stack : allPermutations) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        int generatedNumber;
        System.out.println("Generating an array of numbers:");
        for (int i = 0; i < size; i++) {
            do {
                generatedNumber = (int) (Math.random() * 10);
            } while (isNotUnique(array, generatedNumber, i));
            System.out.print(generatedNumber + " ");
            array[i] = generatedNumber;
        }
        System.out.println();
        System.out.println("The generating completed.");
        return array;
    }

    private static boolean isNotUnique(int[] array, int newElement, int currentPos) {
        for (int i = 0; i < currentPos; i++) {
            if (array[i] == newElement){
                return true;
            }
        }
        return false;

    }
}
