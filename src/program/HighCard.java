package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HighCard {
	public static void main(String[] args) throws IOException {
		Random RandObj = new Random();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aCard[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		System.out.println("最初にカードが出ますから掛け金を決めてください。");
		System.out.println("次に出るカードが前のカードと同じか大きければ、あなたの勝ちです。");
		System.out.println("掛け金が戻りますから、続けるかどうか決めてください。続けて勝てば掛け金は2倍になります。");
		System.out.println("以降、4倍、8倍と戻るお金が増えます。ただし、負けるとそれまでの勝ちはなくなります。");
		System.out.println("所持金がなくなって破産するか、1000$を超えるとゲーム終了です。");
		System.out.println("---------------------------------------------");
		System.out.println("ゲームを開始します。所持金は100$です。");
		int money = 100;
		while (money > 0 && money < 1000) {
			int bet;
			int times = 1;
			int first = RandObj.nextInt(aCard.length);
			System.out.print("最初のカードです。｜" + aCard[first] + "｜");
			do {
				System.out.print("いくら賭けますか？（1$～" + money + "$）");
				bet = Integer.parseInt(br.readLine());
			} while (bet < 1 || bet > money);
			
			money -= bet;
			
			for (;;) {
				int card = RandObj.nextInt( aCard.length );
				System.out.print("｜" + aCard[card] + "｜");
				if (card >= first) {
					System.out.println("あなたの勝ち。" + (bet * times) + "$の勝ちです。");
					System.out.print("倍率は" + (times * 2) + "倍。続けますか？（1=Yes; 0=No!）");
					int reply = Integer.parseInt(br.readLine());
					if (reply == 0) {
						money += (bet * times);
						System.out.print("所持金は " + money + "$です。");
						break;
					}
					
					times *= 2;
					first = card;
				} else {
					System.out.print("あなたの負け。所持金は " + money + "$です。");
					break;
				}
			}
		}
		if (money > 0)
			System.out.print("おめでとう！！あなたは大富豪です。");
		else
			System.out.print("残念でした。破産です。");
	}
}
