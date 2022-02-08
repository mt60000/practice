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
		// "C"を削除した後、続けて"D"を読み込むのでその時点で例外が発生する
		// returnで処理を終了させると回避できる
		
		for (String str : list) {
			System.out.println(str);
		}
	}
}
