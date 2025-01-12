### Projekt
Zaawansowany System Zarządzania Studentami 

## Opis projektu
Projekt Zaawansowany System Zarządzania Studentami to aplikacja napisana w języku Java.

Umożliwia zarządzanie danymi studentów za pomocą graficznego interfejsu użytkownika (GUI) oraz bazy danych SQLite. Funkcjonalność programu:
- Dodawanie nowych studentów.
- Usuwanie istniejących studentów.
- Aktualizowanie danych studentów.
- Wyświetlanie listy wszystkich studentów.
- Obliczanie średniej ocen studentów.

## Wymagania systemowe
-JDK: Java Development Kit 8 lub nowszy
-IDE: Visual Studio Code (lub inne kompatybilne IDE)
-Baza danych: SQLite

## Instrukcja instalacji

1. Pobranie i rozpakowanie projektu:
-Pobierz plik ZIP z projektem;
- Rozpakuj plik ZIP do jakiegokolwiek folderu folderu na dysku, np.:  C:\Users\rwraf\Zaawansowany-system-zarzadzania-studentami`

2. Otwieranie projektu w Visual Studio Code:
- Uruchom Visual Studio Code.
- Wybierz opcję File > Open Folder.
- Przejdź do rozpakowanego folderu projektu i kliknij Select Folder i wybierz folder gdzie pobrano projekt.


4. Kompilacja i uruchomienie projektu:
- Otwórz terminal w Visual Studio Code,
- Skompiluj projekt :
javac -d bin src/*.java
- Uruchomienie aplikacji:
java -cp "bin;lib/sqlite-jdbc-3.47.2.0.jar" src.Main


## Funkcjonalności

1. Dodawanie studenta:
- Wprowadź dane studenta (ID, imię, wiek, ocena) i kliknij przycisk "Add Student"
- Walidacja danych zapewnia, że wiek jest liczbą dodatnią, a ocena mieści się w zakresie 0.0 - 100.0.
2. Usuwanie studenta:
- Wrowadź unikalny ID studenta i kliknij przycisk "Remove Student".
3. Aktualizacja danych:
- Wprowadź unikalny ID studenta, zaktualizowane dane i kliknij "Update Student".
4. Wyświetlanie listy studentów:
- Kliknij "Display All Students", aby zobaczyć pełną listę studentów w bazie danych.
5. Obliczanie średniej ocen:
- Kliknij "Calculate Average", aby obliczyć średnią ocen wszystkich studentów z bazy danych.


## Obsługa błędów
- Wyjątki SQL: Obsługa błędów połączenia, zapytań SQL, itp.
- Walidacja danych: Sprawdzanie poprawności danych wejściowych (np. wiek i oceny - czy są poprawne wartości zgodnie z zasadami).
- Komunikaty: Informacje o sukcesie lub błędach wyświetlane w GUI.


## Struktura projektu
-src: Folder z kodem źródłowym aplikacji.
-bin: Folder z plikami skompilowanymi.
-database: Plik bazy danych SQLite.
-vscode: Launch i Settings.

## Alternatywne miejsce pobrania projektu:
https://github.com/Hokusai97/Zaawansowany-system-zarzadzania-studentami



