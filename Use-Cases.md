##Use Cases

### Use Case 3
Use Case: Install software/packages on development environment.

1. Preconditions <br>
  User must have a slack profile and joined the bot’s channel. <br>
  The bot should have the required keys to SSH to the user's development environment.
2. Main Flow <br>
    User provides the bot with the name of the team[S1]. Bot provides list of suggested softwares [S2]. Bot installs software as requested [S3].
3. Subflows <br>
   [S1] User provides bot with name of the team he/she belongs to. <br>
   [S2] Bot performs a lookup on team same. Provides a list of suggested softwares to the user. <br>
   [S3] Bot will SSH onto the development environment of the user. Install requested software/package. Provide confirmation to user.<br>
4. Alternate Flows <br>
   [E1] Bot does not support the installation of software/package provides by user.
  
