foreach(DBForm('Colaborador')->WHERE('Estatus','!=','')->get() AS $colaborador){
    if($colaborador['Estatus']=='Activo' || $colaborador['Estatus']=='Reingreso'){
        $fechana=$colaborador['Fecha de Nacimiento'];
        $colaborador['Edad']=busca_edad($fechana);
        save($colaborador);
    }
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
