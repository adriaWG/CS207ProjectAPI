# CS207 Project API

## Problem Domain:
### Note-Taking Application
Our group will focus on creating a note-taking application with an integrated text editor.

## Description of Application:
These are some of the key features we hope to implement:

#### 1. Sections and Pages
Users will be able to organise their notes into different sections and pages, allowing structured and easy navigation.
#### 2. API Integration
Integrating API will enhance the application's functionality, enabling features such as collaborative editing.
#### 3. UI for Creating Notes
We believe a user-friendly interface for note-taking is essential, we hope users find it simple to use the application.
#### 4. Display Formatting Options
Users will be able to insert images, change sizes, and create visually appealing notes with a variety of options.
#### 5. Export and Import
Users can import notes from other sources and also export their written notes to different formats (e.g. PDF, images).
#### 6. Text Entry
Other than handwriting-notes, users can choose to type and edit text within the application by using a keyboard.
#### 7. Support for Multiple Languages
This feature will allow the note-taking application to be accessible to a diverse user base.
#### 8. Spell Checking
This feature will perform real-time spell checks as users write their notes. This will help users to identify errors, enhancing the quality of their notes.
#### 9. Save and Load
Users will be able to save their notes at anytime and can load their previous work when they wish to continue where they left off, enabling features like real-time data retrieval.

## API Link:
Below are some of the APIs we think that might be useful to use that are related to our domain:

Evernote API：
https://dev.evernote.com/doc/
https://github.com/evernote/evernote-sdk-java 

Google Docs API:
https://developers.google.com/docs/api 

Microsoft OneNote API:
https://dev.onenote.com/docs 

Google Drive API:
https://developers.google.com/drive/api/guides/about-sdk

ddownload API:
https://ddownload.com/api 

spelling check API:
https://github.com/languagetool-org/languagetool

## Screenshot of Trying Out API:
![Alt text](image.png)

## Example Output of Running our Java Code:
We attempted the API of Evernote and Outlook, however we encountered few problems during our attempts. 

 Problems:
*(This will be further explained below.)*
1. use maven or gradle to include the SDK to the project 
2. sign up for the APIKey correctly
3. Time Limit

### Example of using Drive API-
Here are some of our findings:
1. Google Drive provides a platform on which we can upload our files.
![img_2.png](img_2.png) 
2. ddowload provides the API on their website which provides us some ideas on how to structure our cloud drive.
![img_1.png](img_1.png)
![img.png](img.png)
### Example of Spelling-Correction Attempts-
![img_4.png](img_4.png)
* this shows the supporting app maven it needs (however i met some problems with that because I can't find the path variable)
![img_3.png](img_3.png)
* this shows the total API given (too big, so I didn't attach files to our current project)

## A list of any technical problems blocking progress:
1. Tried to get the access_token of onenote following some steps searched on the Internet, but stuck here because of limited time and authority.
![Alt text](image-1.png)
2. Some environment setting problems
(1) as listed in "Example of spelling correction attempts" with maven settings;
3. Time Limit
