foreach(DBForm('Programación de Servicios')->WHERE('Bandera','=','11')->get() AS $stockRow){
    $contador=0;
    foreach(DBForm('Analisis de riesgos')->WHERE('IDCON','=',$stockRow['idcont'])->get() AS $Areas){
        $Registro=NewRegister('Areas con sensibilidad');
        $Registro['Area Sensible']=$Areas['Area'];
	    $Registro['IdArea']=$Areas['ID Areas Sensibles'];
        $Registro['Idprog']=$stockRow['ID'];
        $Registro['Idprograma']=$stockRow['Idprog'];
        $Registro['Idcon']=$stockRow['idcont'];
        $Registro['Frecuencia a Realizar']=$Areas['Frecuencia de Inspeccion'];	
        $contador++;
        save($Registro); 
    }
    $stockRow['contador']=$contador;
    $stockRow['Bandera']=0;
    save($stockRow);			
}
