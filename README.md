# Parcial-POO — Creación de Pokemones y Entrenadores

Sistema de gestión de: Entrenadores ("Trainers") y Pokemones ("Pokemons") desarrollado en Java aplicando Programación Orientada a Objetos (POO), interfaz gráfica de usuario (GUI) y persistencia de datos en archivos CSV.

## 1. Planeación y alcance del proyecto
Este proyecto corresponde al parcial en pareja de Programación Orientada a Objetos, donde la planeación contempla:
- **Repositorio y control de versiones:** trabajo colaborativo en GitHub (`Milevibes/Parcial-POO`) con *commits* de ambos integrantes y flujo de ramas/actualización (`git clone`, `git status`, `git add`, `git commit`, `git pull`, `git push`).
- **Planeación y documentación:** registro de la estructura, modelo de datos, reglas y decisiones de diseño en este `README.md`.
- **Interfaz gráfica (GUI):** pantallas visuales estilo consola portátil para navegar entre la gestión de entrenadores y pokemones, crear registros, listarlos y eliminarlos.
- **Persistencia:** almacenamiento y lectura de registros mediante los archivos CSV.
- **Datos:** soporte tanto para datos oficiales de Pokémon/Entrenadores como para registros personalizados creados por el usuario.

## 2. Reglas
- **Cantidad de Pokemones por Entrenador:** un entrenador puede tener la cantidad de Pokemones que desee, sin límite máximo ni restricciones adicionales.
- **Relación entre entidades:** relación N a M entre "Trainer" y "Pokemon" (un entrenador puede tener múltiples Pokemones asociados y un Pokemon asimismo puede estar vinculado a muchos Entrenadores o sin entrenador asignado si así se desea).
- **Sincronización al eliminar:** al eliminar un Pokemon, se actualiza su referencia en los entrenadores para mantener coherencia entre "Pokemon.csv" y "Trainer.csv".

## 3. Modelo de clases y estructura del proyecto

### Entidades principales (`src/clases`)
- **Trainer:** representa al Entrenador ("id", "name", y colección/lista de pokemones asociados).
- **Pokemon:** representa al Pokemon ("id", "number", "name", "type", "level" y "trainer"").

### Operaciones y persistencia (`src/operation`)
- **OperationsTrainers:** lectura, guardado y eliminación de Entrenadores sobre "Trainer.csv", además de la actualización de pokemones asociados.
- **OperationsPokemon:** lectura, guardado y eliminación de Pokemones sobre "Pokemon.csv".

### Interfaz gráfica y recursos
- **`src/frontend`:**
    - **InicioModerno**: menú principal de navegación hacia gestión de Entrenadores y Pokemones.
    - **MostrarEntrenadoresModerno y CrearEntrenadorModerno**: listado, eliminación y creación de Entrenadores.
    - **MostrarPokemonesModerno y CrearPokemonModerno**: listado, eliminación y creación de Pokemones.
- **"src/assets" y "src/images":** tipografía (`PokemonFuente.ttf`) e imágenes utilizadas en la interfaz
- **Archivos CSV** ("Trainer.csv" y "Pokemon.csv") persistencia local de los datos.
