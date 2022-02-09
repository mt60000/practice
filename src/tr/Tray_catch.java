package tr;

public class Tray_catch {
	public static void main(String[] args) {
		// catch文はいくつも記述することができるが、catch文の処理が完了するとそれ以降の
		// catch文の処理が行われないため、到達不可能な処理が発生する
		// 到達不可能な処理があるとコンパイルエラーが発生する
		// この場合は、スーパークラスであるSampleExceptionでどちらのエラーも受け取ることができるため
		// もうひとつのcatch文に到達することができず、コンパイルエラーとなる
		
//		try {
//			sample();
//			sub();
//		} catch (SampleException e) {
//			System.out.println("A");
//		} catch (SubSampleException e) {
//			System.out.println("B");
//		}
		
		
		// この場合だとエラーが起きない
		
		try {
			sample();
			sub();
		} catch (SubSampleException e) {
			System.out.println("A");
		} catch (SampleException e) {
			System.out.println("B");
		}
		
	}
	
	private static void sample() throws SampleException {
		throw new SampleException();
	}
	
	private static void sub() throws SubSampleException {
		throw new SubSampleException();
	}
}