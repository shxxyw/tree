package tree;
class ThreadNode{
	int value ;
	int left_Thread;
	int right_Thread;
	ThreadNode left_Node;
	ThreadNode right_Node;
	//构造函数 （线索为1，正常指针为0）
	public ThreadNode(int value) {
		this.value=value;
		this.left_Thread=0;
		this.right_Thread=0;
		this.left_Node=null;
		this.right_Node=null;
	}
}
public class Threaded_Binary_Tree {
	public ThreadNode rootNode;
	public ThreadNode headNode;
	ThreadNode pre;
	int Thread=1;
	int Link=0;
	//无参构造方法
	public Threaded_Binary_Tree() {
	}
//	构造参数：建立线索二叉树，传入参数为一个数组
//	数组中的第一个数据用来建立线索二叉树的根节点
	public Threaded_Binary_Tree(int data[]) {
		for(int i=0;i<data.length;i++)
			Add_Node_To_Tree(data[i]);
		InOrderThreading();
	}
//  将指定的值输入二叉树中
	public void Add_Node_To_Tree(int value) {
		ThreadNode current=rootNode;
		if(rootNode==null) {
			rootNode=new ThreadNode(value);
			return;
		}
		while(true) {
			if(value<=current.value) {
				if(current.left_Node==null) {
					current.left_Node=new ThreadNode(value);
					return;
				}else {
					current=current.left_Node;
				}
			}else {
				if(current.right_Node==null) {
					current.right_Node=new ThreadNode(value);
					return;
				}else {
					current=current.right_Node;
				}
			}
		}
	}
	
//	将二叉树建立线索化形成线索二叉树(中序遍历)
	void InOrderThreading() {
		//建立头节点
		headNode =new ThreadNode(-1);
		headNode.left_Thread=Link;
		headNode.right_Thread=Thread;
		headNode.right_Node=headNode;//右指针回指
		if(rootNode==null) {//若二叉树为空，左指针回指
			headNode.left_Node=headNode;
		}else {//令头节点为pre，从根节点开始建立
			headNode.left_Node=rootNode;
			pre=headNode;
			InThreading(rootNode);
		//建立最后一个节点
			pre.right_Node=headNode;
			pre.right_Thread=Thread;
			headNode.right_Node=pre;
		}
	}
	//中序遍历进行中序线索化 （找到对应节点左右节点，判断是否为左指针空 即下一个节点位置
	//是，则进行线索化操作：当前节点线索）
	void InThreading(ThreadNode temp) {
		if(temp!=null) {
			InThreading(temp.left_Node);
			if(temp.left_Node==null) {//必须判断是否为空，为空在中序中即为下一个节点
				temp.left_Node=pre;
				temp.left_Thread=Thread;
			}
			if(pre.right_Node==null) {//前驱有指针为空则为线索，需将其指向当前节点
				pre.right_Node=temp;
				pre.right_Thread=Thread;
			}
			pre=temp;
			InThreading(temp.right_Node);
		}
	}
	
//	遍历线索二叉树
	/*要点：
	 * 1.如何找到第一个节点：从根节点开始找到左子树为线索的第一个节点
	 * 2.如何找到一个后继节点：在当前接节点右标值，若为标记，则通过标记找后继
	 *   若为指针，则以该节点右指针所指为树找到左子树为线索的第一节点
	 */
	void InOderTraverse() {
		ThreadNode current=headNode.left_Node;
		while(current!=headNode) {//为空树或遍历结束时候相等，从而结束
			while(current.left_Thread==Link)//第一个只能用遍历寻找
				current=current.left_Node;
			System.out.println(current.value);//输出对应值
			while(current.right_Thread==Thread && 
					current.right_Node!=headNode) {
				current=current.right_Node;
				System.out.println(current.value);
			}
			current=current.right_Node;
		}
	}
}
