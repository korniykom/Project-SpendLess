### The App Idea
SpendLess is a finance tracking app with a focus on security. The aim is to  
keep track of the userʼs income and expenses while also securing the data in  
terms of accessing the app and storing data.

### Login Screen
- An account consists of a username and PIN
- Account information is only stored locally
- The PIN has to be encrypted before persisting locally
- The PIN text field must be 5 digits long
- Username requirements:
    - Must be at least 3 characters
    - Must not exceed 14 characters
    - Only alphanumeric and digits are allowed in any combination
    - No space characters are allowed
    - Valid usernames: "user123", "A1B2C3", "JohnDoh"
- User must be able to complete login only by using keyboard
    - Username text field must be focused when this screen is shown
    - User must be able to use the keyboard action button to move to the PIN text field
    - User must then be able to use the keyboard action button to trigger login
- Username text field must be focused when this screen is shown
- Upon an invalid username and PIN combo, show a red banner in the same style as shown on the Registration Screen with text: "Username or PIN is incorrect"
- The "New to SpendLess" text button takes the user to the *Registration flow*