import java.util.*;
import java.io.*;
import java.math.*;
public class Solution {

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            int p1 = Integer.parseInt(s[2]);
            int p2 = Integer.parseInt(s[3]);

            int[] parents = new int[E];
            // 루트노드가 아니면 어쨌든 누군가의 자식노드니까 전체 노드에서 자식 노드 다 빼버리면? 짜라잔??

            Set<Integer> allNodes = new HashSet<>();
            Set<Integer> childNodes = new HashSet<>();

            String[] nodes = br.readLine().split(" ");
            for (int i = 0; i < nodes.length; i++) {
                allNodes.add(Integer.parseInt(nodes[i]));
                if (i % 2 == 1) {
                    childNodes.add(Integer.parseInt(nodes[i]));
                }
            }

            int rootNum = 0;
            for (int i : allNodes) {
                if (!childNodes.contains(i)) {
                    rootNum = i;
                }
            }

            // 루트노드 뭔지 알았으니 자식부모 관계 만들어주기?
            Map<Integer, Node> childParent = new HashMap<>();
            for (int i = 0; i < V; i++) {
                childParent.put(i + 1, new Node(i + 1));

            } // 일단 노드 냅다 다 넣어

            for (int i = 0; i < E; i++) { // 부모자식관계 만들어주기
                Node parentNode = childParent.get(Integer.parseInt(nodes[2 * i]));
                Node childNode = childParent.get(Integer.parseInt(nodes[2 * i + 1]));

                childNode.parent = parentNode;

                if (parentNode.left == null) {
                    parentNode.left = childNode;
                } else {
                    parentNode.right = childNode;

                }
            } // 이러면 다 된거아닌가...?
            // 대충 간선? 연결 다 했다 치고

            // 가장 가까운 조상 찾기? p1, p2 를 받아오고,
            // p1,p2 부모를 타고 올라가다보면?
            // p1 부모 일단 다 넣어. -> p2 다 넣다가 처음으로 만나는 놈 -> 가장 가까운 조상님

            Set<Node> findJosang = new HashSet<>();
            Node nodeP1 = childParent.get(p1);
            while (nodeP1.parent != null) {
                findJosang.add(nodeP1.parent);

                nodeP1 = nodeP1.parent;
            } // 냅다 p1 조상까지 다 넣어버리기
            sb.append("#").append(tc).append(" ");
            boolean isFound = false;
            Node nodeP2 = childParent.get(p2);
            int josangNum = 0;
            a:
            while (nodeP2.parent != null) {
                if (findJosang.contains(nodeP2.parent)) {
                    // keySet 가져오고, contains(해당 키)
                    for (int n : childParent.keySet()) {
                        if (childParent.get(n) == nodeP2.parent) {
                            josangNum = n;
                            sb.append(josangNum).append(" ");
                            break a;
                        }
                    }
                }
                findJosang.add(nodeP2.parent);
                nodeP2 = nodeP2.parent;

            }

            // 이제 그 서브트리 크기만 찾으면...
            int count = 0;
            Node findSub = childParent.get(josangNum);
            // 어떻게?
            Stack<Node> subStack = new Stack<>();

            subStack.push(findSub);

            while(!subStack.isEmpty()) {
                Node temp = subStack.pop();
                count++;
                if(temp.left != null) {
                    subStack.push(temp.left);
                }
                if(temp.right != null) {
                    subStack.push(temp.right);
                }
            }

            sb.append(count);
            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}