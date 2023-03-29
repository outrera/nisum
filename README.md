# Ejercicio de Java (Nisum)
 Autor: Orlando Utrera 

## Prerequisito

 Java JDK 1.8+

 Gradle 7.7

## Instalacion
git clone https://github.com/outrera/nisum.git
 
nota: cambiar al directorio del proyecto

cd nisum


## Compilar y Ejecutar el proyecto api 
gradle bootRun

## Docker run
docker build -t nisum/myapp .
docker run -p 8080:8080 -e "JAVA_OPTS=-Ddebug -Xmx128m" nisum/myapp