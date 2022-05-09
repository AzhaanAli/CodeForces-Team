import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** DIRECTIONS:
         * Three students will only decide to implement a solution to a problem if at least two of them agree.
         * Given n, the amount of solutions, and n sets of 0/1 triples, count the amount of solutions the students will implement.
         *
         * A triple can look like "0  1  0"
         * This one in particular means that student one disagrees, student two agrees, and student three disagrees.
         */

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        // Count the amount of triples that satisfy the condition.
        int counter = 0;
        for(int i = 0; i < n; i++)
            if(contains2Ones(s.nextLine()))
                counter++;
        System.out.println(counter);


    }

    // For each triple, we have two options. Count the amount of 1's and make sure it's not 1,
    // or count the amount of 0's, and make sure it's not greater than 2.
    public static boolean contains2Ones(String input){

        char[] charArr = input.toCharArray();

        boolean foundOneOne = false;
        boolean foundOneZero = false;

        // += 2 to skip the spaces.
        for(int i = 0; i < 6; i += 2)
        {
            if(charArr[i] == '1')
            {
                // If we've already found a 1, then now we've found 2 and can return true.
                // If we haven't found a 1, then now we have and can turn the boolean on for next time.
                if(foundOneOne) return true;
                else foundOneOne = true;

            }else{
                // If we've already found a 0, then now we've found 2 and can return false.
                // If we haven't found a 0, then now we have and can turn the boolean on for next time.
                if(foundOneZero) return false;
                else foundOneZero = true;

            }
        }
        return false;

    }
}