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
	public TreeNode rootNode;//创立根节点
	/*
	 * 总结：在遇到这种错误是因为继承时父类无参构造方法，导致其无法实例化。父类没有实例化，子类就无法实例化。解决方法有二。
       1 .利用super（）语句显式调用父类的带参构造方法
       2.给父类方法提供一个无参构造方法，使之能够实例化。因为父类声明了构造方法后，其隐式构造方法不会建立
	 */
//建立空的二叉树 (隐式构造参数，当继承类调用的时候自己构建了构造方法，则需要声明)
	public BinaryTreeByLinkedList() {
		rootNode=null;
	}
//	初始化利用数组参数来建立树
	public BinaryTreeByLinkedList(int[] dataArray) {
		for(int i=0;i<dataArray.length;i++)
			add_data_to_node(dataArray[i]);
	}
	//将指定的值加入相应的二叉树对应部位
	void add_data_to_node(int value) {
		TreeNode currentNode =rootNode;
		if(rootNode==null) {//根节点建立
			rootNode=new TreeNode(value);
			return;
		}
		while(true) {//循环建立除根节点外的树
			if(value<currentNode.data) {//建立左子树
				if(currentNode.left_Node==null) {
				currentNode.left_Node=new TreeNode(value);
				return;
				}else {
					currentNode=currentNode.left_Node;
				}
			}else {//建立右子树
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
	 * 遍历二叉树 利用递归方法前序、中序、后续遍历
	 */
	//先序遍历
	public void PreOrder(TreeNode node) {
		if(node!=null) {
			System.out.print(" ["+node.data+"] ");
			PreOrder(node.left_Node);
			PreOrder(node.right_Node);
		}
	}
	//中序遍历
		public void InOrder(TreeNode node) {
			if(node!=null) {
				InOrder(node.left_Node);
				System.out.print(" ["+node.data+"] ");
				InOrder(node.right_Node);
			}
		}
	//后序遍历
		public void PostOrder(TreeNode node) {
			if(node!=null) {
				PostOrder(node.left_Node);
				PostOrder(node.right_Node);
				System.out.print(" ["+node.data+"] ");
			}
		}
		
}


/*
 * 可以计算表达式值得二叉树的建立
 */
class Expression_Tree extends BinaryTreeByLinkedList{
	public Expression_Tree (char[] information,int index) {
		//利用create将二叉树的数组表示法转换成链式表示法
		rootNode = create(information,index);
	}
	public TreeNode create(char[]sequence,int index) {
		TreeNode tempNode;
		if(index >= sequence.length)//作为递归调用的出口条件
			return null;
		else {//前缀表达式利用先序序列建树
			tempNode = new TreeNode((int)sequence[index]);
			//建立左子树
			tempNode.left_Node=create(sequence,2*index);
			//建立右子树
			tempNode.right_Node=create(sequence,2*index+1);
			return tempNode;
		}
	}
	//针对操作情况为字符的遍历
	//先序遍历
		public void PreOrder(TreeNode node) {
			if(node!=null) {
				System.out.print((char)node.data);
				PreOrder(node.left_Node);
				PreOrder(node.right_Node);
			}
		}
		//中序遍历
			public void InOrder(TreeNode node) {
				if(node!=null) {
					InOrder(node.left_Node);
					System.out.print((char)node.data);
					InOrder(node.right_Node);
				}
			}
		//后序遍历
			public void PostOrder(TreeNode node) {
				if(node!=null) {
					PostOrder(node.left_Node);
					PostOrder(node.right_Node);
					System.out.print((char)node.data);
				}
			}
//		判断表达式如何运算的方法的声明
		public int condition(char operator,int num1,int num2) {
			switch(operator) {
			case '*':return(num1*num2);//这里return自带中断不需break
			case '/':return(num1/num2);
			case '+':return(num1+num2);
			case '-':return(num1-num2);
			case '%':return(num1%num2);
			}
			return -1;
		}	
//		传入根节点，计算二叉树的值
		public int answer(TreeNode node) {
			int firstNumber=0;
			int secondNumber=0;
			//递归条件出口
			if(node.left_Node==null && node.right_Node==null)
				//将节点的值转换成数值后返回
				return Character.getNumericValue((char)node.data);
			else {
				firstNumber = answer(node.left_Node);//计算左子树
				secondNumber = answer(node.right_Node);//计算右子树
				return condition((char)node.data,firstNumber,secondNumber);
			}
		}
}
