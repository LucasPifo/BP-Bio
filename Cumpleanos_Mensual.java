$cont = 0;
$fecha_hoy = date('Y-m-j');
$nuevafecha = strtotime('+1 month', strtotime($fecha_hoy));
$nuevafecha = date('Y-m-j', $nuevafecha);
$fecha_det = explode("-", $nuevafecha);
$mes_siguiente = $fecha_det[1];

$per = [];
$edad2 = [];
$dia_na=[];
$mess=mes($nuevafecha);
foreach(DBForm('Colaborador')->WHERE('Estatus','!=','')->get() AS $colaborador){
if($colaborador['Estatus']=='Activo' || $colaborador['Estatus']=='Reingreso'){
    $fecha_cumple = $colaborador['Fecha de Nacimiento'];
    $mes_cumple = date('m', strtotime($fecha_cumple));
    if ($mes_siguiente == $mes_cumple){
        $cont++;
        array_push($per, $colaborador['Nombre Completo']);
        array_push($edad2, (busca_edad($fecha_cumple)+1));
        array_push($dia_na, obteneryear($fecha_cumple));
    }
  }
}
$matriz=[];
$longitud = count($per);
for($i=0; $i<$longitud; $i++){
	array_push($matriz, array($dia_na[$i],array($per[$i],$edad2[$i])));
}
sort($matriz);

if($cont > 0){
    $longitud = count($per);
    $renglon = "";
    $blanco="#E1EEF4";
    $azul="rgba( 58, 155, 144, 0.57 )";
    for($i=0; $i<$longitud; $i++){
        $dia=conocerDiaSemanaFecha($matriz[$i][0]);
        if ($i%2==0){
            $renglon .= "<tr><td style='padding: 3px 10px; color: #3400a8; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $blanco;text-align: center'>".$matriz[$i][1][0]."</td><td style='padding: 3px 10px; color: #3400a8; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $blanco;text-align: center'>".$matriz[$i][1][1]."</td><td style='padding: 3px 10px; color: #3400a8; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $blanco;text-align: center'>".$dia." , ".$matriz[$i][0]."</td></tr>";
        }else{
            $renglon .= "<tr><td style='padding: 3px 10px; color: #000000; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $azul;text-align: center;'>".$matriz[$i][1][0]."</td><td style='padding: 3px 10px; color: #000000; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $azul;text-align: center;'>".$matriz[$i][1][1]."</td><td style='padding: 3px 10px; color: #000000; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: bold; background: $azul;text-align: center;'>".$dia." , ".$matriz[$i][0]."</td></tr>";
        }    
    }
    $personal = implode(",",$per);    
    sendEmail("alejandra.domene@acintegral.mx", "Lista de cumpleaños de $mess", "<p style='font: normal 15px Arial, Helvetica, sans-serif;font-weight:bold'>Felicidades a:</p> <br><div style='font: normal 12px/150% Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 1px solid #006699; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px;'><table style=' border-collapse: collapse; text-align: left; width: 100%;'><thead><tr><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8;text-align: center;'>Nombre</th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Años a cumplir</th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Fecha de Cumpleaños</th></tr></thead><tbody>$renglon</tbody></table></div><br/><br/> <h3>Departamento de Recursos Humanos.</h3>");
    sendEmail("reclutamiento@biosinsa.com.mx", "Lista de cumpleaños de $mess", "<p style='font: normal 15px Arial, Helvetica, sans-serif;font-weight:bold'>Felicidades a:</p> <br><div style='font: normal 12px/150% Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 1px solid #006699; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px;'><table style=' border-collapse: collapse; text-align: left; width: 100%;'><thead><tr><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8;text-align: center;'>Nombre</th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Años a cumplir/th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Fecha de Cumpleaños</th></tr></thead><tbody>$renglon</tbody></table></div><br/><br/> <h3>Departamento de Recursos Humanos.</h3>");
    sendEmail("biosinsasistema1@gmail.com", "Lista de cumpleaños de $mess", "<p style='font: normal 15px Arial, Helvetica, sans-serif;font-weight:bold'>Felicidades a:</p> <br><div style='font: normal 12px/150% Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 1px solid #006699; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px;'><table style=' border-collapse: collapse; text-align: left; width: 100%;'><thead><tr><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8;text-align: center;'>Nombre</th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Años a cumplir</th><th style='padding: 3px 10px; background-color:#36752D; color:#FFFFFF; font-size: 15px; font-weight: bold; border-left: 1px solid #0070A8; text-align: center;'>Fecha de Cumpleaños</th></tr></thead><tbody>$renglon</tbody></table></div><br/><br/> <h3>Departamento de Sistemas.</h3>");
}
function busca_edad($fecha_nacimiento){
    $dia = date("d");
    $mes = date("m");
    $ano = date("Y");
    $dianaz = date("d", strtotime($fecha_nacimiento));
    $mesnaz = date("m", strtotime($fecha_nacimiento));
    $anonaz = date("Y", strtotime($fecha_nacimiento));
    if (($mesnaz == $mes) && ($dianaz > $dia)) {
        $ano = ($ano - 1);
    }
    if ($mesnaz > $mes) {
        $ano = ($ano - 1);
    }
    $edad = ($ano - $anonaz);
    return $edad;
}
function mes($fecha_d){
    $fecha = $fecha_d;
    $diass="";
    $fechats = strtotime($fecha); 
    switch (date('n', $fechats)){ 
        case 1: $diass= "Enero"; break; 
        case 2: $diass= "Febrero"; break; 
        case 3: $diass= "Marzo"; break; 
        case 4: $diass= "Abril"; break; 
        case 5: $diass= "Mayo"; break; 
        case 6: $diass= "Junio"; break; 
        case 7: $diass= "Julio"; break;    
        case 8: $diass= "Agosto"; break;    
        case 9: $diass= "Septiembre"; break;    
        case 10: $diass= "Octubre"; break;    
        case 11: $diass= "Noviembre"; break;    
        case 12: $diass= "Diciembre"; break;    
           
    } 
    return $diass;
}
function obtenerFechaEnLetra($fecha){
    $dia= conocerDiaSemanaFecha($fecha);
    $num = date("j", strtotime($fecha));
    $anno = date("Y", strtotime($fecha));
    $mes = array('enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio', 'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre');
    $mes = $mes[(date('m', strtotime($fecha))*1)-1];
    return $dia.', '.$num.' de '.$mes.' del '.$anno;
}
function conocerDiaSemanaFecha($fecha) {
    $dias = array('Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado');
    $dia = $dias[date('w', strtotime($fecha))];
    return $dia;
}
function obteneryear($fecha){
    $dianaz = date("d", strtotime($fecha));
    $mesnaz = date("m", strtotime($fecha));
    $ano = date("Y");
	$fechita=$dianaz.'-'.$mesnaz.'-'.$ano;
	$dia=conocerDiaSemanaFecha($fechita);
    return $fechita;
}