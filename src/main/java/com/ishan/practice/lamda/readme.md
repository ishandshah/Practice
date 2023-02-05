* ~~1 aur baar Streams and Lambda.... 01/30
* 
* 
* lambda expressions (and their related features) significantly enhance
* Java because of two primary reasons. 
* First, they add new syntax elements that increase the expressive power of the language. 
* In the process, they streamline the way that certain common
* constructs are implemented. 
* 
* Second, the addition of lambda expressions resulted in new
* capabilities being incorporated into the API library. Among these new capabilities are the
* ability to more easily take advantage of the parallel processing capabilities of multi-core
* environments, especially as it relates to the handling of for-each style operations, and the
* new stream API, which supports pipeline operations on data. 
* 
* The addition of lambda expressions also provided the catalyst for other new Java features, 
* including the default method (described in Chapter 9), which lets you define default behavior for an interface
* method, and the method reference (described here), which lets you refer to a method
* without executing it.
* 
* Java’s implementation of lambda expressions are two constructs. The
* first is the lambda expression, itself. The second is the functional interface.
* 
* lambda expression is, essentially, an anonymous (that is, unnamed) method. However,
* this method is not executed on its own. Instead, it is used to implement a method defined
* by a functional interface. Thus, a lambda expression results in a form of anonymous class.
* Lambda expressions are also commonly referred to as closures.~~
* 
* 
* 
* A functional interface is an interface that contains one and only one abstract method.
  Normally, this method specifies the intended purpose of the interface. Thus, a functional
  interface typically represents a single action. For example, the standard interface Runnable is
  a functional interface because it defines only one method: run( ). Therefore, run( ) defines
  the action of Runnable. Furthermore, a functional interface defines the target type of a lambda
  expression. Here is a key point: a lambda expression can be used only in a context in which
  its target type is specified. One other thing: a functional interface is sometimes referred to as
  a SAM type, where SAM stands for Single Abstract Method.

The new operator, sometimes referred to as the lambda operator or the arrow operator, is **−>**.

The −> can be verbalized as “becomes” or “goes to.”