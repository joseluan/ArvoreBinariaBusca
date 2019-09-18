package br.com.luan.model;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
    
    public Node getMaxValue(){
    	if(this.right != null) {    	
	    	Node direita = this.right;
	    	while(direita.getRight() != null) {
	    		direita = direita.getRight();
	    	}
	    	
	    	return direita;
    	}else {
    		Node esquerda = this.left;
	    	while(esquerda.getLeft() != null) {
	    		esquerda = esquerda.getRight();
	    	}
	    	
	    	return esquerda;
    	}
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }
    
    public Node searchFather(int key) {    
    	if(null != this.left && null != this.right) return null;
        
    	if(null != this.left) {
        	if (key == this.left.getValue()) {
        		return this;
        	}            
        }
        
        if (null != this.right) {
        	if(key == this.right.getValue()) {
                return this;
        	}
        }

        
	    if (key < this.value) {            	           
	        return this.left.searchFather(key);         
	    }if (key > this.value) {
            return this.right.searchFather(key);            
        }

        return null;
    }
}
