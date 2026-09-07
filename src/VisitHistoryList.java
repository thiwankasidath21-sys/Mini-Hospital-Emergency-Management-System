public class VisitHistoryList {

    private class ListNode {
        String visitDetails;
        ListNode next;

        ListNode(String visitDetails) {
            this.visitDetails = visitDetails;
            this.next = null;
        }
    }

    private ListNode head;

    public VisitHistoryList() {
        head = null;
    }

    public void addVisit(String visitDetails) {
        ListNode newNode = new ListNode(visitDetails);

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayVisits() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.visitDetails);
            current = current.next;
        }
    }
}