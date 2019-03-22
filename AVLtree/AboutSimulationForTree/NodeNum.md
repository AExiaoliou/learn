<pre>
Binary Tree  
0  
1               2  
3       4       5       6  
...

0(root)
0*2+1           0*2+2
1*2+1   1*2+2   2*2+1   2*2+2
...

Three Fork Tree  
0  
1                       2                       3  
4       5       6       7       8       9       10      11      12  
...

0(root)
0*3+1                   0*3+2                   0*3+3
1*3+1   1*3+2   1*3+3   2*3+1   2*3+2   2*3+3   3*3+1   3*3+2   3*3+3
...

</pre>

and also  
<pre>
1(root)
1*2+0           1*2+1
2*2+0   2*2+1   3+2+0   3*2+1
...

</pre>

about preprocessor  
```cpp
#define _left *2+1
#define _right *2+2
#define _par /2
#define _parent /2 //just as you like
int node = 7;
tree[node _left] // replace to tree[node *2+1]
tree[node _par] // replace to tree[node /2]
#undef _left
#undef _right
#undef _par
#undef _parent
```
