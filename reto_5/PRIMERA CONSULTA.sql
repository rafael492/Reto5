1. Primer informe.

Generar un informe bas�ndose en la tabla con la informaci�n 
respectiva al �L�der�. El listado debe contener: el ID_Lider, 
el Nombre, el Primer_Apellido y la Ciudad_Residencia. 
Este informe debe estar ordenado por la �Ciudad_Residencia� 
de forma alfab�tica.

SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia
FROM Lider l
ORDER BY Ciudad_Residencia ASC;

