# PayByPlateParkingStation
# Author: Le Duy An Tran
![Snip1](https://user-images.githubusercontent.com/114903308/193646664-930fbb66-e960-4c5b-9c94-87395de13567.PNG)
# About:
A simple parking station program that is used to register for a 2-hour parking ticket with user's license plate number. The purpose of this project is to practice using Java classes, analyzing parking station software and program operations, visualizing and turn it into a suitable ticket-registered parking application. The application takes place at a local city in Washington
# Inspirations:
Nowadays, there are multiple ways of paying parking ticket create such a convenient life quality for the people - Online/Mobile payment, App Payment, and Pay Station Payment. One of the ways I mostly use everyday to pay the parking ticket is through a pay station. Whenever I made a payment with a pay station, go through each of the process, from a new user to an experience user, it is always easy to use and provide such rich understandable infomation for users of all ages. Through a lot of times, interacting with the station gives me so much inspiration and have me wonder whether or not can I make a program like this. And this time with the growth of technology, instead of having a screen and physical buttons, I want to make it to be an application on a touching screen instead - screen provided keyboards.
# Softwares:
Eclipse IDE
# What it does: 
1. The user will be introduced with an information screen about the current location, time, dates along with a prompt button to enter the user's license plate.
2. The user will then be allow to enter their user's license plate number, there will be a screen-provided keyboards for the user to interact with.

![Snip2](https://user-images.githubusercontent.com/114903308/193646677-e590d3e6-3535-4048-b44c-41cc5714b0d5.PNG)

3. The application then ask for the parking lot where the user's vehicle is parked. This is for the necessary information to be identify on the ticket.

![Snip3](https://user-images.githubusercontent.com/114903308/193646684-f77fb5fd-21b3-415c-a2f5-a9b303876c0d.PNG)

4. The application finally printed out all the information that is needed to know by the user - License Plate Number and Parking lot, Expired Time and Date, and the total cost the customer has to pay. There is an option button to print out the ticket and keep it for records. After printing the ticket, the application will return to the starting screen.

![snip4](https://user-images.githubusercontent.com/114903308/193646692-a68d0d86-d207-45c5-9346-24ad88beb5e0.PNG)

# How it is built:
The application is built using Java and Java Swing with a practice of improving in code readability, references, and classes upon small scope project. The application is first built as console program for tracking and debugging logic bugs. It is then built on to graphical user-interface to receive input with ActionListener. The screens are switched by clearing current window information and adding new information and components to the window. The application graphical user-interface is implementing color designs as red for important information, blue for proceeding to the next steps which improved the user engagement and experience. The clock in the application is built by creating another class of time, and using Windows current time/date to show current time/date and layout with Swing alignments. 
# What I learned
- The uses of functions and methods
- The importance of keeping abstractions of classes, and code readability
- The importance of GUI elements, and designs affect the application experience
- More of Java Swing and programming GUI components.
# What can it be improved:
- A payment method to charge customers
- The application should restart to the start screen if the user doesn't want to print out the ticket, and there should be an option to opt printing the ticket.



