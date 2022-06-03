# Build and minimum requirements 

I Included MAVEN Only as a means to simplify the build process and assured a correct java version.
I developed a java 1.8 version which is a minimum acceptable version nowadays.
I don't pull any other dependency to a third party library even for testing.

Along the code there are comments explaining some design decisions and why I take some paths


# Package structure of the solution
The solution is hosted in “es.danrivcap.cv.cards” wich is divided in three packages:
- **client**: Contains a client application with a main application containing a happy path. This client only knows about public interfaces and nothing about concrete implementations.
- **model**: Contains application data model such as Card Suit and Face, they are modeled as classes, enums and interfaces because is more suitable that primitive types or plain String, they allow the flexibility of modeling any kind of Card composing their “appearance” but they are all equals in behavior for this reason I use generic types instead of inheritance.
- **app**: It contains interfaces and implementations for the Deck and auxiliary components needed, the central interface is Deck which defines the contract for implementing different kinds of Decks. There are other components like Dealers that help Deck to deal Cards because Deck responsibility is to build a Deck and allow clients to play with them but how to deal cards is the responsibility of the Dealer interface which we can Implement which strategy we like in this case a random one. And there is a Factory which helps us to build all components and hide complexity to the client so clients only know he works with a Deck of Cards which have Suits and Faces but doesn’t worry about the concrete thing of them. 