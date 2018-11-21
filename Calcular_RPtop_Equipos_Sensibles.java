foreach(DBForm('Equipo Sensible')->WHERE('Bandera','=','0')->get() AS $stockRow){
    $top = $stockRow['Top'];
    $rps=[];
    foreach(DBForm('Riesgo por tipo de plaga para equipos sensibles')->WHERE('IDEquiposensible', '=', $stockRow['ID Equipo Sensible'])->get() AS $Plagas){
        array_push($rps, $Plagas['RP']);
    }
    rsort($rps);
    $no_repetidos = array_values(array_unique($rps));
    $numero_rps_mayores=count($no_repetidos);
    $numero_rps=count($rps);
    $suma=0;
    $contador=0;
    if($top <= $numero_rps_mayores){
        for($i=0; $i<$top; $i++){
            for($c=0; $c<$numero_rps;$c++){
                if($no_repetidos[$i] == $rps[$c]){
                    $contador++;
                    $suma+=$rps[$c];
                }
            }
        }
        $stockRow['RPTop']=$suma/$contador;
    }else{
        $stockRow['RPTop']=000000;
    }
    $stockRow['Bandera']='1';
    save($stockRow);
}