package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Numbers {
	public static void main(String[] args) throws IOException {
		Random RandObj = new Random();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("4桁の数を当ててください。");
		System.out.println("同じ数字は1度しか使用されません。");
		System.out.println("最上位に0が使用される場合もあります。");
		System.out.println("ヒントとして、合っている数字の数と、");
		System.out.println("桁 （位置） も合っている数字の数を示します。");
		System.out.println("答えが’4135’で入力が’0123’の場合、’数：2,桁：1’とヒントが出ます。");
		System.out.println("--------------------------------------");
		
		int reply;
		do {
			int numbers[] = new int[4];
			
			do {
				numbers[0] = RandObj.nextInt(10);
				numbers[1] = RandObj.nextInt(10);
				numbers[2] = RandObj.nextInt(10);
				numbers[3] = RandObj.nextInt(10);
			} while ( ! ( numbers[0] != numbers[1]
						&& numbers[0] != numbers[2]
						&& numbers[0] != numbers[3]
						&& numbers[1] != numbers[2]
						&& numbers[1] != numbers[3]
						&& numbers[2] != numbers[3]));
			System.out.println("4桁の数字を考えました！！");
			for (int turn = 1 ; ; turn++) {
				System.out.println("数を当ててください。");
				int num = Integer.parseInt(br.readLine());
				
				int test[] = new int[4];
				
				test[3] = num % 10;
				test[2] = (num / 10) % 10;
				test[1] = (num / 100) % 10;
				test[0] = (num / 1000) % 10;
				
				int kazu = 0;
				int keta = 0;
				
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (numbers[i] == test[j]) {
							kazu++;
							if (i==j)
								keta++;
						}
					}
				}
				
				if (keta == 4) {
					System.out.println("おめでとう！！" + turn + "回目で正解です。");
					break;
				} else {
					System.out.println("数：" + kazu + ",桁：" + keta);
				}
			}
			
			System.out.println("もう一度やりますか？（Yes:1 No:0） ");
			reply = Integer.parseInt(br.readLine());
		} while (reply != 0);
	}
}
