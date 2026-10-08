# Artesanal: Taller 2 ArrayList

Solución sobre el repositorio original DylanRa06/artesanal. Maquina.java y sus pruebas originales se conservan sin cambios.

## Ejecutar en Eclipse
File > Import > General > Existing Projects into Workspace; selecciona esta carpeta.
El proyecto se llama Artesanal_TallerArrayList para evitar conflictos con el anterior.
El Build Path usa JUnit 5; si Eclipse no lo resuelve, clic derecho > Build Path > Add Libraries > JUnit > JUnit 5.
Run As > Java Application: TestIntegracion o TestClientes.
Run As > JUnit Test: paquete com.krakedev.artesanal.testJUnit.
Se excluye el descriptor module-info.java vacío del Build Path para trabajar con el classpath de JUnit.

## Alcance
NegocioMejorado implementa maquinas/clientes ArrayList, código aleatorio M-1...M-100, validación de duplicados, carga, búsquedas, registro de clientes, consumo acumulado y total vendido.
Cada colisión devuelve false; no se reintenta automáticamente.
Se mantiene llenarMaquina original: capacidadMaxima - 200 ML.
Se mantiene servirCerveza original: retorna cero sin descontar stock si no alcanza.
TestIntegracion esperado: cliente 7.5; stock 7050 ML; ventas 7.5.

## Datos que faltaban en el repositorio
El repositorio solo tenía Maquina y pruebas; no tenía Cliente ni Negocio. Cliente y el contador ultimoCodigo se agregaron aquí. Se usa C-1, C-2... como formato de código, pendiente de contrastar con la clase Negocio del curso.
Las nuevas máquinas usan 8000 ML de capacidad, como las pruebas originales. Puedes ajustar la capacidad con setCapacidadMaxima antes de cargar.
Por tanto no se afirma que el formato de clientes sea una transcripción de una clase original ausente.

## Error requerido por el taller
TestClientesError deja clientes en null para reproducir la etapa sin inicialización y provocar NullPointerException. La versión final inicializa clientes.
Ejecuta TestClientesError y toma una captura real de Eclipse para enviar al grupo. ERROR_INTENCIONAL.txt contiene la traza real obtenida aquí. No se envió ningún mensaje a WhatsApp.

## Verificación
18 pruebas JUnit ejecutadas y aprobadas: 3 originales y 15 del taller.
Compilación con OpenJDK 17 y JUnit Jupiter 5.10.2. Eclipse no fue ejecutado aquí.
También se ejecutaron TestIntegracion y el error intencional.
El pom.xml permite resolver JUnit con Maven; la verificación aquí usó javac y JUnit Console, no Maven.
