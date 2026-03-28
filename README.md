# Design Patterns 

This repository contains implementations of various design patterns in Java. Each pattern is implemented in a separate file, and the code is organized in a way that makes it easy to understand and use.

## List of design patterns implemented
- Singleton
- Strategy
- Template Method
- Factory Method
- State
- Command
- Adapter
- Decorator
- Builder
- Chain of Responsibility

---

## Creational Patterns
> About *how objects are made*

---

### Singleton

Ensures a class has **only one instance** and provides a global access point to it. Useful for shared resources like config managers, loggers, or thread pools.

**Core Components**
- `Instance` – the single shared object
- `Private constructor` – prevents external instantiation
- `Static accessor` – returns the existing instance or creates it on first call

---

### Factory Method

Defines an interface for creating objects, but lets **subclasses decide** which class to instantiate. Decouples object creation from the code that uses the object.

**Core Components**
- `Creator` – declares the factory method
- `ConcreteCreator` – overrides the factory method to return a specific product
- `Product` – the interface for created objects
- `ConcreteProduct` – the actual object being created

---

### Builder

Separates the **construction of a complex object** from its representation, so the same construction process can produce different results step by step.

**Core Components**
- `Builder` – interface declaring construction steps
- `ConcreteBuilder` – implements construction steps; tracks the product
- `Director` – defines the order of construction steps
- `Product` – the resulting complex object

---

## Behavioral Patterns
> About *how objects communicate and coordinate*

---

### Strategy

Defines a family of **interchangeable algorithms**, encapsulates each one, and makes them swappable at runtime without changing the client that uses them.

**Core Components**
- `Context` – holds a reference to a strategy and delegates work to it
- `Strategy interface` – common interface for all supported algorithms
- `ConcreteStrategy A/B` – implements a specific algorithm

---

### Template Method

Defines the **skeleton of an algorithm** in a base class, deferring some steps to subclasses. Subclasses can override steps without changing the overall structure.

**Core Components**
- `AbstractClass` – defines `templateMethod()` and its fixed steps
- `templateMethod()` – the algorithm skeleton (final/non-overridable)
- `primitiveOp()` – abstract steps subclasses must implement
- `ConcreteClass` – fills in the abstract steps

---

### State

Allows an object to **alter its behavior** when its internal state changes. The object appears to change its class, avoiding large conditional branching on state.

**Core Components**
- `Context` – maintains a reference to the current state object
- `State interface` – declares the behavior for each state
- `ConcreteState A/B` – implements behavior for a specific state
- `handle()` – method called by the context, delegated to the current state

---

### Command

**Encapsulates a request as an object**, allowing you to parameterize clients with different requests, queue/log operations, and support undoable actions.

**Core Components**
- `Command` – interface with `execute()` and `undo()`
- `ConcreteCommand` – implements the command, binds a receiver to an action
- `Receiver` – the object that performs the actual work
- `Invoker` – triggers the command
- `Client` – creates and configures commands

---

### Chain of Responsibility

**Passes a request along a chain of handlers**. Each handler decides whether to process the request or forward it to the next handler in the chain.

**Core Components**
- `Handler` – interface declaring `handle(request)` and a reference to the next handler
- `ConcreteHandler` – processes the request or passes it along
- `Client` – builds the chain and initiates the request
- `successor` – the next handler in the chain

---

## Structural Patterns
> About *how objects are composed*

---

### Adapter

**Converts the interface of a class** into another interface that clients expect. Acts as a bridge between incompatible interfaces without modifying existing code.

**Core Components**
- `Target interface` – the interface the client expects
- `Adaptee` – the existing class with an incompatible interface
- `Adapter` – wraps the Adaptee and translates calls to the Target interface
- `Client` – works with the Target interface only

---

### Decorator

**Attaches additional responsibilities to an object dynamically**. Provides a flexible alternative to subclassing for extending functionality by wrapping objects.

**Core Components**
- `Component` – the base interface for both the real object and decorators
- `ConcreteComponent` – the base object being decorated
- `Decorator` – wraps a Component and delegates calls to it
- `ConcreteDecorator` – adds behavior before/after delegating to the wrapped component


