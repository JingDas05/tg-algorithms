package top.treegrowth.trie;

import java.util.HashMap;

/**
 * @author wusi
 * @version 2017/10/20 11:00
 */
public class Trie {

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        //该字串的重复数目,频数
        int frequency;
        //以该子串为前缀的单词数
        int prefix_num;
        //可以没有，数组下标可以知道val值
        char val;
        // 当前字符串的值是否存在，true为截止到当前数组的字符串存在，false为别的字符串中的一段
        boolean isLeaf;
        public TrieNode(char val) {
            this.val = val;
            isLeaf = false;
        }
    }
    private TrieNode root;
    public Trie(){
        // 第一个节点为空字符串,trie的结构定义
        root = new TrieNode(' ');
    }
    //插入一个单词，一直查找，没有就插入，有了就置为root节点
    public void insert(String word) {
        TrieNode cur = root;
        char[] data = word.toLowerCase().toCharArray();
        // 遍历词的数组
        for(int i=0;i<data.length;i++) {
            // 获取字符的相对于‘a’的偏移值，即数组中要存储的字母顺序
            int index = data[i] - 'a';
            // 如果为null就新增
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(data[i]);
            }
            // 如果树中已经有相对应的字符，此时root节点为 cur.children[index]所在节点
            cur = cur.children[index];
            // 以该子串为前缀的单词数 自增
            cur.prefix_num++;
        }
        cur.isLeaf = true;
        cur.frequency++;
    }

    //寻找是否存在某个单词，从根节点开始寻找
    public boolean search(String word) {
        TrieNode cur = root;
        // 要搜索的词
        char[] data = word.toLowerCase().toCharArray();
        for(int i=0;i<data.length;i++) {
            int index = data[i] - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isLeaf;
    }
    //查找是否有以某个字符串为开头的单词
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] data = prefix.toLowerCase().toCharArray();
        for(int i=0;i<data.length;i++) {
            int index = data[i] - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    /*
    * 得到所有单词及出现次数
    * */
    public HashMap<String, Integer> getAllwords() {
        return helper(root, "");
    }
    private HashMap<String, Integer> helper(TrieNode cur, String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (cur != null) {
            if (cur.isLeaf == true) {
                hashMap.put(s, cur.frequency);
            }
        }
        for (int i = 0; i < cur.children.length; i++) {
            if(cur.children[i]!=null) {
                String tmp = s + (char)(i + 'a');
                hashMap.putAll(helper(cur.children[i], tmp));
            }
        }
        return hashMap;
    }
    /*
    * 得到以某字串为前缀的字串集，包括字串本身！
    * */
    public HashMap<String, Integer> getWordsForPrefix(String prefix) {
        return getWordsForPrefix(root, prefix);
    }
    private HashMap<String,Integer> getWordsForPrefix(TrieNode cur, String prefix) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        char[] data = prefix.toLowerCase().toCharArray();
        for(int i=0;i<data.length;i++) {
            if (cur.children[data[i] - 'a'] == null) {
                return hashMap;
            }
            cur = cur.children[data[i] - 'a'];
        }
        return helper(cur, prefix);
    }
}
