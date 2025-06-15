# Pokedex - JavaFX Application
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/MaarceloLuiz/Pokedex-PokeAPI/blob/main/LICENSE) 

<div align="left">
  
[**Objective**](https://github.com/MaarceloLuiz/Pokedex-PokeAPI#objective) <br>
[**Features**](https://github.com/MaarceloLuiz/Pokedex-PokeAPI#features) <br>
[**Tech and Frameworks**](https://github.com/MaarceloLuiz/Pokedex-PokeAPI#tech-and-frameworks) <br>
[**How to Run**](https://github.com/MaarceloLuiz/Pokedex-PokeAPI#how-to-run) <br>
[**Author**](https://github.com/MaarceloLuiz/Pokedex-PokeAPI#author)

</div>

## Objective
- Develop a desktop application using JavaFX to interact with the PokeAPI.
- Interface to display Pokemon details and search for specific Pokemon.
- Portfolio project utilizing Spring Boot, Maven and JSON parsing libraries.

## Features
- Fetch Pokemon data from the PokeAPI.
- Display Pokemon information including name, types, weaknesses, stats, etc.
- Search functionality to find specific Pokemon.

## Tech and Frameworks
- **Spring Boot**: To manage application dependencies and configurations.
- **Maven**: As the build automation tool.
- **JavaFX**: For creating the graphical user interface.
- **Jackson**: For JSON processing (fetching and parsing data from PokeAPI).
- **PokeAPI**: RESTful API to retrieve Pokemon data.

## How to Run

### Option 1 (Recommended):
### Windows Users
- Windows users need VcXsrv to display the JavaFX GUI from the Docker container on their desktop.
- 
### Steps
#### 1. Install [VcXsrv](https://vcxsrv.com/) and start XLaunch:
   - In case you cannot find XLaunch from the Windows Search, you can access your `VcXsrv` installation folder and look for `xlaunch.exe`
   - Choose: Multiple windows, display 0, start no client, disable access control
   - Click Finish (you should see an X icon in your system tray - bottom left in your taskbar)

#### 2. Clone the repository:
 ```bash
git clone https://github.com/MaarceloLuiz/Pokedex-PokeAPI.git
cd Pokedex-PokeAPI
```

#### 3. **Build and Run:**
 ```sh
 docker build -t pokedex-pokeapi .
 docker run --rm -e DISPLAY=host.docker.internal:0.0 pokedex-pokeapi
```

### Option 2:
### Prerequisites
- Java 8 or higher
- Maven
- Internet connection to fetch Pokemon data from PokeAPI

### Steps
#### 1. Clone the repository:
 ```bash
git clone https://github.com/MaarceloLuiz/Pokedex-PokeAPI.git
cd Pokedex-PokeAPI
```
#### 2. Build the project using Maven:
```bash
mvn clean install
```
#### 3. Run the Application:
```bash
mvn javafx:run
```
#### 4. Start Fetching Pokemon Data:
- Click on the **blue play button** (indicated in the image below) to begin fetching and displaying Pokemon information.

<img src="https://github.com/user-attachments/assets/4fd272e8-c973-417c-9347-8d6100155c86" alt="Pokedex Interface" width="500">

5. Explore!  
- Use the **arrow buttons** (highlighted within the yellow rectangle in the image) to navigate forward or backward through the list of Pokemon.

<img src="https://github.com/user-attachments/assets/f097b560-0b6c-4a66-8e4d-368430ca17cf" alt="arrows" width="500">

- Use the **search bar** to search for a specific Pokemon by its ID.

<img src="https://github.com/user-attachments/assets/87830499-8b4d-4615-88ed-38a483648878" alt="pokemon fetching" width="500">

- Click on the **Stats** button to view the stats and detailed attributes of the selected Pokemon.

<img src="https://github.com/user-attachments/assets/6ee7f0d6-a92b-4848-a82c-7bf5ef9c0878" alt="pokemon stats" width="500">

- Click on the **shiny button** (highlighted by the yellow circle) to toggle and view the **shiny version** of the selected Pokemon.

<img src="https://github.com/user-attachments/assets/528d3695-f8f1-45ef-bff2-38f993f2f8d4" alt="pokemon shiny" width="500">

## Author
Marcelo Luiz Guimarães Pereira

<a href="https://www.linkedin.com/in/marcelo-luiz-guimar%C3%A3es-pereira-613933269/"><img src="https://img.shields.io/badge/linkedin%20-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/></a>

---
