import java.util.Stack;

public class Tree {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public static void preOrder(TreeNode root){ // 前序递归遍历
		if(root != null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
			}
		
	}
	public static void InOrder(TreeNode root){ // 中序递归遍历
		if(root != null){
			InOrder(root.left);
			System.out.print(root.val + " ");
			InOrder(root.right);
			}
		
	}
	public static void LastOrder(TreeNode root){ // 后序递归遍历
		if(root != null){
			LastOrder(root.left);
			LastOrder(root.right);
			System.out.print(root.val + " ");
			}
		
	}
	
	
	public static void preOrder_No_recursive(TreeNode root){//中左右
		Stack<TreeNode> stack = new Stack<TreeNode>();  
		TreeNode p = root;
		if(p!=null){
			stack.push(p);
			while(!stack.isEmpty()){
				p = stack.pop();
				System.out.print(p.val+" ");
				if(p.right!=null){
					stack.push(p.right);
				}
				if(p.left!=null){
					stack.push(p.left);
				}
			}
			
		}
	}
	private static void InOrder_No_recursive(TreeNode root) { //左中右
		// TODO Auto-generated method stub
		Stack<TreeNode> stack = new Stack<TreeNode>();  
		TreeNode p = root;
		while(p!=null || !stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p=p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				System.out.print(p.val+" ");
				p = p.right;
			}
		}
       
	}
	private static void LastOrder_No_recursive(TreeNode root) {
		// TODO Auto-generated method stub
		Stack<TreeNode> stack=new Stack<TreeNode>();  
        TreeNode p = root;  
        while(p!=null){
        	while(p.left!=null){
        		stack.push(p);
        	}
        	while(p!=null &&(p.right == null||p.right == root)){//右子树不需要处理（为空或者已经处理过）
        		System.out.print(p.val +' ');
        		root = p;
        		if(stack.isEmpty()){
        			return;
        		}
        		p = stack.pop();
        	}
        	//处理右子树
        	stack.push(p);
        	p=p.right;
        }
		
	}
	
	
	
	public static TreeNode TreeForTest1(){
		//       0
		//    1     2
		//  3      4
		//5   6
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		return root;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode test1 = TreeForTest1();
		System.out.println("前序遍历");
		preOrder(test1);
		System.out.println("-以下为非递归-");
		preOrder_No_recursive(test1);
		System.out.println("");
		System.out.println("中序遍历");
		InOrder(test1);
		System.out.println("-以下为非递归-");
		InOrder_No_recursive(test1);
		System.out.println("");
		System.out.println("后序遍历");
		LastOrder(test1);
		System.out.println("-以下为非递归-");
		LastOrder_No_recursive(test1);
	}
	

}
