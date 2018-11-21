$cont = 0;
$mes_actual = date('m');
$dia_actual = date('j');
$per = [];
$edad2 = [];
foreach(DBForm('Colaborador')->WHERE('Estatus','!=','')->get() AS $colaborador){
    if($colaborador['Estatus'=='Activo'] || $colaborador['Estatus'=='Reingreso']){
        $fecha_cumple = $colaborador['Fecha de Nacimiento'];
        $mes_cumple = date('m', strtotime($fecha_cumple));
        $dia_comple = date('j', strtotime($fecha_cumple));
        if ($mes_actual == $mes_cumple && $dia_actual == $dia_comple){
            $cont++;
            array_push($per, $colaborador['Nombre Completo']);
            array_push($edad2, busca_edad($fecha_cumple));
            $colaborador['Edad'] = busca_edad($fecha_cumple);
            save($colaborador);
        }
    }
}
if($cont > 0){
    $longitud = count($per);
    $renglon = "";
    for($i=0; $i<$longitud; $i++){
        $renglon .= "<b>$per[$i]</b> que cumple <b>$edad2[$i]</b> años.<br>";
    }
    $personal = implode(",",$per);
    sendEmail("alejandra.domene@acintegral.mx", "Lista de cumpleañeros de hoy", "<font face='sans-serif'><h2>Felicidades a:</h2> <font size='3'>$renglon</font><br/> <h3>Departamento de Recursos Humanos.</h3></font>");
    sendEmail("reclutamiento@biosinsa.com.mx", "Lista de cumpleañeros de hoy", "<font face='sans-serif'><h2>Felicidades a:</h2> <font size='3'>$renglon</font><br/> <h3>Departamento de Recursos Humanos.</h3></font>");
    sendEmail("biosinsasistema1@gmail.com", "Lista de cumpleañeros de hoy", "<font face='sans-serif'><h2>Felicidades a:</h2> <font size='3'>$renglon</font><br/> <h3>Departamento de Recursos Humanos.</h3></font>");
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