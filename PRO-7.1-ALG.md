# [CE 7.c] ¿Que librería/clases has utilizado para realizar la práctica.? Comenta los métodos mas interesantes

## Nuevas clases implementadas

Las clases nuevas que he implementado son **`reservaVueloDAO`** y **`reservaHotelDAO`**, dos DAOs que acceden a los archivos CSV en los que se guardan los datos mediante los métodos `read()`, `create()`, `update()` y `delete()`.

## Otras clases utilizadas

En cuanto a otras clases, para la práctica he utilizado específicamente la clase **`File`** de Java, que con sus métodos `writeText()` y `appendText()` nos permite escribir en un archivo, mientras uso `readLines()` para leer el contenido del mismo



# [CE 7.d] 2.a ¿Que formato le has dado a la información del fichero para guardar y recuperar la información?

Para guardar la información de las reservas he utilizado dos archivos **CSV**, uno para las reservas de vuelo y otro para las reservas de hotel. Este formato ha sido muy conveniente, ya que puedo recuperar la información fácilmente al estar perfectamente separada por comas.

2.b ¿Que estrategia has usado para trabajar con los ficheros? (Carpeta en donde se guardan los ficheros, cuando crear los archivos, ....) 

Los ficheros se encuentran en el directorio raíz del proyecto por facilidad a la hora de manejar las rutas con la clase **`File`**. El acceso al fichero en sí está fijo en el código, ya que no vi la necesidad de dejar al usuario elegir dónde quiere guardar esa información. Es más simple dejar un fichero por defecto y así no tener que estar constantemente garantizando si este existe o se puede escribir, etc


2.c ¿Cómo se gestionan los errores? Pon ejemplos de código (enlace permanente al código en GitHub).

En el código nuevo tenemos varios ejemplos de manejo de errores, como es el caso del método `read()`, que no mapea el archivo si detecta que el mismo está vacío, al mismo tiempo que filtra las líneas vacías antes de leerlas para que no haya problemas cuando hacemos el `split()`. También encontramos varios ejemplos de gestión de errores en el código ya introducido, como es el caso de que, si se introduce un dato inválido en el número de noches de la reserva del hotel, este dato toma el valor de `1` por defecto, haciendo así que el programa pueda seguir funcionando correctamente.


# [CE 7.e] 3.a Describe la forma de acceso para leer información

Para leer el contenido de alguno de los ficheros, lo hacemos desde el método `read()` de su respectivo DAO, que nos devuelve el contenido del fichero mapeado a los objetos reserva en sí, permitiéndonos trabajar con normalidad.

# 3.b Describe la forma de acceso para escribir información
El unico acceso a escritura de los archivos es mediante el método `create()` de los respectivos DAO, que guardarán la información de las reservas de su tipo en sus respectivos archivos

# 3.c Describe la forma de acceso para actualizar información. Pon ejemplos de código (enlace permanente al código en GitHub).
El acceso a actualizar información es el mismo método `create()`, ya que si este mismo detecta que ya existía una reserva con el mismo ID, sobreescribirá los datos de la reserva antigua por la nueva
