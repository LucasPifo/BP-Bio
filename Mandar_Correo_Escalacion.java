$contador = 0;
foreach(DBForm('Administración de Servicios')->WHERE('campoafectado','=','Escala')->get() AS $Administracion){  
    $fecha_inicio = $Administracion['Fecha_Terminada'];
    $tipo_servicio = $Administracion['Tipos de Servicios'];
    $areaslist=[];
    $dispolist=[];
    $niveleslist=[];
    $inspeccionlist=[];
    $fechaInicioAray = [];
    $fechaFinAray = [];
    $escalaadmin=0;
    switch($tipo_servicio){
        case "Monitoreo de roedores exteriores" :
            foreach(DBForm('Area con Dispositivos Exteriores')->WHERE('IDPROG','=',$Administracion['ID Programación'])->get() AS $AreasDisp){
                $niveles_por_area = [];
                foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->get() AS $Monitoreo){
                    array_push($niveles_por_area, $Monitoreo['Nivel de Escalacion']);
                }
                $niveles_unicos = array_values(array_unique($niveles_por_area));
                rsort($niveles_unicos);
                $nivel_mayor = $niveles_unicos[0];
                $contregis=0;
                foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo2){
                    if($Monitoreo2['Nivel de Escalacion']==$nivel_mayor){
                        $contregis++;
                    }
                }
                if($contregis>0){
                    $nivel_total=$nivel_mayor+1;   
                }else{
                    $nivel_total=$nivel_mayor;  
                }
                foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$Administracion['idcont'])->WHERE('Tipo de servicio','=',$tipo_servicio)->WHERE('Nivel de Escalacion','=',$nivel_total)->get() AS $Niveles){
                }
                foreach(DBForm('Monitoreo de Dispositivos de Control Exteriores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo1){
                    foreach(DBForm('Asignacion de Dispositivos')->WHERE('Consecutivo','=',$Monitoreo1['IDASGD'])->get() AS $Asigdisp){
                        switch($Niveles['Inspeccion']){
                            case "3 semanas primera diario" :
                                $fecha_ini = strtotime( '+1 day' , strtotime($fecha_inicio));
                                $fecha_ini = date( 'Y-m-j' , $fecha_ini);
                                $fecha_reset = strtotime( '+23 day' , strtotime($fecha_inicio));
                                $fecha_reset = date( 'Y-m-j' , $fecha_reset );
                                $fecha_fina = strtotime( '+22 day' , strtotime($fecha_inicio));
                                $fecha_fina = date( 'Y-m-j' , $fecha_fina);
                                $Asigdisp['Fecha que resetea el nivel'] = $fecha_reset;
                                $Asigdisp['Nivel general del dispositivo'] = $nivel_total;
                                array_push($areaslist,$Asigdisp['Area']);
                                array_push($dispolist,$Asigdisp['Numero de dispositivo QR']);
                                array_push($niveleslist,$Asigdisp['Nivel general del dispositivo']);
                                array_push($inspeccionlist,$Niveles['Inspeccion']);
                                array_push($fechaInicioAray, $fecha_ini);
                                array_push($fechaFinAray, $fecha_fina);
                                save($Asigdisp);
                                $escalaadmin++;
                            break;
                            case "1 semana" :
                                $fecha_reset = strtotime( '+8 day' , strtotime($fecha_inicio));
                                $fecha_reset = date( 'Y-m-j' , $fecha_reset ); 
                                $fecha_ini = strtotime( '+7 day' , strtotime($fecha_inicio));
                                $fecha_ini = date( 'Y-m-j' , $fecha_ini);
                                $fecha_fina = $fecha_ini;
                                $Asigdisp['Fecha que resetea el nivel'] = $fecha_reset;
                                $Asigdisp['Nivel general del dispositivo'] = $nivel_total;
                                array_push($areaslist,$Asigdisp['Area']);
                                array_push($dispolist,$Asigdisp['Numero de dispositivo QR']);
                                array_push($niveleslist,$Asigdisp['Nivel general del dispositivo']);
                                array_push($inspeccionlist,$Niveles['Inspeccion']);
                                array_push($fechaInicioAray, $fecha_ini);
                                array_push($fechaFinAray, $fecha_fina);
                                save($Asigdisp);
                                $escalaadmin++;
                            break;
                        }
                    }                    
                }           
                unset($niveles_por_area);
            } 
            $numero_inspecciones=count($inspeccionlist);
            $nivellistunico=array_values(array_unique($niveleslist));
            $conlisnivel=count($nivellistunico);
            $inspeccionunico=array_values(array_unique($inspeccionlist));
            $numero_insp_unicas=count($inspeccionunico);
            $areasunico=array_values(array_unique($areaslist));
            $numareas_unicas=count($areasunico);
            $areasydispositivos="";
            $fechaInicioAray_count = count($fechaInicioAray);
            $fechaInicioAray_unicos =array_values(array_unique($fechaInicioAray));
            $fechaFinAray_count = count($fechaFinAray);
            $fechaFinAray_unicos = array_values(array_unique($fechaFinAray));
            if($conlisnivel > 1){
                if($numero_insp_unicas > 1){
                    for($a=0; $a<$numero_insp_unicas; $a++){
                        $areasydispositivos .="$inspeccionunico[$a]<br><br>Areas:<br>";
                        $areas_inspeccion = [];
                        for($c=0;$c<$numero_inspecciones; $c++){
                            if($inspeccionunico[$a]==$inspeccionlist[$c]){
                                array_push($areas_inspeccion, $areaslist[$c]);
                            }
                        }
                        $areasunico=array_values(array_unique($areas_inspeccion));
                        $numareas_unicas=count($areasunico);
                        for($b=0; $b<$numareas_unicas; $b++){
                            $areasydispositivos .="$areasunico[$b]<br>";
                            for($c=0;$c<$numero_inspecciones; $c++){
                                if($inspeccionunico[$a]==$inspeccionlist[$c] && $areasunico[$b]==$areaslist[$c]){
                                    $areasydispositivos .= "$dispolist[$c]<br>";
                                }
                            }	
                        }
                        $areasydispositivos .="<br><br>";
                        sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha de : {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear un <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia):<br>Agregar las areas y dispositivos siguientes: $areasydispositivos Fecha de inicio:<br> $fechaInicioAray_unicos[$a]<br> Fecha final: $fechaFinAray_unicos[$a]</b>");
                        unset($areas_inspeccion);
                    }
                }else{
                    if($escalaadmin>0){
                        for($b=0; $b<$numareas_unicas; $b++){
                            $areasydispositivos.="$areasunico[$b]<br>";
                            for($c=0;$c<$numero_inspecciones; $c++){
                                if($areasunico[$b]==$areaslist[$c]){
                                    $areasydispositivos .= "$dispolist[$c]<br>";
                                }
                            }
                            $areasydispositivos.="<br>";
                        }
                        sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha: {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear una <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia): {$Niveles['Inspeccion']}<br>Agregar las areas y dispositivos siguientes:<br>$areasydispositivos Fecha de inicio: $fechaInicioAray[0]<br> Fecha final: $fechaFinAray[0]</b>");
                    }
                }
            }else{
                if($escalaadmin > 0){
                    for($b=0; $b<$numareas_unicas; $b++){
                        $areasydispositivos.="$areasunico[$b]<br>";
                        for($c=0;$c<$numero_inspecciones; $c++){
                            if($areasunico[$b]==$areaslist[$c]){
                                $areasydispositivos .= "$dispolist[$c]<br>";
                            }
                        }
                        $areasydispositivos.="<br>";
                    }
                    sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha: {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear una <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia): {$Niveles['Inspeccion']}<br>Agregar las areas y dispositivos siguientes:<br>$areasydispositivos Fecha de inicio: $fechaInicioAray[0]<br> Fecha final: $fechaFinAray[0]</b>");
                }
            }
        break;
        case "Monitoreo de roedores interiores" :
            foreach(DBForm('Area con Dispositivos Interiores')->WHERE('IDPROG','=',$Administracion['ID Programación'])->get() AS $AreasDisp){
                $niveles_por_area = [];
                foreach(DBForm('Monitoreo de Dispositivos de Control Interiores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->get() AS $Monitoreo){
                    array_push($niveles_por_area, $Monitoreo['Nivel de Escalacion']);
                }
                $niveles_unicos = array_values(array_unique($niveles_por_area));
                rsort($niveles_unicos);
                $nivel_mayor = $niveles_unicos[0];
                $contregis=0;
                foreach(DBForm('Monitoreo de Dispositivos de Control Interiores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo2){
                    if($Monitoreo2['Nivel de Escalacion']==$nivel_mayor){
                        $contregis++;
                    }
                }
                if($contregis>0){
                    $nivel_total=$nivel_mayor+1;   
                }else{
                    $nivel_total=$nivel_mayor;  
                }
                foreach(DBForm('Nivel de Escalación')->WHERE('Idcon','=',$Administracion['idcont'])->WHERE('Tipo de servicio','=',$tipo_servicio)->WHERE('Nivel de Escalacion','=',$nivel_total)->get() AS $Niveles){
                }
                foreach(DBForm('Monitoreo de Dispositivos de Control Interiores')->WHERE('N.S.T','=',$Administracion['N.S.T'])->WHERE('Area','=',$AreasDisp['Area'])->WHERE('Existe Nivel de Escalación','=','SI')->get() AS $Monitoreo1){
                    foreach(DBForm('Asignacion de Dispositivos')->WHERE('Consecutivo','=',$Monitoreo1['IDASGD'])->get() AS $Asigdisp){
                        switch($Niveles['Inspeccion']){
                            case "3 semanas primera diario" :
                                $fecha_ini = strtotime( '+1 day' , strtotime($fecha_inicio));
                                $fecha_ini = date( 'Y-m-j' , $fecha_ini);
                                $fecha_reset = strtotime( '+23 day' , strtotime($fecha_inicio));
                                $fecha_reset = date( 'Y-m-j' , $fecha_reset );
                                $fecha_fina = strtotime( '+22 day' , strtotime($fecha_inicio));
                                $fecha_fina = date( 'Y-m-j' , $fecha_fina);
                                $Asigdisp['Fecha que resetea el nivel'] = $fecha_reset;
                                $Asigdisp['Nivel general del dispositivo'] = $nivel_total;
                                array_push($areaslist,$Asigdisp['Area']);
                                array_push($dispolist,$Asigdisp['Numero de dispositivo QR']);
                                array_push($niveleslist,$Asigdisp['Nivel general del dispositivo']);
                                array_push($inspeccionlist,$Niveles['Inspeccion']);
                                array_push($fechaInicioAray, $fecha_ini);
                                array_push($fechaFinAray, $fecha_fina);
                                save($Asigdisp);
                                $escalaadmin++;
                            break;
                            case "1 semana" :
                                $fecha_reset = strtotime( '+8 day' , strtotime($fecha_inicio));
                                $fecha_reset = date( 'Y-m-j' , $fecha_reset ); 
                                $fecha_ini = strtotime( '+7 day' , strtotime($fecha_inicio));
                                $fecha_ini = date( 'Y-m-j' , $fecha_ini);
                                $fecha_fina = $fecha_ini;
                                $Asigdisp['Fecha que resetea el nivel'] = $fecha_reset;
                                $Asigdisp['Nivel general del dispositivo'] = $nivel_total;
                                array_push($areaslist,$Asigdisp['Area']);
                                array_push($dispolist,$Asigdisp['Numero de dispositivo QR']);
                                array_push($niveleslist,$Asigdisp['Nivel general del dispositivo']);
                                array_push($inspeccionlist,$Niveles['Inspeccion']);
                                array_push($fechaInicioAray, $fecha_ini);
                                array_push($fechaFinAray, $fecha_fina);
                                save($Asigdisp);
                                $escalaadmin++;
                            break;
                        }
                    }                    
                }           
                unset($niveles_por_area);
            } 
            $numero_inspecciones=count($inspeccionlist);
            $nivellistunico=array_values(array_unique($niveleslist));
            $conlisnivel=count($nivellistunico);
            $inspeccionunico=array_values(array_unique($inspeccionlist));
            $numero_insp_unicas=count($inspeccionunico);
            $areasunico=array_values(array_unique($areaslist));
            $numareas_unicas=count($areasunico);
            $areasydispositivos="";
            
            $fechaInicioAray_count = count($fechaInicioAray);
            $fechaInicioAray_unicos =array_values(array_unique($fechaInicioAray));
            $fechaFinAray_count = count($fechaFinAray);
            $fechaFinAray_unicos = array_values(array_unique($fechaFinAray));
            
            if($conlisnivel > 1){
                if($numero_insp_unicas > 1){
                    for($a=0; $a<$numero_insp_unicas; $a++){
                        $areasydispositivos .="$inspeccionunico[$a]<br><br>Areas:<br>";
                        $areas_inspeccion = [];
                        for($c=0;$c<$numero_inspecciones; $c++){
                            if($inspeccionunico[$a]==$inspeccionlist[$c]){
                                array_push($areas_inspeccion, $areaslist[$c]);
                            }
                        }
                        $areasunico=array_values(array_unique($areas_inspeccion));
                        $numareas_unicas=count($areasunico);
                        for($b=0; $b<$numareas_unicas; $b++){
                            $areasydispositivos .="$areasunico[$b]<br>";
                            for($c=0;$c<$numero_inspecciones; $c++){
                                if($inspeccionunico[$a]==$inspeccionlist[$c] && $areasunico[$b]==$areaslist[$c]){
                                    $areasydispositivos .= "$dispolist[$c]<br>";
                                }
                            }	
                        }
                        $areasydispositivos .="<br><br>";
                        sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha de : {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear un <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia):<br>Agregar las areas y dispositivos siguientes: $areasydispositivos Fecha de inicio:<br> $fechaInicioAray_unicos[$a]<br> Fecha final: $fechaFinAray_unicos[$a]</b>");
                        unset($areas_inspeccion);
                    }
                }else{
                    if($escalaadmin>0){
                        for($b=0; $b<$numareas_unicas; $b++){
                            $areasydispositivos.="$areasunico[$b]<br>";
                            for($c=0;$c<$numero_inspecciones; $c++){
                                if($areasunico[$b]==$areaslist[$c]){
                                    $areasydispositivos .= "$dispolist[$c]<br>";
                                }
                            }
                            $areasydispositivos.="<br>";
                        }
                        sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha: {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear una <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia): {$Niveles['Inspeccion']}<br>Agregar las areas y dispositivos siguientes:<br>$areasydispositivos Fecha de inicio: $fechaInicioAray[0]<br> Fecha final: $fechaFinAray[0]</b>");
                    }
                }
            }else{
                if($escalaadmin > 0){
                    for($b=0; $b<$numareas_unicas; $b++){
                        $areasydispositivos.="$areasunico[$b]<br>";
                        for($c=0;$c<$numero_inspecciones; $c++){
                            if($areasunico[$b]==$areaslist[$c]){
                                $areasydispositivos .= "$dispolist[$c]<br>";
                            }
                        }
                        $areasydispositivos.="<br>";
                    }
                    sendEmail("biosinsasistema2@gmail.com","Programacion por escalacion","Te informamos que el servicio : {$Administracion['N.S.T']} con fecha: {$Administracion['Fecha de ejecucion']} del contrato : {$Administracion['Contrato']}, ha tenido dispositivos con escalacion. <br><br> Favor de crear una <b>ESQUEMA DE PROGRAMACION</b> en dicho contrato con las siguientes caracteristicas:<br> <b>Tipo de programacion: Escalacion<br> Inspeccion(Frecuencia): {$Niveles['Inspeccion']}<br>Agregar las areas y dispositivos siguientes:<br>$areasydispositivos Fecha de inicio: $fechaInicioAray[0]<br> Fecha final: $fechaFinAray[0]</b>");
                }
            }
        break;            
    }
    $contador++;
    $Administracion['campoafectado']='Escalado';
    save($Administracion); 
}