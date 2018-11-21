foreach(DBForm('Asignacion de Dispositivos')->WHERE('Replica','=','SI')->get() AS $stockRow){
	$stockRow['SisearaReplica']=0;
    $stockRow['Replica']='NO';
	save($stockRow);
	$contador=2;
    While($contador <= $stockRow['Cantidad']){
		$replica = NewRegister('Asignacion de Dispositivos');
		$replica['Area']=$stockRow['Area'];
		$replica['Contrato']=$stockRow['Contrato'];
		$replica['IDAREA']=$stockRow['IDAREA'];
		$replica['Clasificacion Dispositivo']=$stockRow['Clasificacion Dispositivo'];
		$replica['Consumible 1']=$stockRow['Consumible 1'];
		$replica['Consumible 2']=$stockRow['Consumible 2'];
		$replica['idCON']=$stockRow['idCON'];
		$replica['Modelo']=$stockRow['Modelo'];
		$replica['Replica']='NO';
		$replica['SisearaReplica']=0;
		$contador++;
		save($replica);
	}
}