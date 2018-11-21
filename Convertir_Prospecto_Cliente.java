foreach(DBForm('Prospecto Calificado')->WHERE('Estatus del Prospecto','=','Agregando')->get() AS $stockRow){
    $visita = NewRegister('Clientes');
	$visita['Razon Social']=$stockRow['Razon Social del Prospecto'];
	$visita['Nombre del Contrato Principal']=$stockRow['Nombre Comercial'];
	$visita['Calle']=$stockRow['Calle'];
	$visita['Num.Exterior']=$stockRow['No. Exterior'];
	$visita['Num.Interior']=$stockRow['No. Interior'];
	$visita['Rfc']=$stockRow['RFC'];
	$visita['Codigo Postal']=$stockRow['CP'];
	$visita['Colonia']=$stockRow['Colonia'];
	$visita['Estado']=$stockRow['Estado'];
	$visita['Municipio']=$stockRow['Municipio'];
	$visita['Poblacion o Delegacion']=$stockRow['Poblacion o Delegacion'];
	$visita['Giro Comercial del Cliente']=$stockRow['Giro Comercial del Prospecto'];
	$visita['Sucursal Biosinsa']=$stockRow['Sucursal Biosinsa'];
	$visita['Vendedor']=$stockRow['Vendedor'];	
	save($visita);		
	$stockRow['Estatus del Prospecto']='Dado de alta en Clientes';
	save($stockRow);
}