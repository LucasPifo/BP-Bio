foreach(DBForm('Administración de Servicios')->WHERE('campoafectado','=','Escalado')->get() AS $Administracion){
    $tipo_servicio = $Administracion['Tipos de Servicios'];
    switch($tipo_servicio){
        case "Monitoreo de roedores exteriores" :
            foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo){
                foreach(DBForm('Asignacion de Dispositivos')->WHERE('Consecutivo','=',$Monitoreo['IDASGD'])->get() AS $Asigdisp){
                    $Monitoreo['Nivel de Escalacion']=$Asigdisp['Nivel general del dispositivo'];
                    save($Monitoreo);
                }
            }
        break;
        case "Monitoreo de roedores interiores" :
            foreach(DBForm('Monitoreo de Dispositivos de Control Interiores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo){
                foreach(DBForm('Asignacion de Dispositivos')->WHERE('Consecutivo','=',$Monitoreo['IDASGD'])->get() AS $Asigdisp){
                    $Monitoreo['Nivel de Escalacion']=$Asigdisp['Nivel general del dispositivo'];
                    save($Monitoreo);
                }
            }
        break;    
    }
    $Administracion['campoafectado']='Cambio nivel';
    save($Administracion);
}