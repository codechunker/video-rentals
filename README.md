# Read Me First
This is a Video Rental Application to enable a company that displays a list of available movies from a database and calculates video rental fees for a movie selected from the list.

# Getting Started
The application was compiled with JDK 1.8. In order to run the jar, simply download the [zip file](https://github.com/codechunker/video-rentals/blob/main/video-rentals.zip)  and run the command below and you are good to go - just make sure you have Java
running on your system. The application runs on port 8097 but of course you can change the port in the ***application.properties*** file in the config folder.
 ```
java -jar video-rentals.jar
```
**The application will populate some video data in a temporary database (H2) that deletes the data once the application is restarted. Once the app starts running, go to http://localhost:8097/h2-console to see the data in the DB.**

# Flow, Concepts and Deductions
The documentation says it should be able to list videos with their genre and types. So I wrote some functions to help to populate the db whenever the app is restarted. This made it handy for me to have some data to work with.

From the documentation, I deduced that The Genres and Types will already be existing in the DB so that The UI that populate it as a drop for the user to pick from when renting. So this means that I didn't hardcode any types and genres and as such, one can easily create more types, genres and prices. There are endpoints provided in other to view and create these features.

I wrote my own queries for some features because of the way the app was designed.  


### Reference Documentation
The documentation for the project can be found on http://localhost:8097/swagger-ui.html once the application is running. Sample Image is shown below:
![Video Rentals Documentation](https://github.com/codechunker/video-rentals/blob/main/video-rentals-doc.PNG)
