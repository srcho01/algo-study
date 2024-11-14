import sys

input = sys.stdin.readline

def postorder(in_start, in_end, pre_root):
    if in_start < in_end:
        node = preorder[pre_root]
        
        postorder(in_start, inorder_idx[node], pre_root+1)
        postorder(inorder_idx[node]+1, in_end, pre_root + inorder_idx[node] - in_start + 1)
        
        print(node, end=" ")

t = int(input())
for _ in range(t):
    n = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))
    
    inorder_idx = {}
    for i, node in enumerate(inorder):
        inorder_idx[node] = i  
    
    postorder(0, n, 0)
    print()