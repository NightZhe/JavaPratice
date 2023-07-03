public class test46start {
    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            for (int k = 1; k <= 4 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        for (int i = 0; i <= 3; i++) {
            for (int k = 1; k <= i + 1; k++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}
