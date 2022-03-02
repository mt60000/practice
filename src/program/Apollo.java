package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apollo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("月着陸船を、無事月面に軟着陸點せてください。");
		System.out.println("月の重力は地球の約1/6です。１秒毎にエンジンを燃焼させて落下速度を調節してください。");
		System.out.println("燃料を１ユニット燃焼すると0.1m/s落下速度が減少します。１回で最大５０ユニットまで燃焼できます。");
		System.out.println("月面に0.1m/s以下の速度で到達すると着陸成功です。");
		System.out.println("--------------------------------------------------------------------");
		
		int reply;
		do {
			double altitube = 100.0; // 高度
			double velocity = 0.0;	 // 速度
			int fuel = 250;			 // 燃料
			
			while (altitube > 0.0) {
				for( int i = 0; i < (int)(altitube / 2.0); i++)
					System.out.print(" ");
				System.out.println(">□");
				System.out.println("高度： " + altitube
									+ "m 速度: " + velocity
									+ "m/s 残燃料： " + fuel);
				int max_fuel = 50; // 最大燃焼ユニット
				
				if (fuel < max_fuel) // 残燃料が少ない場合
					max_fuel = fuel;
				
				do {
					System.out.println("何ユニット燃焼しますか？（0～" + max_fuel + "）");
					reply = Integer.parseInt(br.readLine());
				} while (! (0 <= reply && reply <= max_fuel));
				
				// 速度の計算
				velocity += 1.62;					// 重力加速度
				velocity -= ((double)reply * 0.1);  // 燃焼
				
				// 残燃料の計算
				fuel -= reply;
				
				// 高度の計算
				altitube -= velocity;
			}
			
			if (velocity > 1.0) {
				System.out.println("残念！ 着陸船は速度 " + velocity
									+ "m/sで月面に激突しました。");
			} else {
				System.out.println("おめでとう！ 無事、月面に軟着陸できました。");
			}
			
			System.out.println("もう一度やりますか？　（Yes:1 No:0）");
			reply = Integer.parseInt(br.readLine());
		} while (reply != 0);
	}
}
