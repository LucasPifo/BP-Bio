foreach(DBForm('Programación de Servicios')->WHERE('Bandera','=','13')->get() AS $stockRow){
    $contador=0;
    foreach(DBForm('Materia Prima Sensible')->WHERE('IDCON','=',$stockRow['idcont'])->get() AS $Equipo){
        if($Equipo['Frecuencia de Inspeccion']!='Sin Inspeccion'){
            $Registro=NewRegister('Materia Prima con Sensibilidad');
            $Registro['Materia Prima Sensible']=$Equipo['Materias Primas'];
            $Registro['Idprogr']=$stockRow['ID'];
            $Registro['Idprograma']=$stockRow['Idprog'];
            $Registro['idcon']=$stockRow['idcont'];
            $Registro['Frecuencia a Realizar']=$Equipo['Frecuencia de Inspeccion'];	
            $contador++;
            save($Registro); 
        }
    }
    $stockRow['contador']=$contador;
    $stockRow['Bandera']=0;
    save($stockRow);			
}