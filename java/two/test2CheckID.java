import java.util.Scanner;

public class test2CheckID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入您的生份證號碼:");
		String s = sc.nextLine();
		// String s = "A323456789";
		idCardVerification(s);

	}

	public static String idCardVerification(String s) {
		String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO"; // 字母代號對照表
		if (s.length() == 10) {
			char[] c = s.toUpperCase().toCharArray(); // 建立 c 陣列，同時將s字串轉大寫後，轉成字元陣列放入 c 陣列
			int[] ID = new int[c.length]; // 建立一個運算用的整數陣列，空間為 c 的字元個數
			// 驗證首位字母是否合法 (該字元是否能在checkHead[]找到), 驗證第一位是否為 1 or 2 (1=男生, 2=女生)
			if (checkHead.indexOf(c[0]) == -1 || (c[1] != '1' && c[1] != '2'))
				System.out.println("格式不合法");
			else {
				int sum = 0;
				ID[0] = checkHead.indexOf(c[0]) + 10; // 第一個英文字運算
				sum += ID[0] / 10; // .. 將商數加總 sum += ID[0]/10
				ID[0] %= 10; // .. 取餘數放回 ID[0] 以便之後的運算
				for (int i = 1; i < 10; i++) // 將身分證後9碼轉成整數型態 (ASCII碼-48)
					ID[i] = (int) c[i] - 48;
				for (int i = 0; i < 9; i++) { // 代入公式:
					ID[i] *= (9 - i); // 總和 sum += (ID[0])*9 + ID[1]*8 + ID[2]*7 + ... + ID[9]*1
					sum += ID[i];
				}
				// 檢查(10-sum%10)是否相等於檢查碼，且 sum%10(餘數)為0時，檢查碼為0 => (10-sum%10)%10
				if ((10 - sum % 10) % 10 == ID[9])
					System.out.println("合法.");
				else
					System.out.println("不合法");
			}
		} else
			System.out.println("長度不合法");
		return checkHead;

	};
}
