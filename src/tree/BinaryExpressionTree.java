package tree;

public class BinaryExpressionTree {
	public static void main(String[] args) {
		//��������������ķ�ʽ������
		char [] information = {' ','+','*','%','6','3','9','5'};
		Expression_Tree test= new Expression_Tree(information, 1);
		System.out.println("����������ʵ��");
		System.out.println("ǰ׺���ʽ");
		test.PreOrder(test.rootNode);
		System.out.println("\n ������ʽ");
		test.InOrder(test.rootNode);
		System.out.println("\n ��׺���ʽ");
		test.PostOrder(test.rootNode);
		System.out.println("\n ���ʽ������:");
		int answer=test.answer(test.rootNode);
		System.out.print(answer);
	}
}
