package com.dsa.trees;
public class NodePair{
	
	Node node;
	int value;
	
	public NodePair(Node node, int value) {
		
		this.node = node;
		this.value = value;
	}

	@Override
	public String toString() {
		return "NodePair [node=" + node + ", value=" + value + "]";
	}
	
}