package HackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 13/03/2021, Saturday, 23:27
 */
public class LearningStack {

	static class Node{
		int data;
		int position;

		public Node(int data, int position) {
			this.data = data;
			this.position = position;
		}
	}

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Stack<Node> stack = new Stack<>();
		Stack<Node> maxStacks = new Stack<>();
		maxStacks.push(new Node(Integer.MIN_VALUE,0));
		int pos = 0;
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0){
			int query = scanner.nextInt();
			if(query == 1){
				int elementToPush = scanner.nextInt();
				Node node = new Node(elementToPush,pos);
				stack.push(node);

				if(elementToPush > maxStacks.peek().data){
					maxStacks.push(new Node(elementToPush,pos));
				}
				pos++;
			}else if(query == 2){
				pos--;
				Node lastMaxNode = maxStacks.peek();
				Node lastStackNode = stack.peek();
				if(lastMaxNode.data == lastStackNode.data && lastMaxNode.position == lastStackNode.position){
					maxStacks.pop();
				}
				stack.pop();
			}else {
				System.out.println(maxStacks.peek().data);
			}
		}
	}
}
