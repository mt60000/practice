package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hungman_main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--- HANGMAN ---");
		System.out.println("");
		
		int reply;
		
		do {
			Hungman game = new Hungman();
			
			for (;;) {
				game.showState();
				
				char ch = game.inputAnswer(br);
				
				game.checkAnswer(ch);
				
				if (game.checkFinish()) {
					break;
				}
			}
			System.out.println("AGAIN (1=YES; 0=NO!)?");
			reply = Integer.parseInt(br.readLine());
		} while(reply != 0);
	}
}
