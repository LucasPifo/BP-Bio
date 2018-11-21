foreach(DBForm('Clientes')->WHERE('Estatus Cliente','=','Agregando')->get() AS $stockRow){		
	$visita = NewRegister('Contratos');
	$visita['Razon Social del Cliente']=$stockRow['Razon Social']; 
	$visita['Denominacion del Contrato']=$stockRow['Nombre del Contrato Principal'];
	$visita['Calle']=$stockRow['Calle'];
	$visita['No.Exterior']=$stockRow['Num.Exterior'];
	$visita['Codigo Postal']=$stockRow['Codigo Postal'];
	$visita['Colonia']=$stockRow['Colonia'];
	$visita['Estado']=$stockRow['Estado'];
	$visita['Municipio']=$stockRow['Municipio'];
	$visita['Poblacion']=$stockRow['Poblacion o Delegacion'];
	$visita['Sucursal que Atiende']=$stockRow['Sucursal Biosinsa'];
	$visita['IdCTL']=$stockRow['Idcliente']; 
	save($visita);
	$stockRow['Estatus Cliente']='Activo';
	$stockRow['¿Agregar Datos al Contrato?']='Agregado';
	save($stockRow);	
}			