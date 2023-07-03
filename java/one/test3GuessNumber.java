import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class test3GuessNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String computerGuess = "";
		// 產生一個亂數種子
		Random random = new Random();

		// 產生第一個數字，必須為1-9之間的數字
		int num1 = random.nextInt(9) + 1;

		// 產生第二個數字，不等於num1，必須為0-9之間的數字
		int num2;
		do {
			num2 = random.nextInt(10);
		} while (num2 == num1);

		// 產生第三個數字，不等於num1和num2，必須為0-9之間的數字
		int num3;
		do {
			num3 = random.nextInt(10);
		} while (num3 == num1 || num3 == num2);

		// 產生第四個數字，不等於num1、num2和num3，必須為0-9之間的數字
		int num4;
		do {
			num4 = random.nextInt(10);
		} while (num4 == num1 || num4 == num2 || num4 == num3);

		// 將四個數字合併為字串型態
		computerGuess = Integer.toString(num1) + Integer.toString(num2) +
				Integer.toString(num3) + Integer.toString(num4);

		// 輸出結果
		System.out.println("random: " + computerGuess);

		while (true) {
			int A = 0, B = 0;
			boolean check[] = new boolean[4]; // 紀錄每個位數是否檢查過
			Arrays.fill(check, false);
			String guess = sc.next(); // 使用者輸入數字
			if (guess.length() != 4) {
				System.out.println("輸入不正確，請輸入一組四位數字。");
				return;
			}

			Set<Character> set = new HashSet<>();
			for (char c : guess.toCharArray()) {
				if (!set.add(c)) {
					System.out.println("輸入不正確，四個數字不能重複。");
					return;
				}
			}

			// System.out.println("輸入正確，四個數字都不相同。");

			// 檢查有幾A
			for (int i = 0; i < 4; i++) {
				if (computerGuess.charAt(i) == guess.charAt(i)) {
					A++;
					check[i] = true;
				}
			}
			// 檢查有幾B
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (!check[j] && computerGuess.charAt(j) == guess.charAt(i)) {
						B++;
						check[j] = true;
						break;
					}
				}
			}

			// Output
			if (A == 4) {
				System.out.println("Correct");
				break;
			} else {
				System.out.println(A + "A" + B + "B");
			}

		}
	}
}
