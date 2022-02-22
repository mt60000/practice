package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stasion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("列車は時速100km/hで走っています。駅までの距離は500mです。");
		System.out.println("ブレーキを強くしたり、弱くしたりしながら駅に停車してください。");
		System.out.println("ブレーキは毎回、1段階だけ強くしたり弱くしたりできます。");
		int reply;
		
		do {
			int remain = 500; //残りの距離
			int speed = 100;  //スピード
			int brake = 0;    //ブレーキの強さ
			int second;	  	  //経過秒数
			
			for (second = 0; speed > 0; second++) {
				for (int i = 0; i < (remain / 10); i++)
					System.out.print("_");
				System.out.println("□ □ □");
				System.out.println("残り距離" + remain + "m 速度 "
									+ speed + "km/h ブレーキの強さ " + brake );
				System.out.println("ブレーキの強さは？(2=強く、 1=弱く、 0=そのまま)");
				reply = Integer.parseInt(br.readLine());
				if (reply == 2)
					brake++;
				else if (reply == 1 && brake > 00)
					brake--;
				if (speed > brake)
					speed -= brake;
				else
					speed = 0;
				remain -= (((speed * 10) + 35) / 36);
			}
			System.out.println(Integer.toString(second)
								+ "秒 駅までの距離 " + remain
								+ "mで停止しました。");
			System.out.println("もう一度やりますか？ (1=Yes; 0=No!) ");
			reply = Integer.parseInt(br.readLine());
		} while(reply != 0);
	} 
}
