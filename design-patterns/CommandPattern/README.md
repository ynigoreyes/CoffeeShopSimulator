# Command Pattern

Command Pattern is a software engineering pattern that helps decouple the sender and reciever. In our app, we found this useful when creating objects that listen to one another for events.

For example, our project had many objects that listened to each other adnd we are going to call them Foo and Bar. Foo sends a Baz event. We have set up Bar to listen for the Baz event. The Baz event has all of the information needed to complete some task, Fib. All instances of Bar can now listen for Baz events. We have now decoupled the sender from the reciever. Bar does not know that Foo has send the Baz event, we only know that a Baz event was sent and the Bar object must handle it.