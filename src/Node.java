public class Node {

    Patient patient;
    Node left;
    Node right;

    public Node(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}