<link rel='stylesheet' href='web/swiss.css'/>

# Module Unit 5: Textual Concrete Syntax

In this module unit, we are going to discuss how to design the textual syntax of a DSL so that their abstract syntax is automatically represented as an Ecore metamodel and a parser is automatically obtained for the DSL. The advantage of this approach for implementing a parser - actually to generate it automatically - is that DSL programs can be viewed as (domain) models directly, by representing their abstract syntax as models, as discussed in Module Unit 4. This will enable the rapid development of interpreters and of compilers as we will discuss in the next module units. The aim of this module unit is, however, to design and develop the syntactic representation of DSLs using model-driven technology atop the Eclipse Modeling Framework (EMF), introduced in Module Unit 4, by using the Xtext language. 

Given that Xtext forms an abstraction layer atop compiler techniques, some basic notions from compiler theory are revised in the slides: parsers, interpreters and compilers, context-free grammars, parse trees and abstract syntax trees, language of a context-free grammar. In the last session the bridge between context-free grammars (grammarware) and metamodels (modelware) using the Xtext approach is discussed. This bridge is also illustrated in a talk by Sven Efftinge, the project lead of the Xtext project at itemis.com, on the development of DSLs using Xtext. 

In the problem class, we are going to discuss how to design context-free grammars using EBNF notation and we are going to illustrate the method that Xtext uses to generate metamodels from context-free grammars by example.

In the lab session, Xtext is going to be used to develop the textual concrete syntax of a small DSL by developing a grammar using the Xtext language. The approach to be followed in the worksheet is illustrated in a video tutorial.

## Lectures

* L5a: Context-free grammars 
  * :movie_camera: [Lecture 5a (video)](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=5f7b169b-aa72-49e8-be42-ed0911bfb028)
  * :notebook: [handouts](./L5a_handouts.pdf)
* L5b: Xtext (to be released after 15 Nov)
  * :movie_camera: [Lecture 5b (video)](TBA) 
  * :notebook: [handouts](./L5b_handouts.pdf)

### Sven Efftinge on Introduction to DSL development with Xtext

:movie_camera: [Introduction to DSL development with Xtext](https://vimeo.com/138873446)

An Introductory session to Eclipse's successful language development environment. Xtext let's you build fully featured programming languages as well as simple domain specific languages (DSL). The first half of this session will give an overview of what Xtext can do for you. During the second half we will develop a DSL live and from scratch!

A well designed DSL (domain specific language) can be a huge productivity boost in many scenarios. Being it a special language for describing technical things like services or data structures or something more business oriented such as a DSL for describing complex financial products. But to make development of a custom language worthwile it must be easy to define and maintain such a DSL and of course the users must have assistance through tool support.

Xtext provides a set of APIs and DSLs to develop such DSLs easily. It not only gives you a generated parser but supports the full stack of infrastruture that is needed. This also includes editor support for Eclipse, IntelliJ and Web as well as integration with the common build tools Maven, Gradle, and Ant. Xtext is an Eclipse.org project and as such available as open-source. The framework is actively developed, very mature and widely used in industry and research.

In this session you will first get a brief introduction into the main concepts of Xtext. After that we will build a DSL from scratch.

Sven Efftinge is the project lead of Xtext, a framework for developing programming languages and domain-specific languages. Sven works as development manager for itemis.

## Exercises

* :movie_camera: [Problem: design of context-free grammars](tba) (to be enabled after Tuesday)
  * :notebook: [worksheet](./sur2.pdf) 
  * :black_nib: [solution to exercises](./sur2_solution.pdf) (this link will be enabled when solutions are released)
* :computer: [Textual concrete syntax with Xtext](TBA)  (to be released after 15 Nov) 
  * :computer: [solution to exercises](TbA) (this link will be enabled when solutions are released)

  
## References

* Lorenzo Bettini. Implementing Domain-Specific Languages with Xtext and Xtend. [online access](http://readinglists.le.ac.uk/items/6833D3AD-5488-CEA7-BA79-2A89043D5633.html?referrer=%2Flists%2F0B9D5ADC-32C2-3DDC-5F17-D6D96DCC5924.html%23item-6833D3AD-5488-CEA7-BA79-2A89043D5633)
