foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Generando')->get() AS $Admin){
    $Contador=0;
    $ServicioAsociado = $Admin['Servicio asociado'];
    foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$Admin['idcont'])->WHERE('Nivel de Escalacion','=','1')->WHERE('Tipo de servicio','=','Monitoreo de Dispositivos de Control Aves')->get() AS $NivelEscala){
        $Contador++;
    }
    foreach(DBForm('Areas del Servicio')->WHERE('IDPROG','=',$Admin['ID Programación'])->get() AS $AreasAves){
        foreach(DBForm('Asignacion de Dispositivos')->WHERE('IDAREA','=',$AreasAves['IdArea'])->WHERE('Clasificacion Dispositivo','=','AV')->get() AS $Asignacion){
            $Dispositivo=NewRegister('Monitoreo de Dispositivos de Control Aves');
            $Dispositivo['No.Dispositivo']=$Asignacion['Numero de dispositivo QR'];
	        $Dispositivo['Dispositivo']=$Asignacion['Modelo'];
            $Dispositivo['Contrato']=$Admin['Contrato'];
            $Dispositivo['LlaveQR']=$Admin['N.S.T'].$Asignacion['Numero de dispositivo QR'];
            $Dispositivo['IDASGD']=$Asignacion['Consecutivo'];
            $Dispositivo['Area Visitada']=$AreasAves['Area'];
            $Dispositivo['NST']=$Admin['N.S.T'];
            $Dispositivo['Cliente']=$Admin['Cliente'];
            $Dispositivo['Fecha']=$Admin['Fecha de ejecucion'];
            $Dispositivo['Tecnico que Firma']=$AreasAves['Tecnico'];
            $Dispositivo['Personal Encargado']=$Admin['Personal Encargado'];
            $Dispositivo['Tipo de Monitoreo']=$Admin['Servicio asociado'];
            $Dispositivo['Servicio']=$Admin['Servicio'];
            $Dispositivo['Programa']=$Admin['Programa'];
            $Dispositivo['Contacto']=$Admin['Contacto'];
            $Dispositivo['Estatus']='Pendiente';
            $numerito=$Asignacion['Numero de dispositivo QR'];
            $res=explode( '-', $numerito ) ;	
            $resultado=array_pop($res);
            $Dispositivo['Numerodispositivoabre']="AV-".$resultado;
            save($Dispositivo);
        }
        $AreasAves['Bandera']='0';
        save($AreasAves);
    }
    $Admin['Estatus']='Activo';
    $Admin['Bandera']='0';
    save($Admin);
}