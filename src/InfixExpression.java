import java.util.Scanner;

public class InfixExpression {
	String iExpression;
	
	public InfixExpression() {
		Scanner scannerI = new Scanner(System.in);
		iExpression = scannerI.nextLine();
		iExpression = iExpression.trim();//trim()用于清除string中的空格
		//scannerI.close();//原打算在这里关闭，后来发现会关闭system.in,导致主函数Scanner不可用，逐放弃
	}
	
	public String getIExpress() {
		return iExpression;
	}
}
