foreach(DBForm('Programación de Servicios')->WHERE('Bandera','=','12')->get() AS $stockRow){
    $contador=0;
    foreach(DBForm('Equipo Sensible')->WHERE('IDCON','=',$stockRow['idcont'])->get() AS $Equipo){
        $Registro=NewRegister('Equipos con Sensibilidad');
        $Registro['Equipo Sensible']=$Equipo['Equipo'];
	    $Registro['Area']=$Equipo['Area'];
        $Registro['Idprogr']=$stockRow['ID'];
        $Registro['Idprograma']=$stockRow['Idprog'];
        $Registro['idcon']=$stockRow['idcont'];
        $Registro['Frecuencia a realizar']=$Equipo['Frecuencia de Inspeccion'];	
        $contador++;
        save($Registro);         
    }
    $stockRow['contador']=$contador;
    $stockRow['Bandera']=0;
    save($stockRow);			
}