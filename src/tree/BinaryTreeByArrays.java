package tree;
/*
 * ���ｨ���Ķ��������أ�С�ڸ��ڵ��ֵ�������㣬���ڸ��ڵ��ֵ���ҽڵ�
 * �����ܹ�ȷ����������ֵһ����ȫС����������������ֵһ����������
 */
public class BinaryTreeByArrays {
	public static void main(String[] args) {
	int level,i;
	int data[]= {6,3,5,9,7,8,4,2};
	int tree[]=new int[16];
	//��ʼ��tree
	for(i=0;i<16;i++) tree[i]=0;
	//��ʼ��data
	System.out.println("ԭʼ����Ϊ��");
	for(i=0;i<8;i++) System.out.print(" ["+data[i]+"] ");
		for(i=0;i<8;i++) {//��ԭ�������ֵ�ӵ�һ������ɸѡ
			for(level=1;tree[level]!=0;) {//�Ƚ�����������ֵ
				if(data[i]<tree[level])//������
					level=2*level;
				else level=2*level+1;//������
			}
			tree[level]=data[i];
		}
		
		//���������
		System.out.println("\n ����������Ϊ��");
		for(i=1;i<16;i++) {
			System.out.print(" ["+tree[i]+"] ");
		}
	}
}
