# **Proyecto de Conexión a InterSystems IRIS con Spring Boot**

Este proyecto demuestra cómo conectarse a una base de datos **InterSystems IRIS** utilizando **Spring Boot** y realizar operaciones básicas como la creación de tablas e inserción de datos. El objetivo es proporcionar una guía práctica para interactuar con IRIS desde una aplicación Java.

---

## **Tabla de Contenidos**

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Requisitos Previos](#requisitos-previos)
3. [Configuración del Proyecto](#configuración-del-proyecto)
4. [Ejecución del Proyecto](#ejecución-del-proyecto)
5. [Funcionalidades Implementadas](#funcionalidades-implementadas)
6. [Manejo de Errores](#manejo-de-errores)
7. [Contribuciones](#contribuciones)
8. [Licencia](#licencia)

---

## **Descripción del Proyecto**

Este proyecto utiliza **Spring Boot** para conectarse a una instancia de **InterSystems IRIS** alojada en un contenedor Docker. La aplicación realiza las siguientes tareas:
- Verifica si una tabla existe en la base de datos.
- Crea la tabla si no existe.
- Inserta datos de ejemplo en la tabla.

El proyecto está diseñado para ser utilizado como punto de partida para aplicaciones más complejas que interactúen con IRIS.

---

## **Requisitos Previos**

Antes de ejecutar este proyecto, asegúrate de cumplir con los siguientes requisitos:

### **1. Software Necesario**
- **Java 17 o superior**: [Descargar JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven**: [Instalar Maven](https://maven.apache.org/install.html)
- **Docker**: [Instalar Docker](https://www.docker.com/products/docker-desktop) (para ejecutar IRIS en un contenedor)

### **2. Dependencias**
Asegúrate de tener acceso a las siguientes dependencias:
- **Controlador JDBC de InterSystems IRIS**: Disponible en [Maven Central](https://search.maven.org/artifact/com.intersystems/intersystems-jdbc).
- **Spring Boot Starter**: Incluido automáticamente mediante Maven.

### **3. Instancia de IRIS**
- Una instancia de **InterSystems IRIS** debe estar en ejecución (puede ser local o en un contenedor Docker).
- Configura el puerto y las credenciales adecuadas para acceder a la base de datos.

---

## **Configuración del Proyecto**

### **1. Clonar el Repositorio**
Clona este repositorio en tu máquina local usando el siguiente comando:

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio

