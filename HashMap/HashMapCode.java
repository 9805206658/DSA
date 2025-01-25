import java.util.*;

public class HashMapCode {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Number of key-value pairs
        private int N = 4; // Initial number of buckets
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) { // Use equals for value-based comparison
                    return i;
                }
            }
            return -1;
        }

        // Rehash function
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N = 2 * N; // Double the size
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // Transfer data from old buckets to new buckets
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                // Key exists, update the value
                buckets[bi].get(di).value = value;
            } else {
                // Key does not exist, add new node
                buckets[bi].add(new Node(key, value));
                n++;
            }

            // Rehash if load factor exceeds 2.0
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                return true;
            } else {
                // Key does not exist, add new node
                return false;
            }
        }

        public V get(K key)
        {   int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                // Key exists, update the value
                return buckets[bi].get(di).value;
            } else
           { return null;}
        }
        public V remove(K key)
        {
             int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                // Key exists, update the value
                V val= buckets[bi].remove(di).value;
                 n--;
                 return val;
            } 
           return null;
        }
        public ArrayList<K> keySet()
        {
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i<buckets.length; i++)
            {   LinkedList<Node> ll = buckets[i];
                for(Node node : ll)
                {keys.add(node.key); }
            }
            return keys;

        }
        public boolean isEmpty()
        {
            if(n == 0)
            {
             return true;
            }
            else return false;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("apple", 300);
        hm.put("dog", 200);
        hm.put("cat", 500);
        ArrayList<String> keys= hm.keySet();
        for(String key:keys)
        {
            System.out.println(hm.get(key));
        }

        // System.out.println(hm.get("cat")); // Output: true
        // System.out.println(hm.containsKey("banana")); // Output: false
    }
}
