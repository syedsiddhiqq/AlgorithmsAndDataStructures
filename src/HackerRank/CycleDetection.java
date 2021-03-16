package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 06:48
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */
public class CycleDetection extends TemplateClass {
	static boolean hasCycle(SinglyLinkedListNode head){
		boolean cycleDetected = false;
		SinglyLinkedListNode turtle = head,hare = head;
		while(turtle.next != null && hare.next!= null && hare.next.next != null){
			turtle = turtle.next;
			hare = hare.next.next;
			if(turtle == hare){
				return true;
			}
		}
		return cycleDetected;
	}
}
