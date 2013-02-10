####EhCache Effective Caching: How-To
##Recipe 5 (Hibernate Second-Level Caching)
---
In this recipe you will be shown how to integrate EhCache in a Hibernate application as a Second Level Caching solution. Second-level caching is that one associated to the Sesion Factory Object. This simply means that caching can be shared accross multiple sessions instead of a per-session basis (First-level caching).

In our simple application, we will use Hibernate with embedded HSQLDB. We will exemplify how to configure EhCache as well as Hibernate to bind them together. Simplicity is used for academic purposes. Nevertheless, the same approach should be followed for complex enterprise applications.        

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)