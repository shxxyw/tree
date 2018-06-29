package tree;

public class BinaryExpressionTree {
	public static void main(String[] args) {
		//将二叉树以数组的方式来声明
		char [] information = {' ','+','*','%','6','3','9','5'};
		Expression_Tree test= new Expression_Tree(information, 1);
		System.out.println("二叉树运算实例");
		System.out.println("前缀表达式");
		test.PreOrder(test.rootNode);
		System.out.println("\n 中序表达式");
		test.InOrder(test.rootNode);
		System.out.println("\n 后缀表达式");
		test.PostOrder(test.rootNode);
		System.out.println("\n 表的式计算结果:");
		int answer=test.answer(test.rootNode);
		System.out.print(answer);
	}
}
