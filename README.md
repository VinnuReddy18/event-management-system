# Event Management System 

This project is an event management system designed to streamline the planning and execution of events. It includes functionalities for creating, modifying, retrieving, and deleting event details, managing participants, venues, and organizers.

## Features 🎉

### Event Details Management 📅

#### Models Involved: Event, Venue, Organizer

- **Event Model**: Contains fields such as Event ID (Auto Increment), name, description, date, venue (linked to Venue ID), and organizer (linked to Organizer ID).
- **CRUD Operations**: Implemented CRUD operations for Event details, ensuring integrity and consistency between Event, Venue, and Organizer data.
- **Update Event Information**: Provides features for organizers to update event information except for changing the venue directly.

### Participant Management 🙋‍♂️

#### Models Involved: Participant, Event

- **Participant Model**: Designed with fields like Participant ID, name, email, and events attended.
- **Registration Management**: Enables registration and deregistration of participants for events, including CRUD operations on participant records.
- **Participant Listing**: Supports listing all participants for a specific event and their registration status.

### Venue Management 🏟️

#### Models Involved: Venue

- **Venue Model**: Developed with fields such as Venue ID, name, location, capacity, and availability.
- **Venue CRUD**: Allows CRUD operations on venues to manage where events can be held.
- **Availability Check**: Implemented a feature to check venue availability and schedule events accordingly.

### Organizer Profile Management 👩‍💼

#### Models Involved: Organizer, Event

- **Organizer Model**: Constructed with fields such as Organizer ID, name, contact information, and associated events.
- **Profile Management**: Implemented functionalities for organizers to manage their profiles and the events they are organizing.

### Architecture and Technologies Used 🛠️

- **RESTful API**: Implemented using Spring Boot.
- **Database Integration**: Integrated with MySQL Database.
- **Hibernate ORM**: Used for database interaction to facilitate CRUD operations and ensure data integrity.
- **Cardinality Rules**: Ensured the right cardinality rules are maintained between the models.
- **Logging**: Considered adding logging for each CRUD operation to aid in debugging and tracking system usage.

## Setup Instructions 🚀

1. Clone the repository.
2. Set up MySQL database and configure database properties in `application.properties`.
3. Run the application using your preferred IDE or by executing `mvn spring-boot:run` command in the terminal.
4. Access the API endpoints to interact with the system.

## API Endpoints 🌐

- **Event Management**:
  - `/events`: GET (Retrieve all events), POST (Create a new event)
  - `/events/{eventId}`: GET (Retrieve event by ID), PATCH (Update event), DELETE (Delete event)
- **Participant Management**:
  - `/participants`: GET (Retrieve all participants), GET (Get all events), POST (Create a new participant)
  - `/participants/{participantId}`: GET (Retrieve participant by ID), PATCH (Update participant), DELETE (Delete participant)
- **Venue Management**:
  - `/venues`: GET (Retrieve all venues), POST (Create a new venue)
  - `/venues/{venueId}`: GET (Retrieve venue by ID), PUT (Update venue), DELETE (Delete venue)
- **Organizer Management**:
  - `/organizers`: GET (Retrieve all organizers), POST (Create a new organizer)
  - `/organizers/{organizerId}`: GET (Retrieve organizer by ID), PATCH (Update organizer by ID), PUT (Update event by organizer)

## Contributors 🌟

- [Vinay Reddy](https://github.com/VinnuReddy18) 
- [Harshit Shah](https://github.com/harshit4311) 
- [Manjari Rathore](https://github.com/ManjariRathore) 
- [Spoorthy Madasu](https://github.com/Spoorthy1423) 
- [Priyanshu Baul](https://github.com/nobitaN0bi) 
- [Shivam Goel](https://github.com/ShivamGoelOSS) 
