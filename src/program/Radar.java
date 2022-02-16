package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Radar {
	public static void main(String[] args) throws IOException {
		System.out.println("☆レーダー☆");
		System.out.println("ターゲットとして 0～100 のうち1つの数が設定されます。"
			+ "探知する位置と範囲を入力してターゲットを見つけてください。");
		System.out.println("ターゲットと探索位置の差が探索範囲以下であればヒットです。探索範囲より大きければ、はずれです。");
		System.out.println("探索位置とターゲットが一致すれば正解です。");
		System.out.println("-----------------------------------------");
		System.out.println("ゲームを開始します。");
		
		Random RandObj = new Random();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int reply;
		do {
			int target = RandObj.nextInt(101);
			
			System.out.println("ターゲットが設定されました。¥n");
			
			for (int turn = 1; ; turn++) {
				System.out.println("位置は？");
				int position = Integer.parseInt(br.readLine());
				
				System.out.println("範囲は？");
				int range = Integer.parseInt(br.readLine());
				
				int distance;
				
				if (target > position)
					distance = target - position;
				else
					distance = position - target;
				
				if (distance == 0) {
					System.out.println("おめでとう！ "
							+ turn + "回目で正解です！");
					break;
				} else if (distance <= range) {
					System.out.println("ヒットしました。");
				} else {
					System.out.println("はずれました。");
				}
			}
			
			System.out.println("もう一度やりますか？ (1=Yes; 0=No!))");
			
			reply = Integer.parseInt(br.readLine());
		} while (reply != 0);
	}
}
