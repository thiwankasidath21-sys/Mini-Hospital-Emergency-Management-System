public class TreatmentHistoryStack {

    private class StackNode {
        String treatment;
        StackNode next;

        StackNode(String treatment) {
            this.treatment = treatment;
            this.next = null;
        }
    }

    private StackNode top;

    public TreatmentHistoryStack() {
        top = null;
    }

    public void push(String treatment) {
        StackNode newNode = new StackNode(treatment);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }

        String treatment = top.treatment;
        top = top.next;
        return treatment;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayHistory() {
        StackNode current = top;
        while (current != null) {
            System.out.println(current.treatment);
            current = current.next;
        }
    }
}