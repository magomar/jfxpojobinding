jfxpojobinding
==============

Experiments with JavaFX binding and POJOs

This code provides simple examples of how to use JavaFX bidirectional binding in general. 
In addition, and more especifically, this project adresses the binding of Plain Old Java Objects (POJO) and JavaFX.
Since a POJO, like a Java Bean, does not uses JavaFX properties, it is not suited to apply the JavaFX Binding framework.
In this little project I explore a simple way to overcome this gap by applying a Memento design pattern. This pattern decouples 
the objects in the persistence layer and the objects in the logical layer (the models of the JavaFX application). 
The Memento pattern allows a non destructive modification of the models, that is, after having modified the models, 
it is still is possible to discard the latest changes and revert back to the previously persisted data.
