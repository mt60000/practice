package tr;

import java.util.ArrayList;

public class CME {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		for (String str : list) {
			if ("C".equals(str)) {
				list.remove(str);
				System.out.println(str + "を削除しました。");
			}
		}
		
		// removeメソッド実行後に読み出しをすると
		// ConcurrentModificationException例外が発生する
		// removeした後、listを再度読み取ろうとしているので例外が発生する
		// returnで意図的に処理を終了させると回避することはできる
		
		for (String str : list) {
			System.out.println(str);
		}
	}
}
