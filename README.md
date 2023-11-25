# CS207 Project API
Group 13 - TUT0101 - BA3175

Team Members: Agnes Yau, Emily Tieu, Nanxin Wang, Yunhan Jin

## Problem Domain:
### Note-Taking Application
Our group will focus on creating a note-taking application.

## API:
We decided to use Microsoft OneNote API as it is the most related to our domain.
Microsoft OneNote API:
https://dev.onenote.com/docs

Other APIs we looked at:

Evernote API：
https://github.com/evernote/evernote-sdk-java

Google Docs API:
https://developers.google.com/docs/api

Google Drive API:
https://developers.google.com/drive/api/guides/about-sdk

ddownload API:
https://ddownload.com/api

spelling check API:
https://github.com/languagetool-org/languagetool

### Have access to the onenote api
We created a sandbox which contains some virtual accounts of mircosoft in Microsoft Azure and created out own app CSC207note to have access to the onenote api.
<img width="1062" alt="3d43431a3e81531edb62b9a59648ec8" src="https://github.com/adriaWG/CS207ProjectAPI/assets/106577956/34113e95-3251-47c0-b73e-d0dcd04f31a1">

#### Run the code using api
To use the api in the code, we download maven to add dependency to the project.
There are mainly two external libraries:

1.org.apache.httpcomponents: httpclient

2.org.apache.httpcomponents: httpcore

#### How to add these libs:
1.right click at the project, open module settings

2.click libraries,cilck the "+"

3.use maven to seache for the two libraries mentioned above

4.Then there's no red line under "import org.apache.http..."

## Functionality
These are some of the key features we hope to implement:
#### 1. API Integration
Integrating API will enhance the application's functionality, enabling features such as collaborative editing.
#### 2. Open a New Page
Users are able to open a new page and naming the file.
#### 3. Editing a Page 
Users are able to edit the page by typing their notes.
#### 4. Exporting Notes 
Users are able to export their notes to different sources (e.g. pdf).
#### 5. Deleting Notes 
Users are able to delete their notes.

## Design
To start implementing, we have assigned use cases to help implementing the note-taking app.
#### Use Case 1: 
Users can decide to open up their previously saved work or create a new note. 
#### Use Case 2:
Users can type and edit their notes in the opened file.
#### Use Case 3:
Users can export their notes to their desired output file type (e.g. pdf)
#### Use Case 4:
Users can delete their notes if they decided that they will no longer need it.

### SOLID 
Our implementation adheres to SOLID 
### Clean Architecture
Our implementation adheres to CLean Architecture
### Design Patterns

## Demo
Insert screenshots of our finished code 

## Testing
Our test folder shows our testings to specific parts of the project.

## Further Implementations:
With time permitting, here are some of the features we want to implement:
#### 1. Formatting Options
Users will be able to insert images, change sizes, and create visually appealing notes with a variety of options.
#### 2. Import Function
Users can import notes from other sources.
#### 3. Text Entry
Other than handwriting-notes, users can choose to type and edit text within the application by using a keyboard.
#### 4. Support for Multiple Languages
This feature will allow the note-taking application to be accessible to a diverse user base.
#### 5. Spell Checking
This feature will perform real-time spell checks as users write their notes. This will help users to identify errors, enhancing the quality of their notes.
#### 6. Save and Load
Users will be able to save their notes at anytime and can load their previous work when they wish to continue where they left off, enabling features like real-time data retrieval.



