# Design

## Problem Description

When a software engineer newly joins a team, he/she has to perform certain necessary tasks and duties as part of the “onboarding” process. These include varying tasks such as setting up the development environment, getting the engineer up to speed with the current status of the team’s projects, and getting him/her indoctrinated with the other members of the team. This manual onboarding process, quite often, can be a problem, since it is time-consuming and requires additional effort on behalf of the team. Often, when human error is factored into the process, there could be mistakes committed, such as overlooking the installations of certain key tools. Thus, there is scope for these processes to be automated, and thereby reducing the drudgery associated with manually performing them. 

## Bot Description

The onboarding bot is a software bot that will ensure successful onboarding of a new engineer into a team. The bot aims to perform three primary tasks as part of the onboarding process - 

* Install necessary softwares on development environment
* Provide the user with access to knowledge sources like GitHub and Slack
* Grant access to the required databases by procuring necessary permissions

The above tasks, when manually performed, require time and effort and are repetitive in nature. Thus, a bot will provide a good solution in this scenario, as it will automate the successful completion of these pre-defined tasks. It will greatly reduce the burden on the team, thereby helping to increase efficiency. It will also help negate the scope for human error. 

The bot will initially interact with the user, and begin by asking for the user’s personal details, and team information.  Based on the provided details, it will set up user profiles and accounts on knowledge sources like Slack, Github and mailing lists for the specific team. The bot will also acquire permissions necessary for giving the user access to the databases used by the team, and install the database softwares and IDEs. It will obtain the domain of work  involved - such as front-end development, data analytics, machine learning etc. and will proceed with installing all necessary softwares and tools for the specified domain. 

## Design Sketches

#### Storyboard

![Alt text](Storyboard.JPG?raw=true "Storyboard")

#### Wireframe

![Alt text](Wireframe.JPG?raw=true "Wireframe")

## Architecture Design

![Alt text](Architecture Diagram.JPG?raw=true "Architecture Design")

The onboarding bot will be hosted on a server. It will be interacting with the users via the slack interface using API calls. Additionally, the bot will also interact with the following:

* A lookup database: Consists of a list of all team and domain names and the related software and database accesses that need to be provided. The bot will lookup the database and retreive the information relevant to the new member.

* Project databases: These are the databases which the user requires access to. The bot will ssh to the database server and grant the new team member access to the databases which are returned after the look-up.

* Development Environment: The environment for the new team member where the softwares returned from the lookup need to be installed. The bot will ssh to the development environment and install the corresponding softwares. 

* Knowledge Sources - Github, Slack and the corresponding mailing lists: We will use the Slack API to add the new member to his corresponding team and the Github API to add him/her as a collaborator on the team's respositories. Also he will be added to the team's mailing lists. 

#### Constraints

1. User needs to join a slack channel specific to new employees.

2. Bot should have super user privileges for slack, Github and the databases.



