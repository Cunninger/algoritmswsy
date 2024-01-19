package leetcode_daily;

import java.util.HashMap;

public class LFUCache {

    public static class Node{
        public int key;
        public int value;

        public int times;
        public Node up;
        public Node down;

        public Node(int key,int value,int times){
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    // 桶结构

    public static class NodeList {
        public Node head;
        public Node tail;
        public NodeList last;
        public NodeList next;

        public NodeList(Node node){
            head = node;
            tail = node;
        }

        //
        public void addNodeFromHead(Node newHead){
            newHead.down = head;
            head.up = newHead;
            head = newHead;
        }// 头插法



        // 判断这个桶是否为空，便于删除桶
        public boolean isEmpty(){
            return head == null;
        }

        // 删除node节点，并保证node的上下环境重新连接
        public void deleteNode(Node node){
            if (head == tail){
                head = null;
                tail = null;
            }// 只有一个节点
            else {
            // 有多个节点
                // 删除头节点
                if (node == head){
                    head = node.down;
                    head.up = null;
                }
                // 删除尾节点
                else if (node == tail){
                    tail = node.up;
                    tail.down = null;
                }
                // 删除中间节点
                else {
                    node.up.down = node.down;
                    node.down.up = node.up;
                }
            }
            node.up = null;// 断开node的上下环境
            node.down = null;// node 为删除节点

        }

    }

    public static class LFU{
        private int capacity;
        private int size;// 缓存目前有多少个节点
        private HashMap<Integer,Node> records;// 表示key由哪个节点代表
        private HashMap<Node,NodeList> heads;// 表示Node 在哪个桶里
        private NodeList headList; // 整个结构中最左的桶
        // 为什么不用记录最右边的桶？因为最右边的桶是最近使用的桶，不会被删除


        public LFU(int K){
            this.capacity = K;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        // removeNodeList: 刚刚减少了一个节点的桶

        // 功能是： 判断 刚刚减少了一个 节点的桶 是不是 已经空了。
        // 1.如果不为空，什么都不做


        // 2.如果空了，removeNodeList 还是 整个缓存中最左的桶
        // 删除 这个桶的 同时也要让 最左的桶变成 removeNodeList 的下一个桶
        //
        // 如果空了，removeNodeList 不是 整个缓存中最左的桶
        // 把这个桶删除，并保证上一个桶 和下一个桶之间还是 双向链表—><- 的连接方式
        //

        public boolean modifyHeadList(NodeList removeNodeList){
        // 函数的返回值 表示 刚刚 减少 了一个节点 的桶 是不是空了。空了返回true,不空返回false

            if (removeNodeList.isEmpty()){
                // 如果空了，removeNodeList 还是 整个缓存中最左的桶
                if (headList == removeNodeList){
                    // headList 是缓存中最左的桶
                    headList = removeNodeList.next;
                    if (headList != null){
                        headList.last = null;// headList 不是最左的桶了，所以last = null
                    }
                }else{// 如果空了，removeNodeList 不是 整个缓存中最左的桶
                    removeNodeList.last.next = removeNodeList.next;
                    // removeNodeList 的上一个桶的next 指向 removeNodeList 的下一个桶
                    if (removeNodeList.next!=null){
                        removeNodeList.next.last = removeNodeList.last;
                        // removeNodeList 的下一个桶的last 指向 removeNodeList 的上一个桶
                        // 为什么要判空？ 因为 removeNodeList 可能是最右的桶，最右的桶没有next
                    }
                }
                return true;
            }
            return false;
        }




        // 函数：node 这个节点的使用次数+1, 且这个节点原来在 oldNodeList 桶里，
        // 把 node 从oldNodeList 桶里删除，然后把 node 放到 次数+1 的桶里
        // 整个过程既要保证 桶之间是双向 链表 ，也要保证 节点之间是双向 链表
        private  void move(Node node,NodeList oldNodeList) {

            oldNodeList.deleteNode(node);

            // preList 表示次数 +1的桶 的前一个 桶是谁
            // 如果oldNodeList 删掉node 之后还有节点，oldNodeList就是次数+1的前一个桶
            // 如果oldNodeList 删掉node 之后空了，oldNodeList是需要删除的，所以次数+1的桶
            // 前一个桶，是oldNodeList的前一个桶


            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
            // 如果oldNodeList 删掉node 之后还有节点，oldNodeList就是次数+1的前一个桶
            // modifyHeadList 表示删除的节点减少了一个节点的桶 是不是空了
            // preList可能为空吗？

            NodeList nextList = oldNodeList.next;
            // nextList 表示次数 +1的桶 的后一个 桶是谁
            if (nextList == null) {
                NodeList newList = new NodeList(node);
                if (preList != null) {
                    // 这里为什么需要判空？因为 preList 可能是最右的桶，最右的桶没有next
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
                // heads是啥？表示Node 在哪个桶里
            } else {// 如果 nextList != null
                if (nextList.head.times==node.times) {
                    // 如果次数+1的桶已经存在,把节点头插放入
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {// 如果次数+1的桶不存在，创次数+1的桶
                    NodeList newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }// 如果nextList是最左的桶，那么newList就是最左的桶

                    heads.put(node, newList);

                }
            }
        }


        public void put(int key,int value) {
            if (capacity==0)return;
            if (records.containsKey(key)){
                Node node = records.get(key);

                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node);// 根据node 找到它所在的桶
                move(node,curNodeList);

            }else{
                if (size == capacity){
                    Node node = headList.tail;// 最左的桶的尾节点
                    headList.deleteNode(node);
                    modifyHeadList(headList);// 对删除了节点的桶进行判断，是不是空了
                    records.remove(node.key); // 删除了节点，就要删除它在records节点里的记录
                    heads.remove(node);//  删除了节点，就要删除它在heads桶里的记录
                    size--;
                    // key->node->桶
                    //


                }
                Node node = new Node(key,value,1);
                // 新节点的使用次数是1

                if (headList == null){
                    headList = new NodeList(node);
            }//  如果headList为空，就创建一个新的桶
                else{
                    // headList 不为空，就把新节点头插到headList桶里

                    if (headList.head.times==node.times){
                        // 次数相同放入同一个桶

                        headList.addNodeFromHead(node);
                    }
                    else{
                        NodeList newList = new NodeList(node);
                        // 没有次数为1的桶，就创建一个次数为1的桶，连接以前的headList
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;// 更新headList
                    }
                }

                records.put(key,node);// 新节点放入records
                heads.put(node,headList);// 新节点放入heads
                size++;
        }
    }
        public int get(int key){
            if (!records.containsKey(key)){
                return 0;
            }
            Node node = records.get(key);// 根据key 找到node
            node.times++;
            NodeList curNodeList = heads.get(node);// node->桶
            move(node,curNodeList);// 把node 从curNodeList桶里删除，然后把node放到次数+1的桶里
            return node.value;
        }



    }

    public static void main(String[] args) {
        LFU lfu = new LFU(2);
        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }



}