foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Activo')->WHERE('Fecha de ejecucion','=',currentDate())->get() AS $stockRow){
    $Contador=0;
    $acciones = "";
    $detonantes = "";
    foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$stockRow['idcont'])->WHERE('Tipo de servicio','=','Monitoreo de roedores exteriores')->get() AS $Nivel){
        $Contador++;
    }
    if($stockRow['tipo_programacion']=="Normal"){
        foreach(DBForm('Area con Dispositivos Exteriores')->WHERE('IDPROG','=',$stockRow['ID Programación'])->get() AS $AreasDisp){
            foreach(DBForm('Asignacion de Dispositivos')->WHERE('Contrato','=',$stockRow['Contrato'])->WHERE('IDAREA','=',$AreasDisp['IdArea'])->WHERE('Clasificacion Dispositivo','=','RE')->get() AS $Asignacion){
                $Administracion=NewRegister('Monitoreo de Dispositivos de Control Exteriores');
                $Administracion['No. Dispositivo']=$Asignacion['Numero de dispositivo QR'];
                $Administracion['Contrato']=$stockRow['Contrato'];
                $Administracion['Llave QR']=$stockRow['N.S.T'].$Asignacion['Numero de dispositivo QR'];
                $Administracion['IDASGD']=$Asignacion['Consecutivo'];
                $Administracion['Area']=$AreasDisp['Area'];
                $Administracion['N.S.T']=$stockRow['N.S.T'];
                $Administracion['Cliente']=$stockRow['Cliente'];
                $Administracion['Fecha']=$stockRow['Fecha de ejecucion'];
                $Administracion['Tecnico que firma']=$AreasDisp['Tecnico'];
                $Administracion['Personal Encargado']=$stockRow['Personal Encargado'];
                $Administracion['Tipo de Monitoreo']=$stockRow['Servicio asociado'];
                $Administracion['Servicio']=$stockRow['Servicio'];
                $Administracion['Programa']=$stockRow['Programa'];
                $Administracion['Consumible']=$Asignacion['Consumible 1'];
                $Administracion['Contacto']=$stockRow['Contacto'];
                if($Contador > 0){
                    $Administracion['Nivel de Escalacion']=$Asignacion['Nivel general del dispositivo'];
                    $nivel_mas_uno = $Asignacion['Nivel general del dispositivo']+1;
                    foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$stockRow['idcont'])->WHERE('Tipo de servicio','=','Monitoreo de roedores exteriores')->get() AS $Nivel2){
                        if($Nivel2['Nivel de Escalacion']==$nivel_mas_uno){
                           $acciones = $Nivel2['Acciones'];
                        }
                        if($Nivel2['Nivel de Escalacion']==$Asignacion['Nivel general del dispositivo']){
                           $detonantes = $Nivel2['Detonantes'];
                        }
                        if($Asignacion['Nivel general del dispositivo']=='0'){
                            if($Nivel2['Nivel de Escalacion']=='1'){
                                $acciones = $Nivel2['Acciones'];
                                $detonantes = $Nivel2['Detonantes'];
                            }
                        }
                    }
                }
                $Administracion['Detonantes'] = $detonantes;
                $Administracion['Acciones'] = $acciones;
                $numerito=$Asignacion['Numero de dispositivo QR'];
                $res=explode( '-', $numerito );	
                $resultado=array_pop($res);
                $Administracion['Numerodispositivoabre']="RE-".$resultado;
                save($Administracion);
            }
        }
    }else{
        foreach(DBForm('Areas con Escalacion')->WHERE('IDPROG','=',$stockRow['ID Programación'])->get() AS $Areasescala){
            $dispoarea=$Areasescala['Dispositivos'];
            $dispo=explode('~',$dispoarea);
            $discant=count($dispo);
            foreach(DBForm('Asignacion de Dispositivos')->WHERE('Contrato','=',$stockRow['Contrato'])->WHERE('Area','=',$Areasescala['Areas con Escalacion'])->WHERE('Clasificacion Dispositivo','=','RE')->get() AS $Adis){
                for($i=0;$i<$discant;$i++){
                    if($dispo[$i]==$Adis['Numero de dispositivo QR']){                 
                        $Dispositivo=NewRegister('Monitoreo de Dispositivos de Control Exteriores');
                        $Dispositivo['No. Dispositivo']=$Adis['Numero de dispositivo QR'];
                        $Dispositivo['Contrato']=$stockRow['Contrato'];
                        $Dispositivo['Llave QR']=$stockRow['N.S.T'].$Adis['Numero de dispositivo QR'];
                        $Dispositivo['IDASGD']=$Adis['Consecutivo'];
                        $Dispositivo['N.S.T']=$stockRow['N.S.T'];
                        $Dispositivo['Area']=$Areasescala['Areas con Escalacion'];
                        $Dispositivo['Cliente']=$stockRow['Cliente'];
                        $Dispositivo['Fecha']=$stockRow['Fecha de ejecucion'];
                        $Dispositivo['Tecnico que firma']=$Areasescala['Tecnico'];
                        $Dispositivo['Personal Encargado']=$stockRow['Personal Encargado'];
                        $Dispositivo['Tipo de Monitoreo']=$stockRow['Servicio asociado'];
                        $Dispositivo['Servicio']=$stockRow['Servicio'];
                        $Dispositivo['Programa']=$stockRow['Programa'];
                        $Dispositivo['Consumible']=$Adis['Consumible 1'];
                        $Dispositivo['Contacto']=$stockRow['Contacto'];
                        if($Contador > 0){
                            $Dispositivo['Nivel de Escalacion']=$Adis['Nivel general del dispositivo'];
                            $nivel_mas_uno = $Adis['Nivel general del dispositivo']+1;
                            foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$stockRow['idcont'])->WHERE('Tipo de servicio','=','Monitoreo de roedores exteriores')->get() AS $Nivel3){
                                if($Nivel3['Nivel de Escalacion']==$nivel_mas_uno){
                                    $acciones = $Nivel3['Acciones'];
                                }
                                if($Nivel3['Nivel de Escalacion']==$Adis['Nivel general del dispositivo']){
                                    $detonantes = $Nivel3['Detonantes'];
                                }
                            }
                            $Dispositivo['Detonantes']=$detonantes;
                            $Dispositivo['Acciones']=$acciones;
                        }
                        $numerito=$Adis['Numero de dispositivo QR'];
                        $res=explode( '-', $numerito );	
                        $resultado=array_pop($res);
                        $Dispositivo['Numerodispositivoabre']="RE-".$resultado;
                        save($Dispositivo);
                    }
                }
            }
        }
    }
    $stockRow['Estatus']='Activo';
    $stockRow['Bandera']='0';
    save($stockRow);
}