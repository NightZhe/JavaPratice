public class test44start {
    public static void main(String[] args) {
        for (int i = 5; i > 0; i--) {
            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int k = 5; k > 5 - i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
