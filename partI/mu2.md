<link rel='stylesheet' href='web/swiss.css'/>

# Module Unit 2: Polyglot Persistence

In this module unit, we are going to discuss 
* key notions underpinning the success of NoSQL technologies with respect to SQL technologies;
* an outline of the NoSQL ecosystem, focussing on Document stores with MongoDB.

As a representative example of NoSQL technologies, we will experiment with a MongoDB instance deployed on the Cloud.

The lectures are supplemented with a presentation on the subject by Martin Fowler - the author of the book that we are using for this module unit.

The exercises illustrate how to use a document store (MongoDB) for implementing data persistence layers for cloud applications with very little effort using the languages that we learnt in the previous module unit (Gradle and Groovy). 

## Introduction to NoSQL by Martin Fowler

Martin Fowler - Author, Speaker, Consultant & General Loud-mouth on Software Development

This presentation was recorded at [GOTO Aarhus 2012](http://gotocon.com).

Martin gives a rapid introduction to NoSQL databases: where they came from, the nature of the data models they use, and the different way you have to think about consistency. From this he outlines what kinds of circumstances you should consider using them, why they will not make relational databases obsolete, and the important consequence of polyglot persistence.

[![ScreenShot](http://img.youtube.com/vi/qI_g07C_Q5I/0.jpg)](https://youtu.be/qI_g07C_Q5I)


## Lectures

Lecture recordings are released on Wednesdays

* L2: NoSQL (NoSQL - motivation, outline and scalability)
  * :movie_camera: [Lecture 2a. NoSQL](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=fa918bdf-3a39-4a50-87fa-ef59a91c4059): Panopto lost connection with the mic and the recording had to be restarted
  * :movie_camera: [Lecture 2b. NoSQL](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=c6b908c8-9699-476b-a05c-4a3d33be9c78): motivation and outline of NoSQL technologies
  * :movie_camera: [Lecture 2c. NoSQL](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=2c3879bd-a3c2-44b7-a2d3-65e8c39efbd5): scalability and MongoDB
  * :notebook: [handouts (NoSQL)](./L2a_handouts.pdf)
* L2b: MongoDB
  * :movie_camera: [Lecture 2d. NoSQL](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dc917a33-8efb-4232-af6f-7cc2c780121f): MongoDB and demo 
  * :notebook: [handouts (MongoDB)](./L2b_handouts.pdf)

## Exercises

For doing formative and assessed coursework, set up your own private [as explained in the tooling section](https://github.com/uol-inf/CO7X17-17-18/blob/master/tooling.md#setting-up-your-github-repository). Once you private repository is set up, do the following exercise:

* :computer: [MongoDB exercises](./mongodb/readme.md)
  * :computer: [solution to exercises](./mongodb_solution) (this link will be enabled when solutions are released)
  
Solutions to exercises will be posted under this folder on GitHub as projects with the name `${ExerciseName}_solution`.
  
## References

* Pramod J. Sadalage; Martin Fowler. NoSQL Distilled: A Brief Guide to the Emerging World of Polyglot Persistence. Addison-Wesley Professional. Chapters 1-4, 9. (available on the [Library catalogue](http://proquest.safaribooksonline.com.ezproxy3.lib.le.ac.uk/book/databases/9780133036138))

