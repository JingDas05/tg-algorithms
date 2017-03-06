package top.treegrowth.algorithms.tree;

/**
 * @author wusi
 * @version 2017/3/3 10:51
 */

import java.util.*;

import net.sf.json.JSONArray;

public class TreeBuilder {

    List<TreeBuilder.Node> nodes = new ArrayList<TreeBuilder.Node>();

    public TreeBuilder(List<Node> nodes) {
        super();
        this.nodes = nodes;
    }

    /**
     * 构建JSON树形结构
     *
     * @return
     */
    public String buildJSONTree() {
        List<Node> nodeTree = buildTree();
        JSONArray jsonArray = JSONArray.fromObject(nodeTree);
        return jsonArray.toString();
    }

    /**
     * 构建树形结构
     *
     * @return
     */
    public List<Node> buildTree() {
        List<Node> treeNodes = new ArrayList<Node>();
        List<Node> rootNodes = getRootNodes();
        for (Node rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    /**
     * 递归子节点，这个方法很重要，大体思路就是
     * 先找出所有的根节点，之后找到每个根节点的childList,调用node setMenus方法
     *这样只能找到根节点和根节点的直接childList，为了能遍历整个树状结构，需要
     * 递归调用自己，递推结束的条件就是自己没有child了
     * @param node
     */
    public void buildChildNodes(Node node) {
        List<Node> children = getChildNodes(node);
        //判断是否是最后的节点
        if (!children.isEmpty()) {
            //递归执行本方法
            for (Node child : children) {
                buildChildNodes(child);
            }
            node.setMenus(children);
        }
    }

    /**
     * 获取父节点下所有的子节点
     *
     //* @param nodes
     * @param pnode
     * @return
     */
    public List<Node> getChildNodes(Node pnode) {
        List<Node> childNodes = new ArrayList<Node>();
        for (Node n : nodes) {
            if (pnode.getId().equals(n.getPid())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    /**
     * 判断是否为根节点，遍历所有元素，寻找node的pid是否在id中存在
     *
     //* @param nodes
     //* @param inNode
     * @return
     */
    public boolean rootNode(Node node) {
        boolean isRootNode = true;
        for (Node n : nodes) {
            if (node.getPid().equals(n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    /**
     * 获取集合中所有的根节点
     *
     //* @param nodes
     * @return
     */
    public List<Node> getRootNodes() {
        List<Node> rootNodes = new ArrayList<Node>();
        for (Node n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }

    public static class Node {

        private String id;
        private String pid;
        private String text;
        private String url;
        private List<Node> menus;

        public Node() {
        }

        public Node(String id, String pid, String text, String url) {
            super();
            this.id = id;
            this.pid = pid;
            this.text = text;
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Node> getMenus() {
            return menus;
        }

        public void setMenus(List<Node> menus) {
            this.menus = menus;
        }
    }

    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<Node>();
        Node p1 = new Node("01", "", "01", "");
        Node p6 = new Node("02", "", "02", "");
        Node p7 = new Node("0201", "02", "0201", "");
        Node p2 = new Node("0101", "01", "0101", "");
        Node p3 = new Node("0102", "01", "0102", "");
        Node p4 = new Node("010101", "0101", "010101", "");
        Node p5 = new Node("010102", "0101", "010102", "");

        nodes.add(p1);
        nodes.add(p2);
        nodes.add(p3);
        nodes.add(p4);
        nodes.add(p5);
        nodes.add(p6);
        nodes.add(p7);

        TreeBuilder treeBuilder = new TreeBuilder(nodes);
        System.out.println(treeBuilder.buildJSONTree());
        System.out.println("11");
    }
}
