from heapq import heappush, heappop
import sys

maxHeap = []
minHeap = []

n = int(sys.stdin.readline())
res = []
res.append(int(sys.stdin.readline()))
heappush(maxHeap, -res[0])
for _ in range(n-1):
    k = int(sys.stdin.readline())
    if k <= -maxHeap[0] :
        heappush(maxHeap,-k)
    else :
        heappush(minHeap,k)

    if len(maxHeap) < len(minHeap):
        heappush(maxHeap, -heappop(minHeap))
    elif len(maxHeap) > len(minHeap)+1:
        heappush(minHeap, -heappop(maxHeap))

    res.append(-maxHeap[0])
for s in res:
    print(s)