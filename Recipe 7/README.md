####EhCache Effective Caching: How-To
##Recipe 7 (Custom Eviction Algorithm)

In this recipe you will be shown how to create and implement an EhCache custom eviction algorithm. Eviction algorithms are used to determine when to evict (or simply "eject") an element from the Cache Layer. There are built-in algorithms already in EhCache that you can certainly reuse, namely:

- LRU (Least Recently Used, this is the default)
- LFU (Least Frequently Used)
- FIFO (First In First Out)

However, you can create your custom eviction policy by inheriting simple EhCache Abstraction classes. In our case, we will be creating our own policy for evicting elements.

###Instructions
1. Import as maven project
2. Run -> Run Configurations -> new Maven Build
3. Base Directory:${workspace_loc:/recipe7} | clean exec:java

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)