# Tarjeta de Fidelidad Gamificada

Este proyecto implementa un sistema de fidelización por consola en Java. Los clientes acumulan puntos por compras y suben de nivel (Bronce, Plata, Oro, Platino).

## Funcionalidades
- Gestión de clientes (CRUD)
- Registro de compras y asignación de puntos
- Bonificaciones por compras seguidas
- Niveles de fidelidad automáticos
- Interfaz de línea de comandos (CLI)
- Pruebas unitarias con JUnit 5
- Medición de cobertura con JaCoCo

## Requisitos
- Java 21+
- Maven
- Git

## Compilación y ejecución

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="fidelidad.App"
