package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Sugoroku {
	static private Random RandObj = new Random();
	static int ThrowDices(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += RandObj.nextInt(3) + 1;
		}
		return sum;
	}
	
	static void ShowBoard(int pos) {
		for (int i = 0; i < pos; i++) {
			System.out.print("_ ");
		}
		System.out.print("▲");
		for (int i = pos + 1; i < 30; i++) {
			System.out.print("_ ");
		}
		System.out.println("|上がり！");
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("▲すごろく▲");
		System.out.println("30マス先にゴールがあります。");
		System.out.println("1,2,3の3つの目を持つ特別なさいころ10個を、好きな数だけ振って駒を進めます。");
		System.out.println("ぴったり上がりに泊まれば終わりです。目の数が多ければ、余った目の数だけ戻ります。");
		System.out.println("-------------------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int reply;
		
		do {
			int position = 0;
			ShowBoard(position);
			for (int turn = 1; ; turn++) {
				int n;
				while (true) {
					System.out.println("残り" + ( 30 - position ) + "マスです。サイコロの数は？");
					n = Integer.parseInt(br.readLine());
					
					if (n <= 10)
						break;
					else
						System.out.println("サイコロは10個までです。");
				}
				int me = ThrowDices(n);;
				System.out.println("出た目の合計 " + me);
				position += me;
				
				if (position == 30) {
					System.out.println("おめでとう！！ " + turn + "回目で上がりです。");
					break;
				}
				
				if (position > 30) {
					position = 30 - (position - 30);
					ShowBoard(position);
				}
				
				
			} 
			System.out.println("もう一度やりますか？（Yes:1 No:0）");
			reply = Integer.parseInt(br.readLine());
		} while (reply != 0);
	}
}
