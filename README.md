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
![Screenshot 2022-12-23 142911](https://user-images.githubusercontent.com/100077067/209305917-a7011ed6-5f85-45b4-924b-10aa45bdd8c7.jpg)
![Screenshot 2022-12-23 142942](https://user-images.githubusercontent.com/100077067/209305932-871d3fb5-9547-4cde-9fb6-b7c6b2bc7611.jpg)

![Screenshot 2022-12-23 142957](https://user-images.githubusercontent.com/100077067/209305948-ccc45bb5-80ea-4f59-9c27-1e1711d64db2.jpg)
![Screenshot 2022-12-23 143027](https://user-images.githubusercontent.com/100077067/209305955-dc8fe58d-7472-4513-994f-e2a2826c934e.jpg)




# Video Sample


https://user-images.githubusercontent.com/100077067/209281964-b1c7a0c5-8325-4cf6-bf77-b24950d2e83b.mp4

