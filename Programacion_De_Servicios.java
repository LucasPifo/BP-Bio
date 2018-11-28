foreach(DBForm('Programación de Servicios')->WHERE('Estatus Programación','=','Programando')->get() AS $stockRow){
    IF($stockRow['Frecuencia']!='Segun se requiera'){
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_final=$stockRow['Fecha Final de acuerdo a rotacion'];
        $fecha_det=explode("-",$dateToAdd);	 
        $cadacuantosanos=$stockRow['¿Cada cuantos años?'];
        $Anos = $cadacuantosanos*364;
        $cadacuantosdias=$stockRow['¿Cada cuantos días?'];
        $cadacuantassemanas=$stockRow['¿Cada cuantas semanas?'];
        $semanas = $cadacuantassemanas*7;
        $Meses=$stockRow['¿Cada cuantos meses?'];
        $varSwitch = $stockRow['Frecuencia'];
        save($stockRow);
        $cadayears=$cadacuantosanos;
        $cadyear= $cadayears;
        $visitasanuales=0;
        $visitames = $fecha_det[1];
        $mesmi=explode("-",$dateToAdd);
        $mesmismo=$mesmi[1];
        $regis4=1;
        $cada4vecesmes=$Meses;
        $cada4=$cada4vecesmes;
        $primercambio=false;
        $visitasmensuales4veces=0;
        $regis = 0;
        $cadacuantosmeses = $Meses;
        $cadmes = $cadacuantosmeses;
        $primerafecha = true;
        $visitasmensuales = 0;
        $enero=1;
        $febrero=2;
        $marzo=3;
        $abril=4;
        $mayo=5;
        $junio=6;
        $julio=7;
        $agosto=8;
        $sep=9;
        $oct=10;
        $nov=11;
        $dici=12;
        $contador=0;
        While(strtotime($dateToAdd) <= strtotime($fecha_final)){
        $fecha_repetida_cont = 0;
        $contador++;
        $mesca=explode("-",$dateToAdd);
        $mescambio=$mesca[1];
        $regis = 0;
        $primerafecha = true;
        $fecha_det = explode("-",$dateToAdd);
        $timestamp = strtotime( $dateToAdd );
        $diasdmes = date( "t", $timestamp );
        $diadelasemana = date("w",strtotime($dateToAdd));
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadacuantosmeses = 1;
                    }else{
                        $cadacuantosmeses = $cadmes;
                    }foreach(DBForm('Programación de Servicios')->WHERE('Estatus Programación','=','Programando')->get() AS $stockRow){
    IF($stockRow['Frecuencia']!='Segun se requiera'){
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_final=$stockRow['Fecha Final de acuerdo a rotacion'];
        $fecha_det=explode("-",$dateToAdd);	 
        $cadacuantosanos=$stockRow['¿Cada cuantos años?'];
        $Anos = $cadacuantosanos*364;
        $cadacuantosdias=$stockRow['¿Cada cuantos días?'];
        $cadacuantassemanas=$stockRow['¿Cada cuantas semanas?'];
        $semanas = $cadacuantassemanas*7;
        $Meses=$stockRow['¿Cada cuantos meses?'];
        $varSwitch = $stockRow['Frecuencia'];
        save($stockRow);
        $cadayears=$cadacuantosanos;
        $cadyear= $cadayears;
        $visitasanuales=0;
        $visitames = $fecha_det[1];
        $mesmi=explode("-",$dateToAdd);
        $mesmismo=$mesmi[1];
        $regis4=1;
        $cada4vecesmes=$Meses;
        $cada4=$cada4vecesmes;
        $primercambio=false;
        $visitasmensuales4veces=0;
        $regis = 0;
        $cadacuantosmeses = $Meses;
        $cadmes = $cadacuantosmeses;
        $primerafecha = true;
        $visitasmensuales = 0;
        $enero=1;
        $febrero=2;
        $marzo=3;
        $abril=4;
        $mayo=5;
        $junio=6;
        $julio=7;
        $agosto=8;
        $sep=9;
        $oct=10;
        $nov=11;
        $dici=12;
        $contador=0;
        $fechas_de_visitas = [];
        While(strtotime($dateToAdd) <= strtotime($fecha_final)){
        $fecha_repetida_cont = 0;
        $contador++;
        $mesca=explode("-",$dateToAdd);
        $mescambio=$mesca[1];
        $regis = 0;
        $primerafecha = true;
        $fecha_det = explode("-",$dateToAdd);
        $timestamp = strtotime( $dateToAdd );
        $diasdmes = date( "t", $timestamp );
        $diadelasemana = date("w",strtotime($dateToAdd));
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadacuantosmeses = 1;
                    }else{
                        $cadacuantosmeses = $cadmes;
                    }
                    $regis = $regis + $cadacuantosmeses;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Mes']=$fecha_det[1];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Supervisor']=$stockRow['Supervisor']; 
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Sucursal']=$stockRow['Sucursal']; 
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']="Licencia #:".$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']=$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasmensuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
                            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }                        
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;  
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; 
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion2){
                    if($dateToAdd == $Administracion2['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "4 veces por Mes"){
            if($cada4>=2){
                if($primercambio==true){
                    $mesmi=explode("-",$dateToAdd);
                    $mesmismo=$mesmi[1];
                }
                if($contador==$regis4){
                    if($mescambio==$mesmismo){
                        $cada4vecesmes=1;
                        $regis4 = $regis4 + $cada4vecesmes;
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $primercambio=false;
                        $visitasmensuales4veces++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion3){
                            if($dateToAdd == $Administracion3['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }
                    }
                    else{
                        if($primercambio==false){
                            $cada4vecesmes=($cada4-1)*4;
                            $regis4 = $regis4 + $cada4vecesmes;
                            $primercambio=true;
                        }
                    }
                }
            }
            else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal'];
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado']; 
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal']; 
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion4){
                    if($dateToAdd == $Administracion4['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadyear>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadayears = 1;
                    }else{
                        $cadayears = $cadyear;
                    }
                    $regis = $regis + $cadayears;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasanuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion5){
                            if($dateToAdd == $Administracion5['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; 
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion6){
                    if($dateToAdd == $Administracion6['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else{
            $visita = NewRegister('Administración de Servicios');
            $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
            $visita['Idprogsd']=1;
            $visita['ID Programación']=$stockRow['ID'];
            $visita['Idctl']=$stockRow['Idctl'];
            $visita['idcont']=$stockRow['idcont'];
            $visita['Frecuencia']=$stockRow['Frecuencia'];
            $visita['Programa']=$stockRow['Programa'];
            $visita['Estatus']='Activo';
            $visita['Fecha de ejecucion']=$dateToAdd;
            $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
            $visita['Servicio']=$stockRow['Nombre Servicio']; 
            $visita['Cliente']=$stockRow['Cliente']; 
            $visita['Contrato']=$stockRow['Contrato'];
            $visita['Contacto']=$stockRow['Contacto'];
            $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
            $visita['Costo']=$stockRow['Costo'];
            $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
            $visita['Facturable']=$stockRow['Facturable'];
            $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
            $visita['Plaguicida']=$stockRow['Plaguicida'];
            $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
            $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
            $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
            $visita['Ruta']=$stockRow['Ruta'];
            $visita['Vehiculo']=$stockRow['Vehiculo'];
            $visita['Supervisor']=$stockRow['Supervisor'];
            $visita['Sucursal']=$stockRow['Sucursal'];
            $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
            $visita['Colonia']=$stockRow['Colonia'];
            $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
            $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
            $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
            $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
            $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
            $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
            $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
            $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
            $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
            $visita['Mes']=$fecha_det[1]; 
            $visita['Dia']=$fecha_det[2];
            $visitames= $visita['Mes'];
            $diadevisita=$visita['Dia'];
            foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion7){
                if($dateToAdd == $Administracion7['Fecha de ejecucion']){
                    $fecha_repetida_cont++;
                }
            }
            if($fecha_repetida_cont == 0){
                array_push($fechas_de_visitas, $dateToAdd);
                save($visita);
            }
        }
        $varSwitch = $stockRow['Frecuencia'];
        switch($varSwitch){
            case "Anual" :
                $fecharelpica=strtotime('+364 day',strtotime($dateToAdd));	
                $fecharelpica=date('Y-m-j',$fecharelpica);
                $fecha_repl = explode("-",$fecharelpica);
                $mesreplica = $fecha_repl[1];
                $cont=0;
                $contrepli=0;
                $dia = date("N",strtotime($dateToAdd));
                $diareplica = date("N",strtotime($fecharelpica));
                $fecha_det = explode("-",$dateToAdd);
                $diaactual = $fecha_det[2]; 
                $diaactualreplica = $fecha_repl[2];
                $mes = $fecha_det[1];
                $visitadia = ($diaactual) - (1);
                $viadiareplica = ($diaactualreplica) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);
                $fresrepl = strtotime('-'.$viadiareplica.'day',strtotime($fecharelpica));
                $fresrepl = date('Y-m-j',$fresrepl);
                for ($j = 1; $j <= $diaactual; $j++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;				
                    }
                    $fecha_resta = strtotime('+1 day',strtotime($fecha_resta));	
                    $fecha_resta = date('Y-m-j',$fecha_resta);			
                }
                for ($p = 1; $p <= $diaactualreplica; $p++){
                    $diadelasemanareplica = date("N", strtotime($fresrepl));
                    if($diadelasemanareplica == $diareplica){
                        $contrepli++;				
                    }
                    $fresrepl = strtotime('+1 day',strtotime($fresrepl));	
                    $fresrepl = date('Y-m-j',$fresrepl);			
                }
                if($cont == 1){
                    $diaresta = $diaactual - 1;
                    if($diaresta <= 0){
                        $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );		
                    }else{
                        if($mesreplica == $mes){
                            $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                        }else{
                            $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );						
                        }
                    }
                }else if($cont == 5){
                    $dateToAdd=strtotime('+357 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }else if($cont == $contrepli){
                    $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }
                else{
                    $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );	
                }
            break;
            case "Diario" :
                $dateToAdd=strtotime('+'.$cadacuantosdias.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Semanal" :
                $dateToAdd=strtotime('+'.$semanas.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Mensual" :
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($numerodia == 5){
                    if($fecha_det1[2] <=28){
                        $dateToAdd = strtotime('+35 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }else if($fecha_det1[2] >=29){
                        $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }
                }else if($numerodia == 4){
                    $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }  
            break;
            case "Dos Veces por Mes" :					 				
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes>= 29){
                    if($numerodia == 5){
                        if($fecha_det1[2] <= 10){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 15 && $fecha_det1[2] <= 28){
                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){
                        $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;
            case "4 veces por Mes" :                   
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                            
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                    $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes >= 29){
                    if($numerodia == 5){			
                        if($fecha_det1[2] <= 21){	                 
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 22 && $fecha_det1[2] <= 28){                    
                            $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){		            
                        $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;	
            case "Catorcenal" :
                $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;		
        }
        $primerafecha = false;
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasmensuales;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);        
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);              
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "4 veces por mes"){
            if($cada4>=2){
                $stockRow['Total de visitas']=$visitasmensuales4veces;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);               
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasanuales;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                
                
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);
            }
        }
        else{
            $stockRow['Total de visitas']=$contador;
            $fechas_visitas_string = implode(',', $fechas_de_visitas);
            save($stockRow);
            }
        }
    }
    $fecha_repetida_cont = 0;
    $contador=0;
    IF($stockRow['Frecuencia']=='Segun se requiera'){
        $contador++;
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_det= explode("-",$dateToAdd);  
        $visita = NewRegister('Administración de Servicios');
        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
        $visita['Idprogsd']=1;
        $visita['ID Programación']=$stockRow['ID'];
        $visita['Idctl']=$stockRow['Idctl'];
        $visita['idcont']=$stockRow['idcont'];
        $visita['Frecuencia']=$stockRow['Frecuencia'];
        $visita['Programa']=$stockRow['Programa'];
        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
        $visita['Plaguicida']=$stockRow['Plaguicida'];
        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
        $visita['Estatus']='Activo';
        $visita['Fecha de ejecucion']=$dateToAdd;
        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
        $visita['Servicio']=$stockRow['Nombre Servicio']; 
        $visita['Cliente']=$stockRow['Cliente']; 
        $visita['Contrato']=$stockRow['Contrato'];
        $visita['Contacto']=$stockRow['Contacto'];
        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
        $visita['Costo']=$stockRow['Costo'];
        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
        $visita['Facturable']=$stockRow['Facturable'];
        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
        $visita['Ruta']=$stockRow['Ruta'];
        $visita['Vehiculo']=$stockRow['Vehiculo'];
        $visita['Supervisor']=$stockRow['Supervisor'];
        $visita['Sucursal']=$stockRow['Sucursal']; 
        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
        $visita['Colonia']=$stockRow['Colonia'];
        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
        $visita['Mes']=$fecha_det[1]; 
        $visita['Dia']=$fecha_det[2];
        $visitames= $visita['Mes'];
        $diadevisita=$visita['Dia']; 
        $stockRow['Total de visitas']=$contador;
        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                $fecha_repetida_cont++;
            }
        }
        if($fecha_repetida_cont == 0){
            array_push($fechas_de_visitas, $dateToAdd);
            save($visita);
        }
        $fechas_visitas_string = implode(',', $fechas_de_visitas);        
        save($stockRow);
    }
    switch($stockRow['Tipo Servicio']){
        case "Monitoreo de roedores exteriores" :
        $clasificacion = "RE";
        break;
        case "Monitoreo de roedores interiores" :
        $clasificacion = "RI";
        break;
        case "Monitoreo de insectos voladores Exteriores" :
        $clasificacion = "VE";
        break;
        case "Monitoreo de insectos voladores Interiores" :
        $clasificacion = "VI";
        break;
        case "Inspeccion Feromonas" :
        $clasificacion = "FE";
        break;
        case "Monitoreo de Jaulas" :
        $clasificacion = "MJ";
        break;
        case "Monitoreo de Dispositivo de Control Aves" :
        $clasificacion = "AV";
        break;
    }
    foreach(DBForm('Asignacion de Dispositivos')->WHERE('idCON','=',$stockRow['idcont'])->WHERE('Clasificacion Dispositivo','=',$clasificacion)->get() AS $Asignacion){
        $Asignacion['Fechas_de_revision_del_dispositivo'].=$fechas_visitas_string;
        save($Asignacion);
    }
}
                    $regis = $regis + $cadacuantosmeses;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Mes']=$fecha_det[1];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Supervisor']=$stockRow['Supervisor']; 
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Sucursal']=$stockRow['Sucursal']; 
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']="Licencia #:".$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']=$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasmensuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
                            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            save($visita);
                        }                        
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;  
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; foreach(DBForm('Programación de Servicios')->WHERE('Estatus Programación','=','Programando')->get() AS $stockRow){
    IF($stockRow['Frecuencia']!='Segun se requiera'){
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_final=$stockRow['Fecha Final de acuerdo a rotacion'];
        $fecha_det=explode("-",$dateToAdd);	 
        $cadacuantosanos=$stockRow['¿Cada cuantos años?'];
        $Anos = $cadacuantosanos*364;
        $cadacuantosdias=$stockRow['¿Cada cuantos días?'];
        $cadacuantassemanas=$stockRow['¿Cada cuantas semanas?'];
        $semanas = $cadacuantassemanas*7;
        $Meses=$stockRow['¿Cada cuantos meses?'];
        $varSwitch = $stockRow['Frecuencia'];
        save($stockRow);
        $cadayears=$cadacuantosanos;
        $cadyear= $cadayears;
        $visitasanuales=0;
        $visitames = $fecha_det[1];
        $mesmi=explode("-",$dateToAdd);
        $mesmismo=$mesmi[1];
        $regis4=1;
        $cada4vecesmes=$Meses;
        $cada4=$cada4vecesmes;
        $primercambio=false;
        $visitasmensuales4veces=0;
        $regis = 0;
        $cadacuantosmeses = $Meses;
        $cadmes = $cadacuantosmeses;
        $primerafecha = true;
        $visitasmensuales = 0;
        $enero=1;
        $febrero=2;
        $marzo=3;
        $abril=4;
        $mayo=5;
        $junio=6;
        $julio=7;
        $agosto=8;
        $sep=9;
        $oct=10;
        $nov=11;
        $dici=12;
        $contador=0;
        $fechas_de_visitas = [];
        While(strtotime($dateToAdd) <= strtotime($fecha_final)){
        $fecha_repetida_cont = 0;
        $contador++;
        $mesca=explode("-",$dateToAdd);
        $mescambio=$mesca[1];
        $regis = 0;
        $primerafecha = true;
        $fecha_det = explode("-",$dateToAdd);
        $timestamp = strtotime( $dateToAdd );
        $diasdmes = date( "t", $timestamp );
        $diadelasemana = date("w",strtotime($dateToAdd));
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadacuantosmeses = 1;
                    }else{
                        $cadacuantosmeses = $cadmes;
                    }
                    $regis = $regis + $cadacuantosmeses;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Mes']=$fecha_det[1];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Supervisor']=$stockRow['Supervisor']; 
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Sucursal']=$stockRow['Sucursal']; 
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']="Licencia #:".$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']=$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasmensuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
                            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }                        
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;  
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; 
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion2){
                    if($dateToAdd == $Administracion2['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "4 veces por Mes"){
            if($cada4>=2){
                if($primercambio==true){
                    $mesmi=explode("-",$dateToAdd);
                    $mesmismo=$mesmi[1];
                }
                if($contador==$regis4){
                    if($mescambio==$mesmismo){
                        $cada4vecesmes=1;
                        $regis4 = $regis4 + $cada4vecesmes;
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $primercambio=false;
                        $visitasmensuales4veces++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion3){
                            if($dateToAdd == $Administracion3['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }
                    }
                    else{
                        if($primercambio==false){
                            $cada4vecesmes=($cada4-1)*4;
                            $regis4 = $regis4 + $cada4vecesmes;
                            $primercambio=true;
                        }
                    }
                }
            }
            else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal'];
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado']; 
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal']; 
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion4){
                    if($dateToAdd == $Administracion4['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadyear>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadayears = 1;
                    }else{
                        $cadayears = $cadyear;
                    }
                    $regis = $regis + $cadayears;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasanuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion5){
                            if($dateToAdd == $Administracion5['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            array_push($fechas_de_visitas, $dateToAdd);
                            save($visita);
                        }
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; 
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion6){
                    if($dateToAdd == $Administracion6['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    array_push($fechas_de_visitas, $dateToAdd);
                    save($visita);
                }
            }
        }else{
            $visita = NewRegister('Administración de Servicios');
            $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
            $visita['Idprogsd']=1;
            $visita['ID Programación']=$stockRow['ID'];
            $visita['Idctl']=$stockRow['Idctl'];
            $visita['idcont']=$stockRow['idcont'];
            $visita['Frecuencia']=$stockRow['Frecuencia'];
            $visita['Programa']=$stockRow['Programa'];
            $visita['Estatus']='Activo';
            $visita['Fecha de ejecucion']=$dateToAdd;
            $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
            $visita['Servicio']=$stockRow['Nombre Servicio']; 
            $visita['Cliente']=$stockRow['Cliente']; 
            $visita['Contrato']=$stockRow['Contrato'];
            $visita['Contacto']=$stockRow['Contacto'];
            $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
            $visita['Costo']=$stockRow['Costo'];
            $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
            $visita['Facturable']=$stockRow['Facturable'];
            $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
            $visita['Plaguicida']=$stockRow['Plaguicida'];
            $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
            $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
            $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
            $visita['Ruta']=$stockRow['Ruta'];
            $visita['Vehiculo']=$stockRow['Vehiculo'];
            $visita['Supervisor']=$stockRow['Supervisor'];
            $visita['Sucursal']=$stockRow['Sucursal'];
            $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
            $visita['Colonia']=$stockRow['Colonia'];
            $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
            $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
            $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
            $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
            $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
            $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
            $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
            $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
            $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
            $visita['Mes']=$fecha_det[1]; 
            $visita['Dia']=$fecha_det[2];
            $visitames= $visita['Mes'];
            $diadevisita=$visita['Dia'];
            foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion7){
                if($dateToAdd == $Administracion7['Fecha de ejecucion']){
                    $fecha_repetida_cont++;
                }
            }
            if($fecha_repetida_cont == 0){
                array_push($fechas_de_visitas, $dateToAdd);
                save($visita);
            }
        }
        $varSwitch = $stockRow['Frecuencia'];
        switch($varSwitch){
            case "Anual" :
                $fecharelpica=strtotime('+364 day',strtotime($dateToAdd));	
                $fecharelpica=date('Y-m-j',$fecharelpica);
                $fecha_repl = explode("-",$fecharelpica);
                $mesreplica = $fecha_repl[1];
                $cont=0;
                $contrepli=0;
                $dia = date("N",strtotime($dateToAdd));
                $diareplica = date("N",strtotime($fecharelpica));
                $fecha_det = explode("-",$dateToAdd);
                $diaactual = $fecha_det[2]; 
                $diaactualreplica = $fecha_repl[2];
                $mes = $fecha_det[1];
                $visitadia = ($diaactual) - (1);
                $viadiareplica = ($diaactualreplica) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);
                $fresrepl = strtotime('-'.$viadiareplica.'day',strtotime($fecharelpica));
                $fresrepl = date('Y-m-j',$fresrepl);
                for ($j = 1; $j <= $diaactual; $j++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;				
                    }
                    $fecha_resta = strtotime('+1 day',strtotime($fecha_resta));	
                    $fecha_resta = date('Y-m-j',$fecha_resta);			
                }
                for ($p = 1; $p <= $diaactualreplica; $p++){
                    $diadelasemanareplica = date("N", strtotime($fresrepl));
                    if($diadelasemanareplica == $diareplica){
                        $contrepli++;				
                    }
                    $fresrepl = strtotime('+1 day',strtotime($fresrepl));	
                    $fresrepl = date('Y-m-j',$fresrepl);			
                }
                if($cont == 1){
                    $diaresta = $diaactual - 1;
                    if($diaresta <= 0){
                        $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );		
                    }else{
                        if($mesreplica == $mes){
                            $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                        }else{
                            $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );						
                        }
                    }
                }else if($cont == 5){
                    $dateToAdd=strtotime('+357 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }else if($cont == $contrepli){
                    $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }
                else{
                    $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );	
                }
            break;
            case "Diario" :
                $dateToAdd=strtotime('+'.$cadacuantosdias.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Semanal" :
                $dateToAdd=strtotime('+'.$semanas.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Mensual" :
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($numerodia == 5){
                    if($fecha_det1[2] <=28){
                        $dateToAdd = strtotime('+35 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }else if($fecha_det1[2] >=29){
                        $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }
                }else if($numerodia == 4){
                    $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }  
            break;
            case "Dos Veces por Mes" :					 				
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes>= 29){
                    if($numerodia == 5){
                        if($fecha_det1[2] <= 10){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 15 && $fecha_det1[2] <= 28){
                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){
                        $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;
            case "4 veces por Mes" :                   
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                            
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                    $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes >= 29){
                    if($numerodia == 5){			
                        if($fecha_det1[2] <= 21){	                 
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 22 && $fecha_det1[2] <= 28){                    
                            $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){		            
                        $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;	
            case "Catorcenal" :
                $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;		
        }
        $primerafecha = false;
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasmensuales;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);        
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);              
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "4 veces por mes"){
            if($cada4>=2){
                $stockRow['Total de visitas']=$visitasmensuales4veces;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);               
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasanuales;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                
                
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                $fechas_visitas_string = implode(',', $fechas_de_visitas);
                save($stockRow);
            }
        }
        else{
            $stockRow['Total de visitas']=$contador;
            $fechas_visitas_string = implode(',', $fechas_de_visitas);
            save($stockRow);
            }
        }
    }
    $fecha_repetida_cont = 0;
    $contador=0;
    IF($stockRow['Frecuencia']=='Segun se requiera'){
        $contador++;
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_det= explode("-",$dateToAdd);  
        $visita = NewRegister('Administración de Servicios');
        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
        $visita['Idprogsd']=1;
        $visita['ID Programación']=$stockRow['ID'];
        $visita['Idctl']=$stockRow['Idctl'];
        $visita['idcont']=$stockRow['idcont'];
        $visita['Frecuencia']=$stockRow['Frecuencia'];
        $visita['Programa']=$stockRow['Programa'];
        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
        $visita['Plaguicida']=$stockRow['Plaguicida'];
        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
        $visita['Estatus']='Activo';
        $visita['Fecha de ejecucion']=$dateToAdd;
        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
        $visita['Servicio']=$stockRow['Nombre Servicio']; 
        $visita['Cliente']=$stockRow['Cliente']; 
        $visita['Contrato']=$stockRow['Contrato'];
        $visita['Contacto']=$stockRow['Contacto'];
        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
        $visita['Costo']=$stockRow['Costo'];
        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
        $visita['Facturable']=$stockRow['Facturable'];
        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
        $visita['Ruta']=$stockRow['Ruta'];
        $visita['Vehiculo']=$stockRow['Vehiculo'];
        $visita['Supervisor']=$stockRow['Supervisor'];
        $visita['Sucursal']=$stockRow['Sucursal']; 
        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
        $visita['Colonia']=$stockRow['Colonia'];
        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
        $visita['Mes']=$fecha_det[1]; 
        $visita['Dia']=$fecha_det[2];
        $visitames= $visita['Mes'];
        $diadevisita=$visita['Dia']; 
        $stockRow['Total de visitas']=$contador;
        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                $fecha_repetida_cont++;
            }
        }
        if($fecha_repetida_cont == 0){
            array_push($fechas_de_visitas, $dateToAdd);
            save($visita);
        }
        $fechas_visitas_string = implode(',', $fechas_de_visitas);        
        save($stockRow);
    }
    switch($stockRow['Tipo Servicio']){
        case "Monitoreo de roedores exteriores" :
        $clasificacion = "RE";
        break;
        case "Monitoreo de roedores interiores" :
        $clasificacion = "RI";
        break;
        case "Monitoreo de insectos voladores Exteriores" :
        $clasificacion = "VE";
        break;
        case "Monitoreo de insectos voladores Interiores" :
        $clasificacion = "VI";
        break;
        case "Inspeccion Feromonas" :
        $clasificacion = "FE";
        break;
        case "Monitoreo de Jaulas" :
        $clasificacion = "MJ";
        break;
        case "Monitoreo de Dispositivo de Control Aves" :
        $clasificacion = "AV";
        break;
    }
    foreach(DBForm('Asignacion de Dispositivos')->WHERE('idCON','=',$stockRow['idcont'])->WHERE('Clasificacion Dispositivo','=',$clasificacion)->get() AS $Asignacion){
        if($stockRow['Tipo de Programacion'] == 'Normal'){
            $Asignacion['Fechas_de_revision_del_dispositivo'].=$fechas_visitas_string;
            save($Asignacion);
        }else if($stockRow['Tipo de Programacion'] == 'Escalacion'){
            foreach(DBForm('Areas con Escalacion')->WHERE('IDPROG','=',$stockRow['ID'])->get() AS $Escalacion){
                $Dispositivos = $Escalacion['Dispositivos'];
                $Dispositivos_array = explode('~',$Dispositivos);
                $catidad_dispo_escalados = count($Dispositivos_array);
                for($p=0; $p<$catidad_dispo_escalados; $p++){
                    if($Dispositivos_array[$p] == $Asignacion['Numero de dispositivo QR']){
                        $Asignacion['Fechas_de_revision_del_dispositivo'].=$fechas_visitas_string;
                        save($Asignacion);
                    }
                }
            }
        }        
    }
}
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion2){
                    if($dateToAdd == $Administracion2['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "4 veces por Mes"){
            if($cada4>=2){
                if($primercambio==true){
                    $mesmi=explode("-",$dateToAdd);
                    $mesmismo=$mesmi[1];
                }
                if($contador==$regis4){
                    if($mescambio==$mesmismo){
                        $cada4vecesmes=1;
                        $regis4 = $regis4 + $cada4vecesmes;
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $primercambio=false;
                        $visitasmensuales4veces++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion3){
                            if($dateToAdd == $Administracion3['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            save($visita);
                        }
                    }
                    else{
                        if($primercambio==false){
                            $cada4vecesmes=($cada4-1)*4;
                            $regis4 = $regis4 + $cada4vecesmes;
                            $primercambio=true;
                        }
                    }
                }
            }
            else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal'];
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado']; 
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal']; 
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion4){
                    if($dateToAdd == $Administracion4['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    save($visita);
                }
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadyear>=2){
                for($h=1;$h<=$contador;$h++){
                    if($primerafecha == true){
                        $cadayears = 1;
                    }else{
                        $cadayears = $cadyear;
                    }
                    $regis = $regis + $cadayears;
                    $primerafecha = false;
                    if($contador == $regis){
                        $visita = NewRegister('Administración de Servicios');
                        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                        $visita['Idprogsd']=1;
                        $visita['ID Programación']=$stockRow['ID'];
                        $visita['Idctl']=$stockRow['Idctl'];
                        $visita['idcont']=$stockRow['idcont'];
                        $visita['Frecuencia']=$stockRow['Frecuencia'];
                        $visita['Programa']=$stockRow['Programa'];
                        $visita['Estatus']='Activo';
                        $visita['Fecha de ejecucion']=$dateToAdd;
                        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                        $visita['Servicio']=$stockRow['Nombre Servicio']; 
                        $visita['Cliente']=$stockRow['Cliente']; 
                        $visita['Contrato']=$stockRow['Contrato'];
                        $visita['Contacto']=$stockRow['Contacto'];
                        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                        $visita['Costo']=$stockRow['Costo'];
                        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                        $visita['Facturable']=$stockRow['Facturable'];
                        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                        $visita['Plaguicida']=$stockRow['Plaguicida'];
                        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                        $visita['Ruta']=$stockRow['Ruta'];
                        $visita['Vehiculo']=$stockRow['Vehiculo'];
                        $visita['Supervisor']=$stockRow['Supervisor'];
                        $visita['Sucursal']=$stockRow['Sucursal'];
                        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                        $visita['Colonia']=$stockRow['Colonia'];
                        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                        $visita['Mes']=$fecha_det[1]; 
                        $visita['Dia']=$fecha_det[2];
                        $visitames= $visita['Mes'];
                        $diadevisita=$visita['Dia'];
                        $visitasanuales++;
                        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion5){
                            if($dateToAdd == $Administracion5['Fecha de ejecucion']){
                                $fecha_repetida_cont++;
                            }
                        }
                        if($fecha_repetida_cont == 0){
                            save($visita);
                        }
                    }
                }
            }else{
                $visita = NewRegister('Administración de Servicios');
                $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
                $visita['Idprogsd']=1;
                $visita['ID Programación']=$stockRow['ID'];
                $visita['Idctl']=$stockRow['Idctl'];
                $visita['idcont']=$stockRow['idcont'];
                $visita['Frecuencia']=$stockRow['Frecuencia'];
                $visita['Programa']=$stockRow['Programa'];
                $visita['Estatus']='Activo';
                $visita['Fecha de ejecucion']=$dateToAdd;
                $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
                $visita['Servicio']=$stockRow['Nombre Servicio']; 
                $visita['Cliente']=$stockRow['Cliente']; 
                $visita['Contrato']=$stockRow['Contrato'];
                $visita['Contacto']=$stockRow['Contacto'];
                $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
                $visita['Costo']=$stockRow['Costo'];
                $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
                $visita['Facturable']=$stockRow['Facturable'];
                $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
                $visita['Plaguicida']=$stockRow['Plaguicida'];
                $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
                $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
                $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
                $visita['Ruta']=$stockRow['Ruta'];
                $visita['Vehiculo']=$stockRow['Vehiculo'];
                $visita['Supervisor']=$stockRow['Supervisor'];
                $visita['Sucursal']=$stockRow['Sucursal']; 
                $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
                $visita['Colonia']=$stockRow['Colonia'];
                $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
                $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
                $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
                $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
                $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
                $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
                $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
                $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
                $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
                $visita['Mes']=$fecha_det[1]; 
                $visita['Dia']=$fecha_det[2];
                $visitames= $visita['Mes'];
                $diadevisita=$visita['Dia'];
                foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion6){
                    if($dateToAdd == $Administracion6['Fecha de ejecucion']){
                        $fecha_repetida_cont++;
                    }
                }
                if($fecha_repetida_cont == 0){
                    save($visita);
                }
            }
        }else{
            $visita = NewRegister('Administración de Servicios');
            $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
            $visita['Idprogsd']=1;
            $visita['ID Programación']=$stockRow['ID'];
            $visita['Idctl']=$stockRow['Idctl'];
            $visita['idcont']=$stockRow['idcont'];
            $visita['Frecuencia']=$stockRow['Frecuencia'];
            $visita['Programa']=$stockRow['Programa'];
            $visita['Estatus']='Activo';
            $visita['Fecha de ejecucion']=$dateToAdd;
            $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
            $visita['Servicio']=$stockRow['Nombre Servicio']; 
            $visita['Cliente']=$stockRow['Cliente']; 
            $visita['Contrato']=$stockRow['Contrato'];
            $visita['Contacto']=$stockRow['Contacto'];
            $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
            $visita['Costo']=$stockRow['Costo'];
            $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
            $visita['Facturable']=$stockRow['Facturable'];
            $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
            $visita['Plaguicida']=$stockRow['Plaguicida'];
            $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
            $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
            $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
            $visita['Ruta']=$stockRow['Ruta'];
            $visita['Vehiculo']=$stockRow['Vehiculo'];
            $visita['Supervisor']=$stockRow['Supervisor'];
            $visita['Sucursal']=$stockRow['Sucursal'];
            $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
            $visita['Colonia']=$stockRow['Colonia'];
            $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
            $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
            $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
            $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
            $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
            $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
            $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
            $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
            $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
            $visita['Mes']=$fecha_det[1]; 
            $visita['Dia']=$fecha_det[2];
            $visitames= $visita['Mes'];
            $diadevisita=$visita['Dia'];
            foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion7){
                if($dateToAdd == $Administracion7['Fecha de ejecucion']){
                    $fecha_repetida_cont++;
                }
            }
            if($fecha_repetida_cont == 0){
                save($visita);
            }
        }
        $varSwitch = $stockRow['Frecuencia'];
        switch($varSwitch){
            case "Anual" :
                $fecharelpica=strtotime('+364 day',strtotime($dateToAdd));	
                $fecharelpica=date('Y-m-j',$fecharelpica);
                $fecha_repl = explode("-",$fecharelpica);
                $mesreplica = $fecha_repl[1];
                $cont=0;
                $contrepli=0;
                $dia = date("N",strtotime($dateToAdd));
                $diareplica = date("N",strtotime($fecharelpica));
                $fecha_det = explode("-",$dateToAdd);
                $diaactual = $fecha_det[2]; 
                $diaactualreplica = $fecha_repl[2];
                $mes = $fecha_det[1];
                $visitadia = ($diaactual) - (1);
                $viadiareplica = ($diaactualreplica) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);
                $fresrepl = strtotime('-'.$viadiareplica.'day',strtotime($fecharelpica));
                $fresrepl = date('Y-m-j',$fresrepl);
                for ($j = 1; $j <= $diaactual; $j++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;				
                    }
                    $fecha_resta = strtotime('+1 day',strtotime($fecha_resta));	
                    $fecha_resta = date('Y-m-j',$fecha_resta);			
                }
                for ($p = 1; $p <= $diaactualreplica; $p++){
                    $diadelasemanareplica = date("N", strtotime($fresrepl));
                    if($diadelasemanareplica == $diareplica){
                        $contrepli++;				
                    }
                    $fresrepl = strtotime('+1 day',strtotime($fresrepl));	
                    $fresrepl = date('Y-m-j',$fresrepl);			
                }
                if($cont == 1){
                    $diaresta = $diaactual - 1;
                    if($diaresta <= 0){
                        $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );		
                    }else{
                        if($mesreplica == $mes){
                            $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                        }else{
                            $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );						
                        }
                    }
                }else if($cont == 5){
                    $dateToAdd=strtotime('+357 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }else if($cont == $contrepli){
                    $dateToAdd=strtotime('+364 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                }
                else{
                    $dateToAdd=strtotime('+371 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );	
                }
            break;
            case "Diario" :
                $dateToAdd=strtotime('+'.$cadacuantosdias.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Semanal" :
                $dateToAdd=strtotime('+'.$semanas.' day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;
            case "Mensual" :
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($numerodia == 5){
                    if($fecha_det1[2] <=28){
                        $dateToAdd = strtotime('+35 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }else if($fecha_det1[2] >=29){
                        $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }
                }else if($numerodia == 4){
                    $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }  
            break;
            case "Dos Veces por Mes" :					 				
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                               
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                        $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes>= 29){
                    if($numerodia == 5){
                        if($fecha_det1[2] <= 10){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 15 && $fecha_det1[2] <= 28){
                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){
                        $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;
            case "4 veces por Mes" :                   
                $fecha_det1 = explode("-",$dateToAdd);
                $visitames = $fecha_det1[1];              
                $cont = 0;
                $dia = date("N", strtotime($dateToAdd));                        
                $visitadia2 = $fecha_det1[2];                                            
                $visitadia = ($visitadia2) - (1);
                $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                $fecha_resta = date('Y-m-j',$fecha_resta);                        
                for ($i = 1; $i <= $diasdmes; $i++){
                    $diadelasemana = date("N", strtotime($fecha_resta));
                    if($diadelasemana == $dia){
                    $cont++;
                    }
                    $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                    $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                }
                $visita['Dia de la semana']=$cont;	
                $numerodia=$visita['Dia de la semana'];
                if($diasdmes >= 29){
                    if($numerodia == 5){			
                        if($fecha_det1[2] <= 21){	                 
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 22 && $fecha_det1[2] <= 28){                    
                            $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }else if($fecha_det1[2] >= 29){
                            $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                            break;
                        }
                    }else if($numerodia == 4){		            
                        $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                        $dateToAdd = date('Y-m-j',$dateToAdd );
                        break;
                    }  
                }else{
                    $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                    $dateToAdd = date('Y-m-j',$dateToAdd );
                    break;
                }
            break;	
            case "Catorcenal" :
                $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                $dateToAdd = date('Y-m-j',$dateToAdd );
            break;		
        }
        $primerafecha = false;
        if($stockRow['Frecuencia'] == "Mensual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasmensuales;
                save($stockRow);        
            }else{
                $stockRow['Total de visitas']=$contador;
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "4 veces por mes"){
            if($cada4>=2){
                $stockRow['Total de visitas']=$visitasmensuales4veces;
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                save($stockRow);
            }
        }else if($stockRow['Frecuencia'] == "Anual"){
            if($cadmes>=2){
                $stockRow['Total de visitas']=$visitasanuales;
                save($stockRow);
            }else{
                $stockRow['Total de visitas']=$contador;
                save($stockRow);
            }
        }
        else{
                $stockRow['Total de visitas']=$contador;
                save($stockRow);
            }
        }
    }
    $fecha_repetida_cont = 0;
    $contador=0;
    IF($stockRow['Frecuencia']=='Segun se requiera'){
        $contador++;
        $stockRow['Estatus Programación']='Activo';
        $dateToAdd=$stockRow['Fecha de Inicio de acuerdo a rotacion'];
        $fecha_det= explode("-",$dateToAdd);  
        $visita = NewRegister('Administración de Servicios');
        $visita['tipo_programacion']=$stockRow['Tipo de Programacion'];
        $visita['Idprogsd']=1;
        $visita['ID Programación']=$stockRow['ID'];
        $visita['Idctl']=$stockRow['Idctl'];
        $visita['idcont']=$stockRow['idcont'];
        $visita['Frecuencia']=$stockRow['Frecuencia'];
        $visita['Programa']=$stockRow['Programa'];
        $visita['Plaga Objetivo']=$stockRow['Plaga Objetivo'];
        $visita['Plaguicida']=$stockRow['Plaguicida'];
        $visita['Metodo de Aplicacion']=$stockRow['Metodo de aplicacion'];
        $visita['Estatus']='Activo';
        $visita['Fecha de ejecucion']=$dateToAdd;
        $visita['Servicio asociado']=$stockRow['Tipo Servicio'];
        $visita['Servicio']=$stockRow['Nombre Servicio']; 
        $visita['Cliente']=$stockRow['Cliente']; 
        $visita['Contrato']=$stockRow['Contrato'];
        $visita['Contacto']=$stockRow['Contacto'];
        $visita['Instrucciones Especiales']=$stockRow['Instrucciones Especiales'];
        $visita['Costo']=$stockRow['Costo'];
        $visita['Horas Servicio']=$stockRow['Horas Inicio Del Servicio'];
        $visita['Facturable']=$stockRow['Facturable'];
        $visita['Duracion del servicio en meses']=$stockRow['Duracion Meses'];
        $visita['Duración Tiempo']=$stockRow['Duracion Tiempo'];
        $visita['Ruta']=$stockRow['Ruta'];
        $visita['Vehiculo']=$stockRow['Vehiculo'];
        $visita['Supervisor']=$stockRow['Supervisor'];
        $visita['Sucursal']=$stockRow['Sucursal']; 
        $visita['Técnico Encargado']=$stockRow['Técnico Encargado'];
        $visita['Colonia']=$stockRow['Colonia'];
        $visita['ColoniaContrato']=$stockRow['Coloniacontrato'];
        $visita['LicenciaSucursal']="Licencia #:".$stockRow['LicenciaSucursal'];
        $visita['dctlexteriorcalle']=$stockRow['Numero Exterior']." ".$stockRow['Calle'];
        $visita['dconextcalle']=$stockRow['Numero ExteriorContra']." ".$stockRow['CalleContra'];
        $visita['dctlmuniestadopostcloni']=$stockRow['Municipio']." ".$stockRow['Estado']." ".$stockRow['codigo Postal'];
        $visita['dconmunestposcolo']=$stockRow['MunicipioContra']." ".$stockRow['EstadoContra']." ".$stockRow['codigo PostalContra'];
        $visita['sucallenocolo']=$stockRow['Callesucursal']." "."No."." ".$stockRow['No. Exteriorsucursal'].", ".$stockRow['Coloniasucursal'];
        $visita['sumuesta']=$stockRow['Municipiosucursal'].", ".$stockRow['Estadosucursal'];
        $visita['sucptel']="C.P. ".$stockRow['Codigosucursal']." Tel: ".$stockRow['Telefonosucursal'];
        $visita['Mes']=$fecha_det[1]; 
        $visita['Dia']=$fecha_det[2];
        $visitames= $visita['Mes'];
        $diadevisita=$visita['Dia']; 
        $stockRow['Total de visitas']=$contador;
        save($stockRow);
        foreach(DBForm('Administración de Servicios')->WHERE('Estatus','=','Activo')->WHERE('idcont','=',$stockRow['idcont'])->WHERE('Servicio asociado','=',$stockRow['Tipo Servicio'])->get() AS $Administracion){
            if($dateToAdd == $Administracion['Fecha de ejecucion']){
                $fecha_repetida_cont++;
            }
        }
        if($fecha_repetida_cont == 0){
            save($visita);
        }
    }
}
