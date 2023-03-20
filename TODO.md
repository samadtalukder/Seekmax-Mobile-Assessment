### Tasks I have completed

* Add a login screen to authenticate a user with the application
  - Needed Input fields: Username & Password and a Button
* The logged-in session needs to be stored
  - The form of the Session will be a JWT-Token
* Add Logout capabilities
* Show list of active (where the status is `PUBLISHED`) job ads (with pagination or lazy loading) (refer to `/design/JobList.png`)
* Add an indicator to the list screen whether the currently authenticated user already applied to a specific job
* Display job ads details with API integration
* Created only `My Profile` &  `Show My Applications` Tab

### Tasks not done

* In `My Profile` Tab, via which candidates can adjust profile attributes (for example name)
  - Also requires Backend Work
* Add Password Change Capabilities
  - Also requires Backend Work
* When clicking on an available job, show a new screen with more details and the option to apply
- Add search capabilities
  - Also requires Backend Work
* In `Show My Applications`, which should show all the current authenticated users applications (need to create a new backend endpoint as well)
  - Also requires Backend Work

### Stack that was used
* Hilt-Dagger is used as a dependency injection framework to manage the app's dependencies
* Used Kotlin and follows the Model-View-ViewModel (MVVM) design pattern to separate the presentation logic from the business logic
* Coroutines are also used to perform asynchronous operations in a more efficient and readable manner.
* The Material Design framework is used for the UI components, providing a modern and consistent look and feel.
* Api
  - Retrofit
  - I have included the necessary dependencies for GraphQL in my project, but I have not completed it yet. I was facing backend issue.

### Things I would have done with more time
* Which tasks not done
* Improve UI/UX, app performance
* Introduce Espresso and Mockito testing

