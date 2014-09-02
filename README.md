AspectJ Time Logger
=====

Example code for running time logging with AspectJ and Spring.  
The configuration of the application is entirely in Java - no XML files.

No bytecode weaving is used - Spring uses proxies instead. 

Note: The configuration class that enables the AspectJ Auto Proxy should  
be registered in the 'getServletConfigClasses' method in the AppInit.
