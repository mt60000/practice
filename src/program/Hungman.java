package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Hungman {
	private String Answer;  	// 正解の単語
	private boolean Correct[];  // 回答状況
	private String Alphabet;    // 未使用文字
	private int Mistake; 		// 誤答数
	
	public Hungman() {
		String aAnswerWord[] = {
			"TIGER", "CAT", "DOG","LION","FOX","WOLF",
			"HOUSE","COW","GOAT","ZEBRA","ELEPHANT","PENGUIN",
			"GIRAFFE","ANTEATER"
		};
		Random RandObj = new Random();  // 正解の単語を選択します
		
		int n = RandObj.nextInt(aAnswerWord.length);
		Answer = aAnswerWord[n];
		
		Correct = new boolean[Answer.length()];
		
		for (int i = 0; i < Answer.length(); i++) {
			Correct[i] = false;
		}
		
		Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Mistake = 0;
	}
	
	public void checkAnswer(char ch) {
		boolean bMatch = false;
		
		for (int i = 0; i < Answer.length(); i++) {
			if (Answer.charAt(i) == ch) {
				Correct[i] = true;
				bMatch = true;
			}
		}
		
		Alphabet = Alphabet.replace(ch, ' ');
		
		if (bMatch == false)
			Mistake++;  // 不正解による誤答数の増加
	}
	
	public boolean checkFinish() {
		boolean bCorrect = true;
		
		for (int i = 0; i < Answer.length(); i++) {
			if (Correct[i] == false)
				bCorrect = false;
		}
		
		if (bCorrect) {
			showHungman(-1);
			System.out.println(Answer);
			return true;
		} else if (Mistake == 6) {
			showHungman(Mistake);
			System.out.println(Answer);
			return true;
		}
		
		return false;
	}
	
	private void showHungman(int mistake) {
		System.out.println(" +------+");
		System.out.println(" |      |");
		
		if (mistake == 0) {
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		} else if (mistake == 1) {
			System.out.println(" |  (+_+;");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		} else if (mistake == 2) {
			System.out.println(" |  (+_+;");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		} else if (mistake == 3) {
			System.out.println(" |   (+_+;");
			System.out.println(" | o／|Y|＼o");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		} else if (mistake == 4) {
			System.out.println(" |   (+_+;");
			System.out.println(" | o／|Y|＼o");
			System.out.println(" |   ／");
			System.out.println(" | ``");
			System.out.println("/|");
		} else if (mistake == 5) {
			System.out.println(" |   (@_@;");
			System.out.println(" | o／|Y|＼o");
			System.out.println(" |   ／ ＼");
			System.out.println(" | ``    ``");
			System.out.println("/|");
		} else if (mistake == 6) {
			System.out.println(" |   (^_^;");
			System.out.println(" | o／|Y|＼o");
			System.out.println(" |   ／ ＼");
			System.out.println(" | ``    ``");
			System.out.println("/|");
		}
	}
	
	public void showState() {
		showHungman(Mistake);
		
		System.out.println(Alphabet);
		
		for ( int i = 0; i < Answer.length(); i++) {
			if (Correct[i] == false) {
				System.out.print("_ ");
			} else {
				System.out.print(Answer.substring(i, i + 1) + " ");
			}
		}
	}
	
	public char inputAnswer(BufferedReader br) throws IOException {
		for (;;) {
			System.out.println("");
			String in = br.readLine().toUpperCase();
			if (in.length() > 0) {
				return in.charAt(0);
			}
		}
	}
}