## Foro Hub Challenge 
Este es un proyecto de API REST desarrollado con Spring Boot como parte de un desafío técnico para practicar conceptos de diseño de APIs, validaciones, persistencia con JPA, manejo de errores y más.

## 🚀 Funcionalidades Actuales
* Iniciar sesión (/login) 

Con cuerpo estilo Json con el formato siguiente:
{
	"login": "ejemplo@forohub.com",
	"contrasena": "contrasena"
}

* Gestión de Tópicos (/topicos)

* Crear tópico (POST /topicos)

* Listar tópico por ID (GET /topicos/{id})

* Listar todos los tópicos (con paginación)

* Actualizar tópico (PUT /topicos/{id})

* Eliminar lógico de tópico (DELETE /topicos/{id}) – no elimina de la base de datos, solo cambia el estado a ELIMINADO.

## Validaciones
Validaciones con @NotBlank en los DTOs de entrada.

Manejo de errores personalizados con @RestControllerAdvice en una clase individual.

## 📌 Tecnologías Utilizadas
Java 17+

Spring Boot 3+

Spring Web

Spring Data JPA

H2 / MySQL

Maven

Lombok

## Cómo ejecutar
bash
Copiar
Editar
# Clonar el proyecto
git clone https://github.com/tu-usuario/foro-hub-challenge.git
cd foro-hub-challenge

# Compilar y ejecutar (si tienes Maven instalado)
./mvnw spring-boot:run
Accede a la API desde:

bash
Copiar
Editar
http://localhost:8080/topicos
✅ Próximas implementaciones
 /usuarios: CRUD para gestión de usuarios.

 /respuestas: Permitir crear y visualizar respuestas en los tópicos.

 Autenticación JWT

 Seguridad con Spring Security

🛠 Estructura del Proyecto
css
Copiar
Editar
src/
 └── main/
     └── java/
         └── com.forohub.Foro.Hub/
             ├── controller/
             │   ├── TopicoController.java
             │   └── infra/exceptions/GestorDeErrores.java
             └── domain/
                 └── topicos/
                     ├── topicos.java
                     ├── TopicoRepository.java
                     ├── DatosRegistroTopico.java
                     ├── DatosActualizacionTopicos.java
                     ├── ListarTopicos.java
                     └── DatosDetallesTopico.java
📄 Licencia
Este proyecto es parte de un desafío educativo y puede ser reutilizado o adaptado libremente con fines de aprendizaje.

