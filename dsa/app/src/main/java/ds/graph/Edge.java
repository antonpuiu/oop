package ds.graph;

import ds.graph.list.ListNode;

public class Edge<DataType, IndexType> {
        private ListNode<DataType, IndexType> src;
        private ListNode<DataType, IndexType> dst;
        private Double weight;

        public Edge(ListNode<DataType, IndexType> src, ListNode<DataType, IndexType> dst) {
            this.src = src;
            this.dst = dst;
        }

        public Edge(ListNode<DataType, IndexType> src, ListNode<DataType, IndexType> dst, Double weight) {
            this(src, dst);
            this.weight = weight;
        }

        public ListNode<DataType, IndexType> getSrc() {
            return src;
        }

        public ListNode<DataType, IndexType> getDst() {
            return dst;
        }

        public double getWeight() {
            return weight;
        }
    }
