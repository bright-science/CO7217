# IDE and Tooling

The tools that need to be installed in your machine in order to do the exercises for CO7X17 17-18 are:
* Java 8
* The Spring Tool Suite (STS) 3.9.0
* Groovy 
* Gradle Buildship

Find below:
* [An installation guide of the tools required.](#installation-guide)
* [Instructions to set up your workspace for CO7X17 17-18.](#setting-up-your-github-repository)

## Installation guide

A screencast describing how to install the STS, Groovy and Gradle is available :movie_camera: [here](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=e319d6ac-c47d-4197-ac82-3850b313b8b7).

Further considerations on the tools that we are going to use in CO7X17 are described below.

### Java 8

* Download Java 8 from [Oracle's website](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
* Install it.

### Spring Tool Suite (STS) 

* Download the Spring Tool Suite (STS) 3.9.0 available from [the Spring website](https://spring.io/tools).
* Unzip and move to:
  * Mac OS: `Applications` 
    * In some cases, you may not be able to install Groovy plugins, with the error being that you don't have write permissions on the installation folder. If you drag and drop the STS file to the `Applications` folder, you may be able to install the plugins.
  * Windows: `Program Files`
    * Use 7-zip ([http://www.7-zip.org](http://www.7-zip.org)) to unzip the zipped file that you get when you download the STS.
    * Some students could not install the STS under the folder `Program Files`. If that is your case, try to install the STS in another folder, e.g. in `My Documents`.
  * Linux: your folder of choice

### For Windows 10 users

Some exercises involve working with [Bash (Unix shell)](https://en.wikipedia.org/wiki/Bash_(Unix_shell)). We strongly recommend the installation of a Linux shell as follows:
1. [Install the Windows Subsystem for Linux](https://msdn.microsoft.com/en-gb/commandline/wsl/install_guide) and create a root account
    * A summary can be found [here](https://superuser.com/a/1059340)
2. Open a cmd terminal and type `bash`, now you are in a bash terminal
    * to access your `C` use `/mnt/c/`, e.g. `ls /mnt/c/` is like `dir c:\`
3. Install Java
    * `sudo apt-get update` and enter the root password that you entered above
    * install Java 8 as described [here](http://tipsonubuntu.com/2016/07/31/install-oracle-java-8-9-ubuntu-16-04-linux-mint-18/)
  
The instructions given for UNIX systems (Linux/MacOS X) should be applicable to Windows using `bash` on a `cmd terminal`. 


### Groovy

* From within STS (launch it first).
* `Help > Dashboard` (from Spring perspective).
* `Manage > IDE extensions`.
* Select:
  * `Groovy 2.4 compiler for Groovy-Eclipse`;
  * `Groovy-Eclipse`;
  * `Groovy-integration with m2clipse` .
* Click `Install` and follow the instructions.

### Gradle

* From within STS (launch it first).
* `Help > Eclipse Marketplace`.
* Search for `Buildship Gradle Integration 2.0`.
* Install it and follow the instructions.

## Setting up your GitHub repository

We are going to use two repositories on GitHub, the main one `CO7X17-17-18`, which is going to be used to release new resources, and your own private repository `CO7X17-17-18-${YourGitHubUsername}`, which is going to be used to do coursework.

### Main repository CO7X17-17-18

Follow these steps:
* Create an account on GitHub if you don't have one already.
* Fill in the corresponding Google form below and provide your GitHub username (you may need to log in with your Google credentials):
  * Google form for [CO7217](https://goo.gl/forms/QQ7yoen3AgRQkfyV2) (campus students)
  * Google form for [CO7517](https://goo.gl/forms/zNg7fDsB65wyAwbg2) (DL students)
  
* You will get access to the resources during the week starting on `2nd October 2017`.

This repository is intended to be used in **READ-ONLY MODE**. That is, do not write or modify any file or folder in your local copy of the repository. If you do it accidentally, please delete the whole local copy of the repository and clone it again. 

### Your individual repository CO7X17-17-18-${YourGitHubUsername}

GitHub is used to submit assessed coursework. Please accept the corresponding invitation below, which will create your individual private repository on GitHub, and clone it in the STS as explained :movie_camera: [in this video](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dc275383-e28f-426e-b5cd-6a60dcc6609d). The video also explains how to import the exercises for sprint 1.
* [Invitation for CO7217](https://classroom.github.com/a/b47fCaTn) (campus students)
* [Invitation for CO7517](https://classroom.github.com/a/0PR7AvFz) (DL students)

This repository is intended to be used in **READ-WRITE MODE**. That is, this is your private repository and you have control over its contents. This repository can be used to keep backup copies of your work and to submit your coursework.

