####EhCache Effective Caching: How-To
##Recipe 4 (Web Fragment Caching)

In this recipe you will be shown how web fragment caching works and how EhCache make this task very simple to implement in your own web project. EhCache web component provides built-in helpers that can be reused in any typical web application. 

In our case, we will create our own custom filters based on the EhCache built-in caching filters with extended criteria. The purpose of these is to show how customizable fragment caching is. This filter will then be integrated in Struts 2 framework application.    

###Instructions
1. Import as maven project.
2. Run -> Run configurations -> new Maven Build
3. Base Directory:${workspace_loc:/recipe4} | Goals: clean jetty:run


#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)