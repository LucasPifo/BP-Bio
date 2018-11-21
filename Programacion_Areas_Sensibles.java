foreach(DBForm('Programación de Servicios')->WHERE('Estatus Programación','=','Programando')->get() AS $Programacion){
    $Fecha_Inicio = $Programacion['Fecha de Inicio de acuerdo a rotacion'];
    $fecha_final = $Programacion['Fecha Final de acuerdo a rotacion'];
    $areas = [];
    $frecuancias = [];
    $dias = [];
    $semanas = [];
    $semanas_2veces = [];
    $Meses = [];
    foreach(DBForm('Areas con sensibilidad')->WHERE('Idprog','=',$Programacion['ID'])->get() AS $Areasensible){
        array_push($areas, $Areasensible['Area Sensible']);
        array_push($frecuancias, $Areasensible['Frecuencia de Inspeccion']);
        array_push($dias, $Areasensible['Dia']); 
        array_push($semanas, $Areasensible['Numero de semana']); 
        array_push($semanas_2veces, $Areasensible['Semana']);
        array_push($Meses, $Areasensible['Cada cuantos meses']);
    }
    $fechasTotales = [];
    $areasFecha = [];
    $frecuanciastotales = [];
    $contarea = count($areas);
    for($c=0; $c<$contarea; $c++){
        $dateToAdd = $Fecha_Inicio;
        $primeravez=true;
        $cadacuantosmeses = $Meses[$c];
        $cadmes = $cadacuantosmeses;
        $contador = 0;
        $visitasmensuales = 0;
        while(strtotime($dateToAdd) <= strtotime($fecha_final)){
            switch($frecuancias[$c]){
                case "4 veces por mes" :
                    if($primeravez==true){
                        $diacaambio = date('N', strtotime($dateToAdd));
                        if(cambiardianumero($dias[$c]) == $diacaambio){
                            $primeravez=false;
                        }else{
                            $dateToAdd = strtotime( '+1 day' , strtotime($dateToAdd));
                            $dateToAdd = date( 'Y-m-j' , $dateToAdd);
                        }
                        $mesca = explode("-",$dateToAdd);
                        $mescambio = $mesca[1];
                        $timestamp = strtotime($dateToAdd);
                        $diasdmes = date( "t", $timestamp );
                    }else{
                        $diasdmes = date( "t", strtotime( $dateToAdd ) );
                        array_push($fechasTotales, $dateToAdd);
                        array_push($areasFecha, $areas[$c]);
                        array_push($frecuanciastotales, $frecuancias[$c]);
                        $cont = 0;
                        $fecha_array = explode("-",$dateToAdd);
                        $visitames = $fecha_array[1];              
                        $dia = date("N", strtotime($dateToAdd));                        
                        $visitadia2 = $fecha_array[2];                                            
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
                        $numerodia=$cont;
                        if($diasdmes >= 29){
                            if($numerodia == 5){			
                                if($visitadia2 <= 21){	                 
                                    $dateToAdd=strtotime('+7 day',strtotime($dateToAdd));	
                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                        break;
                                }else if($visitadia2 >= 22 && $visitadia2 <= 28){                    
                                    $dateToAdd=strtotime('+14 day',strtotime($dateToAdd));	
                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                    break;
                                }else if($visitadia2 >= 29){
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
                    }
                break;
                case "2 veces por mes" :
                    if($primeravez==true){
                        $timestamp = strtotime($dateToAdd);
                        $diasdmes = date( "t", $timestamp );
                        $cont = 0;
                        $fecha_array = explode("-",$dateToAdd);
                        $visitames = $fecha_array[1];              
                        $dia = cambiardianumero($dias[$c]);                        
                        $visitadia2 = $fecha_array[2];                                               
                        $visitadia = ($visitadia2) - (1);
                        $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                        $fecha_resta = date('Y-m-j',$fecha_resta);                       
                        for($i = 1; $i <= $diasdmes; $i++){
                            $diadelasemana = date("N", strtotime($fecha_resta));
                            if($diadelasemana == $dia){
                                $cont++;
                            }
                            $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                            $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                        }
                        $numerodia=$cont;
                        $visitarlasemana = semanasasaltar($semanas_2veces[$c]);
						$fecha_det1 = explode("-",$dateToAdd);
                        $visitames = $fecha_det1[1];              
                        $cont = 0;
                        $visitadia2 = $fecha_det1[2];                                               
                        $visitadia = ($visitadia2) - (1);
                        $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                        $fecha_resta = date('Y-m-j',$fecha_resta); 
						$num_veces=0;
						$num_no_pasadas = 0;
                        for($i = 1; $i <= $diasdmes; $i++){                            
                            $diadelasemana = date("N", strtotime($fecha_resta));
                            if($diadelasemana == $dia){
                                $cont++;
                                for($t=0; $t<2; $t++){
                                    if($visitarlasemana[$t] == $cont){
                                        $num_veces++;										
                                        if(strtotime($fecha_resta) < strtotime($dateToAdd)){
                                            if($num_veces == 2){
                                                $dateToAdd = $fecha_resta;
                                                switch($semanas_2veces[$c]){
                                                    case "Primera y segunda" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Segunda y tercera" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            break;
                                                        }
                                                    break;
                                                    case "Primera y tercera" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Segunda y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Primera y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+7 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Tercera y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                }
                                            }
                                        }else{
											$dateToAdd = $fecha_resta;
                                            array_push($fechasTotales, $dateToAdd);
                                            array_push($areasFecha, $areas[$c]);
                                            array_push($frecuanciastotales, $frecuancias[$c]);                                        
                                            if($num_veces == 2){
                                                switch($semanas_2veces[$c]){
                                                    case "Primera y segunda" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Segunda y tercera" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            break;
                                                        }
                                                    break;
                                                    case "Primera y tercera" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Segunda y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Primera y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+7 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                    case "Tercera y cuarta" :
                                                        if($numerodia == 4){
                                                            $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }else{
                                                            $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                            $dateToAdd = date('Y-m-j',$dateToAdd );
                                                            $primeravez=false;
                                                            break;
                                                        }
                                                    break;
                                                }
                                            }                                        
                                        }
                                    }
                                }
                            }
                        $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                        $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                        }
                    }else{
                        $visitarlasemana = semanasasaltar($semanas_2veces[$c]);
                        $timestamp = strtotime($dateToAdd);
                        $diasdmes = date( "t", $timestamp );
                        $cont = 0;
                        $fecha_array = explode("-",$dateToAdd);
                        $visitames = $fecha_array[1];              
                        $dia = cambiardianumero($dias[$c]);                        
                        $visitadia2 = $fecha_array[2];                                               
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
                        $numerodia=$cont;
                        $visitarlasemana = semanasasaltar($semanas_2veces[$c]);
                        $timestamp = strtotime($dateToAdd);
                        $diasdmes = date( "t", $timestamp );
                        $cont = 0;
                        $fecha_array = explode("-",$dateToAdd);
                        $visitames = $fecha_array[1];              
                        $dia = cambiardianumero($dias[$c]);                        
                        $visitadia2 = $fecha_array[2];                                               
                        $visitadia = ($visitadia2) - (1);
                        $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                        $fecha_resta = date('Y-m-j',$fecha_resta);
                        for ($i = 1; $i <= $diasdmes; $i++){
                            $diadelasemana = date("N", strtotime($fecha_resta));
                            if($diadelasemana == $dia){
                                $cont++;
                                for($t=0; $t<2; $t++){
                                    if($visitarlasemana[$t] == $cont){
                                        switch($semanas_2veces[$c]){
                                            case "Primera y segunda" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    array_push($frecuanciastotales, $frecuancias[$c]);
                                                    $dateToAdd = strtotime('+7 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "Segunda y tercera" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    array_push($frecuanciastotales, $frecuancias[$c]);
                                                    $dateToAdd = strtotime('+7 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "Primera y tercera" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    array_push($frecuanciastotales, $frecuancias[$c]);
                                                    $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "Segunda y cuarta" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    array_push($frecuanciastotales, $frecuancias[$c]);
                                                    $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "Primera y cuarta" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+14 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "Tercera y cuarta" :
                                                if($visitarlasemana[0] == $cont){
                                                    array_push($fechasTotales, $dateToAdd);
                                                    array_push($areasFecha, $areas[$c]);
                                                    array_push($frecuanciastotales, $frecuancias[$c]);
                                                    $dateToAdd = strtotime('+7 day',strtotime($dateToAdd));	
                                                    $dateToAdd = date('Y-m-j',$dateToAdd );
                                                    break;
                                                }else{
                                                    if($numerodia == 5){
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+28 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }else{
                                                        array_push($fechasTotales, $dateToAdd);
                                                        array_push($areasFecha, $areas[$c]);
                                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                                        $dateToAdd = strtotime('+21 day',strtotime($dateToAdd));	
                                                        $dateToAdd = date('Y-m-j',$dateToAdd );
                                                        break;
                                                    }
                                                }
                                                break;
                                        }                                        
                                    }
                                }
                            }
                            $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                            $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                        }                        
                    }
                    break;
                case "Mensual" :
                    $semana = cambiarsemananumero($semanas[$c]);
                    $timestamp = strtotime($dateToAdd);
                    $diasdmes = date( "t", $timestamp );
                    $cont = 0;
                    $fecha_array = explode("-",$dateToAdd);
                    $visitames = $fecha_array[1];              
                    $dia = cambiardianumero($dias[$c]);                        
                    $visitadia2 = $fecha_array[2];                                               
                    $visitadia = ($visitadia2) - (1);
                    $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($dateToAdd));
                    $fecha_resta = date('Y-m-j',$fecha_resta);
                    if($primeravez==true){
                        for ($i = 1; $i <= $diasdmes; $i++){
                            $diadelasemana = date("N", strtotime($fecha_resta));
                            if($diadelasemana == $dia){
                                $cont++;
                                if($cont == $semana){
                                    if(strtotime($fecha_resta) < strtotime($dateToAdd)){
                                        $fecha_comienzo = $fecha_resta;
                                        $fecha_det1 = explode("-",$fecha_comienzo);
                                        $visitames = $fecha_det1[1];              
                                        $cont = 0;
                                        $dia = date("N", strtotime($fecha_comienzo));                        
                                        $visitadia2 = $fecha_det1[2];                                               
                                        $visitadia = ($visitadia2) - (1);
                                        $fecha_resta = strtotime('-'.$visitadia.'day',strtotime($fecha_comienzo));
                                        $fecha_resta = date('Y-m-j',$fecha_resta);                        
                                        for ($o = 1; $o <= $diasdmes; $o++){
                                            $diadelasemana = date("N", strtotime($fecha_resta));
                                            if($diadelasemana == $dia){
                                                $cont++;
                                            }
                                            $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                                            $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                                        }
                                        $numerodia=$cont;
                                        if($numerodia == 5){
                                            if($fecha_det1[2] <=28){
                                                $fecha_resta = strtotime('+35 day',strtotime($fecha_comienzo));	
                                                $fecha_resta = date('Y-m-j',$fecha_resta );
                                                $dias_pasados = $cont;
                                                $primeravez=false;
                                                $dateToAdd = $fecha_resta;
                                                break;
                                            }else if($fecha_det1[2] >=29){
                                                $fecha_resta=strtotime('+28 day',strtotime($fecha_comienzo));	
                                                $fecha_resta = date('Y-m-j',$fecha_resta);
                                                $dias_pasados = $cont;
                                                $primeravez=false;
                                                $dateToAdd = $fecha_resta;
                                                break;
                                            }
                                        }else if($numerodia == 4){
                                            $fecha_resta=strtotime('+28 day',strtotime($fecha_comienzo));	
                                            $fecha_resta = date('Y-m-j',$fecha_resta );
                                            $dias_pasados = $cont;
                                            $primeravez=false;
                                            $dateToAdd = $fecha_resta;
                                            break;
                                        } 
                                    }else{
                                        $i = $diasdmes+1;
                                        $primeravez=false;
                                        break;
                                    }
                                }
                            }
                            $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                            $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                        }
                        $mesca = explode("-",$dateToAdd);
                        $mescambio = $mesca[1];
                        $timestamp = strtotime($dateToAdd);
                        $diasdmes = date( "t", $timestamp );
                        $dateToAdd = $fecha_resta;
                    }else{
                        $contador++;
                        $regis = 0;
                        $primerafecha = true;
                        if($frecuancias[2] == "Mensual"){
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
                                        $fecha_ejecucion=$dateToAdd;
                                        array_push($fechasTotales, $fecha_ejecucion);
                                        array_push($areasFecha, $areas[$c]);
                                        array_push($frecuanciastotales, $frecuancias[$c]);
                                        $visitasmensuales++;
                                    }
                                }
                            }else{
                                $fecha_ejecucion=$dateToAdd;
                                array_push($fechasTotales, $fecha_ejecucion);
                                array_push($areasFecha, $areas[$c]);
                                array_push($frecuanciastotales, $frecuancias[$c]);
                            }
                        }else{
                            $fecha_ejecucion=$dateToAdd;
                            array_push($fechasTotales, $fecha_ejecucion);
                            array_push($areasFecha, $areas[$c]);
                            array_push($frecuanciastotales, $frecuancias[$c]);
                        }
                        for ($i = 1; $i <= $diasdmes; $i++){
                            $diadelasemana = date("N", strtotime($fecha_resta));
                            if($diadelasemana == $dia){
                                $cont++;
                            }
                            $fecha_resta = strtotime( '+1 day' , strtotime($fecha_resta));
                            $fecha_resta = date( 'Y-m-j' , $fecha_resta );            	        
                        }
                        $numerodia=$cont;
                        if($numerodia == 5){
                            if($visitadia2 <=28){
                                $dateToAdd = strtotime('+35 day',strtotime($dateToAdd));	
                                $dateToAdd = date('Y-m-j',$dateToAdd );
                            }else if($visitadia2 >=29){
                                $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                                $dateToAdd = date('Y-m-j',$dateToAdd );
                            }
                        }else if($numerodia == 4){
                            $dateToAdd=strtotime('+28 day',strtotime($dateToAdd));	
                            $dateToAdd = date('Y-m-j',$dateToAdd );
                        }
                    }
                break;
            }
        }
    }
    $total_fechas = count($fechasTotales);
    $fechasno_repetidas = array_values(array_unique($fechasTotales));
    $no_fech_rep = count($fechasTotales);
    $no_fech_no_rep = count($fechasno_repetidas);

    for($i=0;$i<$no_fech_no_rep;$i++){
        $areas_por_fecha = [];
        for($k=0;$k<$no_fech_rep;$k++){
            if($fechasno_repetidas[$i] == $fechasTotales[$k]){
                array_push($areas_por_fecha, $areasFecha[$k]);
            }
        }
        $visita = NewRegister('Administración de Servicios');
        $visita['ID Programación']=$Programacion['ID'];
        $visita['Idctl']=$Programacion['Idctl'];
        $visita['idcont']=$Programacion['idcont'];
        $visita['Frecuencia']='Frecuencia Sensible';
        $visita['Programa']=$Programacion['Programa'];
        $visita['Estatus']='Activo';
        $visita['Fecha de ejecucion']=$fechasno_repetidas[$i];
        $visita['Servicio asociado']=$Programacion['Tipo Servicio'];
        $visita['Servicio']=$Programacion['Nombre Servicio']; 
        $visita['Cliente']=$Programacion['Cliente']; 
        $visita['Contrato']=$Programacion['Contrato'];
        $visita['Contacto']=$Programacion['Contacto'];
        $visita['Instrucciones Especiales']=$Programacion['Instrucciones Especiales'];
        $visita['Costo']=$Programacion['Costo'];
        $visita['Horas Servicio']=$Programacion['Horas Inicio Del Servicio'];
        $visita['Facturable']=$Programacion['Facturable'];
        $visita['Plaga Objetivo']=$Programacion['Plaga Objetivo'];
        $visita['Plaguicida']=$Programacion['Plaguicida'];
        $visita['Metodo de Aplicacion']=$Programacion['Metodo de aplicacion'];
        $visita['Duración Tiempo']=$Programacion['Duracion Tiempo'];
        $visita['Duracion del servicio en meses']=$Programacion['Duracion Meses'];
        $visita['Ruta']=$Programacion['Ruta'];
        $visita['Supervisor']=$Programacion['Supervisor']; 
        $visita['Vehiculo']=$Programacion['Vehiculo'];
        $visita['Sucursal']=$Programacion['Sucursal']; 
        $visita['Técnico Encargado']=$Programacion['Técnico Encargado'];
        $visita['Colonia']=$Programacion['Colonia'];
        $visita['ColoniaContrato']="Licencia #:".$Programacion['Coloniacontrato'];
        $visita['LicenciaSucursal']=$Programacion['LicenciaSucursal'];
        $visita['dctlexteriorcalle']=$Programacion['Numero Exterior']." ".$Programacion['Calle'];
        $visita['dconextcalle']=$Programacion['Numero ExteriorContra']." ".$Programacion['CalleContra'];
        $visita['dctlmuniestadopostcloni']=$Programacion['Municipio']." ".$Programacion['Estado']." ".$Programacion['codigo Postal'];
        $visita['dconmunestposcolo']=$Programacion['MunicipioContra']." ".$Programacion['EstadoContra']." ".$Programacion['codigo PostalContra'];
        $visita['sucallenocolo']=$Programacion['Callesucursal']." "."No."." ".$Programacion['No. Exteriorsucursal'].", ".$Programacion['Coloniasucursal'];
        $visita['sumuesta']=$Programacion['Municipiosucursal'].", ".$Programacion['Estadosucursal'];
        $visita['sucptel']="C.P. ".$Programacion['Codigosucursal']." Tel: ".$Programacion['Telefonosucursal'];
        $visita['Areas sensibles para esta fecha']=implode(',',$areas_por_fecha);
        save($visita);
        unset($areas_por_fecha);
    }
    $Programacion['Total de visitas']=$no_fech_no_rep;
    $Programacion['Estatus Programación']='Activo';
    save($Programacion);
}

function cambiardianumero($dia){
	$diasdesemana = ['', 'L','M','MI','J','V','S','D'];
    for($l=0; $l<8; $l++){
        if($diasdesemana[$l] == $dia){
			return $l;
        }
    }
}
function cambiarsemananumero($semana){
	$diasdesemana = ['', 'Primera','Segunda','Tercera','Cuarta'];
    for($l=0; $l<5; $l++){
        if($diasdesemana[$l] == $semana){
			return $l;
        }
    }
}
function semanasasaltar($semanas){
    $semanas_visita = ['', 'Primera y segunda','Segunda y tercera','Primera y tercera','Segunda y cuarta','Primera y cuarta','Tercera y cuarta'];
    $numero_visita = [[''],['1','2'],['2','3'],['1','3'],['2','4'],['1','4'],['3','4']];
    $fechas_array = [];
    for($l=0; $l<7; $l++){
        if($semanas_visita[$l] == $semanas){
            for($m=0; $m<2; $m++){
                array_push($fechas_array, $numero_visita[$l][$m]);
            }
        }
    }
    return $fechas_array;
}