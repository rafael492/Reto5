2. Segundo informe.

Realizar un informe basándose en la información de 
los proyectos cuya clasificación sea “Casa Campestre” 
y que estén ubicados en las ciudades de “Santa Marta”, 
“Cartagena” y “Barranquilla”. Este informe debe contener: 
el ID_Proyecto, la Constructora, el Nùmero_Habitaciones y 
la respectiva Ciudad.

SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad 
FROM Proyecto p 
WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')
AND Clasificacion = 'Casa Campestre';




