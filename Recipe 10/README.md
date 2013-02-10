####EhCache Effective Caching: How-To
##Recipe 10 (EhCache Transactional Support)

In this recipe you will be shown how EhCache transactional support is configured and deployed in local mode. This is a Spring-based application that embeds Jetty container, Spring AOP, and JDBC - HSQLDB.

This is a simple payroll program that shows how failed payroll transactions are rolled back so that the cached balance is equals to that in database. Worth mentioning that local transactions apply directly in Cache layer, therefore resources (database) can get out of synchronization so we need to react to that event.        

** Note: We are using local transactional mode because we have no JTA implementation. If your application supports full JTA API please consider extended architecure options (xa or xa_strict). Examples can be found here:
[http://ehcache.org/documentation/apis/transactions#Sample-Apps](http://ehcache.org/documentation/apis/transactions#Sample-Apps) 

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)

