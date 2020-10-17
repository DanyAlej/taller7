# Taller 7: Generación automática de datos con Mockaroo, Podam y Faker JS
### Introducción
Se hará una descripción de cada una de las herramientas y un demo de su funcionamiento el cuál será explicado en la wiki del repositorio.
En este caso será necesario:
1. Crear un demo de una API Rest para registro de cuentas nuevas con Mockaroo
2. Crear 3 distintos esquemas para posibles usos dentro de las aplicaciones Habitica y MyExpenses.
3. Generación de esquemas y datos automáticos para el uso en la aplicación móvil de Habitica con Podam.
4. Replicar los mismos esquemas creados con Mockaroo en la herramienta Facker.js.

### Aplicación

1. Partiendo de la base del taller 5, es necesario que se prueben los formularios de registro de la aplicación Habitica, haciendo uso de datos generados automáticamente por la aplicación Faker.js.
Sera necesario probar la creación de 50 cuentas correctamente y hacer 100 intentos fallidos con datos generados automáticamente que no pertenezcan al field donde estan siendo implementados. Los datos deben ser generados automáticamente con mockaroo o faker.js. Se deberan probar distintos esquemas para los campos por llenar. Es decir, se deben probar links de imágenes en el correo, usuario, etc. Y se deberan reportar los mensajes de error o si el formulario permitió la entrada.

2. Se deberán reemplazar todos los test realizados en talleres anteriores end-to-end con información generada automáticamente. Al igual con el punto anterior es necesario probar esquemas permitidos por la aplicación y probar esquemas no convencionales para observar el comportamiento de la aplicación.

3. Mediante el uso de Podam se probarán las mismas funcionalidades en las aplicaciones móviles Habitica y MyExpenses. Se probara el login y registro de Habitica, y los input fields de MyExpenses.


