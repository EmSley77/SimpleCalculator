import java.util.Scanner;
//Emanuel sleyman
// 2024-03-20
//Simple calculator using stack, code along:)
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "";
        System.out.println("Quit type in quit");
        do {
            System.out.println("Enter your numbers to calculate");
            System.out.print(">");

            input = scanner.nextLine();

            int result = s.calculate(input);


            System.out.println("Result: " + result);
        } while (!input.equalsIgnoreCase("quit"));
        System.out.println("Goodbye...");


    }
}