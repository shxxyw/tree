package tree;
import java.io.*;
public class InitalizeBinaryTree  {
	public static void main(String[] args)throws IOException {
		int ArraySize =10;
		int data[]=new int[ArraySize];
		System.out.println("请输入"+ArraySize+"个数据");
		BufferedReader in =new BufferedReader(
				new InputStreamReader(System.in) );
		for(int i=0;i<ArraySize;i++) {
			System.out.println("输入第"+(i+1)+"个数据");
			data[i]=Integer.parseInt(in.readLine());
		}
		BinaryTreeByLinkedList test=new BinaryTreeByLinkedList(data);
		
		System.out.println("先序遍历");
		test.PreOrder(test.rootNode);
		System.out.println("\n 中序遍历");
		test.InOrder(test.rootNode);
		System.out.println("\n 后序遍历");
		test.PostOrder(test.rootNode);
	}
}
