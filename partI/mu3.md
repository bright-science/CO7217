<link rel='stylesheet' href='web/swiss.css'/>

# Module Unit 3: Polyglot Persistence (II)

This module unit is a follow-up of the previous unit on NoSQL, and we are going to cover:
* consistency in cloud systems;
* trade-offs to be made to improve availability in cloud systems;
* consistency in MongoDB.

In the lecture we will discuss a web app built atop the [Spring Framework](https://spring.io/) that integrates with the Twitter API and with MongoDB instance on mLab (via GMongo), building on the exercises used in [module unit 2](./mu2.md). 

In the exercises, we will use the source code of this web app for extracting information from Twitter. This source code is the codebase to be used to solve the programming exercises of [miniproject 1](./miniproject1.md).

There is also a quiz for summarizing the theory covered.

## Lectures

Lecture recordings are released on Wednesdays:

* L3a: NoSQL (consistency)
  * :movie_camera: [Lecture 3a](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=e305bf7e-aec5-4f52-86f9-994e380f2149)
  * :notebook: [handouts](./L3a_handouts.pdf)
* L3b: Preparation for miniproject (Twitter integration)
  * :movie_camera: [Lecture 3b](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=aadd7904-e313-47f7-8cda-969543656e23) 
  * :notebook: [handouts](./L3b_handouts.pdf)

## Exercises

For doing formative and assessed coursework, set up your own private [as explained in the tooling section](https://github.com/uol-inf/CO7X17-17-18/blob/master/tooling.md#setting-up-your-github-repository). Once you private repository is set up, do the following exercise:

* :computer: [Twitter integration](./twitter_exercise/readme.md) (to be released on Wednesday)
  * :computer: [solution to exercises](./twitter_exercise_solution) (this link will be enabled when solutions are released)

Solutions to exercises will be posted under this folder on GitHub as projects with the name `${ExerciseName}_solution`.

* :black_nib: Quiz on NoSQL
  * [CO4217/CO7217 (campus students)](https://blackboard.le.ac.uk/webapps/assessment/take/launchAssessment.jsp?course_id=_5572_1&content_id=_1291085_1&mode=view)
  * [CO7517 (DL students)](https://blackboard.le.ac.uk/webapps/assessment/take/launchAssessment.jsp?course_id=_7623_1&content_id=_1291252_1&mode=cpview)
  * you may need to be logged in Blackboard in your browser for the redirection to work correctly;
  * feedback is provided as soon as you submit your answers.
  

  
## References

* Pramod J. Sadalage; Martin Fowler. NoSQL Distilled: A Brief Guide to the Emerging World of Polyglot Persistence. Addison-Wesley Professional. Chapters 5, 9. (available on the [Library catalogue](http://proquest.safaribooksonline.com.ezproxy3.lib.le.ac.uk/book/databases/9780133036138))

