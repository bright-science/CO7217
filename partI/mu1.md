<link rel='stylesheet' href='web/swiss.css'/>

# Module Unit 1: Agile Practices with Groovy and Gradle

Welcome to the module. In this first unit, we are going to cover the main principles behind agile software development methodologies. Namely, we will use Gradle for automating software builds, providing a stepping stone for achieving [continuous delivery](http://martinfowler.com/bliki/ContinuousDelivery.html). In the rest of the module we will use Gradle for automating software development tasks.

The module unit for this week is structured as follows:
* We will learn [Groovy](#groovy), a scripting language used to program Gradle build scripts.
* We will learn how to program [Gradle](#automating-builds-with-gradle) build scripts using Groovy for Java projects.

At the end of this page you will find a jargon buster on terms that may be new to you.

## Lecture

Unfortunately, there has been a technical problem with the recording of the lecture and the link below refers to the lecture recorded in the previous year.

* :movie_camera: [Lecture 1. Continuous Delivery](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=2c9ccac0-c865-49c7-bb86-f8a4c1edf588)
  * :notebook: [handouts session a](./L1a_handouts.pdf)
  * :notebook: [handouts session b](./L1b_handouts.pdf)


## Groovy

In this unit, we are going to cover the basics of Groovy's syntax so as to be able to read and write Gradle build scripts. We are going to focus on:
* What is Groovy? What are its main features?
* How to write and run Groovy scripts?
* Working with collections and ranges
* Writing and using functions
* Writing and using closures
* Differences between functions and closures
* Dynamic capabilities

### Exercises

For doing formative and assessed coursework, set up your own private [as explained in the tooling section](https://github.com/uol-inf/CO7X17-17-18/blob/master/tooling.md#setting-up-your-github-repository). Once you private repository is set up, do the following exercise:

* :computer: [Exercises with Groovy](https://github.com/uol-inf/CO7X17-17-18/blob/master/partI/Groovy_exercises/readme.md)
  * :computer: [Solution](./Groovy_exercises_solution/) 

Solutions to exercises will be posted under this folder on GitHub as projects with the name `${ExerciseName}_solution`.

## Automating builds with Gradle

In this unit, we are going to focus on automating software builds with Gradle based on what we have learnt about software development methodologies and Groovy:
* What is Gradle?
  * What is the Gradle wrapper?
* What is a Gradle task?
  * Writing and running tasks.
  * Specifying task dependencies.
* What is a typed task?
  * Using the copy task.
* How to use Gradle to build a Java project?
  * What is a Gradle plugin?
  * Tasks offered by the Java plugin
  * What is the Gradle daemon
* How does Gradle handle library dependencies?
  * What is a repository?
  * Using repositories of libraries
* How do you run Java tests from Gradle?

### Releasing with Gradle

[![ScreenShot](http://img.youtube.com/vi/f-9hzWy21jo/0.jpg)](https://youtu.be/f-9hzWy21jo)

### Exercises

* :computer: [Exercise 1](https://github.com/uol-inf/CO7X17-17-18/blob/master/partI/Gradle_ex01/readme.md) (**Gradle tasks and dependencies**)
  * :computer: [Solution](./Gradle_ex01_solution/)
* :computer: [Exercise 2](https://github.com/uol-inf/CO7X17-17-18/blob/master/partI/Gradle_ex02/readme.md) (**Java builds and Java libraries**)
  * :computer: [Solution](./Gradle_ex02_solution/)

Solutions to exercises will be posted under this folder on GitHub as projects with the name `${ExerciseName}_solution`.

## Jargon buster <a name="jargon"></a>

| term  | definition | source |
|-------|------------|--------|
| software development methodology | A methodology specifies the process to be executed, usually as a set of related activities, tasks and/or techniques, together with the work products that must be manipulated (created, used or changed) at each moment and by whom, possibly including models, documents and other inputs and outputs. In turn, specifying the models that must be dealt with implies defining the basic building blocks that should be used to construct. |  [wikipedia](https://en.wikipedia.org/wiki/Software_development_process) |
| sprint | A sprint (or iteration) is the basic unit of development in Scrum. The Sprint is a timeboxed effort; that is, it is restricted to a specific duration. The duration is fixed in advance for each Sprint and is normally between one week and one month, with two weeks being the most common. | [wikipedia](https://en.wikipedia.org/wiki/Scrum_&#40;software_development&#41;#Workflow) |
| sprint backlog | The sprint backlog is a list of tasks to be completed during the sprint. | [mountaingoatsoftware](https://www.mountaingoatsoftware.com/agile/scrum/sprint-backlog) |
| software build | Process of automating the creation of a software build and the associated processes including: compiling computer source code into binary code, packaging binary code, and running automated tests. | [wikipedia](https://en.wikipedia.org/wiki/Build_automation) |



