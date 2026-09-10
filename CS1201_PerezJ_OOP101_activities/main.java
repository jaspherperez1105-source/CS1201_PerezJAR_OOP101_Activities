import java.util.Scanner;

class Menu {
    String ft;
    int item;
    double price;

    Menu(String ft, int item, double price) {
        this.ft = ft;
        this.item = item;
        this.price = price;
    }
}

class Student {
    double Discount;
    double Discounted;
    double Ttl;

    Student(double price, double discountRate) {
        this.Discount = discountRate;
        this.Discounted = this.Discount * price;
        this.Ttl = price - this.Discounted;
    }
}

public class main {
    public static void main(String[] args) {
        Menu First = new Menu("Spaghetti", 1, 80);
        Menu Second = new Menu("Chicken", 2, 60);
        Menu Third = new Menu("Burger", 3, 50);
        Menu Fourth = new Menu("Fries", 4, 45);
        Menu Fifth = new Menu("Coke", 5, 50);
        int TtlItems = 0;
        double TtlBeforeDis = 0;
        double TtlDis = 0;
        double FinalAmount = 0;

        String again = "Y";

        while (again.equalsIgnoreCase("Y")) {
            Scanner input = new Scanner(System.in);
            System.out.println("=====   MENU    =====");
            System.out.printf("1. Spaghetti      - $%.2f%n", First.price);
            System.out.printf("2. Chicken        - $%.2f%n", Second.price);
            System.out.printf("3. Burger         - $%.2f%n", Third.price);
            System.out.printf("4. Fries          - $%.2f%n", Fourth.price);
            System.out.printf("5. Coke           - $%.2f%n", Fifth.price);
            System.out.print("Enter item number: ");
            int choi = input.nextInt();
            while (choi < 1 || choi > 5) {
                System.out.println("Invalid Character. Choose again: ");
                choi = input.nextInt();
            }
            System.out.print("Enter quantity: ");
            int quanti = input.nextInt();

            System.out.print("Are you a Student? (Y/N): ");
            String ans = input.next();

            double price = 0;

            switch (choi) {
                case 1: price = First.price; break;
                case 2: price = Second.price; break;
                case 3: price = Third.price; break;
                case 4: price = Fourth.price; break;
                case 5: price = Fifth.price; break;
            }

            double subtotal = price * quanti;
            System.out.printf("Subtotal: $%.2f%n", subtotal);

            boolean isStu = ans.equalsIgnoreCase("Y");


            double bulkRate = (subtotal > 500) ? 0.05 : 0.0;

            double disRate;
            if (isStu) {
                disRate = 0.10 + bulkRate;
            } else {
                disRate = bulkRate;
            }

            Student s = new Student(subtotal, disRate);

            System.out.printf("Discount: $%.2f%n", s.Discounted);
            System.out.printf("Total: $%.2f%n", s.Ttl);

            // Add this order to the running totals
            TtlItems += quanti;
            TtlBeforeDis += subtotal;
            TtlDis += s.Discounted;
            FinalAmount += s.Ttl;

            System.out.print("Do you want to order again? (Y/N): ");
            again = input.next();
        }

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + TtlItems);
        System.out.printf("Total before discount: $%.2f%n", TtlBeforeDis);
        System.out.printf("Total discount: $%.2f%n", TtlDis);
        System.out.printf("Final amount: $%.2f%n", FinalAmount);
        System.out.printf("Thank you for ordering!%n");
    }
}