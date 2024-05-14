Zugriff auf die Datenbank: http://localhost:8080/h2-console

# Bekannte Probleme

* Dieselbe Person kann dasselbe Fahrrad nur ein einziges Mal ausleihen. Wurde das Fahrrad 
  zurückgegeben, wird kein neues Rentals-Objekt erzeugt.
* Mehrere Personen können gleichzeitig dasselbe Fahrrad ausleihen. 