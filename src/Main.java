import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the boring string:");
            String boringString = scanner.nextLine();


            System.out.println("Enter the number of ranges:");
            int numRanges = scanner.nextInt();

            int[] startIndexes = new int[numRanges];
            int[] endIndexes = new int[numRanges];

            System.out.println("Enter the start indexes :");
            for (int i = 0; i < numRanges; i++) {
                startIndexes[i] = scanner.nextInt();
            }


            System.out.println("Enter the end indexes :");
            for (int i = 0; i < numRanges; i++) {
                endIndexes[i] = scanner.nextInt();
            }

            StringFunifier stringFunifier = new StringFunifier(boringString, startIndexes, endIndexes);
            String funnyString = stringFunifier.getFunnyString();

            System.out.println("Funny String:");
            System.out.println(funnyString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
// abbccCDdBCCcc
// 1, 5, 7, 11
//3, 5, 10, 12