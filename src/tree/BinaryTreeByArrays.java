package tree;
/*
 * 这里建立的二叉树遵守：小于父节点的值放在左结点，大于父节点的值放右节点
 * 这样能够确保左子树的值一定完全小于树跟，右子树的值一定大于树跟
 */
public class BinaryTreeByArrays {
	public static void main(String[] args) {
	int level,i;
	int data[]= {6,3,5,9,7,8,4,2};
	int tree[]=new int[16];
	//初始化tree
	for(i=0;i<16;i++) tree[i]=0;
	//初始化data
	System.out.println("原始数组为：");
	for(i=0;i<8;i++) System.out.print(" ["+data[i]+"] ");
		for(i=0;i<8;i++) {//对原来数组的值从第一个起做筛选
			for(level=1;tree[level]!=0;) {//比较树根和数组值
				if(data[i]<tree[level])//左子树
					level=2*level;
				else level=2*level+1;//右子树
			}
			tree[level]=data[i];
		}
		
		//输出二叉树
		System.out.println("\n 二叉树内容为：");
		for(i=1;i<16;i++) {
			System.out.print(" ["+tree[i]+"] ");
		}
	}
}
