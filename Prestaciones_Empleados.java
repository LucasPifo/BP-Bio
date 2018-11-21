foreach(DBForm('Asignación de Prestaciones')->WHERE('Bandera','=','2')->get() AS $Prestacion){
    $presta=$Prestacion['Prestación'];
    if($presta=='SN Nominal'){
        $Prestacion['Snnominal']=$Prestacion['Monto'];

    }
    if($presta=='Bono Productividad'){
        $Prestacion['Bonoproductividad']=$Prestacion['Monto'];
    }
    $Prestacion['Bandera']='1';
    save($Prestacion);
}