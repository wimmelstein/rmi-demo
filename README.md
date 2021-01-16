# RMI Demo

This repository is part of a tutorial on RMI, Remote Method Invocation.

This demo involves the following techniques:
* Spring Boot
* Docker

In order to start the project:

Go to the root of the project execute:

```docker stack deploy -c ./compose.yml rmi```

Verify that your stack is running:

```docker service ls```

The result should be two services running:

```
ID             NAME             MODE         REPLICAS   IMAGE                         PORTS
sb7gfpj4h0u7   rmi_rmi-client   replicated   1/1        wimmelsoft/rmi-client:1.0.0   *:80->8081/tcp
jreyg4a5vwf3   rmi_rmi-server   replicated   1/1        wimmelsoft/rmi-server:1.0.0
```

To see the application in action call:
```localhost/customers/1000001```

If you have questions, or suggestions, please create an issue with this repository, and I will see if I can address them.

