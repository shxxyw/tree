package tree;
import java.io.*;
public class InitalizeBinaryTree  {
	public static void main(String[] args)throws IOException {
		int ArraySize =10;
		int data[]=new int[ArraySize];
		System.out.println("������"+ArraySize+"������");
		BufferedReader in =new BufferedReader(
				new InputStreamReader(System.in) );
		for(int i=0;i<ArraySize;i++) {
			System.out.println("�����"+(i+1)+"������");
			data[i]=Integer.parseInt(in.readLine());
		}
		BinaryTreeByLinkedList test=new BinaryTreeByLinkedList(data);
		
		System.out.println("�������");
		test.PreOrder(test.rootNode);
		System.out.println("\n �������");
		test.InOrder(test.rootNode);
		System.out.println("\n �������");
		test.PostOrder(test.rootNode);
	}
}
