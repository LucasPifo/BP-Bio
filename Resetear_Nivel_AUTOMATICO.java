foreach(DBForm('Asignacion de Dispositivos')->WHERE('Fecha que resetea el nivel','=',currentDate())->get() AS $Asigdisp){
    $Asigdisp['Nivel general del dispositivo']='0';
    save($Asigdisp);
}