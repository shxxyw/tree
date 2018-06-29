package tree;
class TreeNode{
	int data;
	TreeNode left_Node;
	TreeNode right_Node;
	public TreeNode(int data) {
		this.data =data;
		this.left_Node=null;
		this.right_Node=null;
	}
}
public class BinaryTreeByLinkedList {
	public TreeNode rootNode;//�������ڵ�
	/*
	 * �ܽ᣺���������ִ�������Ϊ�̳�ʱ�����޲ι��췽�����������޷�ʵ����������û��ʵ������������޷�ʵ��������������ж���
       1 .����super���������ʽ���ø���Ĵ��ι��췽��
       2.�����෽���ṩһ���޲ι��췽����ʹ֮�ܹ�ʵ��������Ϊ���������˹��췽��������ʽ���췽�����Ὠ��
	 */
//�����յĶ����� (��ʽ������������̳�����õ�ʱ���Լ������˹��췽��������Ҫ����)
	public BinaryTreeByLinkedList() {
		rootNode=null;
	}
//	��ʼ���������������������
	public BinaryTreeByLinkedList(int[] dataArray) {
		for(int i=0;i<dataArray.length;i++)
			add_data_to_node(dataArray[i]);
	}
	//��ָ����ֵ������Ӧ�Ķ�������Ӧ��λ
	void add_data_to_node(int value) {
		TreeNode currentNode =rootNode;
		if(rootNode==null) {//���ڵ㽨��
			rootNode=new TreeNode(value);
			return;
		}
		while(true) {//ѭ�����������ڵ������
			if(value<currentNode.data) {//����������
				if(currentNode.left_Node==null) {
				currentNode.left_Node=new TreeNode(value);
				return;
				}else {
					currentNode=currentNode.left_Node;
				}
			}else {//����������
				if(currentNode.right_Node==null) {
					currentNode.right_Node=new TreeNode(value);
					return;
				}else {
					currentNode=currentNode.right_Node;
				}
			}
		}
	}
	
	/*
	 * ���������� ���õݹ鷽��ǰ�����򡢺�������
	 */
	//�������
	public void PreOrder(TreeNode node) {
		if(node!=null) {
			System.out.print(" ["+node.data+"] ");
			PreOrder(node.left_Node);
			PreOrder(node.right_Node);
		}
	}
	//�������
		public void InOrder(TreeNode node) {
			if(node!=null) {
				InOrder(node.left_Node);
				System.out.print(" ["+node.data+"] ");
				InOrder(node.right_Node);
			}
		}
	//�������
		public void PostOrder(TreeNode node) {
			if(node!=null) {
				PostOrder(node.left_Node);
				PostOrder(node.right_Node);
				System.out.print(" ["+node.data+"] ");
			}
		}
		
}


/*
 * ���Լ�����ʽֵ�ö������Ľ���
 */
class Expression_Tree extends BinaryTreeByLinkedList{
	public Expression_Tree (char[] information,int index) {
		//����create���������������ʾ��ת������ʽ��ʾ��
		rootNode = create(information,index);
	}
	public TreeNode create(char[]sequence,int index) {
		TreeNode tempNode;
		if(index >= sequence.length)//��Ϊ�ݹ���õĳ�������
			return null;
		else {//ǰ׺���ʽ�����������н���
			tempNode = new TreeNode((int)sequence[index]);
			//����������
			tempNode.left_Node=create(sequence,2*index);
			//����������
			tempNode.right_Node=create(sequence,2*index+1);
			return tempNode;
		}
	}
	//��Բ������Ϊ�ַ��ı���
	//�������
		public void PreOrder(TreeNode node) {
			if(node!=null) {
				System.out.print((char)node.data);
				PreOrder(node.left_Node);
				PreOrder(node.right_Node);
			}
		}
		//�������
			public void InOrder(TreeNode node) {
				if(node!=null) {
					InOrder(node.left_Node);
					System.out.print((char)node.data);
					InOrder(node.right_Node);
				}
			}
		//�������
			public void PostOrder(TreeNode node) {
				if(node!=null) {
					PostOrder(node.left_Node);
					PostOrder(node.right_Node);
					System.out.print((char)node.data);
				}
			}
//		�жϱ��ʽ�������ķ���������
		public int condition(char operator,int num1,int num2) {
			switch(operator) {
			case '*':return(num1*num2);//����return�Դ��жϲ���break
			case '/':return(num1/num2);
			case '+':return(num1+num2);
			case '-':return(num1-num2);
			case '%':return(num1%num2);
			}
			return -1;
		}	
//		������ڵ㣬�����������ֵ
		public int answer(TreeNode node) {
			int firstNumber=0;
			int secondNumber=0;
			//�ݹ���������
			if(node.left_Node==null && node.right_Node==null)
				//���ڵ��ֵת������ֵ�󷵻�
				return Character.getNumericValue((char)node.data);
			else {
				firstNumber = answer(node.left_Node);//����������
				secondNumber = answer(node.right_Node);//����������
				return condition((char)node.data,firstNumber,secondNumber);
			}
		}
}
