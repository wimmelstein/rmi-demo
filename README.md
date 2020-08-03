# RMI Demo

This repository is part of a tutorial on RMI, Remote Method Invocation.

This demo involves the following techniques:
* Spring Boot
* Docker

The project can be started on Mac/Linux from the root of the project in the following way:

```docker stack deploy -c ./compose.yml rmi-demo```

Or on Windows:

```docker stack deploy -c .\compose.yml rmi-demo```

Call the RMI server with:

```http://localhost/iseven/10```

Call the RMI client with:

```http://localhost/iseven/10```

> TODO:
> * Restrict networking between containers
> * Allow only two ports from client to server: 
>
>   1199: Registry, 
>   7001: Fixed port for service
> 
> * Implement fixed service port on server

If you have questions, or suggestions, please create an issue with this repository, and I will see if I can address them.

