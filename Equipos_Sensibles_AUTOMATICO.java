foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Activo')->WHERE('Fecha de ejecucion','=',currentDate())->WHERE('Servicio asociado','=','Inspección de Equipos Sensibles')->get() AS $stockRow){
    $equipo = $stockRow['Areas con Equipos sensibles para esta fecha'];
    $array_equipo = explode(',', $equipo);
    $num_equipo = count($array_equipo);
    foreach(DBForm('Equipos con Sensibilidad')->WHERE('Idprogr','=',$stockRow['ID Programación'])->get() AS $EquiposSensibles){
        for($i=0; $i<$num_equipo; $i++){
            if($array_equipo[$i] == $EquiposSensibles['Equipo Sensible']){
               $NuevoEquipo = NewRegister('Inspeccion de Equipos Sensibles');
               $NuevoEquipo['Equipo']=$EquiposSensibles['Equipo Sensible'];
               $NuevoEquipo['NST']=$stockRow['N.S.T'];
               $NuevoEquipo['Fecha']=$stockRow['Fecha de ejecucion'];
               $NuevoEquipo['Area']=$EquiposSensibles['Area'];
               $NuevoEquipo['Cliente']=$stockRow['Cliente'];
               $NuevoEquipo['Contrato']=$stockRow['Contrato'];
               $NuevoEquipo['Tecnico que Firma']=$EquiposSensibles['Tecnico'];
               $NuevoEquipo['QR']=cambiarcaracter($EquiposSensibles['Equipo Sensible']);
               $NuevoEquipo['LlaveQR']=$stockRow['N.S.T'].$EquiposSensibles['Equipo Sensible'];
               $NuevoEquipo['Programa']=$stockRow['Programa'];
               $NuevoEquipo['Servicio']=$stockRow['Servicio'];
               save($NuevoEquipo);
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