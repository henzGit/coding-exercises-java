package com.leet_code.data_structure;
import java.util.*;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used
 * to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted
 * string word that has the prefix prefix, and false otherwise.
 */
class Trie {
    static class Node {
        char value;
        Map<Character, Node> children;
        boolean endOfWord;

        public Node(char value) {
            this.value = value;
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node(c));
            }
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) return false;
            current = current.children.get(c);
        }
        return current.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c: prefix.toCharArray()) {
            if (!current.children.containsKey(c)) return false;
            current = current.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
