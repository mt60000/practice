package tr;

import java.util.ArrayList;

public class ArrayList_tr {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		// 存在しない添え字の位置にadd使用とすると例外が発生する
		// list.add("A");
		// list.add(2, "B");
		// list.add("C");
		// for (String s : list) {
		//   System.out.println(s);
		// }
		// IndexOutOfBoundsException例外が発生
		
		
		// 下記のコードでは例外は発生しない
		list.add("A");
		list.add("B");
		list.add("D");
		list.add(2, "C");
		list.add("E");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
