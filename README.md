# El Juego de la Vida

[![Java Version](https://img.shields.io/badge/Java-11%2B-blue.svg)](https://www.oracle.com/java/)
[![GUI: Java Swing](https://img.shields.io/badge/GUI-Java%20Swing-orange.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![IDE: VS Code](https://img.shields.io/badge/IDE-VS%20Code-007ACC.svg)](https://code.visualstudio.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![GitHub Repo](https://img.shields.io/badge/Repo-danielrb1900%2FElJuegoDeLaVida-brightgreen.svg)](https://github.com/danielrb1900/ElJuegoDeLaVida)

Una implementación visual y orientada a objetos del clásico **Juego de la Vida** desarrollada íntegramente en **Java**. 

Este proyecto nace con el propósito de explorar la simulación de autómatas celulares aplicando los principios de la Programación Orientada a Objetos (POO), el manejo de eventos y la separación de responsabilidades entre la lógica de dominio y la interfaz gráfica de usuario (GUI). La aplicación ofrece un entorno gráfico interactivo donde el usuario puede diseñar el estado inicial célula por célula, avanzar paso a paso por cada generación para analizar su evolución con precisión y limpiar el lienzo en cualquier momento.

---

<!-- ## 🖼️ Vista Previa 

> 💡 *Espacio reservado para captura de pantalla: Puedes reemplazar esta línea por una imagen de tu interfaz gráfica usando `![Captura del Juego](ruta/a/tu/imagen.png)`*

-->
---

## 📖 Las Reglas del Juego

El universo del Juego de la Vida es una cuadrícula ortogonal bidimensional de celdas cuadradas, donde cada una se encuentra en uno de dos estados posibles: **viva** o **muerta**. Cada célula interactúa con sus ocho vecinos adyacentes (horizontal, vertical y diagonalmente).

En cada paso de tiempo (o *generación*), ocurren las siguientes transiciones de forma simultánea, basadas estrictamente en las [reglas oficiales documentadas en Wikipedia](https://es.wikipedia.org/wiki/Juego_de_la_vida):

| Estado Actual | Condición (Vecinos vivos) | Siguiente Estado | Motivo |
| :---: | :--- | :---: | :--- |
| 🟩 **Viva** | Menos de 2 (`< 2`) | ⬛ **Muerta** | **Subpoblación** (muere por soledad). |
| 🟩 **Viva** | Exactamente `2` o `3` | 🟩 **Viva** | **Supervivencia** (continúa a la siguiente generación). |
| 🟩 **Viva** | Más de 3 (`> 3`) | ⬛ **Muerta** | **Sobrepoblación** (muere por falta de recursos). |
| ⬛ **Muerta** | Exactamente `3` | 🟩 **Viva** | **Reproducción** (nace una nueva célula). |

---

## ✨ Características Principales (Features)

- **Interfaz Gráfica Interactiva (GUI):** Ventana principal desarrollada con Java Swing (`VentanaPrincipal`) que permite visualizar la cuadrícula y el estado de las colonias de células de manera intuitiva.
- **Diseño Personalizado (Píxel a Píxel):** Mediante el controlador `BotonPixelListener`, el usuario puede hacer clic directamente sobre cualquier celda del tablero para alternar su estado (viva/muerta) y dibujar patrones iniciales personalizados.
- **Avance Paso a Paso (Manual):** Control total sobre el flujo temporal de la simulación; cada pulsación en el botón *Play* (`BotonPlayListener`) calcula y renderiza exactamente la siguiente generación.
- **Reinicio Rápido:** Incluye un botón de limpieza (`BotonLimpiarListener`) para vaciar el tablero al instante y probar nuevas configuraciones desde cero.
- **Arquitectura Modular:** Código estructurado en paquetes independientes para la lógica de negocio (`clases`), la vista y eventos (`interfaz`), y el punto de entrada (`main`).

---

## 📂 Estructura del Proyecto

El código fuente está organizado siguiendo una arquitectura modular dividida en tres paquetes principales dentro del directorio `src/`:

```text
📁 ElJuegoDeLaVida
├── 📁 .vscode/
│   └── 📄 settings.json              # Configuración del espacio de trabajo para VS Code
├── 📁 src/                           # Código fuente del proyecto
│   ├── 📁 clases/                    # Lógica de dominio y modelo del autómata
│   │   ├── 📄 Celula.java            # Entidad que gestiona el estado y posición de cada célula
│   │   ├── 📄 Configuracion.java     # Constantes y parámetros globales de la simulación
│   │   ├── 📄 Juego.java             # Motor principal y control del cálculo de generaciones
│   │   └── 📄 Tablero.java           # Gestión de la matriz bidimensional y conteo de vecinos
│   ├── 📁 interfaz/                  # Componentes visuales (GUI) y manejo de eventos
│   │   ├── 📄 VentanaPrincipal.java  # Ventana gráfica principal y renderizado del tablero
│   │   ├── 📄 BotonPixelListener.java    # Listener para activar/desactivar células con el ratón
│   │   ├── 📄 BotonPlayListener.java     # Listener para avanzar a la siguiente generación
│   │   └── 📄 BotonLimpiarListener.java  # Listener para vaciar y reiniciar la cuadrícula
│   └── 📁 main/                      # Punto de entrada
│       └── 📄 Main.java              # Clase principal que inicializa el juego y lanza la GUI
├── 📁 bin/                           # Archivos bytecode compilados (.class)
└── 📄 README.md                      # Documentación del proyecto
```

---

## 🗺️ Mejoras Futuras (Roadmap)

- [ ] **Reproducción automática mediante Hilos (`Threads`):** Implementar programación concurrente para ejecutar un bucle continuo en segundo plano, permitiendo que las generaciones avancen de forma automática sin necesidad de pulsar el botón *Play* en cada turno.

---

## 📜 Licencia y Créditos

Este proyecto se distribuye bajo la Licencia **MIT**.

**Créditos y Referencias:**
* **Autor del Proyecto:** [danielrb1900](https://github.com/danielrb1900)
* **Lógica y Reglas:** Basadas en la documentación de [Wikipedia - Juego de la vida](https://es.wikipedia.org/wiki/Juego_de_la_vida).
