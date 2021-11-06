# Memory Manager

***

#### You are given a task to design a memory manager for a new multitasking OS to support the following features:
* A process may **request N blocks** of memory. Fail if unavailable. The allocation of memory for an existing variable within a process is not allowed.
* A process may **free** previously allocated blocks of memory at any point in its lifetime
* A process may not request more than a fraction of the total memory: 25% of total
* A process can be **killed** also. This will result in freeing up all the memory allocated to the process. Killing an already killed process will print “error memory_allocated/free_memory”
* A process can be **inspected** also. This command will print all the underlying variables and the amount of space occupied by each.
* The memory allocation is not contiguous. If the requested amount of memory is available, the allocation will succeed.

<br>

Input Format:
```
<total-block-count>  
<command-1> <process> <args>
:
<command-N> <process> <args>
```

Output Format:  
```
<command-result> <allocated-space-block-count> / <free-space-block-count>
```

<br>

The available commands & their formats are described below:  
```html
- allocate: allocate <process> <variable> <blocks-requested>
- free: free <process> <variable>
- kill: kill <process>
- inspect: inspect <process>
- status: gives you the whole view of mem
```

<br>

Example
```
100
allocate P1 var_x 1000 
error 0 / 100
allocate P1 var_x 10 
success 10 / 90
allocate P2 var_y 25
success 35 / 65
free P1 var_x
success 25 / 75
kill P2
success 0 / 100
allocate P1 var_z 10
success 10 / 90
kill P2
error 10 / 90
```