# Ejercicio de Java (Nisum)
 Autor: Orlando Utrera 

## Prerequisito

 Java JDK 1.8+

 Gradle 7.7

## Instalacion
git clone https://github.com/outrera/nisum.git
 
nota: cambiar al directorio del proyecto

cd nisum


## Compilar y Ejecutar el proyecto api (Antes dockerizar)
gradle bootRun

## Docker Build
docker build -t nisum/myapp .
## Docker Run
docker run -p 8080:8080 -e "JAVA_OPTS=-Ddebug -Xmx128m" nisum/myapp

# Diagrama de Solucion

### Modelos
![digrama-usuario-phone.jpg](assets%2Fdigrama-usuario-phone.jpg)
![digrama-usuario-mapa.jpg](assets%2Fdigrama-usuario-mapa.jpg)
![digrama-validations.jpg](assets%2Fdigrama-validations.jpg)
![digrama-config.jpg](assets%2Fdigrama-config.jpg)

### Controlador
![digrama-usuario-repository.jpg](assets%2Fdigrama-usuario-repository.jpg)

### Validaciones
![digrama-solucion.jpg](assets%2Fdigrama-solucion.jpg)



