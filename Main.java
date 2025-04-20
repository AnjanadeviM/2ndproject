import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Shorten URL\n2. Expand URL\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter long URL: ");
                String longURL = scanner.nextLine();
                String shortURL = shortener.shortenURL(longURL);
                System.out.println("Shortened URL: " + shortURL);
            } else if (choice == 2) {
                System.out.print("Enter short URL: ");
                String shortURL = scanner.nextLine();
                String originalURL = shortener.expandURL(shortURL);
                System.out.println("Original URL: " + originalURL);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
