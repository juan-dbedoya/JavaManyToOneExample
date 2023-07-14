# JavaManyToOneExample - Spring Boot

## Este proyecto contiene un ejemplo muy concreto de una relación ManyToOne y OneToMany, tomando como ejemplo 2 entidades, oferta de empleo y candidato. Este proyecto funciona con una base de datos MySql, y el ORM JPA, documentacion de apis swagger y JWT en la seguridad.

# -Configuracion de base de datos:
  > Ejecutar esta linea en el editor de codigo de MySQL que desee ->CREATE DATABASE careerOtoM;
  > Las tablas se crearán de manera automatica Y la cadena de conexion en el archivo "applications.properties" está
  escrito para una base de datos cuyo usuario y contraseña sean ambos "root" y que esta corra en el puerto 3306.
  (modificar la cadena de concexion para generarla correctamente)

# -Swagger:
  Headline H2 La documentacion de las Api's corre en el puerto -> /doc/swagger-ui.html

# -JWT Para obtener acceso a las apis debemos hacer lo siguiente: 
    1) Acceder a la base de datos, a la tabla "usuario" de la entidad "User" y crear uno nuevo con sus parametros,
    así por ejemplo:
    USE careerOtoM;
    insert into usuario values(2,"juan@gmail.com","juan","$2a$10$C9KIdElWn2fIgkORuPF5MOVkeA71v8Jfi8fj5hDtD/8n0U6DPgQC2");
    Este ultimo parametro es el token, corresponde a la palabra "darwin" encriptada
    
    2) Ir a su gestor de API's instalado, postman por ejemplo, e ingresar una peticion tipo "POST" en la ruta http://localhost:8080/login
    Una vez hecho esto enviamos ingresamos un cuerpo Json con el email y contraseña sin encriptar así:
    {
    "email":"juan@gmail.com",
    "password":"darwin"
    }
    
    3)Una vez hecho el paso 2 nos dirijimos a Headers en nuestra respuesta, en el item de "Authorization" vamos a ver nuestro token
    vamos a copiarlo.
    
    4)Por ultimo vamos a la API que queremos probar, luego seleccionamos el tipo de autenticacion que vamos a probar y seleccionaremos
    "Bearer Token", una vez seleccionamos esta opccion en el campo "token" vamos a pegar el token copiado en el paso 3 y listo!
    ya temenos acceso a esa api con ese token por 30 dias.





    
