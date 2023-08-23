# Primer Parcial Backend

en el .zip estan las pruebas funcionales de como se realizaron las pruebas de la solucion, adicional a eso los proyectos se ejecutan con java 11, si requieres que los proyectos se ejecuten con java 17 
entra al archivo pom.xml y modifica  el siguente atributo:

```
<properties>
        <java.version>11</java.version>
</properties>
```

cambie el 11 por la version 17, le deberia quedar como en el siguente ejemplo

```
<properties>
        <java.version>17</java.version>
</properties>
```

actualice el proyecto maven para que tome los cambios y listo.


tener en cuenta que el usuario para hacer las pruebas creado en el reino es el siguente

Usuario Normal
usuario: normaluserparcial

password: 12345

Usuario Admin

usuario2: adminuser
password: 123

para el clienteID configurado en el gateway, tiene el siguente nombre para que lo pueda detectar facilmente y obtener el secret access

nombre del Cliente: api-gateway-client


NOTA: en el realm va a encontrar 2 roles USER y ADMIN respectivamente