$contador = 0;
foreach(DBForm('Administración de Servicios')->WHERE('sumaescalacion','>','0')->WHERE('Estatus Escalacion','=','sin escalar')->get() AS $Administracion){   
    $tipo_servicio = $Administracion['Tipos de Servicios'];
    $dispositivos = [];
    $niveles = [];
    $dispo_escala = [];
    switch($tipo_servicio){
        case "Monitoreo de roedores exteriores" :
            foreach(DBForm('Areas del Servicio')->WHERE('IDPROG','=',$Administracion['ID Programación'])->get() AS $AreasDisp){
                $dispo_area = 0;
                foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->get() AS $Monitoreo){
                    if($Monitoreo['Existe Nivel de Escalación'] == 'SI'){
                        if($Monitoreo['Nivel de Escalacion'] > 0){
                            $dispo_area++;
                            $nivel_todos = $Monitoreo['Nivel de Escalacion'];
                        }else{
                            $Monitoreo['Nivel de Escalacion'] = $Monitoreo['Nivel de Escalacion'] + 1;
                            save($Monitoreo);
                            array_push($niveles, $Monitoreo['Nivel de Escalacion']);
                            array_push($dispo_escala, $Monitoreo['IDMDCE']);
                        }
                    }
                }
                foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->get() AS $Monitoreo1){
                    if($dispo_area > 0){
                        $Monitoreo1['Nivel de Escalacion'] = $nivel_todos + 1;
                        save($Monitoreo1);
                        array_push($niveles, $Monitoreo1['Nivel de Escalacion']);
                        array_push($dispo_escala, $Monitoreo1['IDMDCE']);
                    }
                }
            }
        break;
    }
    $contador++;
    $Administracion['Estatus Escalacion']=$dispo_area;
    save($Administracion); 
}