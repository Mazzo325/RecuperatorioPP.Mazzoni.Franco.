🍕 Sistema de Gestión de Pizzería
📋 Descripción del Proyecto

Sistema de gestión orientado a objetos desarrollado en Java que simula las operaciones fundamentales de una pizzería. El proyecto implementa conceptos avanzados de Programación Orientada a Objetos (POO) incluyendo herencia, polimorfismo, interfaces y composición de clases.

🎯 Características Principales

Gestión de Productos: Administración de pizzas y postres con diferentes tipos, tamaños y características

Control de Inventario: Sistema de capacidad máxima con validación de productos duplicados

Cálculo Dinámico de Precios: Aplicación de multiplicadores según tamaño o tipo de producto

Ordenamiento Automático: Implementación de Comparable para ordenar productos alfabéticamente

Generación Aleatoria de Atributos: Calorías y tiempo de preparación calculados aleatoriamente

🏗️ Arquitectura y Patrones de Diseño
Jerarquía de Clases
Producto (Abstract)
    ├── Pizza
    └── Postre

Conceptos Implementados
1. Herencia y Clases Abstractas
public abstract class Producto implements Comparable<Producto>


Clase base abstracta que define el comportamiento común de todos los productos

Implementa Comparable para ordenamiento natural por nombre

Utiliza composición con la clase Fabricante

2. Polimorfismo
public interface IVendible {
    double getPrecioTotal();
}


Interface que define el contrato para productos vendibles

Implementación específica del cálculo de precio en cada subclase

Permite tratamiento uniforme de diferentes tipos de productos

3. Enumeraciones (Enums)
public enum TipoPizza { NAPOLITANA, MUZZARELLA, CALABRESA }
public enum TamanoPizza { CHICA, MEDIANA, GRANDE }
public enum TipoPostre { TIRAMISU, HELADO, FLAN }
public enum TipoProducto { PIZZAS, POSTRES, TODOS }


Uso de tipos enumerados para garantizar valores válidos

Mejora la legibilidad y mantenibilidad del código

4. Encapsulamiento

Atributos protegidos y privados con métodos de acceso controlado

Validación de lógica de negocio en métodos específicos

5. Generación Aleatoria de Atributos
private static Random generador;
static {
    generador = new Random();
}


Instancia única del generador de números aleatorios

Utilizada para asignar calorías y tiempo de preparación a los productos

💻 Tecnologías Utilizadas
Tecnología	Versión	Propósito
Java	21	Lenguaje de programación principal
Apache Ant	1.10+	Sistema de construcción y gestión de dependencias
NetBeans	26	Entorno de desarrollo integrado (IDE)
📂 Estructura del Proyecto
PP.Picapiedra.Pizzeria/
├── src/
│   └── Entidades/
│       ├── Fabricante.java
│       ├── Producto.java
│       ├── Pizza.java
│       ├── Postre.java
│       ├── Pizzeria.java
│       ├── IVendible.java
│       ├── Principal.java
│       ├── TipoPizza.java
│       ├── TamanoPizza.java
│       ├── TipoPostre.java
│       └── TipoProducto.java
├── build.xml
└── nbproject/

🚀 Ejecución del Proyecto
Requisitos Previos

JDK 21 o superior

Apache Ant 1.8.0 o superior (incluido en NetBeans)

🎓 Conceptos de POO Demostrados

✅ Abstracción: Clase abstracta Producto

✅ Encapsulamiento: Modificadores de acceso apropiados

✅ Herencia: Jerarquía Pizza y Postre extienden Producto

✅ Polimorfismo: Interface IVendible y sobrescritura de métodos

✅ Composición: Relación entre Producto y Fabricante

✅ Interfaces: Implementación de IVendible y Comparable

✅ Colecciones: Uso de ArrayList para gestión dinámica

✅ Generics: ArrayList<Producto>

📝 Validaciones Implementadas

Control de capacidad: Límite máximo de productos en pizzería

Prevención de duplicados: Validación mediante método sonIguales()

Null safety: Verificación de referencias nulas en comparaciones

Type safety: Uso de instanceof en sobrescritura de equals()

👨‍💻 Autor

Franco Mazzoni


📄 Aclaración

Este proyecto fue desarrollado con fines académicos para la materia de Programación II.
