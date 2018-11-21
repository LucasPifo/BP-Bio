foreach(DBForm('Areas')->WHERE('banderaregistro','=','12')->get() AS $Areas){
    $RE=$Areas['Inicio de Numeracion RE']; 
    $RI=$Areas['Inicio de Numeracion RI']; 
    $VI=$Areas['Inicio de Numeracion VI']; 
    $VE=$Areas['Inicio de Numeracion VE'];
    $FE=$Areas['Inicio de Numeracion FE'];
    $AV=$Areas['Inicio de Numeracion AV'];
    $MJ=$Areas['Inicio de Numeracion MJ'];
    $Areas['banderaregistro']='1';
    save($Areas);
}