public class PatientBST {

    Node root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient patient) {
        root = insertHelper(root, patient);
    }

    private Node insertHelper(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertHelper(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertHelper(current.right, patient);
        }

        return current;
    }

    public Patient search(int patientId) {
        return searchHelper(root, patientId);
    }

    private Patient searchHelper(Node current, int patientId) {
        if (current == null) {
            return null;
        }
        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        } else if (patientId < current.patient.getPatientId()) {
            return searchHelper(current.left, patientId);
        } else {
            return searchHelper(current.right, patientId);
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node current) {
        if (current != null) {
            inOrderHelper(current.left);
            System.out.println(current.patient);
            inOrderHelper(current.right);
        }
    }
}