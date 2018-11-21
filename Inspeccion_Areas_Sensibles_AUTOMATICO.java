foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Activo')->WHERE('Fecha de ejecucion','=',currentDate())->WHERE('Servicio asociado','=','Inspección de Areas Sensibles')->get() AS $stockRow){
    $areas = $stockRow['Areas sensibles para esta fecha'];
    $array_areas = explode(',', $areas);
    $num_areas = count($array_areas);
    foreach(DBForm('Areas con sensibilidad')->WHERE('Idprog','=',$stockRow['ID Programación'])->get() AS $AreasSensibles){
        for($i=0; $i<$num_areas; $i++){
            if($array_areas[$i] == $AreasSensibles['Area Sensible']){
                $NuevaArea = NewRegister('Inspeccion de Areas Sensibles');
                $NuevaArea['Area']=$AreasSensibles['Area Sensible'];
                $NuevaArea['NST']=$stockRow['N.S.T'];
                $NuevaArea['Fecha']=$stockRow['Fecha de ejecucion'];
                $NuevaArea['Cliente']=$stockRow['Cliente'];
                $NuevaArea['Contrato']=$stockRow['Contrato'];
                $NuevaArea['Tecnico']=$AreasSensibles['Tecnico'];
                $NuevaArea['QR']=cambiarcaracter($AreasSensibles['Area Sensible']);
                $NuevaArea['LlaveQR']=$stockRow['N.S.T'].$AreasSensibles['Area Sensible'];
                $NuevaArea['Programa']=$stockRow['Programa'];
                $NuevaArea['Servicio']=$stockRow['Servicio'];
                save($NuevaArea);
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