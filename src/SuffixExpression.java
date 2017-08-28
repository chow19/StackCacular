import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SuffixExpression {
	ArrayList<String> sExpression = new ArrayList<>();
	private static final Map<String, Integer> basic = new HashMap<String, Integer>();
	static{
		basic.put("(", 0);
		basic.put("+", 1);
		basic.put("-", 1);
		basic.put("*", 2);
		basic.put("/", 2);
		basic.put("%", 2);
		basic.put("^", 3);
	}//用map来提取符号的优先级
	
	public SuffixExpression(String iExpression) {
		ArrayList<String> dealExpression = new ArrayList<>();
		Stack<String> operatorStack = new Stack<>();
		
		StringTokenizer st1 = new StringTokenizer(iExpression, "+|-|*|/|^|%|(|)", true);
		//StringTokenizer,比split好用，可以保留分隔符,分割后用hasMoreElement输出
		while (st1.hasMoreElements()) {
			dealExpression.add(st1.nextToken());
		}
		
		for (String string : dealExpression) {
			try {
				Double.parseDouble(string);//看看是不是数字，是的话就加到后缀的数组里面，不是的话就用Dealoperator处理看看放哪
				sExpression.add(string);
			} catch (Exception e) {
				DealOperator(operatorStack, string, sExpression);
			}
		}
		while (!operatorStack.empty()) {
			sExpression.add(operatorStack.pop());
		}
	}
	
	 private static void DealOperator(Stack<String> operatorStack, String string, ArrayList<String> sExpression) {
		if(operatorStack.empty()){
			operatorStack.push(string);
		}else if (string.equals(")")) {//本来放在下一个判断后面，后来发现下面的判断包含了")"的情况，于是放到上面来
			while(true){
				String string2 = operatorStack.pop();
				if(basic.get(string2)==0){
					break;
				}else {
					sExpression.add(string2);
				}
			}
		}else if (basic.get(string)>basic.get(operatorStack.peek())||basic.get(string)==0) {
			operatorStack.push(string);
		}else {
			sExpression.add(operatorStack.pop());
			DealOperator(operatorStack, string, sExpression);
		}
		
	}

	public double  Cacular() throws Exception {
		Stack<Double> oprandStack = new Stack<>();
		for(String iString : sExpression){
			try {
				double d1 = Double.valueOf(iString);
				oprandStack.push(d1);
			} catch (Exception e) {
				switch (iString) {
				case "+":
					oprandStack.push(oprandStack.pop()+oprandStack.pop());
					break;
				case "-":
					oprandStack.push(oprandStack.pop()-oprandStack.pop());
					break;
				case "*":
					oprandStack.push(oprandStack.pop()*oprandStack.pop());
					break;
				case "/"://下面三个都是第一个数和第二个数顺序不能换，所以先把第二个数取出来放
					double temp = oprandStack.pop();
					oprandStack.push(oprandStack.pop()/temp);
					break;
				case "^":
					double tp = oprandStack.pop();
					oprandStack.push(Math.pow(oprandStack.pop(), tp));
					break;
				case "%":
					double mp = oprandStack.pop();
					oprandStack.push(oprandStack.pop()%mp);
					break;

				default:
					throw new Exception();
				}
			}
		}
		return oprandStack.pop();
	}
	
	public void getSuffixExpression() {
		for (String string : sExpression) {
			System.out.print(string);
		}
		System.out.println();
	}
	
	 /*public static void main(String[] args) throws Exception {
		SuffixExpression suffixExpression = new SuffixExpression("5+4*6/2+3+(4*5)/5");
		for (String string : suffixExpression.sExpression) {
			System.out.print(string);
		}
		System.out.println();
		System.out.println(suffixExpression.Cacular());
	}*/
}
