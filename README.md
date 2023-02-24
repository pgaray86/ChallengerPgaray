Challenge

los endpoints disponibles son los siguientes:

http://localhost:9090/basic 
Devuelve un listado de objetos.

http://localhost:9090/basic/1
Devuelve el primer elemento con el Id = 1

Pero, si se ingresa un id inexistente, el response debe ser

{"status":4001,"message":"Id 2 no encontrado"}

con status 404.

Realizar lo siguiente:
+ Manejar las expeciones de forma centralizada. 
+ Refactorizar y simplicar el proyecto.