<link rel='stylesheet' href='web/swiss.css'/>

# Module Unit 4: Agile automation using domain-specific languages

In previous module units, we have used a number of domain-specific languages as key devices for automating software builds and for facilitating interaction with NoSQL stores. In this module unit, we give a closer look at domain-specific languages from a domain engineering perspective, focussing on model-driven engineering (MDE), and we discuss how to specify the (abstract) syntax of domain-specific modelling languages. In this module unit, we are going to cover:

* Introduction to domain-specific languages from a domain engineering perspective, discussing advantages and disadvantages for automating software development.
* Introduction to agile automation using model-driven engineering, making domain models first-order citizens and providing a range of techniques to automate software development based on models.
* Specification of metamodels (the abstract syntax of modelling languages) using MOF.
* Constraining specifications of metamodels using OCL.

The lectures are supplemented with a presentation by Martin Fowler on domain specific languages.

The exercises for this week consist of:
* a quiz test that you can use to check your understanding on the module unit;
* a modelling exercise in which you will have to define the abstract syntax of a domain-specific modelling language, namely a feature modelling language;
* a programming exercise on metamodelling with the Eclipse Modeling Framework (EMF).

## Lectures

* L4a: Domain-Driven Design and Domain Specific Languages 
  * :movie_camera: [Lecture 4a (video)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=4a78e1f2-14fc-48c8-9e6a-9dd45ee95e6f)
  * :loud_sound: [Lecture 4a (audio)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=91227800-8bd1-4a27-8949-dc7645653751)
  * :notebook: [handouts](./L4a_handouts.pdf)
* L4b: Metamodelling with MOF
  * :movie_camera: [Lecture 4b (video)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dfadb650-91cc-446e-b843-082fd255a1b4) 
  * :loud_sound: [Lecture 4b (audio)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=52c65e97-4d7a-4278-97e4-832c356a42b8)
  * :notebook: [handouts](./L4b_handouts.pdf)

### Martin Fowler on Domain Specific Languages

Domain Specific Languages (DSLs) are limited forms of computer language designed for a specific class of problems. In this JAOO conference talk, Martin Fowler introduces a simple example of DSL, bringing out the difference between external and internal DSLs, and talking through the trade-offs in using both forms. The talk is based on Martin's language workbench article on martinfowler.com.

:movie_camera: [Introduction to Domain Specific Languages](http://www.infoq.com/presentations/domain-specific-languages)

## Exercises

* :black_nib: Quiz 
  * [CO4217/CO7217 (campus students)](https://blackboard.le.ac.uk/webapps/assessment/take/launchAssessment.jsp?course_id=_5572_1&content_id=_1294532_1&mode=cpview)
  * [CO7517 (DL students)](https://blackboard.le.ac.uk/webapps/assessment/take/launchAssessment.jsp?course_id=_7623_1&content_id=_1294542_1&mode=cpview)
  * you may need to be logged in Blackboard in your browser for the redirection to work correctly;
  * feedback is provided as soon as you submit your answers.
* :movie_camera: [Problem: Metamodelling with MOF](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=1b3c7141-858d-4f38-b5f8-22a667dfaa46)
  * :notebook: [worksheet](./sur1_fm.pdf) 
  * :black_nib: [solution to exercises](./sur1_solution.pdf) and :movie_camera: [their explanation](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=aa3d70ff-c365-4a35-bd46-315c470361c6)
* :movie_camera: [Metamodelling with EMF (video)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=7feeb48c-d67c-49e3-aa2d-876e295fa7c2)
  * :computer: [Metamodelling with EMF](./lab4.emf.md) 
  * :computer: [solution to exercises](./lab4.emf.solution/) (this link will be enabled when solutions are released)

  
## References

* Marco Brambilla, Jordi Cabot, and Manuel Wimmer. Model-Driven Software Engineering in Practice. Morgan & Claypool Publishers, 1st edition, 2012.
* Martin Fowler and Rebecca Parsons. Domain-specific languages. Addison-Wesley, Upper Saddle River, NJ, 2011.
