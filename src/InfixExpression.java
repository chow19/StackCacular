import java.util.Scanner;

public class InfixExpression {
	String iExpression;
	
	public InfixExpression() {
		Scanner scannerI = new Scanner(System.in);
		iExpression = scannerI.nextLine();
		iExpression = iExpression.trim();//trim()�������string�еĿո�
		//scannerI.close();//ԭ����������رգ��������ֻ�ر�system.in,����������Scanner�����ã������
	}
	
	public String getIExpress() {
		return iExpression;
	}
}
