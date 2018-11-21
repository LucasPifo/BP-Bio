foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Generando')->get() AS $stockRow){
    $Materia = $stockRow['Materias Primas para esta fecha'];
    $array_Materia = explode(',', $Materia);
    $num_Materia = count($array_Materia);
    foreach(DBForm('Materia Prima con Sensibilidad')->WHERE('Idprogr','=',$stockRow['ID Programación'])->get() AS $MateriasPrimas){
        for($i=0; $i<$num_Materia; $i++){
            if($array_Materia[$i] == $MateriasPrimas['Materia Prima Sensible']){
               $MateriaPrima = NewRegister('Materias Primas');
               $MateriaPrima['Materia']=$MateriasPrimas['Materia Prima Sensible'];
               $MateriaPrima['NST']=$stockRow['N.S.T'];
               $MateriaPrima['Fecha']=$stockRow['Fecha de ejecucion'];
               $MateriaPrima['Cliente']=$stockRow['Cliente'];
               $MateriaPrima['Contrato']=$stockRow['Contrato'];
               $MateriaPrima['Tecnico']=$MateriasPrimas['Tecnico'];
               $MateriaPrima['QR']=cambiarcaracter($MateriasPrimas['Materia Prima Sensible']);
               $MateriaPrima['LlaveQR']=$stockRow['N.S.T'].$MateriasPrimas['Materia Prima Sensible'];
               $MateriaPrima['Programa']=$stockRow['Programa'];
               $MateriaPrima['Servicio']=$stockRow['Servicio'];
               save($MateriaPrima);
            }
        }
    }
    $stockRow['Estatus']='Activo';
    $stockRow['Bandera']='0';
    save($stockRow);
}
function cambiarcaracter($s){
	$s = str_replace("ñ","n",$s);
	$s = str_replace("Ñ","N",$s);
	$s = str_replace("á","a",$s);
	$s = str_replace("é","e",$s);
	$s = str_replace("í","i",$s);
	$s = str_replace("ó","o",$s);
	$s = str_replace("ú","u",$s);
	$s = str_replace("Á","A",$s);
	$s = str_replace("É","E",$s);
	$s = str_replace("Í","I",$s);
	$s = str_replace("Ó","O",$s);
	$s = str_replace("Ú","U",$s);
	return $s;
}