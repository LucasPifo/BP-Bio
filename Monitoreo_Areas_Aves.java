foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Generando')->get() AS $Admin){
    $Contador=0;
    $ServicioAsociado = $Admin['Servicio asociado'];
    foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$Admin['idcont'])->WHERE('Nivel de Escalacion','=','1')->WHERE('Tipo de servicio','=','Monitoreo de Actividad Aves')->get() AS $NivelEscala){
        $Contador++;
    }
    foreach(DBForm('Area Monitoreo de Actividad Aves')->WHERE('IDPROG','=',$Admin['ID Programación'])->get() AS $AreasDisp){
        $Administracion=NewRegister('Areas con Actividad Aves');
        $Administracion['Cliente']=$Admin['Cliente'];
        $Administracion['Contrato']=$Admin['Contrato'];
        $Administracion['Fecha']=$Admin['Fecha de ejecucion'];
        $Administracion['Estatus']='Pendiente';
        $Administracion['Area']=$AreasDisp['Area'];
        $Administracion['Tecnico que firma']=$AreasDisp['Tecnico'];
        $Administracion['N.ST.']=$Admin['N.S.T'];
        $Administracion['Servicio']=$Admin['Servicio'];
        $Administracion['Programa']=$Admin['Programa'];
        $Administracion['Idcliente']=$Admin['Idctl'];
        $Administracion['Idcon']=$Admin['idcont'];
        $Administracion['IDAREA']=$AreasDisp['IdArea'];
	$Administracion['QR Area']=cambiarcaracter($AreasDisp['Area']);
	$Administracion['Relacion Area']=$Admin['N.S.T'].cambiarcaracter($AreasDisp['Area']);
        $Administracion['Bandera']='1';
        save($Administracion);
    }
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