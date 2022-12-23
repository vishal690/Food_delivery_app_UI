# Food_delivery_app_UI

In this  app android , i have sections that include a list of categories of foods, popular foods, details of each food, Intro page and shopping cart.

# Android MVVM
There are applying MVVM architecture pattern.

### Why do we need these patterns?
Adding everything in a Single Activity or Fragment would lead to problems in testing and refactoring the code. Hence, the use of separation of code and clean architecture is recommended.

## Overview:

MVVM stands for Model, View, ViewModel.

### Model: 
This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.

### View:
It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

### ViewModel:
It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.


# ScreenShort


![Screenshot 2022-12-23 112538](https://user-images.githubusercontent.com/100077067/209281550-66bdd8c1-495e-45f3-a666-b2597ca566b6.jpg)
![Screenshot 2022-12-23 112608](https://user-images.githubusercontent.com/100077067/209281557-b8b4f930-e89e-4901-a8cd-d8a79e8de2b7.jpg)

![Screenshot 2022-12-23 112628](https://user-images.githubusercontent.com/100077067/209281566-9858783a-9f32-4910-b430-f1fbb1eade84.jpg)
![Screenshot 2022-12-23 112651](https://user-images.githubusercontent.com/100077067/209281570-b3fd629b-3113-49ea-896e-53a12323bad2.jpg)

# Video Sample


https://user-images.githubusercontent.com/100077067/209281964-b1c7a0c5-8325-4cf6-bf77-b24950d2e83b.mp4

