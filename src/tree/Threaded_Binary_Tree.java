package tree;
class ThreadNode{
	int value ;
	int left_Thread;
	int right_Thread;
	ThreadNode left_Node;
	ThreadNode right_Node;
	//���캯�� ������Ϊ1������ָ��Ϊ0��
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
	//�޲ι��췽��
	public Threaded_Binary_Tree() {
	}
//	��������������������������������Ϊһ������
//	�����еĵ�һ�������������������������ĸ��ڵ�
	public Threaded_Binary_Tree(int data[]) {
		for(int i=0;i<data.length;i++)
			Add_Node_To_Tree(data[i]);
		InOrderThreading();
	}
//  ��ָ����ֵ�����������
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
	
//	�������������������γ�����������(�������)
	void InOrderThreading() {
		//����ͷ�ڵ�
		headNode =new ThreadNode(-1);
		headNode.left_Thread=Link;
		headNode.right_Thread=Thread;
		headNode.right_Node=headNode;//��ָ���ָ
		if(rootNode==null) {//��������Ϊ�գ���ָ���ָ
			headNode.left_Node=headNode;
		}else {//��ͷ�ڵ�Ϊpre���Ӹ��ڵ㿪ʼ����
			headNode.left_Node=rootNode;
			pre=headNode;
			InThreading(rootNode);
		//�������һ���ڵ�
			pre.right_Node=headNode;
			pre.right_Thread=Thread;
			headNode.right_Node=pre;
		}
	}
	//��������������������� ���ҵ���Ӧ�ڵ����ҽڵ㣬�ж��Ƿ�Ϊ��ָ��� ����һ���ڵ�λ��
	//�ǣ��������������������ǰ�ڵ�������
	void InThreading(ThreadNode temp) {
		if(temp!=null) {
			InThreading(temp.left_Node);
			if(temp.left_Node==null) {//�����ж��Ƿ�Ϊ�գ�Ϊ���������м�Ϊ��һ���ڵ�
				temp.left_Node=pre;
				temp.left_Thread=Thread;
			}
			if(pre.right_Node==null) {//ǰ����ָ��Ϊ����Ϊ�������轫��ָ��ǰ�ڵ�
				pre.right_Node=temp;
				pre.right_Thread=Thread;
			}
			pre=temp;
			InThreading(temp.right_Node);
		}
	}
	
//	��������������
	/*Ҫ�㣺
	 * 1.����ҵ���һ���ڵ㣺�Ӹ��ڵ㿪ʼ�ҵ�������Ϊ�����ĵ�һ���ڵ�
	 * 2.����ҵ�һ����̽ڵ㣺�ڵ�ǰ�ӽڵ��ұ�ֵ����Ϊ��ǣ���ͨ������Һ��
	 *   ��Ϊָ�룬���Ըýڵ���ָ����ָΪ���ҵ�������Ϊ�����ĵ�һ�ڵ�
	 */
	void InOderTraverse() {
		ThreadNode current=headNode.left_Node;
		while(current!=headNode) {//Ϊ�������������ʱ����ȣ��Ӷ�����
			while(current.left_Thread==Link)//��һ��ֻ���ñ���Ѱ��
				current=current.left_Node;
			System.out.println(current.value);//�����Ӧֵ
			while(current.right_Thread==Thread && 
					current.right_Node!=headNode) {
				current=current.right_Node;
				System.out.println(current.value);
			}
			current=current.right_Node;
		}
	}
}
