import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackCacular {
	
	public static void sc() throws Exception {
		InfixExpression infixExpression = new InfixExpression();
		SuffixExpression suffixExpression = new SuffixExpression(infixExpression.getIExpress());
		suffixExpression.getSuffixExpression();
		System.out.println(infixExpression.getIExpress());
		System.out.println(suffixExpression.Cacular());
	}
	
	public static void main(String[] args) throws Exception{
		boolean flag=true;
		while (flag) {
			flag = false;
			System.out.println("��������ʽ(����5+4*6/2+3+(4^2)%3):");
			sc();
			System.out.println("������(yes/no)");
			Scanner scannerM = new Scanner(System.in);
			String string = scannerM.nextLine();
			if(string.equals("y")||string.equals("yes")||string.equals("Y")||string.equals("YES")){
				flag = true;
			}
		}
	}
}
