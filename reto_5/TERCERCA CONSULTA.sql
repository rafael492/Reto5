3. Tercer informe.

Realizar un informe basándose en las compras realizadas por 
los proyectos con el proveedor “Homecenter” y 
para la ciudad “Salento”. Este informe debe incluir: 
ID_Compra, Constructora y Banco_Vinculado.

SELECT ID_Compra, p.Constructora , p.Banco_Vinculado 
FROM Compra c 
INNER JOIN Proyecto p  ON c.ID_Proyecto = c.ID_Proyecto 
WHERE p.Ciudad = 'Salento'
AND c.Proveedor = 'Homecenter';




