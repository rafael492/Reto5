2. Segundo informe.

Realizar un informe bas�ndose en la informaci�n de 
los proyectos cuya clasificaci�n sea �Casa Campestre� 
y que est�n ubicados en las ciudades de �Santa Marta�, 
�Cartagena� y �Barranquilla�. Este informe debe contener: 
el ID_Proyecto, la Constructora, el N�mero_Habitaciones y 
la respectiva Ciudad.

SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad 
FROM Proyecto p 
WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')
AND Clasificacion = 'Casa Campestre';




