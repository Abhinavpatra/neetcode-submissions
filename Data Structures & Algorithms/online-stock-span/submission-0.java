// o(n)
class StockSpanner {
    public Node head;
    public Node tail;

    public StockSpanner() {
        
    }

    public int next(int price) {
        Node np = new Node(price);

        if (head == null) {
            head = np;
            tail = np;
            np.span = 1;
            return 1;
        }
        // handling return and value for initial
        tail.next = np;
        np.prev = tail;
        tail = np;

        int span = 1;
        Node curr = np.prev;
// calculating span for all values.
        while (curr != null && curr.value <= price) {
            span += curr.span;
            curr = curr.jump;
        }
        // accumulated span val.
        np.span = span;
        np.jump = curr;

        return span;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        int span;
        Node jump;

        public Node(int val) {
            this.value = val;
            this.next = null;
            this.prev = null;
            this.jump = null;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */