####EhCache Effective Caching: How-To
##Recipe 12 (Datasource Read Overload)

In this recipe you will be shown how to configure and apply a simple solution to the "thundering herd" problem. This problem becomes evident when multiple concurrent clients are requesting the same cached data element. Some of those clients will then read an empty cached value therefore ask directly to the datasource about it. This causes unnecesary queries.

In out simple scenario, we will simulate high concurrency in a single JVM that will read a single cached value. We will then compare access results enabling/disabling our solution.

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)
