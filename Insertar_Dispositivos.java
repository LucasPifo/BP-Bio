foreach(DBForm('Programación de Servicios')->WHERE('Bandera','=','1')->get() AS $stockRow){
    $tipodeservicio = $stockRow['Tipo Servicio'];
    $contador=0;
    switch($tipodeservicio){
    case 'Monitoreo de roedores exteriores' :
        $clasificacion = 'RE';
        break;
    case 'Monitoreo de Jaulas' :
        $clasificacion = 'MJ';
        break;    
    case 'Monitoreo de roedores interiores' :
        $clasificacion = 'RI';
        break;
    case 'Monitoreo de insectos voladores Interiores' :
        $clasificacion = 'VI';
        break;
    case 'Monitoreo de insectos voladores Exteriores' :
        $clasificacion = 'VE';
        break;
    case 'Inspeccion Feromonas' :
        $clasificacion = 'FE';
        break;   
    case 'Monitoreo de Actividad Aves' :
        $clasificacion = 'MA';
        break;
    case 'Monitoreo de Dispositivos de Control Aves' :
        $clasificacion = 'AV';
        break;
    }     
    foreach(DBForm('Areas')->WHERE('Idcon','=',$stockRow['idcont'])->get() AS $Areas){
        $clasificaion_multiple = $Areas['Clasificacion'];
        $posicionidentica = strpos($clasificaion_multiple, $clasificacion);
        if($posicionidentica === false){                         
        }else{
            switch($tipodeservicio){
                case 'Monitoreo de roedores exteriores' :
                    $Registro=NewRegister('Area con Dispositivos Exteriores');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;	
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Monitoreo de roedores interiores' :
                    $Registro=NewRegister('Area con Dispositivos Interiores');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Monitoreo de Jaulas' :
                    $Registro=NewRegister('Areas con Jaulas');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;	
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;    
                case 'Monitoreo de insectos voladores Interiores' :
                    $Registro=NewRegister('Area con Dispositivos Voladores Interiores');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;	
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Monitoreo de insectos voladores Exteriores' :
                    $Registro=NewRegister('Area con Dispositivos Voladores Exteriores');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;	
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Inspeccion Feromonas' :
                    $Registro=NewRegister('Area con Feromonas');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Monitoreo de Actividad Aves' :
                    $Registro=NewRegister('Area Monitoreo de Actividad Aves');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
                case 'Monitoreo de Dispositivos de Control Aves' :
                    $Registro=NewRegister('Area con Dispositivos de Control Aves');
		            $Registro['Tipo de servicio']=$stockRow['Tipo Servicio'];
		            $Registro['tipo_programacion']=$stockRow['Tipo de Programacion'];
                    $Registro['Area']=$Areas['Area'];
                    $Registro['IDPROG']=$stockRow['ID'];
                    $Registro['Idcontrato']=$stockRow['idcont'];
		            $Registro['Contrato'] = $stockRow['Contrato'];
                    $Registro['contadorNulo']=1;
                    $Registro['IdArea']=$Areas['Clave'];
                    $contador++;
                    save($Registro); 
                break;
            }  
        } 
        $stockRow['contador']=$contador;
        $stockRow['Bandera']='0';
        save($stockRow);
    }
}