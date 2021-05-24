package stackDSA;



public class InfixToPostFix {
	
	static StackOperation stack=new StackOperation();
	
	static int precedance(char c){
		switch(c){
		
		case '+':
		case '-':
			return 2;
		
		case '*':
		case '/':
			return 3;
			
		case '^':
			return 4;
		case '(':
		case ')':
			return 1;
			
		default:
			return -1;
	}		
	}
	
	public static String convertInfixToPostfix(String exp){
		String result=new String();
		
		for(int i=0;i<exp.length();i++){
			Character ch=exp.charAt(i);
			if(ch.isLetterOrDigit(ch)){
				result+=ch;
			}
			else if(ch.equals('(')){
				stack.push(ch);
			}
			else if(ch.equals(')')){
				while(!stack.isEmpty() && stack.peek()!='('){
					if(stack.peek()=='(')
						return "invalid";
					result+=(char)stack.pop();
				}
				stack.pop();
			}
			else{
				if(precedance(ch)>precedance((char)stack.peek())){
					stack.push(ch);
				}
				else{
					while(!stack.isEmpty() && precedance(ch)<=precedance((char)stack.peek())){
						if(stack.peek()=='(')
							return "invalid";
						result+=(char)stack.pop();
					}
					stack.push(ch);
				}
			}
		}
		while(!stack.isEmpty()){
			result+=(char)stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		 String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
	        System.out.println(convertInfixToPostfix(exp));

	}

}
