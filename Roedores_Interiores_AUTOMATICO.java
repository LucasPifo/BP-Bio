foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Activo')->WHERE('Fecha de ejecucion','=',currentDate())->WHERE('Servicio asociado','=','Monitoreo de roedores interiores')->get() AS $Admin){
    $Contador=0;
    $ServicioAsociado = $Admin['Servicio asociado'];
    foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$Admin['idcont'])->WHERE('Nivel de Escalacion','=','1')->WHERE('Tipo de servicio','=','Monitoreo de roedores interiores')->get() AS $NivelEscala){
        $Contador++;
    }
    foreach(DBForm('Areas del Servicio')->WHERE('IDPROG','=',$Admin['ID Programación'])->get() AS $AreasDisp){
        foreach(DBForm('Asignacion de Dispositivos')->WHERE('IDAREA','=',$AreasDisp['IdArea'])->WHERE('Clasificacion Dispositivo','=','RI')->get() AS $Dispo){
            $Administracion=NewRegister('Monitoreo de Dispositivos de Control Interiores');
            $Administracion['No. Dispositivo']=$Dispo['Numero de dispositivo QR'];
            $Administracion['Contrato']=$Admin['Contrato'];
            $Administracion['LlaveQR']=$Admin['N.S.T'].$Dispo['Numero de dispositivo QR'];
            $Administracion['IDASGD']=$Dispo['Consecutivo'];
            $Administracion['Area']=$AreasDisp['Area'];
            $Administracion['N.S.T']=$Admin['N.S.T'];
            $Administracion['Cliente']=$Admin['Cliente'];
            $Administracion['Fecha']=$Admin['Fecha de ejecucion'];
            $Administracion['Técnico que firma']=$AreasDisp['Tecnico'];
            $Administracion['Personal Encargado']=$Admin['Personal Encargado'];
            $Administracion['Tipo de servicio']=$Admin['Servicio asociado'];
            $Administracion['Servicio']=$Admin['Servicio'];
            $Administracion['Programa']=$Admin['Programa'];
            $Administracion['Consumible']=$Dispo['Consumible 1'];
            $Administracion['Contacto']=$Admin['Contacto'];
            $numerito=$Dispo['Numero de dispositivo QR'];
            $res=explode( '-', $numerito ) ;	
            $resultado=array_pop($res);
            $Administracion['Numerodispositivoabre']="RI-".$resultado;
            save($Administracion);
        }
    }
    $Admin['Estatus']='Activo';
    $Admin['Bandera']='0';
    save($Admin);
}