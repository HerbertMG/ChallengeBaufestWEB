# CHALLENGE WEB AUTOMATION

En este proyecto se utiliza **SERENITY BDD** con patrón de diseño **SCREENPLAY**

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

## Herramientas necesarias:
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)
- [Java SE Development Kit 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Apache Maven 3.9.2](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

## Plugins en el IDE:
- Cucumber for Java
- Gherkin
- Rainbow CSV (mejor visualización de archivos CSV)

## Configuración del Proyecto:

1. Teniendo el proyecto en nuestra máquina local, dirigirse al archivo **.feature** principal:
   `D:\Proyectos\ChallengeBaufestWEB\src\test\resources\features\DemoblazeWEB.feature`

2. Modificar las credenciales del usuario **"herbert202356789029"** con un valor a conveniencia.

3. Dirigirse al archivo **Runner** y ejecutar la prueba:
   `D:\Proyectos\ChallengeBaufestWEB\src\test\java\runners\DemoblazeRunner.java`


## Generar Reporte:

En el terminal del IDE, ingresar el siguiente comando:
````
mvn serenity:aggregate
````
