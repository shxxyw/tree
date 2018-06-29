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
