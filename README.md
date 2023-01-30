# MEDMAPPER

The purpose of this application is to assist a user with medication administration. This application recieves input from the user about their medications and when they should be administered. The application sends alerts and reminders to the user to take their medications at the appropriate time, and logs successful administration for the user as well as other parties that the user may choose to share their information with. This will allow a user to track their medication usage, and help ensure that they are taking each medication at the appropriate time each day.

STORYBOARD / MOCKUP DEMO:
https://user-images.githubusercontent.com/58799967/215368262-99cf4973-e667-4a01-bb83-43e583b0cdef.mp4

FUNCTIONAL REQUIREMENTS:

  SCENARIO:
  As a user who consistently needs to take multiple medications, I want to be able to input information for my medications     and once inputted receive Schedule times, alerts, option to share schedule.

  DEPENDENCIES: 
    Medication input entry is available and accessible. 
    
  ASSUMPTIONS:
    Medication names are stated in English.
    Alert features are enabeled on user device.
    Medicaiton is taken on a scheduled interval (not as needed).
    
  EXAMPLES 
    1.1 
      AS a user 
      I want to be able to input medications on "My Medicaitons" page
      So that I can view them on "My Schedule" page
      
      Given a medication

      When I add to "My medications"

      Then I should view the medicaiton on "My Schedule"
      
     1.2
      AS a user 
      I want to recieve alerts when it is time to take a medication;
      So that I can take the medication on time.
      
      Given a medication has been added to "My Medications"

      When I need to take the medicaiton

      Then I should recieve an alert that it is time to take the medication.
     
     1.3
      AS a user 
      I want to share my schedule with a medical team or caretaker
      So that they can see when I am supposed to take my medication. 
      
      Given a schedule has generated from "My Medications"

      When I add a person to my "Share List"

      Then they should recieve a copy of my medication schedule for the month.
      
     1.4
      AS a user 
      I want to confirm a medication has been taken
      So that I can track my medication administration
      
      Given that a medication has been taken
      
      When I click "Medication Taken" button on "My Schedule" 

      Then the information will be stored in a "Medication Administration" log, and shared with members of my "Share List".
      

UML CLASS Diagram:
https://user-images.githubusercontent.com/58799967/215370095-469ca745-611b-4e1a-b273-db07688c2b25.png

CLASS DIAGRAM DESCRIPTION:  
https://github.com/jakeFarrish/MedMapper/files/10531467/ClassDescription.docx

SCRUM ROLES:

Intergration Developer: Cherissa Tan
Backend Developers: Logan Farwick, Jacob Farrish
UI Developers: Miriam Boni, Peyton Laeace
Project Owner / DevOps: Jacob Farrish

 
 




 

 



