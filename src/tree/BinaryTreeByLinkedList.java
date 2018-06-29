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
